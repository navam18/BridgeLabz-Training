class Student{
    String name;
    int rollNo;
    double gpa;
    Student next;

    public Student(String name, int rollNo, double gpa) {
        this.name = name;
        this.rollNo = rollNo;
        this.gpa = gpa;
        this.next = null;
    }

    public void insertAtHead(Student head, String name, int rollNo, double gpa) {
        Student newStudent = new Student(name, rollNo, gpa);
        newStudent.next = head;
        head = newStudent;
    }

    public void insertAtTail(Student head, String name, int rollNo, double gpa) {
        Student newStudent = new Student(name, rollNo, gpa);
        if (head == null) {
            head = newStudent;
            return;
        }
        Student temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newStudent;
    }

    public void insertAtPosition(Student head, String name, int rollNo, double gpa, int position) {
        Student newStudent = new Student(name, rollNo, gpa);
        if (position == 0) {
            newStudent.next = head;
            head = newStudent;
            return;
        }
        Student temp = head;
        for (int i = 0; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            return; // Position is out of bounds
        }
        newStudent.next = temp.next;
        temp.next = newStudent;
    }

    public void displayRecords(Student head) {
        Student temp = head;
        while (temp != null) {
            System.out.println("Name: " + temp.name + ", Roll No: " + temp.rollNo + ", GPA: " + temp.gpa);
            temp = temp.next;
        }
    }

    public Student searchByRollNo(Student head, int rollNo) {
        Student temp = head;
        while (temp != null) {
            if (temp.rollNo == rollNo) {
                return temp;
            }
            temp = temp.next;
        }
        return null; // Not found
    }

    public Student deleteByRollNo(Student head, int rollNo) {
        if (head == null) {
            return null;
        }
        if (head.rollNo == rollNo) {
            return head.next; // Deleted head
        }
        Student temp = head;
        while (temp.next != null && temp.next.rollNo != rollNo) {
            temp = temp.next;
        }
        if (temp.next != null) {
            temp.next = temp.next.next; // Bypass the deleted node
        }
        return head;
    }

    public static void main(String[] args) {
        Student head = null;
        Student studentManager = new Student("", 0, 0.0);

        // Insert students
        studentManager.insertAtHead(head, "Alice", 1, 3.5);
        studentManager.insertAtTail(head, "Bob", 2, 3.7);
        studentManager.insertAtPosition(head, "Charlie", 3, 3.8, 1);

        // Display records
        studentManager.displayRecords(head);

        // Search for a student
        Student foundStudent = studentManager.searchByRollNo(head, 2);
        if (foundStudent != null) {
            System.out.println("Found: " + foundStudent.name);
        } else {
            System.out.println("Student not found.");
        }

        // Delete a student
        head = studentManager.deleteByRollNo(head, 1);
        studentManager.displayRecords(head);
    }
}