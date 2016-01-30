/**
 * Created by root on 1/20/2016.
 */
public class NewThreadDemo {

    public static void main(String[] args)
    {
        new NewThread();

        // get the main Thread
        Thread t = Thread.currentThread();
        t.setName("Main Thread");
        System.out.println("After Changing Name :  " + t);
        t.start();

        try {
            for(int i=5; i>0; i--)
            {
                System.out.println("Main Thread : " + i);
                Thread.sleep(500);
            }
        }catch (InterruptedException ex)
        {
            System.out.println("Main Interrupted");
        }

        System.out.println("Main Exiting");
    }

}
