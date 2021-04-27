public class Shop {
    /**
     * Der Name des Shops
     */
    private String _strName;

    /**
     * Der Umsatz des Shops
     * */
    private Float _umsatz;

    /**
     * Die Bücher des Shops
     */
    private Book[] _buecher;

    /**
     * Konstruktor
     */
    public Shop(String name, Float umsatz, Book[] buecher){
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
    public Float get_umsatz() {
        return _umsatz;
    }

    /**
     * Setter für Umsatz
     */
    public void set_umsatz(Float umsatz) {
        _umsatz = umsatz;
    }

    /**
     * Getter für Bücher
     * @return Bücher des Shops
     */
    public Book[] get_buecher(Float umsatz) {
        return _buecher;
    }

    /**
     * Setter für Bücher
     */
    public void set_buecher(Book[] buecher) {
        _buecher = buecher;
    }


    public static void main (String[] args) {
        System.out.println("Hello, World!");
    }
}
