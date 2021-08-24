package chris.moviestore;

import java.util.List;

// logic extracted from statement method in customer
// uses TextStatement or HtmlStatement depending on which method called
public abstract class Statement {
  protected abstract String header(String name);
  protected abstract String lineItem(Rental rental, double thisAmount);
  protected abstract String footer(double totalAmount, int frequentRenterPoints);

  public String statement(List<Rental> rentals, String name, double totalAmount, int frequentRenterPoints) {
    String result = header(name);
    for (Rental rental : rentals) {
      result += lineItem(rental, rental.amount());
    }
    result += footer(totalAmount, frequentRenterPoints);
    return result;
  }
}
