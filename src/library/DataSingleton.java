/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import library.AllClass.EmpBook;
import library.AllClass.Employee;
import library.AllClass.MemberBook;
import library.AllClass.Member;

/**
 *
 * @author AbdelRahman
 */
public class DataSingleton {

    private static DataSingleton data = null;
    private final ObservableList<EmpBook> empBooks;
    private final ObservableList<MemberBook> memberBooks;
    private final ObservableList<Employee> employess;
    private final ObservableList<Member> members;

    public DataSingleton() {
        this.empBooks = FXCollections.observableArrayList();
        this.memberBooks = FXCollections.observableArrayList();
        this.employess = FXCollections.observableArrayList();
        this.members = FXCollections.observableArrayList();
    }

    public static DataSingleton getInstance() {
        if (data == null) {
            data = new DataSingleton();
        }
        return data;
    }

    public ObservableList<EmpBook> getEmpBooks() {
        return empBooks;
    }

    public void setEmpBooks(ObservableList<EmpBook> empBooks) {
        this.empBooks.clear();
        this.empBooks.addAll(empBooks);
    }

    public ObservableList<MemberBook> getMemberBooks() {
        return memberBooks;
    }

    public void setMemberBooks(ObservableList<MemberBook> memberBooks) {
        this.memberBooks.clear();
        this.memberBooks.addAll(memberBooks);
    }

    public ObservableList<Employee> getEmployess() {
        return employess;
    }

    public void setEmployess(ObservableList<Employee> employess) {
        this.employess.clear();
        this.employess.addAll(employess);

    }

    public EmpBook getEmpBook(int bookId) {
        for (EmpBook empBook : empBooks) {
            if (empBook.getBookId() == bookId) {
                return empBook;
            }
        }
        return null;
    }

    public ObservableList<Member> getMembers() {
        return members;
    }

    public void setMembers(ObservableList members) {
        this.members.clear();
        this.members.addAll(members);
    }

}
