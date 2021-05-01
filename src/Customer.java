import java.util.ArrayList;
import java.util.List;

public class Customer {
    /**
     * Der Name des Kunden
     */
    private String _name;

    /**
     * Die Bücher des Kunden
     */
    private List<Book> _books = new ArrayList<>();

    /**
     * Das Geld des Kunden
     */
    private Double _money;

    public Customer(String name, Double money) {
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
    public Double getMoney() {
        return _money;
    }

    /**
     * Verringern des Geldes
     */
    public boolean reduceMoney(Double money) {
        System.out.println(money);
        System.out.println(_money);
        if(money <= _money) {
            _money -= money;
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
