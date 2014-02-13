import java.util.*;
import java.io.*;

public class SelectionSort2 implements Comparable<Integer> {

    private int nElems,  out, in, min;
    protected ArrayList<Integer> a = new ArrayList<Integer>();
    private TestDataGenerator selGen;
    private String outFile = "selectD.txt";
    private File b = new File (outFile);
    Scanner parse;
    private long startTime, endTime;

    public SelectionSort2 ( File f ) throws IOException
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

    void sort ()
    {
        startTime = System.currentTimeMillis();
        for ( out = 0 ; out < nElems-1 ; out++)
        {
            min = out;
            for ( in = out + 1 ; in < nElems ; in++)
            {
                if (a.get(in).compareTo(a.get(min)) > 0)
                    min = in;
            }
            swap (out, min);
        }
        endTime = System.currentTimeMillis();
    }
    public long getLastSortTime ()
    {
        return endTime - startTime;
    }

    public void writeToFile () throws IOException
    {
        selGen = new TestDataGenerator(a,b);
        selGen.toOutfile();
    }

    private void swap (int x, int y)
    {
        Integer temp = a.set( x, a.get(y));
        a.set (y, temp);
    }

    void display ()
    {
        System.out.println("\n\nCalled from SelectionSort - Descending.");
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
