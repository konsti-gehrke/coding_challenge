import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Customer {
    /**
     * Der Name des Kunden
     */
    private final String _name;

    /**
     * Die Bücher des Kunden
     */
    private final List<Book> _books = new ArrayList<>();

    /**
     * Das Geld des Kunden
     */
    private BigDecimal _money;

    public Customer(String name, BigDecimal money) {
        if(money.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Ungültigen Geldwert angegeben!");
        }
        _name = name;
        _money = money;
    }

    /**
     * Getter für Bücher
     */
    public List<Book> getBooks() {
        return _books;
    }

    /**
     * Setter für Bücher
     * @param book: Das neue Buch des Kunden.
     */
    public void addBook(Book book) {
        _books.add(book);
    }

    /**
     * Getter für Geld
     */
    public BigDecimal getMoney() {
        return _money;
    }

    /**
     * Verringern des Geldes
     */
    public boolean reduceMoney(BigDecimal money) {
        if(money.compareTo(_money) <= 0) {
            _money = _money.subtract(money);
            return true;
        }
        return false;
    }

    /**
     * Getter für Name
     */
    public String getName() {
        return _name;
    }
}
