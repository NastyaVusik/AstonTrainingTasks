public interface ListPrototype<E> {
    void add(E element);

    E get(int index);

    boolean remove(Object object);

    E remove(int index);

    String toString();
}
