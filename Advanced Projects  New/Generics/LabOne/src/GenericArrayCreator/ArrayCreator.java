package GenericArrayCreator;

import java.lang.reflect.Array;

public class ArrayCreator<T> {
    public static <T> T[] create(int length, T item) {
        T[] result = (T[]) (new Object[length]);
        for (int i = 0; i < length; i++) {
            result[i] = item;
        }
        return result;
    }

    public static <T> T[] create(Class<T> clazz, int length, T item) {
        T[] result = (T[]) Array.newInstance(clazz, length);
            //инициализираме нов масив с функцията newInstance, която се съдържа в клас Array


        for (int i = 0; i < length; i++) {
            result[i] = item;
        }
        return result;
    }

}
