import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by root on 1/31/2016.
 */
public class FileWriting implements Runnable{

    Thread t;
    private Random rand;

    FileWriting(){
        rand = new Random();
        t = new Thread(this, "first thread");
        t.start();
    }

    public void run(){
        System.out.println("First Thread : start");
        outputToFirstFile();
        outputToSecondFile();
        System.out.println("First Thread : finish");
    }

    private int generateRandomNumber() {
        return rand.nextInt();
    }

    void outputToFirstFile(){
        String fileName = "first file.txt";
        System.out.println("Write First File Data: \n");
        outputToFile(fileName, 5);
    }

    void outputToSecondFile(){
        String fileName = "second file.txt";
        System.out.println("Write Second File Data: \n");
        outputToFile(fileName, 5);
    }

    void outputToFile(String fileName, int size){

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

        StringBuilder sb = new StringBuilder();
        for (int i =0; i<size; i++){
            sb.append(generateRandomNumber());
            sb.append("\n");
        }

        // printing data of file
        System.out.println(sb);

        try {
            Files.write(Paths.get(absoluteFilePath), sb.toString().getBytes(), StandardOpenOption.APPEND);
        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }

}
