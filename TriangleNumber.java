import java.util.Scanner;

public class TriangleNumber
{
    public static int triangle(int n)
    {
        int count = 0;
        while (n > 0)
        {
            count = count + n;
            --n;
        }
        return count;
    }
    public static int recTriangle(int n)
    {
        if (n==1)
            return 1;
        else
            return n + recTriangle(n-1);
    }
    public static void main (String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Select an index of the Triangle number sequence: ");
        int num = keyboard.nextInt();
        System.out.println("Computed iteratively the number is " + triangle(num));
        System.out.println("Computed recursively the number is " + recTriangle(num));
    }
}
