package library.AllClass;

import java.io.Serializable;

public class Employee implements Serializable {

    private int emp_id;
    private String emp_name;
    private boolean admin;
    private String emp_address;
    private String emp_email;
    private int salary;

    public Employee() {
    }

    public Employee(int emp_id, String emp_name, boolean isAdmin, String emp_address, String emp_email, int salary) {
        this.emp_id = emp_id;
        this.emp_name = emp_name;
        this.admin = isAdmin;
        this.emp_address = emp_address;
        this.emp_email = emp_email;
        this.salary = salary;
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

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

}
