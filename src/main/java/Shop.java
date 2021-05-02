import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Shop {
    /**
     * Der Name des Shops
     */
    private final String _strName;

    /**
     * Der Umsatz des Shops
     * */
    private BigDecimal _umsatz;

    /**
     * Die Bücher des Shops
     */
    private final List<Book> _buecher;

    /**
     * Konstruktor
     */
    public Shop(String name, BigDecimal umsatz, List<Book> buecher){
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
     * Getter für Umsatz
     */
    public BigDecimal getUmsatz() {
        return _umsatz;
    }

    /**
     * Verkauf eines Buchs
     */
    public boolean sellBook(Book verkaufendesBuch, Customer customer) {
        if(_buecher.contains(verkaufendesBuch)) {
            if(customer.reduceMoney(verkaufendesBuch.getPrice())) {
                _buecher.remove(verkaufendesBuch);
                _umsatz = _umsatz.add(verkaufendesBuch.getPrice());
                customer.addBook(verkaufendesBuch);
                return true;
            }
            System.out.println("Zu wenig geld vorhanden");
            return false;
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
     * Methode zur feststellung ob zwei Shops die gleichen Bücher im Angebot haben.
     * Überprüfung nur von generellem Inventar: D.h.:
     * Wenn beide Shops an sich alle verschiedenen Bücher nur in unterschiedlicher Quantität führen wird dennoch true zurückgegeben.
     * @return true wenn die Bücherlisten übereinstimmen.
     * */
    public boolean compareBooks(Shop secondShop) {
        List<Book> _buecherUnique = this.getBuecherUnikate();
        Collections.sort(_buecherUnique);
        List<Book> scndShopBooksUnique = secondShop.getBuecherUnikate();
        Collections.sort(scndShopBooksUnique);

        return scndShopBooksUnique.equals(_buecherUnique);
    }

    /**
     * Getter für Bücher mit einem bestimmten Genre als Filter
     * @return Gefilterte Bücher des Shops
     */
    public List<Book> getFilteredBuecher(Genre genre) {
        List<Book> _buecherFiltered = cloneBooks(_buecher);
        _buecherFiltered.removeIf(book -> book.get_genre() != genre);
        return _buecherFiltered;
    }

    /**
     * Anfertigen einer "echten" Kopie einer Bücherliste
     * @return Eine "echte" Kopie von _buecher;
     * */
    private List<Book> cloneBooks (List<Book> listToClone) {
        List<Book> _buecherClone = new ArrayList<>();
        for (Book book : listToClone) {
            if (book != null) {
                _buecherClone.add(new Book(book));
            }
        }
        return _buecherClone;
    }

    /**
     * Liefert die Bücher ohne Duplikate zurück
     * */
    public List<Book> getBuecherUnikate() {
        return cloneBooks(_buecher).stream().filter(distinctByKey(Book::getTitle)).collect(Collectors.toList());
    }

    private static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Set<Object> seen = ConcurrentHashMap.newKeySet();
        return t -> seen.add(keyExtractor.apply(t));
    }

    /**
     * Methode zur Ausgabe der Buchtitel in der Liste.
     * @return Ein String mit den Buchtiteln.
     */
    @Override
    public String toString() {
        StringBuilder returnStr = new StringBuilder();
        for(Book book : this.getBuecherUnikate()){
            returnStr.append(book.toString()).append("\n");
        }
        return returnStr.toString();
    }

    /**
     * Hinzufügen eines Buches
     */
    public void addBook(Book buch) {
        _buecher.add(buch);
    }
}
