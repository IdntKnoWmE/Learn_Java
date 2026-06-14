package Objects;

public class Rectangle {
    private double length;
    private double width;


    // Default Constrictor without parameters
    public Rectangle(){

    }

    // Constructor
    public Rectangle(double length, double width){
        this.length = length;
        this.width = width;
    }

    // Getter and Setter methods in case value needs to be changed after initialization

    // Getter
    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    // Setter

    public void setLength(double length) {
        this.length = length;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    // Area method
    public double area(){
        return this.length * this.width;
    }
}

