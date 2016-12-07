package library.AllClass;

import java.io.Serializable;

public class book implements Serializable {

    private int book_id;
    private String title;
    private String available;
    private int sec_id;

    public book() {
    }

    public book(int book_id, String title, String available, int sec_id) {
        this.book_id = book_id;
        this.title = title;
        this.available = available;
        this.sec_id = sec_id;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available;
    }

    public int getSec_id() {
        return sec_id;
    }

    public void setSec_id(int sec_id) {
        this.sec_id = sec_id;
    }
}
