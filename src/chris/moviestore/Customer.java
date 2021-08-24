package chris.moviestore;

import java.util.ArrayList;
import java.util.List;

public class Customer {
  private String name;
  private List<Rental> rentals = new ArrayList<>();

  public Customer(String name) {
    this.name = name;
  }

  public void addRental(Rental rental) {
    rentals.add(rental);
  }

  public String getName() {
    return name;
  }

  // returns a text statement
  public String statement() {
    return new TextStatement().statement(rentals, getName(), totalAmount(rentals), frequentRenterPoints(rentals));
  }

  // returns an html formatted statement
  public String htmlStatement() {
    return new HtmlStatement().statement(rentals, getName(), totalAmount(rentals), frequentRenterPoints(rentals));
  }

  private double totalAmount(List<Rental> rentals) {
    double totalAmount = 0;
    for (Rental rental : rentals) {
      // determine amounts for rental line
      double thisAmount = rental.amount();

      // show figures for this rental
      totalAmount += thisAmount;
    }
    return totalAmount;
  }

  private int frequentRenterPoints(List<Rental> rentals) {
    int totalRenterPoints = 0;
    for (Rental rental : rentals) {
      // if title is a new release and days rented > 1, adds a bonus renter point
      totalRenterPoints += ((rental.getMovie().getPriceCode() == Movie.NEW_RELEASE) && rental.getDaysRented() > 1) ? 2 : 1;
    }
    return totalRenterPoints;
  }
}