package Interface;

public interface DigitalBook extends Product{

    double book_size_in_KB = 0;
    String product_type = "E-Book";

    @Override
    default void getProduct_type(){
        System.out.println(product_type); // refers to DigitalBook.product_type here
    }
}
