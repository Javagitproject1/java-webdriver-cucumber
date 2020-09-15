package pages;

public class Bird extends Animal {

    public Bird() {
        this.name = name;
    }

    @Override
    public void speak() {
        System.out.println(classAndName() + " " + "is tweeting!");
    }
}
