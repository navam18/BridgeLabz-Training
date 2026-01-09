package linkedList;

class ProcessNode {
    int pid;
    int burstTime;
    int remainingTime;
    int priority;
    int waitingTime;
    int turnaroundTime;
    ProcessNode next;

    ProcessNode(int pid, int burstTime, int priority) {
        this.pid = pid;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
        this.priority = priority;
    }
}

class RoundRobinScheduler {

    private ProcessNode head = null;
    private int processCount = 0;

    public void addProcess(int pid, int burstTime, int priority) {
        ProcessNode node = new ProcessNode(pid, burstTime, priority);

        if (head == null) {
            head = node;
            node.next = head;
        } else {
            ProcessNode temp = head;
            while (temp.next != head)
                temp = temp.next;

            temp.next = node;
            node.next = head;
        }
        processCount++;
    }

    public void displayQueue() {
        if (head == null) return;

        ProcessNode temp = head;
        do {
            System.out.print("[P" + temp.pid + " | RT=" + temp.remainingTime + "] -> ");
            temp = temp.next;
        } while (temp != head);
        System.out.println("(back to head)");
    }

    public void schedule(int timeQuantum) {
        if (head == null) return;

        ProcessNode curr = head;
        int time = 0;
        int completed = 0;
        double totalWT = 0, totalTAT = 0;

        System.out.println("\n--- Round Robin Execution ---");

        while (completed < processCount) {

            if (curr.remainingTime > 0) {

                int execTime = Math.min(timeQuantum, curr.remainingTime);
                time += execTime;
                curr.remainingTime -= execTime;

                ProcessNode temp = head;
                do {
                    if (temp != curr && temp.remainingTime > 0)
                        temp.waitingTime += execTime;
                    temp = temp.next;
                } while (temp != head);

                if (curr.remainingTime == 0) {
                    curr.turnaroundTime = time;
                    totalWT += curr.waitingTime;
                    totalTAT += curr.turnaroundTime;
                    completed++;
                    System.out.println("Process P" + curr.pid + " completed.");
                }
            }

            displayQueue();
            curr = curr.next;
        }

        System.out.println("\n--- Final Results ---");
        ProcessNode temp = head;
        do {
            System.out.println("P" + temp.pid +
                    " | WT=" + temp.waitingTime +
                    " | TAT=" + temp.turnaroundTime);
            temp = temp.next;
        } while (temp != head);

        System.out.println("\nAverage Waiting Time: " + (totalWT / processCount));
        System.out.println("Average Turnaround Time: " + (totalTAT / processCount));
    }
}

public class RoundRobinApp {
    public static void main(String[] args) {

        RoundRobinScheduler rr = new RoundRobinScheduler();

        rr.addProcess(1, 10, 1);
        rr.addProcess(2, 5, 2);
        rr.addProcess(3, 8, 1);
        rr.addProcess(4, 6, 3);

        System.out.println("Initial Queue:");
        rr.displayQueue();

        rr.schedule(3);
    }
}
