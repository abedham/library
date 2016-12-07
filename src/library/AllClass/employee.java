
package library.AllClass;

import java.io.Serializable;



public class employee implements Serializable{
    
   private int emp_id;
   private String emp_name;
   private String isAdmin;
   private String emp_address;
   private String emp_email;

    public employee() {
    }

    public employee(int emp_id, String emp_name, String isAdmin, String emp_address, String emp_email) {
        this.emp_id = emp_id;
        this.emp_name = emp_name;
        this.isAdmin = isAdmin;
        this.emp_address = emp_address;
        this.emp_email = emp_email;
    }

   
    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public String getEmp_name() {
        return emp_name;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    public String getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(String isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String getEmp_address() {
        return emp_address;
    }

    public void setEmp_address(String emp_address) {
        this.emp_address = emp_address;
    }

    public String getEmp_email() {
        return emp_email;
    }

    public void setEmp_email(String emp_email) {
        this.emp_email = emp_email;
    }
   
   
   
    
}
