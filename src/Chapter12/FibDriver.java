package Chapter12;

/* CS211 Fibonacci Class, for Chapter 12 Assignment
 * Bellevue College, W.P. Iverson, instructor
 * January 2020
 */
public class FibDriver {
    public static void main(String[] args) {
        /*
        Fibonacci test = new Fibonacci(10000); // only needed for overload
        //System.out.println(test.fibForLoop()); // slow version in text
        //System.out.println(test.fibonacci()); // slow version in text
       // System.out.println(test.bigFib()); // same as above, but use BigIntegers
        long startTime = System.nanoTime();
        System.out.println(test.bigFastFib()); // same as above, but MUCH faster
        long endTime = System.nanoTime();
        long elapsed = endTime - startTime;
        System.out.println("that took " + elapsed + " nanoseconds");
       // System.out.println(test.fib());
        */



        Fibonacci test = new Fibonacci(42); // constructor overload
        //System.out.println(test.fibForLoop()); // Chapter 2 code not used this week
        long time1 = System.currentTimeMillis();
        System.out.println(test.fibonacci()); // slow version in text
        long time2 = System.currentTimeMillis();
        System.out.println("slow version run time ms: " + (time2-time1));
        System.out.println();
        // After numerous tests, and analysis of code, and considerable thought:
        // I conclude that fibonacci() is very slow with Big-O complexity of O(2^N) (There are two branches, each of which have N number of operations or layers to perform)

        time1 = System.currentTimeMillis();
        //System.out.println(test.bigFib()); // same as above, but use BigIntegers
        System.out.println(test.bigFastFib()); // same as above, but MUCH faster
        time2 = System.currentTimeMillis();
        System.out.println("bigFastFib version run time ms: " + (time2-time1));
        // After numerous tests, and analysis of code, and considerable thought:
        // I conclude that bigFastFib() is very fast with Big-O complexity of O(N) (I think mine would be some sort of O(N-1, a+b, b) where a and b don't associate with N and start at constants
                                                                                                                                // neglecting a and b and the subtraction simply yields O(N)
    }


}