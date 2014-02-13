import java.util.*;
import java.io.*;

public class BubbleSort implements Comparable<Integer> {

    private int nElems,  out, in;
    protected ArrayList<Integer> a = new ArrayList<Integer>();
    private TestDataGenerator bblGen;
    private Scanner parse;
    private long startTime, endTime;
    private String outFile = "bubbleA.txt";
    private File b = new File (outFile);


    public BubbleSort  ( File f ) throws IOException
    {
        parse = new Scanner(f);
        parse.useDelimiter(" ");

        while (parse.hasNext())
        {
            a.add(Integer.valueOf(parse.next()));
        }
        parse.close();
        nElems = a.size();
    }

   public void sort ()
   {
       startTime = System.currentTimeMillis();
       for ( out = nElems-1 ; out > 1 ; out--)
       {
           for ( in = 0 ; in < out ; in++ )
           {
               if ( (a.get(in)).compareTo(a.get(in+1)) > 0 )
               {
                   swap (in, in+1);
               }
           }
       }
       endTime = System.currentTimeMillis();
   }

    public void writeToFile () throws IOException
    {
        bblGen = new TestDataGenerator(a,b);
        bblGen.toOutfile();
    }


    public long getLastSortTime ()
    {
        return endTime - startTime;
    }

    private void swap (int x, int y)
    {
        Integer temp = a.set( x, a.get(y));
        a.set (y, temp);
    }

    void display ()
    {
        System.out.println("\n\nCalled from BubbleSort - Ascending.");
        for (Comparable thing : a )
            System.out.print (thing + "\t");
        System.out.println();
    }


    @Override
    public int compareTo(Integer i) {

        Integer thisThing, otherThing;

        thisThing = (a.get(in));
        otherThing = (a.get(in+1));

        if (thisThing < otherThing)
            return -1;
        else if (thisThing > otherThing)
            return 1;
        else
            return 0;
    }
}
