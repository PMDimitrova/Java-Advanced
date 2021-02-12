package blackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Base64;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        Scanner scan = new Scanner(System.in);
        Class<BlackBoxInt> clazz = BlackBoxInt.class;
        //взимам си класа

        Constructor<BlackBoxInt> ctor = clazz.getDeclaredConstructor(int.class);
        //взимам си конструктор на този клас, като в paramTypes вкарвам, че търси инт

        ctor.setAccessible(true);
        //правя го тоя конструктор да е видим, защото по дифолт е private

        BlackBoxInt blackBoxInt = ctor.newInstance(0);
        //вдигам нова инстанция чрез конструктора от по-горе и задавам за дифолтна стойност 0

        String input = scan.nextLine();


        while (!input.equals("END")){
            String[] tokens = input.split("_");
            String methodName = tokens[0];
            int param = Integer.parseInt(tokens[1]);

            try{
                Method method = clazz.getDeclaredMethod(methodName, int.class);
                //записвам проментлива _метод_, която сочи към конкретен метод в този клас,
                //  който метод подаваме с името methodName и с int.class показваме какво ще
                //  приема този клас

                method.setAccessible(true);
                //правим го метода да е видим

                method.invoke(blackBoxInt,param );
                //извикваме метода върху инстанция от класа, която сме направили по-горе blackBoxInt
                //  като го извикваме със съответната стойност под param

                Field field = clazz.getDeclaredField("innerValue");
                //взимаме поле от този клас, което се казва innerValue

                field.setAccessible(true);
                //правим го видимо

                System.out.println(field.get(blackBoxInt));
                //взима стойността, която е записана в този клас в това поле и принтираме

            }catch (NoSuchMethodException e){
                throw new IllegalStateException(e);
            }

            input = scan.nextLine();
        }
    }
}
