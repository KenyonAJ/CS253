import java.util.*;
import java.io.*;

public class InsertionSort implements Comparable<Integer> {

    private int nElems,  out, in, min;
    protected ArrayList<Integer> a = new ArrayList<Integer>();
    private TestDataGenerator insrtGen;
    private String outFile = "insertA.txt";
    private File b = new File (outFile);
    Scanner parse;
    private long startTime, endTime;

    public InsertionSort ( File f ) throws IOException
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

    void sort()
    {
        startTime = System.currentTimeMillis();
        Integer temp[] = new Integer[1];
        for ( out = 1 ; out < nElems ; out++)
        {
            temp[0] = a.get(out);
            in = out;
            while ( in > 0 && a.get(in-1).compareTo(temp[0]) >= 0 )
            {
                a.set(in, a.get(in-1));
                --in;
            }
            a.set(in, temp[0]);
        }
        endTime = System.currentTimeMillis();
    }
    public long getLastSortTime ()
    {
        return endTime - startTime;
    }

    public void writeToFile () throws IOException
    {
        insrtGen = new TestDataGenerator(a,b);
        insrtGen.toOutfile();
    }

    private void swap (int x, int y)
    {
        Integer temp = a.set( x, a.get(y));
        a.set (y, temp);
    }

    void display ()
    {
        System.out.println("\n\nCalled from InsertionSort - Ascending.");
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
