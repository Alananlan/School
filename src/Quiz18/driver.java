package Quiz18;

public class driver {
    public static void main(String[] args) {

        HashSet<Integer> test = new HashSet<Integer>();
        test.add(1); test.add(2); test.add(3); test.add(17);  test.add(443);
        System.out.println(test); // [1, 2, 3, 17, 443]
        System.out.println(test.backwards()); // above in reverse order

        test.add(13);  test.add(23);  test.add(33); // forcing collisions
        System.out.println(test.toString()); // more data
        //System.out.println(test.toString2()); // to see chained hashing
        System.out.println(test.backwards()); // reverse order

    }
}
