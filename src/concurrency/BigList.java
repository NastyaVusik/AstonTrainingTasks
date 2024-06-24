package concurrency;

import java.util.ArrayList;
import java.util.List;

public class BigList implements Runnable{
    List<String> bigList = new ArrayList<>();


//    Generate random strings
    public List<String> getBigList(long listSize) {

//        StringBuilder stringBuilder = new StringBuilder();

        // choose a Character random from this String
        String alphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                                    + "0123456789"
                                    + "abcdefghijklmnopqrstuvxyz";

        for (int i = 0; i < listSize; i++) {
            int index = (int) (alphaNumericString.length() * Math.random());
//            stringBuilder.append(alphaNumericString.charAt(index)).append(", ");
            String str = String.valueOf(alphaNumericString.charAt(index));
            bigList.add(str);
        }

//        return stringBuilder.toString();
        return bigList;
    }



//    Treat the first part of the list. Change all strings to upper case
    public List<String> getUpperCaseInFirstHalfOfList(long listSize){

List<String> firstBigList = new ArrayList<>(getBigList(listSize).subList(0, (int) (listSize / 2)));

return firstBigList.stream()
        .map(x -> x.toUpperCase().concat(" Hello!!!"))
        .toList();
    }



//    Tread the second part of the list. Change all strings to lower case
public List<String> getLowerCaseInSecondHalfOfList(long listSize){

    List<String> secondBigList = new ArrayList<>(getBigList(listSize).subList((int) (listSize / 2), (int) (listSize)));

    return secondBigList.stream()
            .map(x -> x.toLowerCase().concat(" Bye!!!"))
            .toList();
}



    @Override
    public void run() {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
