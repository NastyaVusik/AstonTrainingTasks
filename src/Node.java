import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class Node<E> {

        private Node<E> previousNode;
        private E value;
        private Node<E> nextNode;


        public Node(Node<E> previousNode, E value, Node<E> nextNode) {
                this.previousNode = previousNode;
                this.value = value;
                this.nextNode = nextNode;
        }
}
