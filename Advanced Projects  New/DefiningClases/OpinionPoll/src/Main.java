import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int count = Integer.parseInt(scan.nextLine());
        String[] data;

        List<Person> personList = new LinkedList<>();

        for (int i = 0; i < count; i++) {
            data = scan.nextLine().split("\\s+");
            String name = data[0];
            int age = Integer.parseInt(data[1]);

            Person person = new Person(name, age);
            personList.add(person);
        }
        Map<String, Person> finalList = new TreeMap<>();

//        personList.stream().forEach(person -> {
//           if(person.getAge() > 30){
//               finalList.put(person.getName(), person);
//           }
//       });
//        finalList.entrySet().stream()
//                .forEach(guy ->{
//                    System.out.println(guy.getValue().dataToString());
//                });


        //personList.sort((f,s) -> f.getName().compareTo(s.getName()));

        personList.stream()
                .filter((per -> per.getAge() > 30))
                .sorted(Comparator.comparing(per -> per.getName()))
                .forEach(per ->{
                    System.out.println(per.dataToString());
                });
    }
}
