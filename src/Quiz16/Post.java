package Quiz16;
// Code to post with Quiz16
// copyright by Bellevue College
public class Post {
    public static void main(String[] q16) {
        LinkedList<Integer> quiz16 = new LinkedList<Integer>();
        System.out.println(quiz16.isPerfectMirror()); // false
        quiz16.add(1); quiz16.add(2); quiz16.add(3);
        quiz16.add(3); quiz16.add(2); quiz16.add(1); //quiz16.add(7);
        System.out.println(quiz16.size());
        System.out.println(quiz16); // [1, 2, 3, 3, 2, 1]
        System.out.println(quiz16.isPerfectMirror()); // true
        quiz16.undoMirror();
        System.out.println(quiz16); // [1, 2, 3]
    }
}