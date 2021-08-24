package chris.moviestore;

public class Main {

    public static void main(String[] args) {
        Customer customer = new Customer("Bob");
        Movie movieA = new Movie("Jaws", Movie.REGULAR);
        customer.addRental(new Rental(movieA, 2));
        customer.addRental(new Rental(new Movie("Golden Eye", Movie.REGULAR), 3));
        customer.addRental(new Rental(new Movie("Short New", Movie.NEW_RELEASE), 1));
        System.out.println(customer.statement());
        System.out.println(customer.htmlStatement());
    }
}
