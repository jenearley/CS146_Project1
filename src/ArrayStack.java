import java.util.EmptyStackException;

/**
 * Created by Jennifer Earley on 2/3/2016.
 * this class is an array implementation of a stack
 */
public class ArrayStack implements DStack{
    private double[] aStack;
    private int arraySize = 10;
    private int size;

    public ArrayStack(){
        aStack = new double[arraySize];
        size = 0;
    }

    /**
     * this method checks if the ArrayStack
     * has any elements in it or not
     * @return whether the stack is empty or not, true/false
     */
    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * this method adds a new element
     * to the ArrayStack after the previous
     * element added
     * @param d
     */
    @Override
    public void push(double d) {
        if(isEmpty() == true){
            aStack[0] = d;
        } else {
            if(aStack[aStack.length - 1] != 0){
                aStack = resize(aStack);
                aStack[aStack.length / 2] = d;
            } else {
                int i = 0;
                while(aStack[i] != 0){
                    i++;
                }
                aStack[i] = d;
            }
        }
        size++;
    }

    /**
     * this method removes the last pushed
     * element of the ArrayStack and returns it
     * @return last filled item in the array, found
     */
    @Override
    public double pop() {
        if(isEmpty() == true){
            throw new EmptyStackException();
        } else {
            double popped;
            int i = 0;
            while(aStack[i] != 0){
                i++;
            }
            popped = aStack[i -1];
            aStack[i -1] = 0;
            size--;
            return popped;
        }
    }

    /**
     * this method allows the user to
     * look at the element last
     * pushed into the ArrayStack
     * @return last filled item in the ArrayStack, aStack[i -1]
     */
    @Override
    public double peek() {
        if(isEmpty() == true){
            throw new EmptyStackException();
        } else {
            int i = 0;
            while(aStack[i] != 0){
                i++;
            }
            return aStack[i -1];
        }
    }

    /**
     * this method takes a an ArrayStack A
     * and copies over all the elements
     * in ArrayStack A into a new ArrayStack B
     * twice the size of ArrayStack A
     * @param s
     * @return a new ArrayStack with double the size and all the previous elements, newStack
     */
    private double[] resize(double[] s){
        double[] newStack = new double[s.length * 2];
        for(int i = 0; i < s.length; i++){
            newStack[i] = s[i];
        }
        return newStack;
    }

    /**
     * this method returns the number of
     * elements present in the ArrayStack
     * @return the number of elements in the ArrayStack, size
     */
    public int getSize(){
        return size;
    }
}
