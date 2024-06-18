package streamTest;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Person {
    private String name;
    private int age;


    private enum AgeGroup{
        CHILDREN,
        YOUTH,
        ADULT,
        SENIOR
    }
}
