
public class NodeQueue<E> implements Queue<E>
{
    protected Node<E> head;
    protected Node<E> tail;
    protected int size;

    public NodeQueue()
    {
        head = null;
        tail = null;
        size = 0;
    }

    public int size()
    {
        return size;
    }

    public boolean isEmpty()
    {
        if (head == null)
        {
            return true;
        }
        return false;
    }

    public void enqueue (E elem)
    {
        Node<E> node = new Node<E>();
        node.setElement(elem);
        node.setNext(null);

        if (size == 0)
        {
            head = node;
        }
        else
        {
            tail.setNext(node);
        }
        tail = node;
        size++;
    }

    public E dequeue() throws EmptyQueueException
    {
        if (size == 0)
        {
            throw new EmptyQueueException("Queue is empty.");
        }
        E temp = head.getElement();
        head = head.getNext();
        size--;

        if (size == 0)
        {
            tail = null;
        }
        return temp;
    }

    public E front() throws EmptyQueueException
    {
        if (size == 0)
        {
            throw new EmptyQueueException("Queue is empty.");
        }
        E temp = head.getElement();
        return temp;
    }
}
