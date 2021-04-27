public class Book {

    /**
     * Der Titel des Buchs
     */
    private String _title;

    /**
     * Der Preis des Buchs
     */
    private Float _price;

    /**
     * Die Seitenanzahl des Buches
     */
    private Integer _pageCount;

    /**
     * Das Genre des Buchs
     */
    private Genre _genre;

    public Book(String title, Float price, Integer pageCount, Genre genre) {
        _title = title;
        _price = price;
        _pageCount = pageCount;
        _genre = genre;
    }

    public String get_title() {
        return _title;
    }

    public Float get_price() {
        return _price;
    }

    public Integer get_pageCount() {
        return _pageCount;
    }

    public Genre get_genre() {
        return _genre;
    }
}
