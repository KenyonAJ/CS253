/**
 * Created by Andrew Kenyon
 *
 */

class EmptyQueueException extends RuntimeException
{
    public EmptyQueueException(String s)
    {
        System.out.println(s);
    }
}

public class NodeQueue<E>
{
    protected Node<E> head;
    protected Node<E> tail;
    private int size;

    public NodeQueue()
    {
        head = null;
        tail = null;
        size = 0;
    }

    public void enqueue(E e)
    {
        Node<E> newNode = new Node<E>();
        newNode.setElement(e);
        newNode.setNext(null);
        if (size == 0)
            head = newNode;
        else
            tail.setNext(newNode);
        tail = newNode;
        size++;
    }

    public E dequeue() throws EmptyQueueException
    {
        if (isEmpty())
            throw new EmptyQueueException("Queue is empty.");
        E item = head.getElement();
        head = head.getNext();
        size--;
        if (size == 0)
            tail = null;
        return item;
    }

    public E front() throws EmptyQueueException
    {
        if (isEmpty())
            throw new EmptyQueueException("Queue is empty.");
        return head.getElement();
    }

    public int size()
    {
        return size;
    }

    public boolean isEmpty()
    {
        return (size() == 0);
    }


}
