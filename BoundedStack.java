package stack;

public class BoundedStack<E> {

    private Node sentinel;
    private int cap;
    private int size;

    private class Node {
        public E item;
        public Node next;

        public Node(E i, Node n) {
            item = i;
            next = n;
        }
    }

    public BoundedStack (int cap) {
        this.cap = cap;
        this.size = 0;
        sentinel = new Node((E) new Object(), null);
    }

    public void push(E item) // This public method adds the generic item to the top of the stack that is limited to 50
                             // objects. If the stack is full, the overflow method is called.
    {
        if (size == cap)
            overflow();

        ++size;
        Node temp = new Node(item, sentinel.next);
        sentinel.next = temp;
    }
    public E pop() // This public method removes the generic item from the top of the stack and returns it.
    {
        if (isEmpty())
            return null;
        E to_return = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        --size;

        return to_return;
    }
    private void overflow() // This private method removes the oldest item in the stack.
    {
        Node temp = sentinel;
        for (int i = 0; i < cap - 1; i++) {
            temp = temp.next;
        }
        temp.next = null;
        --size;
    }
    public boolean isEmpty() // This public method will return true if the stack is empty
    {
        return size == 0;
    }
}
