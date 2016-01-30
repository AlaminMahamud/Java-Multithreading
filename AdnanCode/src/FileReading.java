import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;

/**
 * Created by root on 1/31/2016.
 */
public class FileReading implements Runnable {
    Thread t;

    ArrayList first = new ArrayList();
    ArrayList second = new ArrayList();

    FileReading(){
        t = new Thread(this, "second thread");
        t.start();
    }

    public void run(){
        System.out.println("Second Thread : start");
        readFromFirst();
        readFromSecond();
        System.out.println("Second Thread : finish");
    }

    void readFromFirst(){
        String fileName = "first file.txt";
        System.out.println("Read First File Data: \n");
        first = readFromFile(fileName);
    }

    void readFromSecond() {
        String fileName = "second file.txt";
        System.out.println("Read Second File Data: \n");
        second = readFromFile(fileName);
    }

    ArrayList readFromFile(String fileName)
    {
        ArrayList data = new ArrayList();

        String workingDir = System.getProperty("user.dir");
        String absoluteFilePath = workingDir + File.separator + fileName;
        try {
            BufferedReader br = new BufferedReader(new FileReader(absoluteFilePath));
            String line;
            while ((line = br.readLine()) != null) {
                // process the line.
                data.add(line);
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }

    ArrayList getFirst()
    {
        return first;
    }

    ArrayList getSecond(){
        return second;
    }
}
