package Simplicity.Objects;

import Simplicity.Sim;

public class Book extends Furniture{
    String genre;
    //Constructor
    public Book(String type, int price, int length, int width, String genre) {

        super(type, price, length, width);
        // GENRE HARUS one og: "Comic book", "Fantasy novel", "Non-fiction"
        this.genre = genre;
    }

    //masih prototype
    public void doAction(Sim sim) {
        sim.readBook(genre);
    }
}
