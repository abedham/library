/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import library.AllClass.MemberBook;
import library.AllClass.Employee;
import library.AllClass.member;

/**
 *
 * @author AbdelRahman
 */
public class Model {

    static DBConnection db = new DBConnection();
    static Connection conn = db.getConn();
    static PreparedStatement pstmtGetEmployee;
    static PreparedStatement pstmtGetMember;
    static PreparedStatement pstmtGetMemPhones;
    static PreparedStatement pstmtGetEmpBooks;
    static PreparedStatement pstmtReturnBook;

    static {
        try {
            pstmtGetEmployee = conn.prepareStatement("select * from employee where emp_id=? and password=?");
            pstmtGetMember = conn.prepareStatement("select * from member where mem_id=?");
            pstmtGetMemPhones = conn.prepareStatement("select * from phone_number where mem_id=?");
            pstmtGetEmpBooks = conn.prepareStatement("select * from EMP_BOOKS where MEM_ID=?");
            pstmtReturnBook = conn.prepareStatement("{call Return_Book(?,?)}");//need procedure to update available and returned

        } catch (SQLException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static member getMember(int memId) {
        member member = null;
        ResultSet res = null;
        try {
            pstmtGetMember.setInt(1, memId);
            res = pstmtGetMember.executeQuery();
            if (res.next()) {
                member = new member(memId, res.getString("NAME"),
                        res.getString("EMAIL"), res.getString("ADDRESS"), res.getString("EXPIRE_DATE"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (res != null) {
                try {
                    res.close();

                } catch (SQLException ex) {
                    Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return member;
    }

    public static List<String> getMemberPhones(int memId) {
        List<String> phones = new ArrayList<>();
        ResultSet res = null;
        try {
            pstmtGetMemPhones.setInt(1, memId);
            res = pstmtGetMemPhones.executeQuery();
            while (res.next()) {
                phones.add(res.getString("phone"));
            }
        } catch (SQLException ex) {
            if (res != null) {
                try {
                    res.close();
                } catch (SQLException ex1) {
                    Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex1);
                }
            }
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }
        return phones;
    }

    public static Employee logIn(int empId, String password) {
        Employee emp = null;
        ResultSet res = null;
        try {
            pstmtGetEmployee.setInt(1, empId);
            pstmtGetEmployee.setString(2, passHash(password));
            res = pstmtGetEmployee.executeQuery();
            if (res.next()) {
                emp = new Employee(res.getInt("emp_id"), res.getString("name"), res.getBoolean("isAdmin"),
                        res.getString("address"), res.getString("email"), res.getInt("salary"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (res != null) {
                try {
                    res.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return emp;
    }

    public static List<MemberBook> getEmpBooks(int memId) {
        List<MemberBook> empBooks = new ArrayList<>();
        ResultSet res = null;
        try {
            pstmtGetEmpBooks.setInt(1, memId);
            res = pstmtGetEmpBooks.executeQuery();
//            res = conn.createStatement().executeQuery("select * from EMP_BOOKS where MEM_ID='1'");

            while (res.next()) {
                empBooks.add(new MemberBook(res.getInt("BOOK_ID"), res.getInt("MEM_ID"), res.getString("TITLE"),
                        res.getString("CUR_DATE"), res.getString("EXPIRE_DATE"), res.getBoolean("returned")));
            }
        } catch (SQLException ex) {
            if (res != null) {
                try {
                    res.close();
                } catch (SQLException ex1) {
                    Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex1);
                }
            }
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }
        return empBooks;
    }

    public static String passHash(String pass) {
        try {
            MessageDigest mdAlgorithm = MessageDigest.getInstance("MD5");
            mdAlgorithm.update(pass.getBytes());

            byte[] digest = mdAlgorithm.digest();
            StringBuilder hexString = new StringBuilder();
            for (int i = 0; i < digest.length; i++) {
                pass = Integer.toHexString(0xFF & digest[i]);
                if (pass.length() < 2) {
                    pass = "0" + pass;
                }
                hexString.append(pass);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static void returnBook(int memberId, int bookId) {
        try {
            pstmtReturnBook.setInt(1, bookId);
            pstmtReturnBook.setInt(2, memberId);
            pstmtReturnBook.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
