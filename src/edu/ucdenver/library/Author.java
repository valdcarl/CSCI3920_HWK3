// Author class

package edu.ucdenver.library;
public class Author {
    /*
        - name: String          (Complete)  -UML says name, changing to authorName for readability
        + Author(String)        (Complete)
        + getName(): String     (Complete)  -UML says getName, changing to getAuthorName for readability
        + toString(): String    (Complete)
     */
    private String authorName;

    public Author(String authorName) {
        this.authorName = authorName;
    }
    public String getName() { return authorName; }

    public String toString() {
        // in text file it wants authorName (Author) to be output
        /* example:
                == Author List ==   <-- this line (from library toString)
                authorName (Author)
         */
        return String.format("%s (Author)", getName());
    }
}
