
package library.AllClass;

import java.io.Serializable;


public class phone_number implements Serializable{
    
    private int mem_id;
    private int phone;

    public phone_number() {
    }

    
    public phone_number(int mem_id, int phone) {
        this.mem_id = mem_id;
        this.phone = phone;
    }

    
    public int getMem_id() {
        return mem_id;
    }

    public void setMem_d(int mem_id) {
        this.mem_id = mem_id;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }
    
}
