package Chapter15;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

/**
 * This ArrayIntStack uses a last-in-first-out (LIFO) stack of integers. There are push and pop operations,
 * peek and empty methods.
 *
 * When a ArrayIntStack is first created there are no integer values in it.
 *
 * There is a built-in iterator method.
 * @author Alan Ly
 * Created: 22 February 2021
 */

public class ArrayIntStack {
    private int[] intArray;
    private int size;
    public static final int CAPACITY = 20;

    /**
     * Default constructor that initializes the capacity of ArrayIntStack; Default capacity 20.
     *
     */
    public ArrayIntStack() {
        this(CAPACITY);
    }

    /**
     * Creates a stack with a specific capacity.
     * @param capacity Initializes the max capacity of the stack
     */
    public ArrayIntStack(int capacity){
        intArray = new int[capacity];
        size = 0;
    }

    /**
     * Checks if this stack is empty.
     * @return true if the size of stack is less than 1; false otherwise.
     */
    public boolean empty() {
        if(size < 1) {
            return true;
        } else return false;
    }

    /**
     * Looks at the uppermost integer of the stack without removing the integer.
     * @throws EmptyStackException if the size is less than one, containing no items.
     * @return the uppermost integer of this stack.
     */
    public int peek() {
        if (size < 1) { throw new EmptyStackException(); }
        return intArray[size-1];
    }

    /**
     * Removes the uppermost integer of this stack and returns that integer.
     * @return the uppermost integer of this stack.
     * @throws EmptyStackException if the size is less than one, containing no items.
     */
    public int pop() {
        if (size < 1) { throw new EmptyStackException(); }
        int poppedValue = intArray[size-1];
        size--;
        return poppedValue;
    }

    /**
     * Adds an integer onto the uppermost position of the stack.
     * @param value the integer (int) to be pushed to the top of this stack.
     * @return integer value as initially provided as a parameter.
     */
    public int push(int value) {
        if (size == CAPACITY) { throw new StackOverflowError(); }
        intArray[size] = value;
        size++;
        return value;
    }

    /**
     * Creates an iterator that passes in this ArrayIntStack as an object.
     * @return a new IntStackIterator object for ArrayIntStack object.
     */
    public IntStackIterator iterator() { return new IntStackIterator(this); }

    /**
     * Nested iterator object for the ArrayIntStack stack object.
     */
    public static class IntStackIterator {
    private int position;
    private ArrayIntStack stack;

        /**
         * Constructor for IntStackIterator and initializes this iterator object.
         * @param intStack ArrayIntStack stack of integers as a parameter.
         */
        public IntStackIterator (ArrayIntStack intStack) {
            this.stack = intStack;
            position = stack.size;
        }

        /**
         * Iterator methods checks if provided stack has consecutive items.
         * @return True if there is a preceding value in the stack.
         * @throws NoSuchElementException if the stack has no items.
         */
        public boolean hasNext() {
            if (position == 0) { throw new NoSuchElementException(); }
            return (position) > 0;
        }

        /**
         * Checks and returns the next value in the stack, decrementing from the uppermost value.
         * @return the value before the uppermost value in this stack.
         */
        public int next() {
            return stack.intArray[--position];
        }
    }


}
