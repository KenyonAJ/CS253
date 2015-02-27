/**
 * CS 463 HW #1 question 2.
 */
public class SquareRootFloor
{
    public static double squareRoot (int n)
    {
        double x0 = 1;
        double x1;

        while (true)
        {
            x1 = (x0 + n/x0)/2;
            if (Math.abs(x1-x0) < 1.0e-6)
                break;
            x0 = x1;
        }
        return x1;
    }

    public static int floor (double d)
    {
        double e = d*10;
        int i = (int)e/10;
        return i;
    }

    public static void main (String[] args)
    {
        int m = 13;
        double x = squareRoot(m);
        System.out.println("The square root of " + m + " is " + x);
        System.out.println("The floor of the square root is " + floor(x));
    }
}
