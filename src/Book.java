import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Book {
    /**
     * Der Titel des Buchs
     */
    private String _title;

    /**
     * Der Preis des Buchs
     */
    private Double _price;

    /**
     * Die Seitenanzahl des Buches
     */
    private Integer _pageCount;

    /**
     * Das Genre des Buchs
     */
    private Genre _genre;

    private String _isbn;

    public Book(String title, Double price, Integer pageCount, Genre genre, String isbn) {
        String regex = "^(?:ISBN(?:-13)?:? )?(?=[0-9]{13}$|(?=(?:[0-9]+[- ]){4})[- 0-9]{17}$)97[89][- ]?[0-9]{1,5}[- ]?[0-9]+[- ]?[0-9]+[- ]?[0-9]$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(isbn);
        if(!matcher.matches()) {
            throw new IllegalArgumentException("Falsche ISBN-13!");
        }
        _isbn = isbn;
        _title = title;
        _price = price;
        _pageCount = pageCount;
        _genre = genre;
    }

    public Book(Book book){
        this._genre = book._genre;
        this._isbn = book._isbn;
        this._title = book._title;
        this._price = book._price;
        this._pageCount = book._pageCount;
    }

    /**
     * Getter für Titel
     */
    public String get_title() {
        return _title;
    }

    /**
     * Getter für Preis
     */
    public Double get_price() {
        return _price;
    }

    /**
     * Getter für Seitenanzahl
     */
    public Integer get_pageCount() {
        return _pageCount;
    }

    /**
     * Getter für Genre
     */
    public Genre get_genre() {
        return _genre;
    }

}
