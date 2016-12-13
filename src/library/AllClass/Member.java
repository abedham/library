package library.AllClass;

import java.io.Serializable;

public class Member implements Serializable {

    private int mem_id;
    private String name;
    private String email;
    private String address;
    private String expire_date;
    private String empName;

    public Member() {
    }

    public Member(int mem_id, String empName, String name, String email, String address, String expire_date) {
        this.mem_id = mem_id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.empName = empName;
        this.expire_date = expire_date;
    }

    public int getMem_id() {
        return mem_id;
    }

    public void setMem_id(int mem_id) {
        this.mem_id = mem_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getExpire_date() {
        return expire_date;
    }

    public void setExpire_date(String expire_date) {
        this.expire_date = expire_date;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

}
