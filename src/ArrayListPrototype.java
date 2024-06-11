import java.util.Arrays;

public class ArrayListPrototype<E> implements CustomArrayList<E> {
    private E[] elementsArr;
    private static final int DEFAULT_CAPACITY = 10;
    private int size;


    public ArrayListPrototype() {
        this.elementsArr = (E[]) new Object[DEFAULT_CAPACITY];
    }


    public E[] increaseIfNeed(E[] elementsArr) {

        if (elementsArr.length == size) {
            elementsArr = Arrays.copyOf(this.elementsArr, this.elementsArr.length * 3 / 2 + 1);
        }

        return elementsArr;
    }


    @Override
    public void add(E element) {

        this.increaseIfNeed(this.elementsArr);

        elementsArr[size++] = element;

    }

    @Override
    public E get(int index) {
        return elementsArr[index];
    }


    @Override
    public boolean remove(Object object) {
        int index;
        for (index = 0; index < this.size; index++) {
            if (elementsArr[index].equals(object)) {
                elementsArr[index] = null;

                for (int j = index; j < this.size; j++) {
                    elementsArr[j] = elementsArr[j + 1];
                }
                this.size--;
                return true;
            }
        }

        return false;
    }


    @Override
    public E remove(int index) {

        elementsArr[index] = null;

        for (int j = index; j < this.size; j++) {
            elementsArr[j] = elementsArr[j + 1];
        }

        this.size--;

        return elementsArr[index];
    }


    @Override
    public String toString() {

        String str = "";

        if (size == 0) {
            System.out.println("[]");
        } else {
            for (int i = 0; i < (size - 1); i++) {
                str = str + elementsArr[i] + " ,";
            }
            str = "[" + str + elementsArr[size - 1] + "]";
        }

        return str;
    }
}

