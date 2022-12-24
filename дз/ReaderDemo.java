public class ReaderDemo {
    public static void main(String[] args) {
        Reader reader1 = new Reader("Петров", 1, "Биг дата", "20.11.2000", "123456789");
        Reader reader2 = new Reader("Степанов", 2, "Биг дата", "21.11.2000", "987654321");
        Reader reader3 = new Reader("Иванов", 3, "Биг дата", "22.11.2000", "111111111");
        Reader[] readers = {reader1, reader2, reader3};

        Book book1 = new Book("Книга1", "Автор1");
        Book book2 = new Book("Книга2", "Автор2");
        Book book3 = new Book("Книга3", "Автор3");
        Book[] books = {book1, book2, book3};

        printReaders(readers);
        printBooks(books);

        reader1.takeBook(3);
        reader2.takeBook("Книга4, Автор4", "Книга5, Автор5");
        reader3.takeBook(book1, book2,book3);

        reader1.returnBook(4);
        reader2.returnBook("Книга5, Автор5");
        reader3.returnBook(book3);
    }

    private static void printReaders(Reader[] readers) {
        System.out.println("Список читателей:");
        for (Reader reader : readers) {
            System.out.println( reader.getInfo());
        }
        System.out.println();
    }


    private static void printBooks(Book[] books) {
        System.out.println("Список книг:");
        for (Book book : books) {
            System.out.println(book.getInfo());
        }
        System.out.println();
    }

}