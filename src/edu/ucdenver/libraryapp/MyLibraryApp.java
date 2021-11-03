/*
 * Name: Carlos A. Valdez (101355229)
 * Class: CSCI-3920 : Advanced Java and Python
 * Instructor: Javier Pastorino
 * Due: September 24th, 2021
 * Description: HWK3 LibraryApp
 * Compiled on IntelliJ, tested on AutoGrader
 */

package edu.ucdenver.libraryapp;
import edu.ucdenver.library.Library;            // access point for other classes through Library class
import java.time.LocalDate;
public class MyLibraryApp {                     // start of MyLibraryApp class

    public static void main(String[] args){     // start of main

        Library myLibrary = new Library("My Auraria Library");
        // Adding the authors
        try {
            myLibrary.addAuthor("John Grisham");
        }
        catch (IllegalArgumentException ie){ System.out.println("ERROR:"+ie); }
        //try {     -- Uncomment to add me in there too :D, to let me know not just AutoGrader is grading this :D
           // myLibrary.addAuthor("Carlos A. Valdez");
        //}
        //catch (IllegalArgumentException ie){ System.out.println("ERROR:"+ie); }

        try {
            myLibrary.addAuthor("David Baldacci");
        }
        catch (IllegalArgumentException ie){ System.out.println("ERROR:"+ie); }
        /* Removed the extra .addAuthor("John Grisham since it was working, comment out if want to test)
        try {
            myLibrary.addAuthor("John Grisham");
        }
        catch (IllegalArgumentException ie){ System.out.println("ERROR:"+ie); }
        */
        // Adding the books
        try{
            String[] titles = {"The Guardians: A Novel","Guardians","Guardianes"};
            myLibrary.addPrintedBook("The Guardians", LocalDate.of(2019,10,15),titles,
                    "John Grisham", "isbn 123", 120 );
        }catch (IllegalArgumentException ie){ System.out.println("ERROR:"+ie); }

        try{
            String[] titles = {"b1","book 1","the title of book 1"};
            myLibrary.addPrintedBook("Book 1", LocalDate.of(2000,1,1),titles,
                    "Al. Baker", "isbn 2", 200 );
        }catch (IllegalArgumentException ie){ System.out.println("ERROR:"+ie); }

        try{
            String[] titles = {"Camino Winds","Winds","The last one"};
            myLibrary.addEBook("Camino Winds", LocalDate.of(2020,4,28),titles,
                    "John Grisham", "isbn 234", 500, 50 );
        }catch (IllegalArgumentException ie){ System.out.println("ERROR:"+ie); }
        System.out.println(myLibrary);
    }   // end main
}   // end MyLibraryApp class
