//public class LinkedListPrototype<E> implements CustomLinkedList<E> {
//
//    int size = 0;
//    private Node<E> head;
//    private Node<E> tail;
//
//
//    @Override
//    public void linkFirst(E value) {
//        Node<E> first = head;
//        Node<E> newNode = new Node<>(null, value, first);
//        head = newNode;
//        if (first == null)
//            tail = newNode;
//        else
//            first.setPreviousNode(newNode);
//        size++;
//    }
//
//
//    @Override
//    public void linkLast(E value) {
//        Node<E> last = tail;
//        Node<E> newNode = new Node<>(last, value, null);
//        tail = newNode;
//        if (last == null)
//            head = newNode;
//        else
//            last.setNextNode(newNode);
//        size++;
//    }
//
//    @Override
//    public boolean add(E value) {
//        linkLast(value);
//
//        return true;
//    }
//
//    @Override
//    public E get(int index) {
//        if (index >= 0 && index < size) {
//            return node(index).getValue();
//        } else {
//            throw new IndexOutOfBoundsException();
//        }
//    }
//
//
//    @Override
//    public E remove(int index) {
//
//        Node<E> node = head;
//
//        for (int i = 0; i < index - 1; i++) {
//            node = node.getNextNode();
//        }
//        node.setNextNode(node.getNextNode().getNextNode());
//
//        return node.getValue();
//    }
//
//
//    @Override
//    public String toString() {
//
//        StringBuilder builder = new StringBuilder();
//
//        if (head != null) {
//            Node<E> currentNode = head;
//            while (currentNode.getNextNode() != null) {
//                builder.append(currentNode.getValue()).append(", ");
//                currentNode = currentNode.getNextNode();
//            }
//            builder.append(currentNode.getValue()).append(". ");
//        }
//
//        return builder.toString();
//    }
//
//
//    Node<E> node(int index) {
//
//        if (index < (size >> 1)) {
//            Node<E> x = head;
//            for (int i = 0; i < index; i++)
//                x = x.getNextNode();
//
//            return x;
//        } else {
//            Node<E> x = tail;
//            for (int i = size - 1; i > index; i--)
//                x = x.getPreviousNode();
//
//            return x;
//        }
//    }
//}
