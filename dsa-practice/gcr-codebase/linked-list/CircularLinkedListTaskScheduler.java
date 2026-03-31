class Task {
    int taskId;
    String taskName;
    int priority;
    String dueDate;
    Task next;

    Task(int id, String name, int priority, String dueDate) {
        this.taskId = id;
        this.taskName = name;
        this.priority = priority;
        this.dueDate = dueDate;
    }
}

class TaskScheduler {
    private Task head = null;
    private Task current = null;

    // Add at beginning
    void addAtBeginning(Task t) {
        if (head == null) {
            head = t;
            t.next = head;
            current = head;
            return;
        }

        Task temp = head;
        while (temp.next != head) temp = temp.next;

        t.next = head;
        temp.next = t;
        head = t;
    }

    // Add at end
    void addAtEnd(Task t) {
        if (head == null) {
            addAtBeginning(t);
            return;
        }

        Task temp = head;
        while (temp.next != head) temp = temp.next;

        temp.next = t;
        t.next = head;
    }

    // Remove by Task ID
    void removeById(int id) {
        if (head == null) return;

        Task curr = head, prev = null;

        do {
            if (curr.taskId == id) {
                if (prev != null) {
                    prev.next = curr.next;
                } else {
                    Task last = head;
                    while (last.next != head) last = last.next;
                    head = head.next;
                    last.next = head;
                }
                return;
            }
            prev = curr;
            curr = curr.next;
        } while (curr != head);
    }

    // View current task and move next
    void viewCurrentTask() {
        if (current == null) {
            System.out.println("No tasks available");
            return;
        }
        System.out.println("Current Task: " + current.taskName);
        current = current.next;
    }

    // Search by priority
    void searchByPriority(int priority) {
        if (head == null) return;

        Task temp = head;
        do {
            if (temp.priority == priority) {
                System.out.println(temp.taskName);
            }
            temp = temp.next;
        } while (temp != head);
    }

    // Display all tasks
    void displayTasks() {
        if (head == null) {
            System.out.println("No tasks");
            return;
        }

        Task temp = head;
        do {
            System.out.println(temp.taskId + " | " + temp.taskName +
                    " | Priority: " + temp.priority +
                    " | Due: " + temp.dueDate);
            temp = temp.next;
        } while (temp != head);
    }

}
public class CircularLinkedListTaskScheduler{
    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();
        scheduler.addAtEnd(new Task(1, "Coding", 1, "10-02-2026"));
        scheduler.addAtEnd(new Task(2, "Testing", 2, "12-02-2026"));
        scheduler.addAtBeginning(new Task(3, "Design", 1, "08-02-2026"));

        scheduler.displayTasks();
        scheduler.viewCurrentTask();
        scheduler.searchByPriority(1);
    }
}