/**
 * Created by root on 1/20/2016.
 */

// Create second thread
public class NewThread implements Runnable {

    // Declare a thread
    Thread t;

    NewThread()
    {
        // instantiate a new thread
        t = new Thread(this, "Child Thread");
        System.out.println("Thread Created : " + t);

        // this will call run
        t.start();
    }


    // this is the entry point for the second thread
    public void run()
    {
        try{
            for(int i=10;i>0;i--)
            {
                System.out.println("Child thread : " + i);
                Thread.sleep(500);
            }
        }catch (InterruptedException ex)
        {
            System.out.println("Child Interrupted");
        }

        System.out.println("Exiting Child Thread");
    }
}
