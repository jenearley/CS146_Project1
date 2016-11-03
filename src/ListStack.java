import java.util.EmptyStackException;

/**
 * Created by Jennifer Earley on 2/3/2016.
 * this class is a linked-list implementation of a stack
 */
public class ListStack implements DStack{
    private Node head;
    private Node tail;
    private int size;

    public ListStack(){
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * this method checks if the ArrayStack
     * has any elements in it or not
     * @return whether the stack is empty or not, true/false
     */
    @Override
    public boolean isEmpty() {
        if(size == 0){
            return true;
        } else {
            return false;
        }
    }

    /**
     * this method adds a new element
     * to the end of the ListStack
     * @param d
     */
    @Override
    public void push(double d) {
        Node added = new Node(d);
        if(isEmpty() == true){
            head = added;
            tail = added;
        } else {
            Node end = tail;
            end.next = added;
            added.previous = end;
            tail = added;
        }
        size++;
    }

    /**
     * this method removes the element
     * at the end of the ListStack and
     * returns the value of the element
     * @return the popped element at the
     * end of the ListStack, deleted
     */
    @Override
    public double pop() {
        if(isEmpty() == true){
            throw new EmptyStackException();
        } else {
            double deleted = tail.display();
            Node precursor = tail.previous;
            tail = precursor;
            size--;
            return deleted;
        }
    }

    /**
     * this method lets the user look
     * at the value of the last added
     * element in the ListStac
     * @return the value of the last element
     * in the ListStack, tail.display()
     */
    @Override
    public double peek() {
        if(isEmpty() == true){
            throw new EmptyStackException();
        } else {
            return tail.display();
        }
    }
    /**
     * this method returns the number of
     * elements present in the ListStack
     * @return the number of elements in the ListStack, size
     */
    public int getSize() {
        return size;
    }

    /**
     * this is a Node class
     * that makes up the ListStack
     */
    public class Node{
        public double data;
        public Node next;
        public Node previous;

        public Node(double i){
            data = i;
        }

        public double display(){
            return data;
        }
    }
}
