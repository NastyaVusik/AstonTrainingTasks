package streamTest;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamMethods {

//    Напишите программу, которая создает список целых чисел, а затем использует стримы для фильтрации только четных
//    чисел и их сортировки по возрастанию.
    public List<Integer> getList(int size){

        List<Integer> list = new Random().ints(-150, 150)
                .limit(size)
                .peek(System.out::println)
                .filter(el -> el%2 == 0)
                .sorted()
                .boxed()
                .collect(Collectors.toList());

        return list;
    }



//    Создайте список строк, затем используйте стримы для преобразования каждой строки в верхний регистр и сборки
//    результатов в новый список.
    public String getString(long size){

        int leftLimit = 97;
        int rightLimit = 122;
        Random random = new Random();

        String str = random.ints(size, leftLimit, rightLimit)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString()
                .toUpperCase();

        String str1 = str.toString();

        return str1;
    }



//    Напишите программу, которая использует стрим для вычисления суммы всех элементов в массиве целых чисел
    public int getSum(int size){

        int sumNumber = new Random().ints(-100, 200)
                .limit(size)
                .peek(System.out::println)
                .sum();

        return sumNumber;
    }



//    Создайте список объектов (например, объекты класса Person с полями name и age). Используйте стримы для
//    группировки объектов по возрасту и вычисления среднего возраста в каждой группе.

    public void getPersonAgeGroup(List <Person> personList){

        Predicate<Person> childrenGroup = person -> (person.getAge() >= 0 && person.getAge() < 15);
        Predicate<Person> youthGroup = person -> (person.getAge() >= 15 && person.getAge() < 25);
        Predicate<Person> adultGroup = person -> (person.getAge() >= 25 && person.getAge() < 65);
        Predicate<Person> seniorGroup = person -> person.getAge() >= 65;

List<Person> child = personList.stream().filter(childrenGroup).toList();
List<Person> youth = personList.stream().filter(youthGroup).toList();
List<Person> adult = personList.stream().filter(adultGroup).toList();
List<Person> senior = personList.stream().filter(seniorGroup).toList();

child.forEach(System.out::println);
youth.forEach(System.out::println);
adult.forEach(System.out::println);
senior.forEach(System.out::println);


////        Collector<Person, ?, List<List<Person>>> result = Collectors.teeing(Collectors.filtering(childrenGroup, Collectors.toList()),
////                Collectors.filtering(youthGroup, Collectors.toList()),
////                        Collectors.filtering(adultGroup, Collectors.toList()),
////                                Collectors.filtering(seniorGroup, Collectors.toList()),



//        Map<String, List<Integer>> childGroup = personList.stream()
//                .collect(Collectors.groupingBy(Person::getName, Collectors.mapping(Person::getAge,
//                        Collectors.filtering(age -> (age > 0 && age < 15), Collectors.toList()))));
//
//        Map<String, List<Integer>> youthGroup = personList.stream()
//                .collect(Collectors.groupingBy(Person::getName, Collectors.mapping(Person::getAge,
//                        Collectors.filtering(age -> (age >=15 && age < 25), Collectors.toList()))));
//
//        Map<String, List<Integer>> adultGroup = personList.stream()
//                .collect(Collectors.groupingBy(Person::getName, Collectors.mapping(Person::getAge,
//                        Collectors.filtering(age -> (age >= 25 && age < 65), Collectors.toList()))));
//
//        Map<String, List<Integer>> seniorGroup = personList.stream()
//                .collect(Collectors.groupingBy(Person::getName, Collectors.mapping(Person::getAge,
//                        Collectors.filtering(age -> (age >= 65), Collectors.toList()))));


////        List<Person> groupByAge = personList.stream()
////                .filter(person -> (person.getAge() >= 0 && person.getAge() < 15))
////                .filter(person -> (person.getAge() >= 15 && person.getAge() < 25))
////                .filter(person -> (person.getAge() >= 25 && person.getAge() < 65))
////                .map(Person::getName)
////                .collect(Collectors.toList());

   }

    public void getAverageAge(List <Person> personList){

        Predicate<Person> childrenGroup = person -> (person.getAge() >= 0 && person.getAge() < 15);
        Predicate<Person> youthGroup = person -> (person.getAge() >= 15 && person.getAge() < 25);
        Predicate<Person> adultGroup = person -> (person.getAge() >= 25 && person.getAge() < 65);
        Predicate<Person> seniorGroup = person -> person.getAge() >= 65;

        double childrenAverageAge = personList.stream()
                .filter(childrenGroup)
                .mapToInt(person -> person.getAge())
                .average().orElse(0);
        System.out.println("childrenAverageAge = " + childrenAverageAge);

        double youthAverageAge = personList.stream()
                .filter(youthGroup)
                .mapToInt(person -> person.getAge())
                .average().orElse(0);
        System.out.println("youthAverageAge = " + youthAverageAge);

        double adultAverageAge = personList.stream()
                .filter(adultGroup)
                .mapToInt(person -> person.getAge())
                .average().orElse(0);
        System.out.println("adultAverageAge = " + adultAverageAge);

        double seniorAverageAge = personList.stream()
                .filter(seniorGroup)
                .mapToInt(person -> person.getAge())
                .average().orElse(0);
        System.out.println("seniorAverageAge = " + seniorAverageAge);
    }



//    Создайте список строк. Используйте стримы для фильтрации строк длиной более 5 символов и поиска первой строки,
//    удовлетворяющей условию.
    public List<String> getLineMoreFiveSymbols(String str){

        return Arrays.stream(str.split("\\s+|,\\s*|\\.\\s*"))
                .filter(s -> s.length() > 4)
                .collect(Collectors.toList());
    }


    public String getFirstWordWithLengthMoreFive(String str){

        return Arrays.stream(str.split("\\s+|,\\s*|\\.\\s*"))
                .filter(s -> s.length() > 4)
                .findFirst().orElse("No words with length >= 5");
    }



//    Перепишите одну из предыдущих задач с использованием параллельного стрима (parallelStream()) для выполнения
//    операций на нескольких ядрах процессора.
    //    Создайте список строк. Используйте стримы для фильтрации строк длиной более 5 символов и поиска первой строки,
//    удовлетворяющей условию.
    public List<String> getLineMoreFiveSymbolsWithParallelStream(String str){

        return Arrays.asList(str.split("\\s+|,\\s*|\\.\\s*"))
                .parallelStream()
                .filter(s -> s.length() > 4)
                .collect(Collectors.toList());
    }



//    Напишите программу, которая читает текстовый файл построчно, фильтрует строки по заданному условию (например,
//    содержащим определенное слово), и выводит результаты на консоль.
    public List<String> getWords(String path){

        Path path1 = Paths.get(path);
        String text = "";

        try {
            text = Files.readAllLines(path1).toString();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        List<String> strings = Arrays.asList(text.split("\\s+|,\\s*|\\.\\s*"))
                .stream().filter(s -> s.contains("m"))
                .collect(Collectors.toList());

        return strings;
    }



//    Рассмотрите ситуацию, когда стрим может содержать значения, которые не могут быть преобразованы в желаемый тип.
//    Напишите программу, которая фильтрует стрим таким образом, чтобы исключить некорректные значения и обработать
//    такие случаи.
public List<Integer> getNewStream(List<String> stringList){

    IntStream.range(-2,5).forEachOrdered(System.out::println);

    List<Integer> list = new ArrayList<>(stringList.stream()
            .filter(string -> string.matches("[-+]?\\d+"))
            .map(str -> Integer.valueOf(str))
            .toList());

    return list;
}

}
