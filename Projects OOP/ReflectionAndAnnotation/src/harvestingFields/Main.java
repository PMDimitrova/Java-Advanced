package harvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Class<RichSoilLand> clazz = RichSoilLand.class;

        List<Field> declaredFields = Arrays.asList(clazz.getDeclaredFields());
        String command = scan.nextLine();
        while (!command.equals("HARVEST")) {
            //print the fields with the given access modifier
            // access modifier - field type - field name
            String modifier = command;
            declaredFields.stream()
                    .filter(field -> Modifier.toString(field.getModifiers()).equals(modifier)
                            ||modifier.equals("all"))
                    .forEach(field -> System.out.printf("%s %s %s%n",
                            Modifier.toString(field.getModifiers()),
                            field.getType().getSimpleName(),
                            field.getName()
                            ));

            command = scan.nextLine();
        }
    }
}
