// Book class must be abstract class, base class for EBook and PrintedBook

package edu.ucdenver.library;
import java.time.LocalDate;

public abstract class Book {
    /*
        - title: String                 (Complete)
        - publicationDate: LocalDate    (Complete)
        - otherTitles: String[]         (Complete)
        - isbn: String                  (Complete)
        + Book(String, LocalDate, String[], Author, String) (Complete)
        + getNumPages(): int            (Complete)
        + toString(): String            (Complete)
        + getTitle(): String            (Complete)
        + setTitle(String): void        (Complete)
        + getPublicationDate(): LocalDate       (Complete)
        + setPublicationDate(LocalDate): void   (Complete)
        + getOtherTitles(): String[]            (Complete)
        + setOtherTitles(String[]): String[]    (Complete)
        + getISBN() : String                    (Complete)
        + getAuthor(): Author                   (Complete)
     */
    private String title;
    private LocalDate publicationDate;
    private String[] otherTitles;
    private Author author;              // assumed based on need for constructor, but not in UML
    private String isbn;

    public Book(String title, LocalDate publicationDate, String[] otherTitles, Author author, String isbn){
        setTitle(title);            // to use the setters
        setPublicationDate(publicationDate);
        setOtherTitles(otherTitles);
        this.author = author;
        this.isbn = isbn;
    }
    public abstract int getNumPages();

    public String toString(){
        // will return the formatted string containing all the necessary content
        // in text file example below
        /* example:
        The Guardians (isbn:isbn 123), published on 2019-10-15 authored
                       by John Grisham (Author) with 120 pages and 3 other titles. (one line)

         */
        return String.format("Book: %s (isbn:%s), published on ", getTitle(), getISBN()) + getPublicationDate().toString()
                            + " authored by " + getAuthor().toString() + " with " + getNumPages()
                            + " pages and " + getOtherTitles().length + " other titles.\n";
    }

    public String getTitle() { return title; }
    public void setTitle(String title){
        this.title = title;
    }

    public LocalDate getPublicationDate() { return publicationDate; }
    public void setPublicationDate(LocalDate publicationDate){
        this.publicationDate = publicationDate;
    }

    public String[] getOtherTitles() { return otherTitles; }
    public void setOtherTitles(String[] otherTitles){
        this.otherTitles = otherTitles;
    }

    public String getISBN() { return isbn; }

    public Author getAuthor() { return author; }

}
