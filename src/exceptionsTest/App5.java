package exceptionsTest;

public class App5 {
    public static void main(String[] args) {
        try {
            System.err.println("try");
            throw new RuntimeException();
        }
            finally
         {
            System.err.println("finally");
        }
//        System.err.println("more");
//        System.out.println("more1");

    }
}