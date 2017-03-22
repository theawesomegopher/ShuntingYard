package ekordik.cuw.edu.shuntingyard;

/**
 * Created by emmakordik on 3/21/17.
 */

public class Queue {
    private Node head;
    private Node tail;
    private int count;

    public Queue() {
        count = 0;
        head = null;
        tail = null;
    }

    public void enqueue(String data) {
        Node newNode = new Node(data);
        if(head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNextNode(newNode);
            tail = newNode;
        }
        count++;
    }

    public String dequeue() throws RuntimeException {
        if(head == null) {
            throw new RuntimeException("Can't dequeue an empty list");
        }

        Node currFront = head;
        this.head = currFront.getNextNode();
        currFront.setNextNode(null);
        this.count--;
        return currFront.getData();
    }

    public int getCount() {
        return this.count;
    }
}

