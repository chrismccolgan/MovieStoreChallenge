package chris.moviestore;

public class Movie {

  public static final int CHILDRENS = 2;
  public static final int NEW_RELEASE = 1;
  public static final int REGULAR = 0;

  private String title;
  private Price price;

  public Movie(String title, int priceCode) {
    this.title = title;
    this.price = new Price(priceCode);
  }

  public int getPriceCode() {
    return price.getPriceCode();
  }

//  public void setPriceCode(int priceCode) {
//    price = new Price(priceCode);
//  }

  public String getTitle() {
    return title;
  }

  public double amount(int daysRented) {
    return price.amount(daysRented);
  }
}
