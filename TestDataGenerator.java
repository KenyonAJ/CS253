import java.util.ArrayList;
import java.util.Random;
import java.io.*;
import java.util.Scanner;

public class TestDataGenerator {

    private ArrayList<Integer> a = new ArrayList<Integer>();
    private Random rand;
    private FileWriter fw;
    private BufferedWriter bw;
    private PrintWriter outFile;
    private Scanner parse;

    public TestDataGenerator ( ArrayList<Integer> a, File f ) throws IOException
    {
        this.a = a;
        fw = new FileWriter(f);
        bw = new BufferedWriter(fw);
        outFile = new PrintWriter(bw);
    }
    public TestDataGenerator ( File f ) throws IOException
    {
        fw = new FileWriter(f);
        bw = new BufferedWriter(fw);
        outFile = new PrintWriter(bw);
    }
    public void toOutfile ()
    {
        for ( Object obj : a)
            outFile.print (obj + " ");
        outFile.close();
    }

    public void rando()
    {
        rand = new Random();
        for (int i = 0 ; i < 2000 ; i++)
            outFile.print (rand.nextInt(250) + " ");
        outFile.close();
    }
    public void ascend()
    {
        for (int i = 0 ; i < 2000 ; i++)
            outFile.print ((i+1) + " ");
        outFile.close();
    }
    public void descend()
    {
        for (int i = 2000 ; i > 0 ; i--)
            outFile.print (i + " ");
        outFile.close();
    }




}
