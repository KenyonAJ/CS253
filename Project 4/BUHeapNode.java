/**
 * Created by Andrew Kenyon on 4/17/2015.
 */

import java.util.Random;

public class BUHeapNode
{
    class Node
    {
        private int data;

        public Node(int key)
        {
            data = key;
        }
        public int getKey()
        {
            return data;
        }
        public void setKey(int id)
        {
            data = id;
        }
    }

    private int comp, exch; // basic operation counters
    private int n; // heap current max size

    // takes an unsorted array and heapifies it from the bottom up
    public Node[] Heap(Node[] A)
    {
        for(int i = n/2; i >= 1; i--)
        {
            int k = i;
            Node v = A[k-1];
            boolean heap = false;

            while(!heap && 2*k <= n)
            {
                int j = 2*k;
                if(j < n)
                {
                    comp++;
                    if(A[j-1].getKey() < A[j].getKey())
                    {
                        comp++;
                        j += 1;
                    }
                }
                if(v.getKey() >= A[j-1].getKey())
                {
                    comp++;
                    heap = true;
                }
                else
                {
                    exch++;
                    A[k-1] = A[j-1];
                    k = j;
                }
            }
            A[k-1] = v;
        }
        return A;
    }

    // Swaps root with final entry, decrements heap size, and re-Heapify
    public int remove(Node[] A)
    {
        Node temp = A[0];
        A[0] = A[--n];
        Heap(A);
        A[n] = temp;
        return temp.getKey();
    }

    // displays elements in Heap
    public void display(Node[] A)
    {
        if(A == null)
        {
            System.out.println("empty");
            return;
        }
        for(int i = 0; i < n; i++)
        {
            System.out.print(A[i].getKey() + " ");
        }
        System.out.println();
    }

    // displays results of in-place sort
    public void display2(Node[] A)
    {
        if(A == null)
        {
            System.out.println("empty");
            return;
        }
        for(Node x : A)
        {
            System.out.print(x.getKey() + " ");
        }
        System.out.println();
    }

    // performs successive remove operations on heap
    // until heap is empty. result is a sorted array (not heap)
    public void sort(Node[] A)
    {
        while(n > 0)
        {
            remove(A);
        }
    }

    // evaluate heapify performance
    public void evaluate()
    {
        Random rand = new Random();
        n = 1000;
        Node[] sortMe = new Node[n];

        // array: low -> high
        for(int i = 0; i < n; i++)
        {
            Node newNode = new Node(i);
            sortMe[i] = newNode;
        }
        Heap(sortMe);
        System.out.println("Array: low -> high");
        System.out.println("Comparisons: " + comp + "\nExchanges: " + exch);
        System.out.println("------------------------");

        comp = 0; exch = 0; n = 1000; // reset counts

        // array: high -> low
        for(int i = 0; i < n; i++)
        {
            Node newNode = new Node(n-i);
            sortMe[i] = newNode;
        }
        Heap(sortMe);
        System.out.println("Array: high -> low");
        System.out.println("Comparisons: " + comp + "\nExchanges: " + exch);
        System.out.println("------------------------");

        comp = 0; exch = 0; n = 1000; // reset counts

        // array: random order
        for(int i = 0; i < n; i++)
        {
            Node newNode = new Node(rand.nextInt(n));
            sortMe[i] = newNode;
        }
        Heap(sortMe);
        System.out.println("Array: random order");
        System.out.println("Comparisons: " + comp + "\nExchanges: " + exch);
        System.out.println("------------------------");

        comp = 0; exch = 0; n = 1000; // reset counts
    }

    // execute me to verify "correctness"
    public void correctCheck()
    {
        Random rand = new Random();
        n = rand.nextInt(8) + 8;
        Node[] sortMe = new Node[n];

        for(int i = 0; i < n; i++)
        {
            Node newNode = new Node(rand.nextInt(n));
            sortMe[i] = newNode;
        }
        System.out.println("Small array implementation verification.");
        System.out.println("----------------------------------------");
        System.out.println("Array before heapify: ");
        display(sortMe);
        System.out.println("After heapify, before sorted: ");
        Heap(sortMe);
        display(sortMe);
        System.out.println("Sorted Array: ");
        sort(sortMe);
        display2(sortMe);
        System.out.println("----------------------------------------");
    }

    public static void main(String[] args)
    {
        BUHeapNode H = new BUHeapNode();

        H.correctCheck();
        H.evaluate();
    }

}
