
package library.AllClass;

import java.io.Serializable;


public class Supplies implements Serializable{
    
    private int pub_id;
    private int book_id;

    public Supplies() {
    }

    public Supplies(int pub_id, int book_id) {
        this.pub_id = pub_id;
        this.book_id = book_id;
    }

    public int getPub_id() {
        return pub_id;
    }

    public void setPub_id(int pub_id) {
        this.pub_id = pub_id;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }
    
    
}
