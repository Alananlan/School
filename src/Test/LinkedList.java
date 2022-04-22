package Test;
import java.util.*;


// Karim Maftoun, CS 211, Winter22, 2/23/2022, February 2022
// Assignment #16 - Ch.16
// I am  writing these methods to get more experience with linked lists
// Bellevue College, W.P. Iverson
//
// Class LinkedList<E> can be used to store a list of values of type E.
// from Buildingjavaprograms.com (2015)
// modified by W.P. Iverson, Bellevue College, January 2021 
// added backwards(); to check list in backwards order

public class LinkedList<E extends Comparable<E>> implements Iterable<E> {
    // 2017, removed implements List due to version differences of List
    private ListNode<E> front; // first value in the list
    private ListNode<E> back; // last value in the list
    private int size; // current number of elements

    // NOTE: an empty list has TWO Nodes to mark front and back
    // post: constructs an empty list
    public LinkedList() {
        front = new ListNode<E>(null);
        back = new ListNode<E>(null);
        clear();
    }

// ADD MORE METHODS HERE (like for assigned CS211 work):



    public ListNode<E> set(int index, ListNode<E> value) {
        checkIndex(index);
        ListNode<E> returnedValue =  this.nodeAt(index);


            ListNode<E> current = (ListNode<E>) nodeAt(index);
            current.data = (E) value.data;


        return returnedValue;

    }

    

    // #7
    public E deleteBack() {
        if (size < 1) { // Exception if the list is empty
            throw new NoSuchElementException();
        }
        E object = nodeAt(size - 1).data; // stores data into E object
        remove(size - 1); // removed the element

        return object; // return the object
    }

    // #8
    public void switchPairs() {
        int i = 0;
        while (i < size - 1) { // goes through the list
            E tempObject = nodeAt(i).data; // stores an element
            set(i, nodeAt(i + 1).data); // sets the values to their counterparts
            set(i + 1, tempObject);
            i += 2; // increment i
        }
    }

    // #9
    public void stutter() {
        int oldSize = size; // save size
        int i = 0;

        while (i < oldSize * 2) { // goes through the list of twice the size
            E tempObject = nodeAt(i).data; // stores the element
            add(i + 1, tempObject); // adds a replica
            i += 2; // increment i
        }
    }

    // #14
    public void removeAll(E object) {
        ListNode<E> previous = front; // previous node
        ListNode<E> current = front.next; // current node
        while (size > 0 && current.data.equals(object)) { // traverse the list
            current = current.next; // removes and updates pointers
            current.prev = previous;
            previous.next = current;
            size--; // update size
        }

        while (size > 0 && current.next != null) { // traverse the list
            if (current.data.equals(object)) {
                current = current.next; // removes and updates pointers
                current.prev = previous;
                previous.next = current;
                size--; // update size
            } else { // moves nodes to the next element
                previous = previous.next;
                current = current.next;
            }
        }
    }

    // post: returns the current number of elements in the list
    public int size() {
        return size;
    }

    // pre : 0 <= index < size() (throws IndexOutOfBoundsException if not)
    // post: returns the value at the given index in the list
    public E get(int index) {
        checkIndex(index);
        ListNode<E> current = nodeAt(index);
        return current.data;
    }

    // post: creates a comma-separated, bracketed version of the list
    public String toString() {
        if (size == 0) {
            return "[]";
        } else {
            String result = "[" + front.next.data;
            ListNode<E> current = front.next.next;
            while (current != back) {
                result += ", " + current.data;
                current = current.next;
            }
            result += "]";
            return result;
        }
    }

    // post: creates a comma-separated, bracketed version of the list
    // Iverson creation
    public String backwards() {
        if (size == 0) {
            return "[]";
        } else {
            String result = "[" + back.prev.data;
            ListNode<E> current = back.prev.prev;
            while (current != front) {
                result += ", " + current.data;
                current = current.prev;
            }
            result += "]";
            return result;
        }
    }

    // post : returns the position of the first occurrence of the given
    // value (-1 if not found)
    public int indexOf(E value) {
        int index = 0;
        ListNode<E> current = front.next;
        while (current != back) {
            if (current.data.equals(value)) {
                return index;
            }
            index++;
            current = current.next;
        }
        return -1;
    }

    // post: returns true if list is empty, false otherwise
    public boolean isEmpty() {
        return size == 0;
    }

    // post: returns true if the given value is contained in the list,
    // false otherwise
    public boolean contains(E value) {
        return indexOf(value) >= 0;
    }

    // post: appends the given value to the end of the list
    public void add(E value) {
        add(size, value);
    }

    // pre: 0 <= index <= size() (throws IndexOutOfBoundsException if not)
    // post: inserts the given value at the given index, shifting subsequent values
    // right
    public void add(int index, E value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("index: " + index);
        }
        ListNode<E> current = nodeAt(index - 1);
        ListNode<E> newNode = new ListNode<E>(value, current.next, current);
        current.next = newNode;
        newNode.next.prev = newNode;
        size++;
    }

    // post: appends all values in the given list to the end of this list
    public void addAll(List<E> other) {
        for (E value : other) {
            add(value);
        }
    }

    // pre : 0 <= index < size() (throws IndexOutOfBoundsException if not)
    // post: removes value at the given index, shifting subsequent values left
    public void remove(int index) {
        checkIndex(index);
        ListNode<E> current = nodeAt(index - 1);
        current.next = current.next.next;
        current.next.prev = current;
        size--;
    }

    // pre : 0 <= index < size() (throws IndexOutOfBoundsException if not)
    // post: replaces the value at the given index with the given value
    public void set(int index, E value) {
        checkIndex(index);
        ListNode<E> current = nodeAt(index);
        current.data = value;
    }

    // post: list is empty
    public void clear() {
        front.next = back;
        back.prev = front;
        size = 0;
    }

    // post: returns an iterator for this list
    public Iterator<E> iterator() {
        return new LinkedIterator();
    }

    // pre : 0 <= index < size()
    // post: returns the node at a specific index. Uses the fact that the list
    // is doubly-linked to start from the front or the back, whichever
    // is closer.
    private ListNode<E> nodeAt(int index) {
        ListNode<E> current;
        if (index < size / 2) {
            current = front;
            for (int i = 0; i < index + 1; i++) {
                current = current.next;
            }
        } else {
            current = back;
            for (int i = size; i >= index + 1; i--) {
                current = current.prev;
            }
        }
        return current;
    }

    // post: throws an IndexOutOfBoundsException if the given index is
    // not a legal index of the current list
    private void checkIndex(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("index: " + index);
        }
    }

    private static class ListNode<E> {
        public E data; // data stored in this node
        public ListNode<E> next; // link to next node in the list
        public ListNode<E> prev; // link to previous node in the list

        // post: constructs a node with given data and null links
        public ListNode(E data) {
            this(data, null, null);
        }

        // post: constructs a node with given data and given links
        public ListNode(E data, ListNode<E> next, ListNode<E> prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }

    private class LinkedIterator implements Iterator<E> {
        private ListNode<E> current; // location of next value to return
        private boolean removeOK; // whether it's okay to remove now

        // post: constructs an iterator for the given list
        public LinkedIterator() {
            current = front.next;
            removeOK = false;
        }

        // post: returns true if there are more elements left, false otherwise
        public boolean hasNext() {
            return current != back;
        }

        // pre : hasNext()
        // post: returns the next element in the iteration
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E result = current.data;
            current = current.next;
            removeOK = true;
            return result;
        }

        // pre : next() has been called without a call on remove (i.e., at most
        // one call per call on next)
        // post: removes the last element returned by the iterator
        public void remove() {
            if (!removeOK) {
                throw new IllegalStateException();
            }
            ListNode<E> prev2 = current.prev.prev;
            prev2.next = current;
            current.prev = prev2;
            size--;
            removeOK = false;
        }
    }
}