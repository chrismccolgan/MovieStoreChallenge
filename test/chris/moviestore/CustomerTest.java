package chris.moviestore;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerTest {
  @Test
  public void htmlTest() {
    Customer customer = new Customer("Bob");
    customer.addRental(new Rental(new Movie("Jaws", Movie.REGULAR), 2));
    customer.addRental(new Rental(new Movie("Golden Eye", Movie.REGULAR), 3));
    customer.addRental(new Rental(new Movie("Short New", Movie.NEW_RELEASE), 1));

    String expected =
        "<h1>Rental Record for Bob</h1>\n" +
        "<table>\n" +
        "<tr><td>Jaws</td><td>2.0</td></tr>\n" +
        "<tr><td>Golden Eye</td><td>3.5</td></tr>\n" +
        "<tr><td>Short New</td><td>3.0</td></tr>\n" +
        "</table>\n" +
        "<p>Amount owed is 8.5</p>\n" +
        "<p>You earned 3 frequent renter points</p>";

    assertEquals(expected, customer.htmlStatement());
  }

  @Test
  public void test() {
    Customer customer = new Customer("Bob");
    customer.addRental(new Rental(new Movie("Jaws", Movie.REGULAR), 2));
    customer.addRental(new Rental(new Movie("Golden Eye", Movie.REGULAR), 3));
    customer.addRental(new Rental(new Movie("Short New", Movie.NEW_RELEASE), 1));
    customer.addRental(new Rental(new Movie("Long New", Movie.NEW_RELEASE), 2));
    customer.addRental(new Rental(new Movie("Bambi", Movie.CHILDRENS), 3));
    customer.addRental(new Rental(new Movie("Toy Story", Movie.CHILDRENS), 4));

    String expected =
        "Rental Record for Bob\n" +
        "\tJaws\t2.0\n" +
        "\tGolden Eye\t3.5\n" +
        "\tShort New\t3.0\n" +
        "\tLong New\t6.0\n" +
        "\tBambi\t1.5\n" +
        "\tToy Story\t3.0\n" +
        "Amount owed is 19.0\n" +
        "You earned 7 frequent renter points";

    assertEquals(expected, customer.statement());
  }
}