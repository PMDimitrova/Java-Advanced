package StrategyPattern;

import java.util.Comparator;

public class PersonComparatorByName implements Comparator<Person> {
    @Override
    public int compare(Person f, Person s) {
            int result = f.getName().length() - s.getName().length();
            if (result==0) {
                result = Character.toLowerCase(f.getName().charAt(0))
                        - Character.toLowerCase(s.getName().charAt(0));
            }
            return result;
    }
}
