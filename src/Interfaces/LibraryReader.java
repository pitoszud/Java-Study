package Interfaces;

public class LibraryReader {
    private Library<Integer> library;


    public void task() {
        library = new Library<>("Public");

        library.setShelfInterface(
                new Library.Shelf<Integer>() {
                    @Override
                    public void load(Integer target) {
                        System.out.println("books on shelf in library " + target);
                    }
                }
        );
    }

    public void study(){
        library.setBookInterface(
            new Library.Book() {
                @Override
                public void read(String title) {
                    System.out.println("Reading book");
                }
            }
        );
    }

    public void handle(){
        Library library = new Library("Private"){
            @Override
            public void enter(){
                System.out.println("enter building");
            }
        };
    }


}
