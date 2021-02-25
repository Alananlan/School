package Quiz14;

import java.util.LinkedList;
import java.util.Queue;

public class main {
    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<Integer>();
       stack.push(1); stack.push (2); stack.push(3); stack.push(4);
       stack.push(5); stack.push(6); stack.push(7); stack.push(8);

       Stack<Integer> stack2 = new Stack<Integer>();
         stack2.push(1); stack2.push(2); stack2.push(3); stack2.push(4);
      stack2.push(5); stack2.push(6); stack2.push(7);

        System.out.println("Bottom " + stack.toString() + " top");
        reverseOddHalf(stack);
        System.out.println("Bottom " + stack.toString() + " top");

        System.out.println("Bottom " + stack2.toString() + " top");
        reverseOddHalf(stack2);
        System.out.println("Bottom " + stack2.toString() + " top");

    }

    public static void reverseOddHalf(Stack<Integer> stack ) {

        Queue<Integer> queue = new LinkedList<>();
        int size = stack.size();

        // puts elements into a queue, reversing the order
        while(!stack.empty()) { queue.add(stack.pop()); }

        // even elements back into stack (reversed), queue re-adds (retains) reversed odd elements
        for (int i = 0; i < size; i++) {

            if (size % 2 == 0) { // even sequence
                if (i % 2 != 0) { stack.push(queue.remove()); }
                else queue.add(queue.remove());
            } else { // odd sequence
                if (i % 2 == 0) { stack.push(queue.remove()); }
                else queue.add(queue.remove());
            }

        }

        // reintroduces stack elements into queue staggered
        for(int i=0; i<size; i++) {

            if(i % 2 == 0) {
                queue.add(stack.pop());
            } else queue.add(queue.remove());

        }

        // restores elements to original stack
        while(!queue.isEmpty()) { stack.push(queue.remove()); }

    }
}
