package second;
import org.omg.CORBA.IntHolder;

public class Task4 {
    public static void main(String[] args) {

        IntHolder a = new IntHolder();
        a.value = 5;
        IntHolder b = new IntHolder();
        b.value = 9;
        System.out.printf("Before: a=%s, b=%s ", a.value, b.value);
        swap(a, b);
        System.out.printf("After: a=%s, b=%s", a.value, b.value);
        //потому что в метод передаются копии значения переменной при манипуляции с примитивами
       //Не можем поменять местами содержимое двух Integer, мы меняем ссылки

    }

    private static void swap(IntHolder a, IntHolder b) {
        int c = a.value;
        a.value = b.value;
        b.value = c;
    }
}

