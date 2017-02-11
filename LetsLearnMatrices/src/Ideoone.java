/**
 * Created by tgulati on 8/2/16.
 */
public final class Ideoone {
    class Inner {
        void test() {
            if (Ideoone.this.flag); {
                sample();
            }
        }
    }
    private boolean flag = true;
    public void sample() {
        System.out.println("Sample");
    }
    public Ideoone() {
        (new Inner()).test();
    }
    public static void main(String args []) {
        new Ideoone();
    }
}
