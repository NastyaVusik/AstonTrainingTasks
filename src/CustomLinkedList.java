public interface CustomLinkedList<E> {

        void linkFirst(E e);

        void linkLast(E e);
        boolean add(E element);

        E get(int index);

//        boolean remove(Object object);

        E remove(int index);

        String toString();
    }

