
package library.AllClass;

import java.io.Serializable;

public class BookRegisteration implements Serializable{
    
    private int empId;
    private int id;
    private String currentDate;

    public BookRegisteration() {
    }

    
    public BookRegisteration(int emp_id, int book_id, String cur_date) {
        this.empId = emp_id;
        this.id = book_id;
        this.currentDate = cur_date;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(String currentDate) {
        this.currentDate = currentDate;
    }
    
    
}
