/**
 * Design a program that allows you to experiment with different sort algorithms. This program should allow
 * you to easily plug-in new sort algorithms and compare them.   Assume that input data is generated randomly
 * and stored in  a text file (have no less than 2000 items to sort). Do not  restrict your program to only one
 * data type, or to one  ordering relationship. The data type, ordering relationship,  and the sorting method must
 * be input parameters for your program. It must produce a comparison chart of all implemented  sort algorithms
 * (consider both comparisons and exchanges).  Do not forget to include worst and best cases in your empirical study.
 * Start with insertion, selection and bubble sorts (other sorts may be included later as we review/study them in class).
 *
 * Checklist:
 * User Interface
 * ** Choose sort method
 * ** Choose ordering relationship
 *
 * Comparison chart
 * ** Best / Worse case
 * Generate input data
 * ** from already sorted
 * ** from random unsorted
 * ** from worst case (i.e. backward "sorted") unsorted
 * Note to self: probably need to handle the exception for when non-Integers (e.g. just hitting Enter)
 * are selected from the option menu

 * Created by Starscream on 2/1/14.
 */

import java.util.*;
import java.io.*;
import javax.swing.*;

class Program01 {

    public static void main (String[] args) throws IOException
    {
        int mIndex = 0;
        int mCase, oCase, switchCase;
        Scanner keyboard = new Scanner (System.in);
        JFileChooser chooser = new JFileChooser();
        File inputFile, outputFile;
        outputFile = new File ("SortComparisonData.txt");
        long sortTime;
        long bblA[] = new long[20];
        long bblD[] = new long[20];
        long selA[] = new long[20];
        long selD[] = new long[20];
        long insA[] = new long[20];
        long insD[] = new long[20];
        int bbla = 0; int bbld = 0; int sela = 0; int seld = 0; int insa = 0; int insd = 0;
        PrintWriter pw = new PrintWriter (outputFile);
        Boolean flag = true;
        String response;

        ArrayList<String> methods = new ArrayList<String>();
        methods.add("Bubble Sort");
        methods.add("Selection Sort");
        methods.add("Insertion Sort");

        // Generate a random data input source
        //String randData = "randomData.txt";
        //outputFile = new File (randData);
        //TestDataGenerator TestData = new TestDataGenerator(outputFile);
        //randTestData.rando();
        //String ascendData = "ascendingData.txt";
        //outputFile = new File (ascendData);
        //TestDataGenerator TestData = new TestDataGenerator(outputFile);
        //TestData.ascend();
        //String descendData = "descendingData.txt";
        //outputFile = new File (descendData);
        //TestDataGenerator TestData = new TestDataGenerator(outputFile);
        //TestData.descend();

        while (flag)
        {

        System.out.println ("Please select from the following options: ");
        System.out.println ("1. Bubble Sort\n2. Selection Sort\n3. Insertion Sort");
        mCase = Integer.parseInt(keyboard.nextLine());

        System.out.println ("Ascending or Descending order?\n1. Ascending.\n2. Descending.\n");
        oCase = Integer.parseInt(keyboard.nextLine());

        switchCase = Integer.parseInt(String.valueOf(mCase).concat(String.valueOf(oCase)));

        JOptionPane.showMessageDialog (null, "Select a file to sort.");
        chooser.showOpenDialog(null); // My personal convenience; cmd directory navigation is tedious.
        inputFile = chooser.getSelectedFile();

        switch (switchCase)
        {
            case 11:
                BubbleSort bubbleSort;
                bubbleSort = new BubbleSort (inputFile);
                bubbleSort.sort();
                bubbleSort.writeToFile();
                sortTime = bubbleSort.getLastSortTime();
                System.out.println("Timer: " + sortTime);
                bblA[bbla] = sortTime;
                bbla++;
                break;
            case 12:
                BubbleSort2 bubbleSort2;
                bubbleSort2 = new BubbleSort2 (inputFile);
                bubbleSort2.sort();
                bubbleSort2.writeToFile();
                sortTime = bubbleSort2.getLastSortTime();
                System.out.println("Timer: " + sortTime);
                bblD[bbld] = sortTime;
                bbld++;
                break;
            case 21:
                SelectionSort selectSort;
                selectSort = new SelectionSort (inputFile);
                selectSort.sort();
                selectSort.writeToFile();
                sortTime = selectSort.getLastSortTime();
                System.out.println("Timer: " + sortTime);
                selA[sela] = sortTime;
                sela++;
                break;
            case 22:
                SelectionSort2 selectSort2;
                selectSort2 = new SelectionSort2 (inputFile);
                selectSort2.sort();
                selectSort2.writeToFile();
                sortTime = selectSort2.getLastSortTime();
                System.out.println("Timer: " + sortTime);
                selD[seld] = sortTime;
                seld++;
                break;
            case 31:
                InsertionSort insertSort;
                insertSort = new InsertionSort (inputFile);
                insertSort.sort();
                insertSort.writeToFile();
                sortTime = insertSort.getLastSortTime();
                System.out.println("Timer: " + sortTime);
                insA[insa] = sortTime;
                insa++;
                break;
            case 32:
                InsertionSort2 insertSort2;
                insertSort2 = new InsertionSort2 (inputFile);
                insertSort2.sort();
                insertSort2.writeToFile();
                sortTime = insertSort2.getLastSortTime();
                System.out.println("Timer: " + sortTime);
                insD[insd] = sortTime;
                insd++;
                break;
            default:
                System.out.println("Invalid menu selection.");
                break;
        }
            System.out.println("Continue: Y or N");
            response = keyboard.nextLine();
            if (response.equalsIgnoreCase("n"))
                flag = false;
        }
        String bubbleA = String.valueOf(bblA[0] + "\t" + bblA[1] + "\t" + bblA[2]);
        String bubbleD = String.valueOf(bblD[2] + "\t" + bblD[1] + "\t" + bblD[0]);
        String selectA = String.valueOf(selA[0] + "\t" + selA[1] + "\t" + selA[2]);
        String selectD = String.valueOf(selD[2] + "\t" + selD[1] + "\t" + selD[0]);
        String insertA = String.valueOf(insA[0] + "\t" + insA[1] + "\t" + insA[2]);
        String insertD = String.valueOf(insD[2] + "\t" + insD[1] + "\t" + insD[0]);


        pw.println("Data order: Best case\tNormal\tWorst case");
        pw.println("Bubble Sort (A): " + bubbleA);
        pw.println("Bubble Sort (D): " + bubbleD);
        pw.println("Selection Sort (A): " + selectA);
        pw.println("Selection Sort (D): " + selectD);
        pw.println("Insertion Sort (A): " + insertA);
        pw.println("Insertion Sort (D): " + insertD);
        pw.close();


    }
}
