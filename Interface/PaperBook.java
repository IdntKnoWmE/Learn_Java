package Interface;

public interface PaperBook extends Product{

    int book_page_counts = 0;
    String product_type = "Paper-Back";

    @Override
    default void getProduct_type(){
        System.out.println(product_type); // refers to PaperBook.product_type here
    }
}
