// Library class

package edu.ucdenver.library;
import java.time.LocalDate;
import java.util.ArrayList;

public class Library {
    // Applications access the domain logic through this class as seen in the provided UML
    // In other words, it is the entry point bridging main and the class apps.
    /*
        - name: String      (Complete)
        // Its not mentioned here but we will need private ArrayLists for the authors and the books...
        + Library(String)   (Complete)
        + addPrintedBook(String, LocalDate, String[], String, String, int): void    (Complete)
        + addEBook(String, LocalDate, String[], String, String, int, int): void     (Complete)
        + printBooks(): String      (Complete)
        + addAuthor(String): void   (Complete)
        + getAuthor(String): Author (Complete)
        + getName(): String         (Complete) -UML says getName, changing to getLibraryName for readability purposes
                                                // update: autograder making me change name back to getName
        + toString(): String        (In-Progress)
     */
    private String libraryName;         // the library name
    private ArrayList<Book> books;      // list of type Book
    private ArrayList<Author> authors;  // list of type Author

    public Library(String name){
        this.libraryName = name;
        books = new ArrayList<Book>();
        authors = new ArrayList<Author>();

    }
    public void addPrintedBook(String title, LocalDate publicationDate, String[] otherTitles, String author,
                               String isbn, int numPages) throws IllegalArgumentException {
        // when we add a book, we need to get the author for that book
        Author author1 = null;      // create an author obj
        try {
            author1 = getAuthor(author);
        }
        catch (IllegalArgumentException ie) {
            addAuthor(author);
            author1 = getAuthor(author);
        }
        for(Book book : books) {    // iterate through the collection of books
            if(book.getTitle().equals(title))  {
                // if a book in the collection of books = title passed as arg,
                // it already exists, throw an exception with output for user.
                throw new IllegalArgumentException("This printed-book already exists in the collection.");
            }
        }   // otherwise, add the book, create a new PrintedBook object, with the title,
            // and add it to the collection of (ArrayList) of books
        Book printedBookObj = new PrintedBook(title, publicationDate, otherTitles, author1,
                                                    isbn, numPages);
        books.add(printedBookObj);
    }

    public void addEBook(String title, LocalDate publicationDate, String[] otherTitles, String author,
                         String isbn, int numberOfWords, int wordsPerPage) throws IllegalArgumentException {
        // when we add a book, we need to get the author for that book
        Author author1 = null;      // create an author obj
        try {
            author1 = getAuthor(author);        // try to get the author
        }
        catch (IllegalArgumentException ie) {   // if authors
            addAuthor(author);
            author1 = getAuthor(author);
        }
        for(Book book : books) {    // iterate through the collection of books
            if(book.getTitle().equals(title)) {
                // if a book in the collection of books = title passed as arg,
                // it already exists, throw an exception with output for user.
                throw new IllegalArgumentException("This electronic-book already exists in the collection.");
            }
        }   // otherwise, add the book, create a new EBook object, with the title,
            // and add it to the collection of (ArrayList) of books
        Book electronicBookObj = new EBook(title, publicationDate, otherTitles, author1, isbn, numberOfWords,
                                 wordsPerPage);
        books.add(electronicBookObj);
    }
    public String printBooks() {
        String printBooksStr = "";
        for(Book book : books) {    // iterate through the collection of books
            printBooksStr = printBooksStr + book.toString() + "\n";  //return each book with end-of-line
        }
        return printBooksStr;
    }
    public void addAuthor(String authorName) throws IllegalArgumentException {
        for(Author author : authors) {  // iterate through collection of authors
            if(author.getName().equals(authorName)) {
                // if an author in the collection of authors = to authorName passed as arg,
                // it already exists, throw an exception with output for user.
                throw new IllegalArgumentException("Author has already exists the collection.");
            }
        }   // otherwise, create a new author object, with that author name,
            // and add it to the collection (ArrayList) of authors
        Author anAuthor = new Author(authorName);
        authors.add(anAuthor);
    }
    public Author getAuthor(String authorName) {
        for(int i = 0; i < authors.size(); i++){
            if(authors.get(i).getName().compareTo(authorName) == 0) {
                return authors.get(i);
            }
        }
        throw new IllegalArgumentException("Could not et author with that name in collection.");
    }
    public String getName() { return libraryName; }
    public String toString() {
        String libStr = "This is the " + getName() + " library.\n" +
                        "== Author List ==\n";
        for (Author author : authors) {
            libStr = libStr + author.toString() + "\n";
        }
        libStr = libStr + ("== Book List ==\n") + printBooks();
        return libStr;
    }
}
