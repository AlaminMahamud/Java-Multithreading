/**
 * Created by root on 1/20/2016.
 */
public class NewThreadDemo {
    public static void main(String[] args)
    {
        new NewThread();

        // get the main thread
        Thread t = Thread.currentThread();
        t.setName("Main Thread");
        System.out.println("Main Thread " + t);

        try
        {
            for(int i=10; i>0; i--)
            {
                System.out.println("Main "+i);
                Thread.sleep(1000);
            }
        }catch (InterruptedException ex)
        {
            System.out.println("Main Interrupted");
        }

        System.out.println("Main Exiting");
    }
}
