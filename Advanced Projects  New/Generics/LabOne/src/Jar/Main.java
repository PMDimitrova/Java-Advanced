package Jar;

public class Main {
    public static void main(String[] args) {
        Jar<Integer> jar = new Jar();

        jar.add(5);
        jar.add(7);
        jar.add(9);


        System.out.println(jar.remove());
    }
}
