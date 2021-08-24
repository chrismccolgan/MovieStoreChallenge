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
      double thisAmount = amount(rental);
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
      double thisAmount = amount(rental);

      // show figures for this rental
      totalAmount += thisAmount;
    }
    return totalAmount;
  }

  private double amount(Rental rental) {
    double thisAmount = 0;
    switch (rental.getMovie().getPriceCode()) {
      case Movie.REGULAR:
        thisAmount += 2;
        if (rental.getDaysRented() > 2)
          thisAmount += (rental.getDaysRented() - 2) * 1.5;
        break;
      case Movie.NEW_RELEASE:
        thisAmount += rental.getDaysRented() * 3;
        break;
      case Movie.CHILDRENS:
        thisAmount += 1.5;
        if (rental.getDaysRented() > 3)
          thisAmount += (rental.getDaysRented() - 3) * 1.5;
        break;
    }
    return thisAmount;
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