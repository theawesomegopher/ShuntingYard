package ekordik.cuw.edu.shuntingyard;


/**
 * Represents a node to be used in a linked list. Each node stores string data and the address
 * of the next node in the list.
 *
 * @author emmakordik
 *
 */
public class Node {
    private String data;
    private Node nextNode;

    public Node(String data){
        this.data = data;
        this.nextNode = null;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }
}
