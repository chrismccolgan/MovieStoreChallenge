package chris.moviestore;

import java.util.ArrayList;
import java.util.List;

public class Customer {

  private String name;
  private List<Rental> rentals = new ArrayList<Rental>();

  public Customer(String name) {
    this.name = name;
  }

  public void addRental(Rental arg) {
    rentals.add(arg);
  }

  public String getName() {
    return name;
  }

  public String statement() {
    String result = header(getName());

    for (Rental rental : rentals) {
      double thisAmount = rental.amount();
      result += lineItem(rental, thisAmount);
    }

    double totalAmount = totalAmount(this.rentals);
    int frequentRenterPoints = frequentRenterPoints(this.rentals);

    // add footer lines
    result += footer(totalAmount, frequentRenterPoints);

    return result;
  }

  private double totalAmount(List<Rental> rentals) {
    double totalAmount = 0;
    for (Rental rental : rentals) {
      //determine amounts for rental line
      double thisAmount = rental.amount();

      // show figures for this rental
      totalAmount += thisAmount;
    }
    return totalAmount;
  }

  private int frequentRenterPoints(List<Rental> rentals) {
    int frequentRenterPoints = 0;
    for (Rental each : rentals) {
      frequentRenterPoints++;
      // add bonus for a two day new release rental
      if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && each.getDaysRented() > 1)
        frequentRenterPoints++;
    }
    return frequentRenterPoints;
  }

  private String header(String name) {
    return "Rental Record for " + name + "\n";
  }

  private String lineItem(Rental rental, double thisAmount) {
    return "\t" + rental.getMovie().getTitle() + "\t" + thisAmount + "\n";
  }

  private String footer(double totalAmount, int frequentRenterPoints) {
    String footer1 = "Amount owed is " + totalAmount + "\n";
    String footer2 =  "You earned " + frequentRenterPoints + " frequent renter points";
    return footer1 + footer2;
  }
}