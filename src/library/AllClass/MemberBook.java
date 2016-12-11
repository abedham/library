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
public class MemberBook {

    private int bookId;
    private int memberId;
    private String bookName;
    private String borrowDate;
    private String returnDate;
    private String status;

    public MemberBook() {
    }

    public MemberBook(int bookId, int memberId, String bookName, String borrowDate, String returnDate, boolean status) {
        this.bookId = bookId;
        this.memberId = memberId;
        this.bookName = bookName;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        if (status) {
            this.status = "Returned";
        } else {
            this.status = "Not returned";
        }
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

    public String getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(String borrowDate) {
        this.borrowDate = borrowDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

}
