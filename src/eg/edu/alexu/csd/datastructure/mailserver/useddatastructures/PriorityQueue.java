package eg.edu.alexu.csd.datastructure.mailserver.useddatastructures;

public class PriorityQueue implements IPriorityQueue {

    public class Node {
        Object data;
        int priority;
        Node next;
    }

    public Node newnode(Object data, int priority)
    {
        Node temp = new Node();
        temp.data = data;
        temp.priority = priority;
        temp.next = null;
        return temp;
    }

    private Node head = new Node();
    private int size;

    @Override
    public void insert(Object item, int key) {

        if (key < 1 || item == null){
            throw new RuntimeException();
        }

        Node start = head;
        Node temp = newnode(item,key);
        if (isEmpty()){
            head = temp;
        }
        else {
            if (key < head.priority) {
                temp.next = head;
                head = temp;
            } else {
                while (start.next != null && start.next.priority < key) {
                    start = start.next;
                }
                temp.next = start.next;
                start.next = temp;
            }
        }
        size++;
    }

    @Override
    public Object removeMin() {
        if (isEmpty()) {
            throw new RuntimeException();
        }
        else {
            Node temp = head;
            head = head.next;
            size--;
            return temp.data;
        }
    }

    @Override
    public Object min() {
        if (isEmpty()) {
            throw new RuntimeException();
        } else {
            return head.data;
        }
    }

    @Override
    public boolean isEmpty() {
        if (size == 0){
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public int size() {
        return size;
    }


    public static void main(String[] args) {
        PriorityQueue pq = new PriorityQueue();
        try {

        }
        catch (Exception excep){
            System.out.println("invaled");
        }
    }


}
