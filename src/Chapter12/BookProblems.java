package Chapter12;

public class BookProblems {
    public static void main(String[] args) {


        System.out.println(doubleDigits(12));

        System.out.println(multiplyEvens(5));

        //System.out.println(sumTo(2));

        System.out.println(dedup("bbbbaannaana"));

        System.out.println(dedup("String"));

        System.out.println(dedup("bookkkkkeeper"));
    }


    public static int doubleDigits(int n) {

        if (n == 0) {
            return 0;
        } else {
            int lastDigit = n % 10;
            return 100 * doubleDigits(n / 10) + 10 * lastDigit + lastDigit;
        }
    }
/*
    d(12):
        lastdigit = 2
    return 100*doubleDigits(12/10) + 10 * 2 + 2
    return 100*11+10*2+2
                d(1):
                    lastdigit = 1
                    return 100*doubledigits(1/10) + 10 * 1 + 1
                    return 11
                     d(0):
                        return 0
    */


    public static int multiplyEvens(int n) {

        if (n <= 0) throw new IllegalArgumentException();
        else if (n == 1) return 2;
        else {
            int k = n * 2;
            return multiplyEvens(n - 1) * k;
        }
    }
      /* m(4):
            4*2=8
            4-1=3
            m(3):

            m(4*2 * m(3*2 * m(2*2 * m(1) ) ) )
              8    *    6    *     4  * 2

        m(2)
            return 8


            */

    public static double sumTo(int n) {

        if (n==0) return 0.0;
        else if (n < 0.0) throw new IllegalArgumentException();
        else {
            int k = 1/n;
            return sumTo( n - 1 ) + k;

        }
/*
s(2)
    s(1/2) + 1


 */



    }

    /* public static String dedup(String s) {
        if (s.length() <= 1)
            return s;
        else if (s.charAt(0) == s.charAt(1)) { // if THIS == NEXT then skip THIS

            return dedup(s.substring(1)); // passes string without index 0

        } else
            return s.substring(0, 1) + dedup(s.substring(1)); // adds index 0 but passes string after 0
    }
*/
    public static String dedup(String s) {
        if (s.length() < 2) return s;
        else if (s.charAt(0) != s.charAt(1)) return s.charAt(0) + dedup(s.substring(1)); //
        else return dedup(s.substring(1)); // skips onto next

    }

  /*
  d(bbbbaannaana):
    d(bbbaannaana):
      d(bbaannaana)
        d(baannaana)



  d(String)
    return S + d(tring)
    return t + d(ring)
    return r + d(ing)
    return i + d(ng)
    return n + d(g)
    return g



   */
}
