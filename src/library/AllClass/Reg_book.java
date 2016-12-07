
package library.AllClass;

import java.io.Serializable;

public class Reg_book implements Serializable{
    
    private int emp_id;
    private int book_id;
    private String cur_date;

    public Reg_book() {
    }

    
    public Reg_book(int emp_id, int book_id, String cur_date) {
        this.emp_id = emp_id;
        this.book_id = book_id;
        this.cur_date = cur_date;
    }

    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public String getCur_date() {
        return cur_date;
    }

    public void setCur_date(String cur_date) {
        this.cur_date = cur_date;
    }
    
    
}
