package sixth.ninth;
import sixth.ninth.Animal;
class Box<T>{
    public T value; //Object value

    public T getValue(){
        return value;
    } //Object getValue
    public void putValue(T value){ // становится putValue(Object value)
        this.value = value;
    } //putValue(Object value)
}
class AnimalBox<T extends Animal> extends Box<T>{ // AnimalBox extends Box
    public void putValue(T value) {
        super.putValue(value);
    }

    //bridge-метод
   /* public void putValue(Object value) {
        putValue((Animal)item);
    }*/

}
//Чтобы решить эту проблему и сохранить полиморфизм универсальных типов после стирания типа,
// компилятор Java генерирует мостовой метод,
// чтобы гарантировать тому выделению подтипов работы как ожидалось.
