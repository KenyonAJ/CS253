
import java.util.Random;

public class QuickSort
{
    public static void main (String[] args)
    {
        Random rand = new Random();

        DList test = new DList();

        for (int i = 0; i < 20; i++)
        {
            test.insertFirst(rand.nextInt(100));
        }

        System.out.println("Before sorting: ");
        test.traverse();
        Qsort(test);
        System.out.println("After sorting: ");
        test.traverse();
    }

    public static DList Qsort(DList S)
    {
        if (S.size() <= 1)
            return S;

        DList L = new DList();
        DList E = new DList();
        DList G = new DList();

        DList.Node pivot = S.trailer.getPrev();


        while(!S.isEmpty())
        {
            DList.Node other = S.deleteLast();

            if (other.compareTo(pivot) < 0)
            {
                L.insertLast(other.getElement());
            }
            else if (other.compareTo(pivot) == 0)
            {
                E.insertLast(other.getElement());
            }
            else
                G.insertLast(other.getElement());
        }
        Qsort(L);
        Qsort(G);
        while (!L.isEmpty())
        {
            DList.Node elem = L.deleteFirst();
            S.insertLast(elem.getElement());
        }
        while (!E.isEmpty())
        {
            DList.Node elem = E.deleteFirst();
            S.insertLast(elem.getElement());
        }
        while (!G.isEmpty())
        {
            DList.Node elem = G.deleteFirst();
            S.insertLast(elem.getElement());
        }
        return S;

    }

}





