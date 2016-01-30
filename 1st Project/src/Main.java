/*
    Purpose -> Controlling the Main Thread
 */

public class Main {

    public static void main(String[] args) {
        Thread t = Thread.currentThread();

        System.out.println("Current Thread:  " + t);

        // Change the name of the Thread
        t.setName("Main Thread");

        System.out.println("After Name Change : " + t);

        try {
            for (int n = 5; n > 0; n--) {
                System.out.println(n);
                Thread.sleep(500);
            }
        }catch(InterruptedException ex)
        {
            System.out.println("Main Thread Interrupted");
        }
    }
}
