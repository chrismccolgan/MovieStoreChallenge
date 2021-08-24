package chris.moviestore;

public class TextStatement extends Statement {
  protected String header(String name) {
    return "Rental Record for " + name + "\n";
  }

  protected String lineItem(Rental rental, double thisAmount) {
    return "\t" + rental.getMovie().getTitle() + "\t" + thisAmount + "\n";
  }

  protected String footer(double totalAmount, int frequentRenterPoints) {
    String footer1 = "Amount owed is " + totalAmount + "\n";
    String footer2 =  "You earned " + frequentRenterPoints + " frequent renter points";
    return footer1 + footer2;
  }
}
