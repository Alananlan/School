package Chapter14;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.Queue;

public class Chapter14java {

    public Chapter14java(){
        super();
    }

    public static Stack<CalendarDate> stutter(Stack<CalendarDate> stack1){
        Queue<CalendarDate> queue = new LinkedList<CalendarDate>();

        Stack<CalendarDate> stack2 = new Stack<>();

        // s2q operation
        while(!stack1.empty()) { queue.add(stack1.pop()); }

        // q2s operation
        while(!queue.isEmpty()) { stack2.push(queue.remove()); }

        // s2q operation
        while(!stack2.empty()) { queue.add(stack2.pop()); }

        // q2s operation but refill stack1 and double stack2
        while(!queue.isEmpty()) {
            CalendarDate date = queue.remove();
            stack2.push(date);
            stack2.push(date);
            stack1.push(date);
        }

        return stack2;
    }

    public static boolean equals(Stack<CalendarDate> stack1, Stack<CalendarDate> stack2){

        Stack<CalendarDate> aux = new Stack<>();
        boolean bool = true;

        if (stack1.size() != stack2.size()) { bool = false; }
        if (stack1.hashCode() == stack2.hashCode()) { return true; }

        // if both have values then compare if equal
        while(!stack1.empty() && !stack2.empty()) {
            CalendarDate s1 = stack1.pop();
            CalendarDate s2 = stack2.pop();
            aux.push(s1);
            aux.push(s2);

            if(s1.compareTo(s2) != 0) {
                bool = false;
                break;
            }
        }

        // put back into respective stacks
        while(!aux.empty()) {
            CalendarDate s1 = aux.pop();
            CalendarDate s2 = aux.pop();
            stack1.push(s1);
            stack2.push(s2);
        }
        return bool;
    }

    public static boolean isSorted(Stack<CalendarDate> stack1){
        boolean bool = true;
        Stack<CalendarDate> stack2 = new Stack<CalendarDate>();

        CalendarDate init = stack1.pop();
        stack2.push(init); // initializes sorting test, must compare to a starting value

        // compares current peek with starting value if in order, then push to auxiliary
        while(!stack1.empty()) {
            CalendarDate date = stack1.peek();
            if(date.compareTo(init) > 0) {
                bool = false;
                break;
            }
            init = date;

            stack2.push(stack1.pop());
        }
        // pops from 2 back into stack 1
        while(!stack2.empty()) { stack1.push(stack2.pop()); }

        return bool;
    }

    public static CalendarDate removeMin(Stack<CalendarDate> stack1){

        if (stack1.size() < 1) { return null; }
        Queue<CalendarDate> queue = new LinkedList<>();
        CalendarDate mindate = stack1.peek(); // initializes first date

        // compares minimum date with current date, adds to queue
        while(!stack1.empty()) {
            CalendarDate date = stack1.pop();

            if(date.compareTo(mindate) < 0) { mindate = date; }

            queue.add(date);
        }

        // filters date if mindate going back into stack1
        while(!queue.isEmpty()) {
            CalendarDate date = queue.peek();
            if (date.equals(mindate)) {
                queue.remove();
            } else {
                date = queue.remove();
                stack1.push(date);
            }
        }

        // reversal s2q and q2s to reorder
        while(!stack1.empty()) {
            queue.add(stack1.pop());
        }

        while(!queue.isEmpty()) {
            stack1.push(queue.remove());
        }
        return mindate;
    }



}
