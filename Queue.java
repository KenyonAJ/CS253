
public interface Queue<E>
{
    // @return number of elements in the queue
    public int size();

    // @return whether queue is empty
    public boolean isEmpty();

    // @return element at the front of the queue
    public E front() throws EmptyQueueException;

    // @param new element to be inserted
    public void enqueue (E element);

    // @return element removed
    public E dequeue() throws EmptyQueueException;
}
