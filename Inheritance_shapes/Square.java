package Inheritance_shapes;

public class Square extends Rectangle{

    @Override // here perimeter is public but parent perimeter is protected
    public double perimeter(){
        return 4 * this.length;
    }

    protected double area(){
        return this.length * this.length;
    }

}
