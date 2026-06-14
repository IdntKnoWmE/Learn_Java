// Online Java Compiler
// Use this editor to write, compile and run your Java code online
/*
Check if a number is prime using recursion and a functional interface.
Instructions:
• Create a functional interface.
• Use recursion for divisibility check.
• Return true if number is prime.

Sample Input & Output:
Input: 7
Output: true

Input: 10
Output: false
*/


import java.util.Scanner;

public class prime
{
    public boolean is_prime(int n, int d){

        if (d==1){
            return true;
        }
        if  (n%d == 0){
            return false;
        }
        return is_prime(n, d-1);
    }
}

void main(String[] args) {

    System.out.println("Enter the number");

    Scanner sc = new Scanner(System.in);

    int n;
    n = sc.nextInt();
    sc.close();

    prime p = new prime();

    boolean is_prime = p.is_prime(n, n/2);
    System.out.println(is_prime);
}
