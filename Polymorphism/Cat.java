package Polymorphism;

public class Cat extends Animal{

    @Override
    public void make_sound(){
        System.out.println("Meow ....");
    }

    // Method overriding
    @Override
    public void eat_food(){
        System.out.println("Fish ....");
    }

    // Method overloading
    public void eat_food(String food){
        System.out.println(food + " ....");
    }
}
