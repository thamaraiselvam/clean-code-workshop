package com.movierental;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CustomerTest {
    private Customer customer;

    @Before
    public void setup() {
        customer = new Customer("Selva");
        customer.addRental(new Rental(new Movie("Toy Story", Movie.CHILDRENS), 10));
        customer.addRental(new Rental(new Movie("Forrest Gump", Movie.NEW_RELEASE), 90));
        customer.addRental(new Rental(new Movie("Avenger", Movie.REGULAR), 30));
    }

    @Test
    public void shouldGenerateAsTextStatement(){
        assertEquals("Rental Record for Selva\n" +
                "\tToy Story\t12.0\n" +
                "\tForrest Gump\t270.0\n" +
                "\tAvenger\t44.0\n" +
                "Amount owed is 326.0\n" +
                "You earned 4 frequent renter points", customer.statement());
    }

    @Test
    public void shouldGenerateAsHtmlStatement(){
        assertEquals("<h1>Rental Record for <strong>Selva</strong></h1>\n" +
                "\t<strong>Toy Story</strong>\t12.0\n" +
                "\t<strong>Forrest Gump</strong>\t270.0\n" +
                "\t<strong>Avenger</strong>\t44.0\n" +
                "Amount owed is <strong>326.0</strong>\n" +
                "You earned <strong>4</strong> frequent renter points", customer.htmlStatement());
    }

}