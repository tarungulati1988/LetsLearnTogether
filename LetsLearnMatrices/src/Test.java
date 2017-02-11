/**
 * Created by tgulati on 8/2/16.
 */
public class Test {
    public synchronized void methodA(int i, String msg){
        System.out.println(Integer.toString(i));
        System.out.println(msg);
    }


    public void methodB(int i, String msg){
        synchronized(this){
            System.out.println(Integer.toString(i));
            System.out.println(msg);
        }
    }

}