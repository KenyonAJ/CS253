import java.util.*;

public class Recursive { // Runs in O(logN)

    public int binSearch ( int[] a, int low, int hi, int target )
    {
        int mp; // midpoint

        if (low > hi) // target not found. (i.e. base case)
            return a.length;

        mp = (low + hi) / 2; // changes with each recursive call, depending on

        if ( a[mp] == target ) // found, we are done.
            return mp;
        else if (a[mp] < target) // look again in upper half
            return binSearch (a, mp+1, hi, target);
        else
            return binSearch (a, low, mp-1, target); // look again on lower half

    }

    public int factorial (int n)  // without using memoization or number theory tricks this is O(N)
    {
        if ( n == 0 ) // base case.  0! is defined as equal to 1
            return 1;
        else
            return n * factorial(n-1);
        // Interestingly enough, I read this is a pretty bad way to write it.
        // Rewrite after we learn about "tail" recursion.

    }

    public int fibbo ( int n ) // drawing a rec tree it looks like O(2^N)
    {
        if ( n == 0 ) // doesn't work if you start from here
            return 0;
        else if ( n == 1 ) // base case
            return 1;
        else
            return fibbo(n-1) + fibbo(n-2); // standard formula in every HS math textbook
    }




}
