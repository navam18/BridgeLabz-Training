package linkedList;

class TextStateNode {
    String text;
    TextStateNode prev, next;

    TextStateNode(String text) {
        this.text = text;
    }
}

class TextEditorHistory {

    private TextStateNode head, tail, current;
    private int size = 0;
    private final int LIMIT = 10;

    public void addState(String text) {
        TextStateNode node = new TextStateNode(text);

        if (head == null) {
            head = tail = current = node;
            size = 1;
            return;
        }

        if (current.next != null) {
            current.next.prev = null;
            current.next = null;
            tail = current;
        }

        tail.next = node;
        node.prev = tail;
        tail = node;
        current = node;

        size++;
        if (size > LIMIT)
            removeFirst();
    }

    private void removeFirst() {
        head = head.next;
        head.prev = null;
        size--;
    }

    public void undo() {
        if (current != null && current.prev != null)
            current = current.prev;
    }

    public void redo() {
        if (current != null && current.next != null)
            current = current.next;
    }

    public void displayCurrentState() {
        if (current == null)
            System.out.println("Editor empty");
        else
            System.out.println("Current Text: " + current.text);
    }
}

public class TextEditor {
    public static void main(String[] args) {

        TextEditorHistory editor = new TextEditorHistory();

        editor.addState("Hello");
        editor.addState("Hello World");
        editor.addState("Hello World!");
        editor.displayCurrentState();

        editor.undo();
        editor.displayCurrentState();

        editor.redo();
        editor.displayCurrentState();
    }
}
