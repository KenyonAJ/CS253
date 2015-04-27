/**
 * Created by Andrew Kenyon on 4/25/2015.
 */
import java.util.Scanner;

public class BinExp
{
    // helper function, decimal --> binary string
    public static String toBinary(int n)
    {
        String result;
        if(n <= 1)
        {
            result = "" + n;
        }
        else
        {
            result = toBinary(n/2) + n%2;
        }
        return result;
    }

    // helper function, binary string --> array of bin digits
    public static int[] stringToIntArray(String s)
    {
        int[] array = new int[s.length()];
        String[] S = s.split("");

        for(int i = 0; i < S.length ; i++)
        {
            array[i] = Integer.parseInt(S[i]);
        }
        return array;
    }

    // the magic
    public static int LtoR(int a, int[] b)
    {
        int product = 1;
        for(int i = 0; i <= b.length-1; i++)
        {
            product *=  product;
            if(b[i] == 1)
            {
                product = product * a;
            }
        }
        return product;
    }

    // the magic
    public static int RtoL(int a, int[] b)
    {
        int n = b.length -1;
        int term = a;
        int product;
        if(b[n] == 1)
        {
            product = a;
        }
        else
        {
            product = 1;
        }
        for(int i = 1; i <= b.length-1; i++)
        {
            term *= term;
            if(b[n-i] == 1)
            {
                product = product * term;
            }
        }
        return product;
    }

    // provide base b, exponent n, and watch the magic happen
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);

        // get user input
        System.out.println("Enter base number:");
        int b = keyboard.nextInt();
        System.out.println("Enter exponent:");
        int n = keyboard.nextInt();

        // convert exponent to binary expansion
        String str = toBinary(n);
        int[] binDigits = stringToIntArray(str);

        // display results
        System.out.println();
        System.out.println("Left-to-right output: " + LtoR(b, binDigits));
        System.out.println("Right-to-left output: " + RtoL(b, binDigits));
        System.out.println();

        // doesn't strictly need to be displayed.  was useful during testing/debugging
        System.out.print("Contents of list b(n), binary coefficient digit expansion: ");
        for(int x : binDigits)
            System.out.print(x + " ");
    }
}
