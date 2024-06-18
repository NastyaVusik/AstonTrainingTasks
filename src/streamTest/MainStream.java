package streamTest;

import java.util.*;
import java.util.stream.LongStream;

public class MainStream {
    public static void main(String[] args) {

        StreamMethods streamMethods = new StreamMethods();


        //    Напишите программу, которая создает список целых чисел, а затем использует стримы для фильтрации только четных
//    чисел и их сортировки по возрастанию.
        System.out.println(streamMethods.getList(15));


        //    Создайте список строк, затем используйте стримы для преобразования каждой строки в верхний регистр и сборки
//    результатов в новый список.
        System.out.println("\n" + streamMethods.getString(20));


        //    Напишите программу, которая использует стрим для вычисления суммы всех элементов в массиве целых чисел
        System.out.println("\n" + streamMethods.getSum(14) + "\n");


        //    Создайте список объектов (например, объекты класса Person с полями name и age). Используйте стримы для
//    группировки объектов по возрасту и вычисления среднего возраста в каждой группе.
        List<Person> personList = List.of(new Person("Tom1", 2),
                new Person("Masha1", 21),
                new Person("Tom2", 26),
                new Person("Masha2", 13),
                new Person("Tom3", 35),
                new Person("Masha3", 62),
                new Person("Tom4", 7),
                new Person("Masha4", 43),
                new Person("Tom5", 17));

        streamMethods.getPersonAgeGroup(personList);
        streamMethods.getAverageAge(personList);


        //    Создайте список строк. Используйте стримы для фильтрации строк длиной более 5 символов и поиска первой строки,
//    удовлетворяющей условию.
        String text = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been " +
                      "the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of " +
                      "type and scrambled it to make a type specimen book. It has survived not only five centuries, but " +
                      "also the leap into electronic typesetting, remaining essentially unchanged. It was popularised " +
                      "in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently " +
                      "with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.";

        System.out.println("\n" + streamMethods.getLineMoreFiveSymbols(text));
        System.out.println("\n" + streamMethods.getFirstWordWithLengthMoreFive(text));


        //    Перепишите одну из предыдущих задач с использованием параллельного стрима (parallelStream()) для выполнения
//    операций на нескольких ядрах процессора.
        //    Создайте список строк. Используйте стримы для фильтрации строк длиной более 5 символов и поиска первой строки,
//    удовлетворяющей условию.
        System.out.println("\n" + streamMethods.getLineMoreFiveSymbolsWithParallelStream(text));


        //    Напишите программу, которая читает текстовый файл построчно, фильтрует строки по заданному условию (например,
//    содержащим определенное слово), и выводит результаты на консоль.
        String path = "src/streamTest/Text";
        System.out.println("\n" + streamMethods.getWords(path));


//        Рассмотрите ситуацию, когда стрим может содержать значения, которые не могут быть преобразованы в желаемый тип.
//    Напишите программу, которая фильтрует стрим таким образом, чтобы исключить некорректные значения и обработать
//    такие случаи.
        List<String> stringList = List.of("aaa", "123", "544m", "8", "-6", "0", "o54", "98345");
        System.out.println("\n" + streamMethods.getNewStream(stringList));

        LongSummaryStatistics stats = LongStream.rangeClosed(2, 16)
                .summaryStatistics();
        System.out.println(stats.getMax());
        System.out.println(stats.getSum());
        System.out.println(stats.getCount());



            String nullName = "nullxfdhhkjhl";
            String name = Optional.ofNullable(nullName).orElseThrow();
        System.out.println(name);

//        var result =
//                Stream.of(5, 12, 19, 21)
//                        .collect(Collectors.teeing(
//                                // первый коллектор
//                                Collectors.counting(),
//                                // второй коллектор
//                                Collectors.summingInt(n -> Integer.valueOf(n.toString())),
//                                // объединение: (count, sum) -> new Result(count, sum);
//                                (count, sum) -> new Result(count, sum) {
//                                }
//                        ));
//        System.out.println(result);


    }
}
