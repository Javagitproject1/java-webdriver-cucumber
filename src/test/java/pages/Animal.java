package pages;

public abstract class Animal {
    protected String name;

    public Animal() {
        this.name = "nameless one";
    }

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return "<" + classAndName() + ">";
    }

    public void setName(String name) {
        if (name.equals("Charlie")) {
            throw new RuntimeException("Not Acceptable name!" + name);
        }
        this.name = name;
    }

    public void walk() {
        System.out.println(classAndName() + " " + "is walking!");
    }


    public void sleep() {
        System.out.println(classAndName() + " " + "is sleeping!");
    }

    public abstract void speak ();

    public void color (String whatColor) {
        System.out.println(classAndName()+ " " + "color is" + " " + whatColor);
    }

    public void age (int whatAge){
        System.out.println(classAndName() + " " + "age is"+" "+whatAge);
    }

    public void breed (String whatBreed){
        System.out.println(classAndName()+ " " + "breed is"+" "+whatBreed);
    }

    public void eat(String what) {

        System.out.println(classAndName() + " " + "is eating" + " " + what);
    }

    protected String classAndName() {
        String[] arr = getClass().toString().split("\\.");
        return arr[arr.length - 1] + " " + name;
    }
}
