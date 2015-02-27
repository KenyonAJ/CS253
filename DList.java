
public class DList
{
    int size;
    Node header, trailer;

    public static class Node implements Comparable
    {
        private Comparable element;
        private Node next, prev;

        private Node(Comparable e)
        {
            this(e, null, null);
        }

        private Node(Comparable e, Node n, Node p)
        {
            element = e;
            next = n;
            prev = p;
        }

        public int compareTo(Object o)
        {
            return this.element.compareTo(((Node)o).element);
        }

        public Comparable getElement()
        {
            return element;
        }

        public Node getNext()
        {
            return next;
        }

        public Node getPrev()
        {
            return prev;
        }

        public void setElement (Comparable newElement)
        {
            element = newElement;
        }

        public void setNext (Node newNext)
        {
            next = newNext;
        }

        public void setPrev (Node newPrev)
        {
            prev = newPrev;
        }

        public void displayNode()
        {
            System.out.print(element);
        }
    }

    public DList()
    {
        size = 0;
        header = new Node(null, null, null);
        trailer = new Node(null, null, header);
        header.setNext(trailer);
    }

    public boolean isEmpty()
    {
        return (size == 0);
    }

    public int size()
    {
        return size;
    }

    public void insertFirst(Comparable newElement)
    {
        Node oldFirst = header.getNext();
        Node newFirst = new Node (newElement, oldFirst, header); // Node args: (Comparable, Node next, Node prev)
        oldFirst.setPrev(newFirst);
        header.setNext(newFirst);
        size++;
    }

    public void insertLast(Comparable newElement)
    {
        Node oldLast = trailer.getPrev();
        Node newLast = new Node (newElement, trailer, oldLast); // Node args: (Comparable, Node next, Node prev)
        oldLast.setNext(newLast);
        trailer.setPrev(newLast);
        size++;
    }

    public Node deleteFirst()
    {
        Node oldFirst = header.getNext();
        Node newFirst = oldFirst.getNext();
        newFirst.setPrev(header);
        header.setNext(newFirst);
        size--;
        return oldFirst;
    }

    public Node deleteLast()
    {
        Node oldLast = trailer.getPrev();
        Node newLast = oldLast.getPrev();
        trailer.setPrev(newLast);
        newLast.setNext(trailer);
        size--;
        return oldLast;
    }

    public boolean search (Comparable key) {
        boolean result = false;
        Node current = header.getNext();
        while (current != trailer) {
            if (current.getElement() == key) {
                result = true;
                return result;
            } else
                current = current.getNext();
        }
        return result;
    }

    public Comparable last()
    {
        return (trailer.getPrev().getElement());
    }

    public Comparable first()
    {
        return (header.getNext().getElement());
    }

    public void traverse()
    {
        System.out.print("Current list: ");
        Node current = header.getNext();
        while (current != trailer)
        {
            current.displayNode();
            System.out.print(" ");
            current = current.getNext();
        }
        System.out.println();
    }


}
