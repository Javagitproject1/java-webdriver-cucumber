package pages;

public class Cat extends Animal {

    public Cat(String name) {
        this.name = name;
    }

    @Override
    public void speak() {
        System.out.println(classAndName() + " " + "is meowing!");
    }


}
