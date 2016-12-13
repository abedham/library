
package library.AllClass;

import java.io.Serializable;


public class Author_book implements Serializable{
    
    private String Author_name;
    private int book_id;

    public Author_book() {
    }

    public Author_book(String Author_name, int book_id) {
        this.Author_name = Author_name;
        this.book_id = book_id;
    }

    
    
    public String getAuthor_name() {
        return Author_name;
    }

    public void setAuthor_name(String Author_name) {
        this.Author_name = Author_name;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }
    
}
