package pages;

public class Canary extends Animal{

    public Canary (String name){
        this.name=name;
    }

    @Override
    public void speak() {
        System.out.println(classAndName() + "is singing!");
    }
}
