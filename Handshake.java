import java.util.Scanner;

public class Handshake
{
    public static int handshakes(int[] x)
    {
        int size_x = x.length;
        int count = 0; // total number of handshakes
        for (int i=0; i < size_x; i++)
            for (int j=size_x-1; j > i; j--)
                count++;
        return count;
    }

    public static void main (String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        int num; // number of people to shake hands
        int[] a;
        System.out.println("Enter number of people: ");
        num = keyboard.nextInt();
        a = new int[num];
        for (int i=0; i < num; i++)
            a[i] = i;
        System.out.println("Number of handshakes is " + handshakes(a));
    }
}
