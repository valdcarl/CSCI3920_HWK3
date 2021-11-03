// PrintedBook class, inherits from Book

package edu.ucdenver.library;
import java.time.LocalDate;
public class PrintedBook extends Book {
    /*
        - numPages: int        (Complete)
        + PrintedBook(String, LocalDate, String[], Author, String, int) (Complete)
        + getNumPages(): int   (Complete)
        + toString(): String   (Complete)
     */
    private int numPages;

    public PrintedBook(String title, LocalDate publicationDate, String[] otherTitles, Author author,
                       String isbn, int numPages) {
        //super must be first statement in the constructor body as said in professor Pastorino's video
        super(title, publicationDate, otherTitles, author, isbn);
        this.numPages = numPages;    // must initialize since Base class does not have --- extending here
    }

    @Override                   // using override
    public int getNumPages() { return numPages; }
    // for a Printed Book just returns the number of pages in the book, unlike EBook

    public String toString() {
        // In lecture videos, Professor Pastorino mentions usage of super.toString(),
        // to simply append subclasses details to it's base classes method
        // in this case, simply signifying that it is a printed book versus an electronic book
        // using super.toString but with the added "Printed" to distinguish between book type
        return "Printed-" + super.toString();
    }
}
