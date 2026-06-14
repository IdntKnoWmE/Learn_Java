# ☕ Lean Java

A streamlined repository packed with comprehensive notes, conceptual breakdowns, and practical code examples for mastering Java. Every code snippet features extensive inline comments to explain the underlying logic, time complexity, and execution flow. 🚀

---

### 📂 Repository Structure

*   `📂 OOPs/` — Object-Oriented Programming concepts, principles, and real-world design patterns.
*   `📂 Data-Structures/` — Implementation of core data structures from scratch and using the Java Collections Framework.

---

### 🧠 Core Modules

#### 1. Object-Oriented Programming (OOPs)
Master the four pillars of OOPs with clean, documented implementations:
*   **Encapsulation**: Data hiding using access modifiers (`private`, `protected`, `public`) and getters/setters.
*   **Inheritance**: Code reusability using `extends` and `implements` keywords (Single, Multilevel, and Hierarchical).
*   **Polymorphism**: Dynamic behavior via Method Overloading (compile-time) and Method Overriding (runtime).
*   **Abstraction**: Hiding complexity using `abstract` classes and `interface` structures.

#### 2. Data Structures & Algorithms (DSA)
Step-by-step code examples for fundamental data structures:
*   **Linear Data Structures**: Arrays, Linked Lists (Singly, Doubly), Stacks, and Queues.
*   **Non-Linear Data Structures**: Trees (Binary Trees, BSTs) and Graphs.
*   **Java Collections Framework**: Practical usage of `ArrayList`, `HashMap`, `HashSet`, and `PriorityQueue`.

---

### 💻 Code Example Style

Every file in this repo follows a strict self-explanatory format. Here is a sneak peek of how the code is structured:

```java
// Example: Demonstrating Runtime Polymorphism (Method Overriding)
class Animal {
    // Base method to be overridden by subclasses
    void sound() {
        System.out.println("This animal makes a generic sound.");
    }
}

class Dog extends Animal {
    @Override
    void sound() {
        // Inline Comment: This overrides the parent class behavior at runtime
        System.out.println("The dog barks: Woof! Woof!");
    }
}

public class Main {
    public static void main(String[] args) {
        // Runtime polymorphism: Parent reference, Child object
        Animal myDog = new Dog();
        
        // Executes the Dog's version of sound() at runtime
        myDog.sound(); 
    }
}
```

---

### 🛠️ How to Use This Repo

1.  **Clone the repository:**
    ```bash
    git clone https://github.com
    ```
2.  **Navigate to a topic:**
    ```bash
    cd Lean_java/Data-Structures
    ```
3.  **Compile and Run:**
    ```bash
    javac filename.java
    java filename
    ```
