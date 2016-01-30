/**
 * Created by root on 1/20/2016.
 */
public class NewThread extends Thread {
    NewThread()
    {
        super("Demo Thread");
        System.out.println("Child Thread : " + this);
        start(); // start the thread
    }

    // this is the entry point for the second thread
    public void run()
    {
        try
        {
            for (int i = 5; i > 0; i--)
            {
                System.out.println("Child Thread : " + i);
                Thread.sleep(100);
            }
        }catch (InterruptedException ex)
        {
            System.out.println("Child Interrupted");
        }

        System.out.println("Child Exiting");
    }

}
