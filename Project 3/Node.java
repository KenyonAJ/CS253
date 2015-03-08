/**
 * Created by Andrew Kenyon
 * for project 3
 */
public class Node<E> //implements Comparable
{
    private E element;
    private Node<E> next;

    public Node()
    {
        this(null, null);
    }

    public Node(E e, Node<E> n)
    {
        element = e;
        next = n;
    }

    public E getElement()
    {
        return element;
    }

    public Node<E> getNext()
    {
        return next;
    }

    public void setElement(E newElem)
    {
        element = newElem;
    }

    public void setNext(Node<E> newNext)
    {
        next = newNext;
    }

//    public int compareTo(E o)
//    {
//        return this.element.compareTo(((Node)o).element);
//    }
}
