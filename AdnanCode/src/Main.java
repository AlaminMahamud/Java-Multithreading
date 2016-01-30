import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

public class Main implements Runnable{

    static Thread t;

   static FileWriting fw;
   static FileReading fr;

    ArrayList first = new ArrayList();
    ArrayList second = new ArrayList();

    Main()
    {
        t = new Thread(this, "Main Thread");
        System.out.println("Main is Created");
    }

    public static void main(String[] args) {

        new Main();

        // thread 1 generates Random Number,and write to 2 file
        fw =  new FileWriting();
        try{
            fw.t.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        // thread 2 reads
        fr =  new FileReading();
        try{
            fr.t.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        // thread 3 Subtracts and write to another file
        System.out.println("waiting for threads to finish");
        t.start();

    }

    int determineArraySize()
    {
        int sizef = first.size();
        int sizel = second.size();

        if(sizef > sizel)
            return sizel;
        else
            return sizef;
    }

    void outputToFile(int size){

        String fileName = "third file.txt";
        String workingDir = System.getProperty("user.dir");

        String absoluteFilePath = workingDir + File.separator + fileName;

        File file = new File(absoluteFilePath);

       try{
           if (file.createNewFile()) {
               System.out.println("File is created");
           }else{
               //System.out.println("File is already existed!");
           }
       }catch (IOException e){
           e.printStackTrace();
       }

        ArrayList diff = new ArrayList(size);

        for(int i=0; i<size; i++){
            diff.add(Integer.valueOf(first.get(i).toString()) - Integer.valueOf(second.get(i).toString()));
            System.out.println(first.get(i) + " - " + second.get(i) + "  = " + (Integer.valueOf(first.get(i).toString()) - Integer.valueOf(second.get(i).toString())));
        }

        StringBuilder sb = new StringBuilder();

        for (Object s : diff){
            sb.append(s.toString());
            sb.append("\n");
        }

        try {
           Files.write(Paths.get(absoluteFilePath), sb.toString().getBytes(), StandardOpenOption.APPEND);
        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        System.out.println("Main Thread : start");
        populateArrayList();
        int size = determineArraySize();
        System.out.println("Write Third File Data: \n");
        outputToFile(size);
        System.out.println("Main Thread : finish");
    }

    void populateArrayList()
    {
        first  =  fr.getFirst();
        second =  fr.getSecond();
    }
}
