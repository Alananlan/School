package Final;//  NO IMPORTS ALLOWED

import java.util.NoSuchElementException; // :)

/* Class SortedLinkedList<E> for final exam day
*  from Buildingjavaprograms.com
*  copyright Bellevue College, March 2021
*  added backwards() to check list in backwards order
*  plus many changes to enforce no imports, just java.lang.*
*/

/*
Alan Ly
Prof Iverson
CS211
24 March 2021
 */
public class SortedLinkedList<E extends Comparable<E>> { 
	// FIELDS:
    private ListNode<E> front;  // leftmost node of the list
    private ListNode<E> back;   // rightmost node of the list
    private int size;           // current number of elements

    // post: constructs an empty list
    public SortedLinkedList() {
        front = new ListNode<E>(null);
        back = new ListNode<E>(null);
        clear();
    }
    
    // TOTAL HACK, just to get three data points loaded
    // Keep this poor constructor, so initial testing is possible
    // Later on we'll write a better .add method and constructor(s)
	public SortedLinkedList(E i, E j, E k) {
		ListNode<E> a = new ListNode<E>(i,null,null);
		ListNode<E> b = new ListNode<E>(j,null,a);
		ListNode<E> c = new ListNode<E>(k,null,b);
        front = new ListNode<E>(null,a,null);
        back = new ListNode<E>(null,null,c);
        a.right = b; a.left = front;
		b.right = c;
		front.right = a;
		back.left = c;
		c.right = back;
		size = 3;
	}
    
// ADD METHODS (CONSTRUCTORS) FOR EXAM HERE: 
	// 1. count data items
	// 2. removeDuplicates
	// 3. deleteLast with O(constant) required 
	// 4. add method, that adds into correct position
	// 5. Constructor to load in any array for initial values
    

	// Code just to get things started:
	
	// 1.
	public int dataCount(E data) {
        if(size() == 0) { return 0; }

        ListNode<E> current = front.right;
        int count = 0;

        for(int i=0; i<size(); i++) {
            if(current.data.compareTo(data) == 0)
                count++;
            else if (i != size()-1)
                current = current.right;
        }
		return count;
	}

	// 2.
	public void removeDuplicates() {
        ListNode<E> current = front.right;

        while(current != null && current.right != null) {
            //compares because sorted
            if(current.data == current.right.data) {
                current.right = current.right.right;
                current.right.left = current;
                size--;
            } else {
                current = current.right;
            }
        }
	}
	
	// 3.
	public E deleteLast() {
        if(size() == 0) { throw new NoSuchElementException(); }
        E current = back.left.data;
        //left pointer of back node point to the second to last node, vice versa
        back.left = back.left.left;
        back.left.right = back;
        size--;

		return current;
	}
	
	// 4.
	public boolean add(E item) {
        ListNode<E> current = front.right;
        boolean added = false;

        //if empty add new item, link with front and back
        if(size() == 0) {
            front.right = new ListNode<E>(item, back, front);
            back.left = front.right;
            size++;
            return true;
        }

        //front case
        if(current.data.compareTo(item) > 0) {
            current.left = new ListNode<E>(item, current, front);
            front.right = current.left;
            size++;
            return true;
        }

        //iterate through
        while(current.data.compareTo(item) < 0) {
            //back node case
            if(current.right == back) {
                back.left = new ListNode<E>(item, back, current);
                current.right = back.left;
                size++;
                return true;
            }
            current = current.right;
        }

        //default inserts to left side current b/c current > item
        current.left = new ListNode<E>(item, current, current.left);
        current.left.left.right = current.left;
        size++;

		return added;
	}
	
	// 5.
	public SortedLinkedList(E[] array) {
		this();

        for(int i=0; i<array.length; i++) {
            add(array[i]);
        }
	}
	

    
//-------------------------------------------------------------------------
    // Below here is provided code from textbook, modified for CS211 exam
    
    // post: returns the current number of elements in the list
    public int size() {
        return size;
    }

    // post: creates a comma-separated, bracketed version of the list
    public String toString() {
        if (size == 0) {
            return "[]";
        } else {
            String result = "[" + front.right.data;
            ListNode<E> current = front.right.right;
            while (current != back) {
                result += ", " + current.data;
                current = current.right;
            }
            result += "]";
            return result;
        }
    }
    
    // post: creates a comma-separated, bracketed version of the list
    // Creation to test reverse links in order
    public String backwards() {
        if (size == 0) {
            return "[]";
        } else {
            String result = "[" + back.left.data;
            ListNode<E> current = back.left.left;
            while (current != front) {
                result += ", " + current.data;
                current = current.left;
            }
            result += "]";
            return result;
        }
    }

    // post : returns the position of the first occurrence of the given
    //        value (-1 if not found)
    public int indexOf(E value) {
        int index = 0;
        ListNode<E> current = front.right;
        while (current !=  back) {
            if (current.data.equals(value)) {
                return index;
            }
            index++;
            current = current.right;
        }
        return -1;
    }

    // post: returns true if the given value is contained in the list,
    //       false otherwise
    public boolean contains(E value) {
        return indexOf(value) >= 0;
    }

    // post: list is empty
    public void clear() {
        front.right = back;
        back.left = front;
        size = 0;
    }

//----------------------------------------------------------------------------
    // INNER Class to provide nodes for this linked list
    // changed to right and left so list could easily adapt to reversals

    private static class ListNode<E> {
        public E data;         	// data stored in this node
        public ListNode<E> right;  // link to the conceptual right 
        public ListNode<E> left;  // link to the conceptual left 
        // post: constructs a node with given data and null links
        public ListNode(E data) {
            this(data, null, null);
        }

        // post: constructs a node with given data and given links
        public ListNode(E item, ListNode<E> first, ListNode<E> second) {
            data = item;
            right = first;
            left = second;
        }
    }
}