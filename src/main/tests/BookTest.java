import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

class BookTest {
    /**
     * Testen der fünf vorgegebenen ISBN-13 Nummern.
     * */

    @Test
    void creation() {
        Book book = new Book("Die Säulen der Erde", new BigDecimal("29.90"), 1376, Genre.FANTASY, "978-3608963762");
        Book book1 = new Book("Die Säulen der Erde", new BigDecimal("29.90"), 1376, Genre.FANTASY, "978-3841335180");
        assertEquals(Book.class, book.getClass());
        assertEquals(Book.class, book1.getClass());
    }

    @Test
    void failCreation() {
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> new Book("Asterix Mundart Kölsch IV", new BigDecimal("14.00"), 48, Genre.COMIC, "978-3442267747"),
                "Falsche ISBN-13 angegeben."
        );
        IllegalArgumentException thrown1 = assertThrows(
                IllegalArgumentException.class,
                () -> new Book("Die Säulen der Erde", new BigDecimal("29.90"), 1376, Genre.FANTASY, "978-758245159"),
                "Falsche ISBN-13 angegeben."
        );
        IllegalArgumentException thrown2 = assertThrows(
                IllegalArgumentException.class,
                () -> new Book("Die Säulen der Erde", new BigDecimal("29.90"), 1376, Genre.FANTASY, "978-3442267819"),
                "Falsche ISBN-13 angegeben."
        );
        assertTrue(thrown.getMessage().contains("Falsche ISBN-13!"));
        assertTrue(thrown1.getMessage().contains("Falsche ISBN-13!"));
        assertTrue(thrown2.getMessage().contains("Falsche ISBN-13!"));
    }

    @Test
    void getTitle() {
        Book book = new Book("Asterix Mundart Kölsch IV", new BigDecimal("14.00"), 48, Genre.COMIC, "978-3-7704-4115-0");
        assertEquals(book.getTitle(), "Asterix Mundart Kölsch IV");
    }

    @Test
    void getPrice() {
        Book book = new Book("Der erste letzte Tag", new BigDecimal("19.50"), 270, Genre.BIOGRAPHY, "9783426283868");
        assertEquals(0, book.getPrice().compareTo(new BigDecimal("19.50")));
    }

    @Test
    void getPageCount() {
        Book book = new Book("Die Säulen der Erde", new BigDecimal("29.90"), 1376, Genre.FANTASY, "978-0-596-52068-7");
        assertEquals(book.getPageCount(), 1376);
    }

    @Test
    void getIsbn() {
        Book book = new Book("Asterix und der Greif", new BigDecimal("59.00"), 112, Genre.COMIC, "978-3-7704-0206-9");
        assertEquals(book.getIsbn(), "978-3-7704-0206-9");
    }

    @Test
    void get_genre() {
        Book book = new Book("Über Menschen", new BigDecimal("22.00"), 416, Genre.ADVENTURE, "9783630876672");
        assertEquals(book.get_genre(), Genre.ADVENTURE);
    }

    @Test
    void validateIsbn() {
        String valid_isbn_10 = "349913599X";
        Book book = new Book("Der Besuch der alten Dame", new BigDecimal("10.00"), 160, Genre.ADVENTURE, "978-3-257-23045-1");
        assertAll(
                () -> assertTrue(book.validateIsbn("978-3-257-23045-1")),
                () -> assertFalse(book.validateIsbn("97papierflieger45-1")),
                () -> assertFalse(book.validateIsbn(valid_isbn_10))
        );

    }

    @Test
    void equals() {
        Book book = new Book("Goldene Flammen", new BigDecimal("12.99"), 352, Genre.FANTASY, "978-3-426-52444-2");
        Book book1 = new Book("Ungeschminkt", new BigDecimal("12.00"), 288, Genre.BIOGRAPHY, "978-3-499-00415-5");
        assertAll(() -> assertFalse(book.equals(book1)),
                  () -> assertTrue(book.equals(book)));
    }

    @Test
    void compareTo() {
        Book book = new Book("Warrior Cats - Special Adventure. Tigerherz' Schatten", new BigDecimal("11.00"), 471, Genre.ADVENTURE, "978-3-407-81267-4");
        Book book1 = new Book("Das Gold der Krähen", new BigDecimal("16.99"), 592, Genre.FANTASY, "978-3-426-65449-1");
        assertEquals(book.compareTo(book), 0);
        assumeTrue(book.compareTo(book1) < 0);
    }
}
