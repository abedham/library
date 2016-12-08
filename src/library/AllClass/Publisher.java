
package library.AllClass;

import java.io.Serializable;

public class Publisher implements Serializable{
    
    private int id;
    private String name;
    private String address;

    public Publisher() {
    }

    
    
    public Publisher(int pub_id, String pub_name, String address) {
        this.id = pub_id;
        this.name = pub_name;
        this.address = address;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    
}
