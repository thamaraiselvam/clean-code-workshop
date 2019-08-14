package com.movierental;

import java.util.ArrayList;
import java.util.List;

public class Customer {
  private String name;
  private List<Rental> rentals = new ArrayList<>();

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

    return new TextStatement().display(this.getName(), this.totalAmount(), this.frequentRenterPoints());
  }

  public String htmlStatement(){
    String result = "<h1>Rental Record for <strong>" + getName() + "</strong></h1>\n";
    for (Rental each : rentals) {
      //show figures for this rental
      result += "\t<strong>" + each.getMovie().getTitle() + "</strong>\t" +
              String.valueOf(each.amount()) + "\n";
    }
    result += "Amount owed is <strong>" + String.valueOf(totalAmount()) + "</strong>\n";
    result += "You earned <strong>" + String.valueOf(frequentRenterPoints())
            + "</strong> frequent renter points";
    return  result;
  }

  private int frequentRenterPoints() {
    return rentals.stream().mapToInt((rentals -> rentals.frequentRenterPoints())).sum();
  }

  private double totalAmount() {
    return rentals.stream().mapToDouble(rental -> rental.amount()).sum();
  }

  private class TextStatement {
    public String display(String name, double totalAmount, int frequentRenterPoints) {
      String result = "Rental Record for " + name + "\n";

      for (Rental each : rentals) {
        //show figures for this rental
        result += "\t" + each.getMovie().getTitle() + "\t" +
            String.valueOf(each.amount()) + "\n";
      }

      //add footer lines result
      result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
      result += "You earned " + String.valueOf(frequentRenterPoints)
          + " frequent renter points";
      return result;
    }
  }
}

