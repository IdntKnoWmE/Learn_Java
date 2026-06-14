package Polymorphism;

public class Run {

    static void main() {

        // Simple class initializing and method calling.
        Dog dog = new Dog();
        dog.make_sound();

        // Implicit UP casting the class dog to its superclass Animal
        Animal a = dog;
        a.make_sound();

        // Explicit DOWN casting the class Animal to its subclass dog or cat.
        Animal animal = new Dog(); // Upcast
        animal.eat_food();
        Dog d = (Dog) animal; // Downcast, explicit and must be safe
        d.eat_food();


    }
}
