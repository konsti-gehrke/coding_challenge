import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Shop {
    /**
     * Der Name des Shops
     */
    private String _strName;

    /**
     * Der Umsatz des Shops
     * */
    private Double _umsatz;

    /**
     * Die Bücher des Shops
     */
    private List<Book> _buecher = new ArrayList<>();

    /**
     * Konstruktor
     */
    public Shop(String name, Double umsatz, List<Book> buecher){
        _strName=name;
        _umsatz=umsatz;
        _buecher=buecher;
    }

    /**
     * Getter für Name
     */
    public String getName(){
        return _strName;
    }

    /**
     * Setter für Name
     */
    public void setName(String name){
        _strName=name;
    }

    /**
     * Getter für Umsatz
     */
    public Double getUmsatz() {
        return _umsatz;
    }

    /**
     * Verkauf eines Buchs
     */
    public boolean sellBook(Book verkaufendesBuch, Customer customer) {
        if(_buecher.contains(verkaufendesBuch)) {
            System.out.println("Buch in der Liste");
            if(customer.reduceMoney(verkaufendesBuch.get_price())) {
                System.out.println("Genug geld");
                _buecher.remove(verkaufendesBuch);
                _umsatz += verkaufendesBuch.get_price();
                customer.addBook(verkaufendesBuch);
                return true;
            }
            System.out.println("Zu wenig geld vorhanden");
        }
        System.out.println("Buch nicht in der Liste enthalten");
        return false;
    }

    /**
     * Getter für Bücher
     * @return Bücher des Shops
     */
    public List<Book> getBuecher() {
        return _buecher;
    }

    /**
     * Getter für Bücher mit einem Genre als Filter
     * @return Gefilterte Bücher des Shops
     */
    public List<Book> getFilteredBuecher(Genre genre) {
        List<Book> _buecherFiltered = new ArrayList<>();
        for (int i = _buecher.size() - 1; i >= 0; --i) {
            Book book = _buecher.get(i);
            if (book != null) {
                _buecherFiltered.add(new Book(book));
            }
        }
        _buecherFiltered.removeIf(book -> book.get_genre() != genre);
        return _buecherFiltered;
    }

    /**
     * Hinzufügen eines Buches
     */
    public void addBook(Book buch) {
        _buecher.add(buch);
    }
}
