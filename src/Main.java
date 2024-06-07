public class Main {
    public static void main(String[] args) {

        ArrayListPrototype arrayListPrototype = new ArrayListPrototype<>();
        arrayListPrototype.add("a");
        arrayListPrototype.add("b");
        arrayListPrototype.add("c");
        arrayListPrototype.add("d");
        arrayListPrototype.add("e");
        System.out.println("arrayListPrototype:\n" + arrayListPrototype);
        System.out.println("\narrayListPrototype get(2):\n" + arrayListPrototype.get(2));
        System.out.println("\narrayListPrototype remove(\"c\"):\n" + arrayListPrototype.remove("c"));
        System.out.println("\narrayListPrototype after remove(\"c\"):\n" + arrayListPrototype);

        System.out.println("\narrayListPrototype remove(2):\n" + arrayListPrototype.remove(2));
        System.out.println("\narrayListPrototype after remove(2):\n" + arrayListPrototype);

    }
}
