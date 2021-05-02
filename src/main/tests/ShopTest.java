import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ShopTest {
    Book book1 = new Book("Die Säulen der Erde", new BigDecimal("29.90"), 1376, Genre.FANTASY, "978-0-596-52068-7");
    Book book2 = new Book("Der erste letzte Tag", new BigDecimal("19.50"), 270, Genre.BIOGRAPHY, "9783426283868");
    Book book3 = new Book("Über Menschen", new BigDecimal("22.00"), 416, Genre.ADVENTURE, "9783630876672");
    Book book4 = new Book("Asterix und der Greif", new BigDecimal("59.00"), 112, Genre.COMIC, "978-3-7704-0206-9");
    Book book5 = new Book("Asterix Mundart Kölsch IV", new BigDecimal("14.00"), 48, Genre.COMIC, "978-3-7704-4115-0");
    Book book6 = new Book("Der Besuch der alten Dame", new BigDecimal("10.00"), 160, Genre.ADVENTURE, "978-3-257-23045-1");
    Book book7 = new Book("Goldene Flammen", new BigDecimal("12.99"), 352, Genre.FANTASY, "978-3-426-52444-2");
    Book book8 = new Book("Ungeschminkt", new BigDecimal("12.00"), 288, Genre.BIOGRAPHY, "978-3-499-00415-5");
    Book book9 = new Book("Warrior Cats - Special Adventure. Tigerherz' Schatten", new BigDecimal("11.00"), 471, Genre.ADVENTURE, "978-3-407-81267-4");
    Book book10 =  new Book("Das Gold der Krähen", new BigDecimal("16.99"), 592, Genre.FANTASY, "978-3-426-65449-1");
    List<Book> uniqueList1 = new ArrayList<>();
    List<Book> uniqueList2 = new ArrayList<>();
    List<Book> uniqueList3 = new ArrayList<>();
    List<Book> duplicateList1 = new ArrayList<>();
    List<Book> duplicateList2 = new ArrayList<>();
    Shop buecherDe;
    Shop hugendubel;
    Shop beckShop;
    Shop thalia;
    Shop shopSameBooksAsThalia;
    Customer franz = new Customer("Frank Funk", new BigDecimal("38.92"));
    Customer gido = new Customer("Gido Geizig", new BigDecimal("200.35"));
    Customer detlef = new Customer("Detlef D", new BigDecimal("15.20"));

    @BeforeEach
    void setUp() {
        uniqueList1.add(book1);
        uniqueList1.add(book1);
        uniqueList1.add(book1);
        uniqueList1.add(book3);
        uniqueList1.add(book6);
        uniqueList1.add(book6);
        uniqueList1.add(book10);
        uniqueList1.add(book10);

        uniqueList2.add(book2);
        uniqueList2.add(book2);
        uniqueList2.add(book2);
        uniqueList2.add(book3);
        uniqueList2.add(book4);
        uniqueList2.add(book6);
        uniqueList2.add(book7);
        uniqueList2.add(book7);
        uniqueList2.add(book8);
        uniqueList2.add(book9);

        uniqueList3.add(book1);
        uniqueList3.add(book3);
        uniqueList3.add(book3);
        uniqueList3.add(book4);
        uniqueList3.add(book4);
        uniqueList3.add(book4);
        uniqueList3.add(book5);
        uniqueList3.add(book9);
        uniqueList3.add(book9);

        duplicateList1.add(book1);
        duplicateList1.add(book3);
        duplicateList1.add(book4);
        duplicateList1.add(book4);
        duplicateList1.add(book5);
        duplicateList1.add(book5);

        duplicateList2.add(book1);
        duplicateList2.add(book1);
        duplicateList2.add(book3);
        duplicateList2.add(book4);
        duplicateList2.add(book5);

        buecherDe = new Shop("buecher.de", new BigDecimal("0.0"), uniqueList1);
        hugendubel = new Shop("hugendubel.de", new BigDecimal("0.0"), uniqueList2);
        beckShop = new Shop("beck-shop.de", new BigDecimal("0.0"), uniqueList3);
        thalia = new Shop("thalia.de", new BigDecimal("0.0"), duplicateList1);
        shopSameBooksAsThalia = new Shop("thaliacopy.de", new BigDecimal("0.0"), duplicateList2);
    }

    @Test
    void getterTests() {
        assertAll(
                () -> assertEquals(hugendubel.getName(), "hugendubel.de"),
                () -> assertEquals(0, hugendubel.getUmsatz().compareTo(new BigDecimal("0.0"))),
                () -> assertEquals(hugendubel.getBuecher(), uniqueList2)
        );
    }

    @Test
    void addBook() {
        assertEquals(hugendubel.getBuecher().size(), 10);
        hugendubel.addBook(book1);
        assertEquals(hugendubel.getBuecher().size(), 11);
    }

    @Test
    void addFail() {
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> buecherDe.addBook(new Book("Bester Döner Hamburgs", new BigDecimal("12.00"), 29, Genre.BIOGRAPHY, "978-3442267747")),
                "Ungültige ISBN angegeben."
        );
        assertTrue(thrown.getMessage().contains("Falsche ISBN-13!"));
    }

    @Test
    void getBuecherUnikate() {
        List<Book> thaliaBooks = thalia.getBuecher();
        List<Book> thaliaBooksUni = thalia.getBuecherUnikate();
        int thaliaBooksDoubles = findDuplicates(thaliaBooks);
        int thaliaBooksUnicateDoubles = findDuplicates(thaliaBooksUni);
        assertEquals(thaliaBooksDoubles, 2);
        assertEquals(thaliaBooksUnicateDoubles, 0);
    }

    private int findDuplicates(List<Book> bookList) {
        int duplicates = 0;
        for (int i = 0; i < bookList.size()-1; i++) {
            for (int j = i+1; j < bookList.size(); j++) {
                if( (bookList.get(i).equals(bookList.get(j))) && (i != j) ) {
                    duplicates += 1;
                }
            }
        }
        return duplicates;
    }

    @Test
    void getFilteredBuecher() {
        List<Book> filteredBooks = beckShop.getFilteredBuecher(Genre.ADVENTURE);
        boolean onlyAdventure = true;
        for(Book book: filteredBooks) {
            if (book.get_genre() != Genre.ADVENTURE) {
                onlyAdventure = false;
                break;
            }
        }
        assertNotEquals(filteredBooks, beckShop.getBuecher());
        assertTrue(onlyAdventure);
    }

    @Test
    void sellBookFail() {
        assertAll(
                () -> assertEquals(0, buecherDe.getUmsatz().compareTo(BigDecimal.ZERO)),
                () -> assertEquals(buecherDe.getBuecher().size(), 8),
                () -> assertEquals(0, detlef.getMoney().compareTo(new BigDecimal("15.20"))),
                () -> assertEquals(detlef.getBooks().size(), 0
        ));
        assertFalse(buecherDe.sellBook(book1, detlef));
        assertAll(
                () -> assertEquals(0, buecherDe.getUmsatz().compareTo(BigDecimal.ZERO)),
                () -> assertEquals(buecherDe.getBuecher().size(), 8),
                () -> assertEquals(0, detlef.getMoney().compareTo(new BigDecimal("15.20"))),
                () -> assertEquals(detlef.getBooks().size(), 0)
        );
        //Ein Buch das es nicht gibt wird mit false zurückgewiesen.
        assertFalse(buecherDe.sellBook(book2, gido));
    }

    @Test
    void sellBook() {
        assertAll(
                () -> assertEquals(0, buecherDe.getUmsatz().compareTo(BigDecimal.ZERO)),
                () -> assertEquals(buecherDe.getBuecher().size(), 8),
                () -> assertEquals(0, franz.getMoney().compareTo(new BigDecimal("38.92"))),
                () -> assertEquals(franz.getBooks().size(), 0)
        );
        assertTrue(buecherDe.sellBook(book1, franz));
        assertAll(
                () -> assertEquals(0, buecherDe.getUmsatz().compareTo(new BigDecimal("29.90"))),
                () -> assertEquals(buecherDe.getBuecher().size(), 7),
                () -> assertEquals(0, franz.getMoney().compareTo(new BigDecimal("9.02"))),
                () -> assertEquals(franz.getBooks().size(), 1)
        );
    }

    @Test
    void testToString() {
        assertEquals(String.class, beckShop.toString().getClass());
    }

    @Test
    void compareBooks() {
        assertTrue(thalia.compareBooks(shopSameBooksAsThalia));
        assertTrue(thalia.compareBooks(shopSameBooksAsThalia));
        assertFalse(thalia.compareBooks(hugendubel));
    }
}
