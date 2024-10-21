package Etapa_4_ListaDinamica;

public class LinkedStack<T> implements Stack<T> {
    private Node<T> top;
    private int size;

    public LinkedStack() {
        this.top = null;
        this.size = 0;
    }

    @Override
    public void push(T element) throws OverflowException {
        Node<T> newNode = new Node<>(element);
        newNode.setNext(top);
        top = newNode;
        size++;
    }

    @Override
    public T pop() throws UnderflowException {
        if (isEmpty()) {
            throw new UnderflowException("Pilha vazia.");
        }
        T element = top.getData();
        top = top.getNext();
        size--;
        return element;
    }

    @Override
    public T top() throws UnderflowException {
        if (isEmpty()) {
            throw new UnderflowException("Pilha vazia.");
        }
        return top.getData();
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public boolean isFull() {
        return false; // Pilha encadeada nunca está cheia (até onde a memória permite)
    }

    @Override
    public int numElements() {
        return size;
    }
}
