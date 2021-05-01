import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main (String[] args) {
        Book book1 = new Book("Die Säulen der Erde", 29.90, 1376, Genre.FANTASY, "978-0-596-52068-7");
        Book book2 = new Book("Der erste letzte Tag", 19.50, 270, Genre.BIOGRAPHY, "9783426283868");
        Book book3 = new Book("Über Menschen", 22.00, 416, Genre.ADVENTURE, "9783630876672");
        Book book4 = new Book("Asterix und der Greif", 59.00, 112, Genre.COMIC, "978-3-7704-0206-9");
        Book book5 = new Book("Asterix Mundart Kölsch IV", 14.00, 48, Genre.COMIC, "978-3-7704-4115-0");
        Book book6 = new Book("Der Besuch der alten Dame", 10.00, 160, Genre.ADVENTURE, "978-3-257-23045-1");
        Book book7 = new Book("Goldene Flammen", 12.99, 352, Genre.FANTASY, "978-3-426-52444-2");
        Book book8 = new Book("Ungeschminkt", 12.00, 288, Genre.BIOGRAPHY, "978-3-499-00415-5");
        Book book9 = new Book("Warrior Cats - Special Adventure. Tigerherz' Schatten", 11.00, 471, Genre.ADVENTURE, "978-3-407-81267-4");
        Book book10 = new Book("Das Gold der Krähen", 16.99, 592, Genre.FANTASY, "978-3-426-65449-1");
        List<Book> allBooks = new ArrayList<>();
        allBooks.add(book1);
        allBooks.add(book2);
        allBooks.add(book3);
        allBooks.add(book4);
        allBooks.add(book5);
        allBooks.add(book6);
        allBooks.add(book7);
        allBooks.add(book8);
        allBooks.add(book9);
        allBooks.add(book10);

        List<Book> bookList1 = new ArrayList<>();
        bookList1.add(book1);
        bookList1.add(book1);
        bookList1.add(book1);
        bookList1.add(book3);
        bookList1.add(book6);
        bookList1.add(book6);
        bookList1.add(book10);
        bookList1.add(book10);

        List<Book> bookList2 = new ArrayList<>();
        bookList2.add(book2);
        bookList2.add(book2);
        bookList2.add(book2);
        bookList2.add(book3);
        bookList2.add(book4);
        bookList2.add(book6);
        bookList2.add(book7);
        bookList2.add(book7);
        bookList2.add(book8);
        bookList2.add(book9);

        List<Book> bookList3 = new ArrayList<>();
        bookList3.add(book1);
        bookList3.add(book3);
        bookList3.add(book3);
        bookList3.add(book4);
        bookList3.add(book4);
        bookList3.add(book4);
        bookList3.add(book5);
        bookList3.add(book9);
        bookList3.add(book9);

        List<Book> bookList4 = new ArrayList<>();
        bookList4.add(book1);
        bookList4.add(book3);

        List<Book> bookList5 = new ArrayList<>();
        bookList5.add(book1);
        bookList5.add(book3);
        bookList5.add(book3);



        Shop buecherDe = new Shop("buecher.de", 0.0, bookList1);
        Shop beckShop = new Shop("beck-shop.de", 0.0, bookList3);
        Shop thalia = new Shop("thalia.de", 0.0, bookList2);
        Shop thaliaCopy = new Shop("thaliacopy.de", 0.0, bookList5);

//        System.out.println(thalia.compareBooks(thaliaCopy));

//        Book falseBook = new Book("Bester Döner Hamburgs", 12.00, 29, Genre.BIOGRAPHY, "978-3442267747");
//        buecherDe.addBook(falseBook);

//        System.out.println("Duplikate");
//        for(Book buch : thalia.getBuecher()) {
//             System.out.println(buch.getTitle());
//        }
//        System.out.println("\nUnikate");
//        for(Book buch : thalia.getBuecherUnikate()) {
//             System.out.println(buch.getTitle());
//        }


//        System.out.println("Normale Anzahl");
//        System.out.println(thalia.getBuecher().size());
//
//        System.out.println("Anzahl +1");
//        thalia.addBook(book1);
//        System.out.println(thalia.getBuecher().size());


        Customer franz = new Customer("Frank Funk", 38.92);
        Customer gido = new Customer("Gido Geizig", 200.35);
        Customer tolkin = new Customer("Tolkin Trotz", 85.01);
        Customer detlef = new Customer("Detlef D", 25.20);
        List<Book> filteredBooks = thalia.getFilteredBuecher(Genre.ADVENTURE);

        System.out.printf("Umsatz von %s %s. Bücher: %s \n", thalia.getName(), thalia.getUmsatz(), thalia.getBuecher());
        System.out.printf("Bücher von %s: %s. Geld: %s \n", franz.getName(), franz.getBooks(), franz.getMoney());
        if(thalia.sellBook(book2, franz)) {
            System.out.println("Der Kauf war erfolgreich!");
        } else {
            System.out.println("Der Kauf war nicht erfolgreich!");
        }
        System.out.printf("Umsatz von %s %s. Bücher: %s \n", thalia.getName(), thalia.getUmsatz(), thalia.getBuecher());
        System.out.printf("Bücher von %s: %s. Geld: %s \n", franz.getName(), franz.getBooks(), franz.getMoney());
    }
}
