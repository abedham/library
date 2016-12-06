
package library.AllClass;

import java.io.Serializable;

public class borrow implements Serializable{
    
    private int emp_id;
    private int mem_id;
    private int book_id;
    private String cur_date;
    private String expire_date;

    public borrow() {
    }

    public borrow(int emp_id, int mem_id, int book_id, String cur_date, String expire_date) {
        this.emp_id = emp_id;
        this.mem_id = mem_id;
        this.book_id = book_id;
        this.cur_date = cur_date;
        this.expire_date = expire_date;
    }

    
    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public int getMem_id() {
        return mem_id;
    }

    public void setMem_id(int mem_id) {
        this.mem_id = mem_id;
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

    public String getExpire_date() {
        return expire_date;
    }

    public void setExpire_date(String expire_date) {
        this.expire_date = expire_date;
    }
    
    
    
}
