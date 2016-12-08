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
import java.util.logging.Level;
import java.util.logging.Logger;
import library.AllClass.Employee;

/**
 *
 * @author AbdelRahman
 */
public class Model {

    static DBConnection db = new DBConnection();
    static Connection conn = db.getConn();
    static PreparedStatement pstmtGetEmployee;

    static {
        try {
            pstmtGetEmployee = conn.prepareStatement("select * from employee where emp_id=? and password=?");

        } catch (SQLException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }
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
}
