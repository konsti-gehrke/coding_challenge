import java.math.BigDecimal;

public class Book implements Comparable<Book> {
    /**
     * Der Titel des Buchs
     */
    private final String _title;

    /**
     * Der Preis des Buchs
     */
    private final BigDecimal _price;

    /**
     * Die Seitenanzahl des Buches
     */
    private final Integer _pageCount;

    /**
     * Das Genre des Buchs
     */
    private final Genre _genre;

    /**
     * ISBN-Nummer eines Buches zur Identifikation
     */
    private final String _isbn;

    /**
     *
     * @param title
     * @param price
     * @param pageCount
     * @param genre
     * @param isbn
     */
    public Book(String title, BigDecimal price, Integer pageCount, Genre genre, String isbn) {
        if(!validateIsbn(isbn)) {
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
    public String getTitle() {
        return _title;
    }

    /**
     * Getter für Preis
     */
    public BigDecimal getPrice() {
        return _price;
    }

    /**
     * Getter für Seitenanzahl
     */
    public Integer getPageCount() {
        return _pageCount;
    }

     /**
     * Getter für Seitenanzahl
     */
    public String getIsbn() {
        return _isbn;
    }

    /**
     * Getter für Genre
     */
    public Genre get_genre() {
        return _genre;
    }

    /**
     * Methode zur Feststellung ob eine ISBN valide ist.
     * @param isbn Zu überprüfende Nummer.
     * @return true wenn die übergebene ISBN valide ist.
     */
    public boolean validateIsbn( String isbn ) {
        if ( isbn == null ) {
            return false;
        }
        isbn = isbn.replaceAll( "-", "" );
        if ( isbn.length() != 13 ) {
            return false;
        }

        try {
            int sum = 0;
            for ( int i = 0; i < 12; i++ ) {
                int digit = Integer.parseInt( isbn.substring( i, i + 1 ) );
                sum += (i % 2 == 0) ? digit : digit * 3;
            }
            //checksum muss unter 10 liegen
            int checksum = 10 - (sum % 10);
            if ( checksum == 10 ) {
                checksum = 0;
            }
            return checksum == Integer.parseInt( isbn.substring( 12 ) );
        }
        catch ( NumberFormatException nfe ) {
            return false;
        }
    }

    /**
     * Wird gebraucht um Collection.sort auf einer Arraylist von Büchern anzuwenden
     * */
    @Override
    public int compareTo(Book book) {
        return this.getIsbn().compareTo(book.getIsbn());
    }

    @Override
    public String toString() {
       return this.getTitle();
    }

    /**
     * Methode um zwei Objekte zu vergleichen. Zur Überprüfung von zwei Bücherlisten gedacht.
     * */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        final Book other = (Book) obj;
        if ((this.getIsbn() == null) ? (other.getIsbn() != null) : !this.getIsbn().equals(other.getIsbn())) {
            return false;
        }

        if(!this.getIsbn().equals(other.getIsbn())){
            return false;
        }
        return true;
    }
}
