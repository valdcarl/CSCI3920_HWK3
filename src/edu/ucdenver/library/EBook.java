// EBook class, inherits from Book

package edu.ucdenver.library;
import java.time.LocalDate;
public class EBook extends Book {
    /*
        - numberOfWords: int       (Complete)
        - wordsPerPage: int        (Complete)
        + EBook(String, LocalDate, String[], Author, String, int, int)  (Complete)
        + getNumPages(): int          (Complete)
        + setWordsPerPage(int): void  (Complete)
        + toString(): String          (Complete)
     */
    private int numberOfWords;
    private int wordsPerPage;

    public EBook(String title, LocalDate publicationDate, String[] otherTitles, Author author,
                 String isbn, int numberOfWords, int wordsPerPage) {
        //super must be first statement in the constructor body as said in professor Pastorino's video
        super(title, publicationDate, otherTitles, author, isbn);
        this.numberOfWords = numberOfWords; // must initialize since Base class does not have --- extending here
        setWordsPerPage(wordsPerPage);
    }

    @Override
    public int getNumPages() throws ArithmeticException {
        // for EBook, this calculation specified num_words/num_words_per_page unlike PrintedBook
        int numPages = 0;
        try {
            numPages = numberOfWords / wordsPerPage; // as described on description for an Ebook
        } catch (ArithmeticException e) { System.out.println(e);}
        if (numberOfWords % wordsPerPage > 0) {  // if theres some remainder, add it to numPages counter
            numPages = numPages + 1;
        }
        return numPages;    // renamed to numPages for consistency
                            // auto-grader says not being inherited from Book somehow
    }

    public void setWordsPerPage(int wordsPerPage){
        this.wordsPerPage = wordsPerPage;
    }

    public String toString() {  // using super.toString but with the added "Electronic" to distinguish between book type
        return "Electronic-" + super.toString();
    }

}
