package Interface;

public interface Product {

    public String product_name = "";
    String product_type = "Not Selected";
    default void getProduct_type(){
        System.out.println(product_type); // refers to Product.product_type here
    }
    static void print(){
        System.out.println("Hello brother");
    }
}
