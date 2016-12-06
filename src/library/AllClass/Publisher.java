
package library.AllClass;

import java.io.Serializable;

public class Publisher implements Serializable{
    
    private int pub_id;
    private String pub_name;
    private String address;

    public Publisher() {
    }

    
    
    public Publisher(int pub_id, String pub_name, String address) {
        this.pub_id = pub_id;
        this.pub_name = pub_name;
        this.address = address;
    }

    
    public int getPub_id() {
        return pub_id;
    }

    public void setPub_id(int pub_id) {
        this.pub_id = pub_id;
    }

    public String getPub_name() {
        return pub_name;
    }

    public void setPub_name(String pub_name) {
        this.pub_name = pub_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    
}
