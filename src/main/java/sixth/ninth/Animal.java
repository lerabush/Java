package sixth.ninth;

import org.jetbrains.annotations.NotNull;

import java.io.Closeable;
import java.util.ArrayList;
import java.util.Scanner;
public class Animal{
    String name ="Animal";
    public Animal(String name){
        this.name = name;
    }

}

class Cat extends Animal{

    public Cat(String name) {
        super(name);
    }

    public void sayMeow(){System.out.println("meow!");}
}

class SiberianCat extends Cat {
    public SiberianCat(String name) {
        super(name);
    }
}

