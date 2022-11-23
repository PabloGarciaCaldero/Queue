package edu.upc.dsa;

public class QueueImpl<E> implements Queue<E> {

    int n;

    int MaxLongitud;
    E [] v;

    public QueueImpl(int MaxLongitud){
        this.n = 0;
        this.MaxLongitud = MaxLongitud;
        this.v = (E[]) new Object[MaxLongitud];
    }


    @Override
    public void push(E e) throws FullQueueException{
        if (EstaPle())
            throw new FullQueueException();
        else {
            v[n] = e;
            n+=1;
        }
    }

    private boolean EstaBuit() {
        return (n==0);
    }

    @Override
    public E pop() throws EmptyQueueException {
        if (EstaBuit())
            throw new EmptyQueueException();
        E ElementTret = v[0];
        reordena(v);
        n--;
        return ElementTret;
    }

    private void reordena(E[] v) {
        for (int i=0; i<v.length-1; i++){
            v[i] = v[i+1];
        }
    }

    private boolean EstaPle() {
        return (n==MaxLongitud);
    }

    @Override
    public int size() {
        return n;
    }
}
