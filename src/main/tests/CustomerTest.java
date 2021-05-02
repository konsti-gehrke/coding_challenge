import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {
    Customer peter = new Customer("Peter Pan", new BigDecimal("83.00"));

    @Test
    void creationFail() {
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> new Customer("Matthias Mattis", new BigDecimal("-29.33")),
                "Ungültigen Geldwert angegeben."
        );
        assertTrue(thrown.getMessage().contains("Ungültigen Geldwert angegeben!"));
    }

    @Test
    void getterTests() {
        Customer petra = new Customer("Petra P", new BigDecimal("37.03"));
        List<Book> bookList = new ArrayList<>();
        assertAll(
                () -> assertEquals(petra.getName(), "Petra P"),
                () -> assertEquals(petra.getMoney(), new BigDecimal("37.03")),
                () -> assertEquals(petra.getBooks(), bookList)
        );
    }

    @Test
    void addBook() {
        Book book = new Book("Über Menschen", new BigDecimal("22.00"), 416, Genre.ADVENTURE, "9783630876672");
        List<Book> bookList = new ArrayList<>();
        assertEquals(peter.getBooks(), new ArrayList<>());
        peter.addBook(book);
        bookList.add(book);
        assertEquals(peter.getBooks(), bookList);
    }

    @Test
    void reduceMoney() {
        assertAll(
                () -> assertTrue(peter.reduceMoney(new BigDecimal("11.00"))),
                () -> assertEquals(0, peter.getMoney().compareTo(new BigDecimal("72.00"))),
                () -> assertFalse(peter.reduceMoney(new BigDecimal("101.00")))
        );
    }
}
