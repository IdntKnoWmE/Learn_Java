package Sealed_Classes;

public final class Square extends Rectangle {

    @Override
    protected double area(){
        return getLength() * getLength();
    }

    @Override
    protected double perimeter(){
        return 4 * getLength();
    }
}
