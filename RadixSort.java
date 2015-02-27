
import java.util.Random;

public class RadixSort
{
    // GetPile returns the integer that determines to which "pile" the current number belongs
    public static int getPile (int number, int digit)
    {
        return (number % (10 * digit)/digit);
    }

    public static void main (String[] args)
    {
        Random rand = new Random();
        int num_objects = 10;
        int digit = 1;
        int MAX_DIGIT = 1000;
        int pile;

        // create the unsorted master list (of integers)
        NodeQueue master = new NodeQueue();

        for (int i = 0; i < num_objects; i++)
        {
            master.enqueue(rand.nextInt(999));
        }

        // verify unsorted master
        /**
        while (master.isEmpty() != true)
        {
            System.out.print(master.dequeue() + " ");
        }
         */

        // create the sub lists
        NodeQueue<Object> sub[] = new NodeQueue[10];

        for (int i = 0; i < 10; i++)
        {
            sub[i] = new NodeQueue<Object>();
        }

        // magic
        while (digit < MAX_DIGIT)
        {
            while (master.isEmpty() != true)
            {
                int temp = (Integer)master.dequeue();
                pile = getPile(temp, digit);
                sub[pile].enqueue(temp);
            }

            for (int i = 0; i < 10; i++)
            {
                while (sub[i].isEmpty() != true)
                {
                    master.enqueue(sub[i].dequeue());
                }
            }
            digit = digit * 10;
        }

        // verify sorted master
        while (master.isEmpty() != true)
        {
            System.out.print(master.dequeue() + " ");
        }

    }
}
