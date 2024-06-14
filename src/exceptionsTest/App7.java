package exceptionsTest;

import java.io.IOException;

public class App7 {
    public static void main(String[] args) throws Exception {

            print();
        System.out.println(print());

    }

//    static String print() throws Exception{
//
//        try {
//            System.out.println("try");
//            throw new Exception();
//        }
//        catch (Exception e){
//            System.out.println("Exception");
//            e.printStackTrace();
//        }
//        return "return";
//    }


//    static String print() throws IOException {
//
//        try {
//            System.out.println("try");
//        }
//        catch (Exception e){
//            e.printStackTrace();
//        }
//        return "return";
//    }


    static String print() throws Exception {
        System.out.println("before throw");
        try {
            throw new Exception();
        }
        catch (Exception e){
            System.out.println("catch Exception");
        }
        return "return";
    }


    static String print1() throws Exception {
        System.out.println("before throw in print1");
            throw new Exception();

    }
}
