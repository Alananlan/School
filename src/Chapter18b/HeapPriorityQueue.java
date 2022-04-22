/*
ALan Ly
Prof I
 */
package Chapter18b;
import java.util.*;
// for Iverson's CS211, Limit yourself to above imports
// these will help us maintain O(log N) run-time for this


// Implements a priority queue of comparable objects using a
// min-heap represented as an array.
public class HeapPriorityQueue<E extends Comparable<E>> {
    private E[] elementData;
    private int size;
    private final Comparator<? super E> tempComparator;
    
    // Constructs an empty queue.
    @SuppressWarnings("unchecked")
    public HeapPriorityQueue() {
        this.tempComparator = null;
        elementData = (E[]) new Comparable[10]; // was Object
        size = 0;
    }
    
    // ADD METHODS HERE for exercise solutions:
    
    public HeapPriorityQueue(Collection<? extends E> collection) {
        this.tempComparator = null;
        elementData = (E[]) new Comparable[10]; // was Object
        size = 0;

        List<E> list = List.copyOf(collection);
        for(int i=0; i<collection.size(); i++) {
            add(list.get(i));
        }

    }

    public HeapPriorityQueue(Comparator<? super E> comparator) {
        this.tempComparator = comparator;
        size = 0;
        elementData = (E[]) new Comparable[10];
    }

    public HeapPriorityQueue(int heapSize) {
        this.tempComparator = null;
        elementData = (E[]) new Comparable[heapSize]; // was Object
        size = 0;

    }


    public E[] toArray() {
        E[] result = (E[]) new Comparable[size];
        int counter = 0;

        for(int i=0; i<elementData.length; i++) {
            if(elementData[i] != null) {
                result[counter++] = elementData[i];
            }

        }
        return result;
    }

    public boolean remove(E value) {
        // if its empty, what's there to remove
        if(isEmpty()) { throw new NoSuchElementException(); }
        int index = 0;
        boolean found = false;

        // makes sure it exists in the queue
        for(int i=1; i<size; i++) {
            if(elementData[i].compareTo(value) == 0) {
                index = i;
            }
        }
        if(index == 0) {
            return false;
        }

        // move rightmost leaf to become new root
        elementData[index] = elementData[size];
        size--;

        // "bubble down" root as necessary to fix ordering


        while (!found && hasLeftChild(index)) {
            int left = leftChild(index);
            int right = rightChild(index);
            int child = left;
            if (hasRightChild(index) &&
                    elementData[right].compareTo(elementData[left]) < 0) {
                child = right;
            }

            if (elementData[index].compareTo(elementData[child]) > 0) {
                swap(elementData, index, child);
                index = child;
            } else {
                found = true;  // found proper location; stop the loop
            }
        }

        if(tempComparator != null && size != 1) {
            List<E> list = Arrays.asList(elementData);

            list.subList(1, size+1).sort(tempComparator);
        }

        return found;
    }


//    public boolean remove(E value) {
//        if(isEmpty()) throw new NoSuchElementException();
//        boolean sorted = false;
//        boolean exists = false;
//        int index = 0;
//
//        for(int i=0; i<size; i++) {
//            if(elementData[i].compareTo(value) == 0) {
//                exists = true;
//                index = i;
//            }
//        }
//
//        if(index == 0) {
//            return false;
//        }
//
//        while (!sorted && hasLeftChild(index)) {
//            int left = leftChild(index);
//            int right = rightChild(index);
//            int child = left;
//            if (hasRightChild(index) &&
//                    elementData[right].compareTo(elementData[left]) < 0) {
//                child = right;
//            }
//
//            if (elementData[index].compareTo(elementData[child]) > 0) {
//                swap(elementData, index, child);
//                index = child;
//            } else {
//                found = true;  // found proper location; stop the loop
//            }
//        }
//
//    }
    
    public E poll() {
        if(isEmpty()) { return null; }

        E firstElement = peek();

        remove();

        return firstElement;
    }

    public void clear() {
        while(size != 0)
            elementData[size--] = null;

    }


    
    
    
    
    // Adds the given element to this queue.
    public void add(E value) {
        // resize if necessary
        if (size + 1 >= elementData.length) { // O(N) issue here
            elementData = Arrays.copyOf(elementData, elementData.length * 2);
        }
        
        // insert as new rightmost leaf
        elementData[size + 1] = value;
        
        // "bubble up" toward root as necessary to fix ordering
        int index = size + 1;
        boolean found = false;   // have we found the proper place yet?
        while (!found && hasParent(index)) {
            int parent = parent(index);
            if (tempComparator == null && elementData[index].compareTo(elementData[parent]) < 0) {
                swap(elementData, index, parent(index));
                index = parent(index);
            } else if(tempComparator != null && elementData[index].compareTo(elementData[parent]) > 0) {
                swap(elementData, index, parent(index));
                index = parent(index);
            } else {
                found = true;  // found proper location; stop the loop
            }
        }
        
        size++;

    }
    
    // Returns true if there are no elements in this queue.
    public boolean isEmpty() {
        return size == 0;
    }
    
    // Returns the minimum value in the queue without modifying the queue.
    // If the queue is empty, throws a NoSuchElementException.
    public E peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return elementData[1];
    }
    
    // Removes and returns the minimum value in the queue.
    // If the queue is empty, throws a NoSuchElementException.
    public E remove() {
        E result = peek();

        // move rightmost leaf to become new root
        elementData[1] = elementData[size];
        size--;
        
        // "bubble down" root as necessary to fix ordering
        int index = 1;
        boolean found = false;   // have we found the proper place yet?
        while (!found && hasLeftChild(index)) {
            int left = leftChild(index);
            int right = rightChild(index);
            int child = left;
            if (hasRightChild(index) &&
                    elementData[right].compareTo(elementData[left]) < 0) {
                child = right;
            }
            
            if (elementData[index].compareTo(elementData[child]) > 0) {
                swap(elementData, index, child);
                index = child;
            } else {
                found = true;  // found proper location; stop the loop
            }
        }

        if(tempComparator != null && size != 1) {
            List<E> list = Arrays.asList(elementData);

            list.subList(1, size+1).sort(tempComparator);
        }

        return result;
    }
    
    // Returns the number of elements in the queue.
    public int size() {
        return size;
    }
    
    // Returns a string representation of this queue, such as "[10, 20, 30]";
    // The elements are not guaranteed to be listed in sorted order.
    public String toString() {
        String result = "[";
        if (!isEmpty()) {
            result += elementData[1];
            for (int i = 2; i <= size; i++) {
                result += ", " + elementData[i];
            }
        }
        return result + "]";
    }
    
    
    // helpers for navigating indexes up/down the tree
    private int parent(int index) {
        return index / 2;
    }
    
    // returns index of left child of given index
    private int leftChild(int index) {
        return index * 2;
    }
    
    // returns index of right child of given index
    private int rightChild(int index) {
        return index * 2 + 1;
    }
    
    // returns true if the node at the given index has a parent (is not the root)
    private boolean hasParent(int index) {
        return index > 1;
    }
    
    // returns true if the node at the given index has a non-empty left child
    private boolean hasLeftChild(int index) {
        return leftChild(index) <= size;
    }
    
    // returns true if the node at the given index has a non-empty right child
    private boolean hasRightChild(int index) {
        return rightChild(index) <= size;
    }
    
    // switches the values at the two given indexes of the given array
    private void swap(E[] a, int index1, int index2) {
        E temp = a[index1];
        a[index1] = a[index2];
        a[index2] = temp;
    }


}
