package book;

/**
 * @author DELL
 * @Date 2019/12/3 16:13
 **/
public class Book {
    String name;
    String author;
    int price;
    String type;
    boolean isBorrow;
    public Book(String name, String author, int price, String type) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.type = type;
    }
}
