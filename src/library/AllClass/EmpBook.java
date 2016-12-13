/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.AllClass;

/**
 *
 * @author AbdelRahman
 */
public class EmpBook {

    private int bookId;
    private String bookName;
    private String section;
    private String publisher;
    private String empName;
    private String date;
    private boolean available;

    public EmpBook() {
    }

    public EmpBook(int bookId, String bookName, String section, String publisher, String empName, String date, boolean available) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.section = section;
        this.publisher = publisher;
        this.empName = empName;
        this.date = date;
        this.available = available;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

}
