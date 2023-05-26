package src.db_tester;

public class Test {
    public static void main(String[] args) {
        Test e1 = new Test();
        System.out.println(e1.recurse(2,-4));
    }

    public int recurse(int number, int rate) {
        if (rate > 0) {
            if (rate == 1) return number;
            else return number * recurse(number, rate - 1);
        } else return 1;
    }
}
