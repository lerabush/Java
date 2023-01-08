package sixth.ninth;

import fourth.Task11;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

/*class MyLambda implements Consumer<Cat> {

    @Override
    public void accept(Cat animal) {
        System.out.println(animal.name);
    }
    public void accept(Object t){

    }


}
*/
public class AnimalExample {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InstantiationException, InvocationTargetException {
        List<Cat> cats1 = new ArrayList<>();
        //ClassCastException & HP
        cats1.add(new Cat("Lucky"));
        listNames(cats1);


        //cats1.forEach((e) -> System.out.println(e.name)); //исключения
        //MyLambda lambda = new MyLambda();
        //cats1.forEach(lambda); //ОК, нет исключения
        List<Cat> cats = new ArrayList<>();
        cats.add(new Cat("Tom"));
        cats.add(new Cat("Jerry"));
        ArrayList<Animal> animals = new ArrayList<>();
        animals.add(new Animal("elephant"));
        animals.add(new Animal("cat"));


        Cat cat = cats1.get(0);
        //new T
        Constructor<Employee> constr1 = Employee.class.getConstructor(String.class, String.class, int.class);
        Constructor<Employee> constr2 = Employee.class.getConstructor(String.class); //c дженериком (безопасное число и порядок аргументов)
        Employee emp1 = constr1.newInstance("Sam", "Law", 25);
        Employee emp2 = constr2.newInstance("Jeniffer");
    }

    //hp
    /*
    @SuppressWarnings("unchecked")
    static <E> E elementAt(Object[] es, int index) {
        return (E) es[index]; тут стирается до Object
        но потом при возвращении будет написано что-то вроде (Cat) elementAt(Object[] es, int index)
    }*/
    /*
    static <E> E elementAt(Object[] es, int index) {
        return es[index]; //Decompile
    }
     */
    /*
    @Override
    public void forEach(Consumer<? super E> action) {
        Objects.requireNonNull(action);
        final int expectedModCount = modCount;
        final Object[] es = elementData;
        final int size = this.size;
        for (int i = 0; modCount == expectedModCount && i < size; i++)
            action.accept((Сat)elementAt(es, i)); //тут исключение
        if (modCount != expectedModCount)
            throw new ConcurrentModificationException();
    }
     */
    public static void listNames(List animals) {
        Animal cat = new Dog("Jack");
        animals.add(cat);

    }

    //new T
    public static <T> T newObjectT(Function<Object[], T> constructor, Object... args) {
        return constructor.apply(args);
    }

    //каст
    @SuppressWarnings("unchecked")
    public static <T> T convertToTRight(Object o, Class<T> classToCast) {
        return classToCast.cast(o); //cast
    }
}


