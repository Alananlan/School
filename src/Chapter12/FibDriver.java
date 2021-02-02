package Chapter12;

/* CS211 Fibonacci Class, for Chapter 12 Assignment
 * Bellevue College, W.P. Iverson, instructor
 * January 2020
 */
public class FibDriver {
    public static void main(String[] args) {
        Fibonacci test = new Fibonacci(400); // only needed for overload
        //System.out.println(test.fibForLoop()); // slow version in text
        //System.out.println(test.fibonacci()); // slow version in text
       // System.out.println(test.bigFib()); // same as above, but use BigIntegers
        long startTime = System.nanoTime();
        System.out.println(test.bigFastFib()); // same as above, but MUCH faster
        long endTime = System.nanoTime();
        long elapsed = endTime - startTime;
        System.out.println("that took " + elapsed + " nanoseconds");
       // System.out.println(test.fib());
    }
}