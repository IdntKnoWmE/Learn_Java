package Polymorphism;

public class Dog extends Animal{

    @Override
    public void make_sound(){
        System.out.println("Woof ....");
    }

    // Method overriding
    @Override
    public void eat_food(){
        System.out.println("Dog food ....");
    }

    // Method overloading
    public void make_sound(String sound){
        System.out.println(sound + " ....");
    }
}
