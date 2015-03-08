import java.util.EmptyStackException;

/**
 * Created by Andrew Kenyon on 3/3/2015.
 */
public class NodeStack<E>
{
    protected Node<E> top;
    protected int size;
    public NodeStack()
    {
        top = null;
        size = 0;
    }

    public int size()
    {
        return size;
    }

    public boolean isEmpty()
    {
        if (top == null)
            return true;
        return false;
    }

    public void push(E elem)
    {
        Node<E> v = new Node<E>(elem, top);
        top = v;
        size++;
    }

    public E top() throws EmptyStackException
    {
        if (isEmpty())
            throw new EmptyStackException();
        return top.getElement();
    }

    public E pop()
    {
        if (isEmpty())
            throw new EmptyStackException();
        E temp = top.getElement();
        top = top.getNext();
        size--;
        return temp;
    }

}
