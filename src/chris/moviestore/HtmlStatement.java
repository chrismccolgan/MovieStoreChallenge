package chris.moviestore;

public class HtmlStatement extends Statement {
  @Override
  protected String header(String name) {
    return "<h1>Rental Record for " + name + "</h1>\n" + "<table>\n";
  }

  @Override
  protected String lineItem(Rental rental, double thisAmount) {
    return "<tr><td>" + rental.getMovie().getTitle() + "</td><td>" + thisAmount + "</td></tr>\n";
  }

  @Override
  protected String footer(double totalAmount, int frequentRenterPoints) {
    String footer1 = "</table>\n" + "<p>Amount owed is " + totalAmount + "</p>\n";
    String footer2 =  "<p>You earned " + frequentRenterPoints + " frequent renter points</p>";
    return footer1 + footer2;
  }
}