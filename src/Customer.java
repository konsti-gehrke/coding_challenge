public class Customer {
    /**
     * Der Name des Kunden
     */
    private String _name;

    /**
     * Die Bücher des Kunden
     */
    private Book[] _books;

    /**
     * Das Geld des Kunden
     */
    private Float _money;

    public Customer(String name, Float money) {
        _name = name;
        _money = money;
    }

    public Book[] get_books() {
        return _books;
    }

    public void set_books(Book[] books) {
        _books = books;
    }

    public Float get_money() {
        return _money;
    }

    public void set_money(Float money) {
        _money = money;
    }

    public String get_name() {
        return _name;
    }
}
