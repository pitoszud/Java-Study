package Interfaces;

public class Library<T> {
    private Book book;
    private Shelf<T> shelf;
    private String name;

    public Library(String name) {
        this.name = name;
    }

    public interface Book{
        void read(String title);
    }

    public interface Shelf<T>{
        void load(T target);
    }

    public void enter(){

    }


    public void setShelfInterface(Shelf<T> shelf){
        this.shelf = shelf;
    }

    public void setBookInterface(Book book){
        this.book = book;
    }
}
