
package library.AllClass;

import java.io.Serializable;

public class Section implements Serializable{
    
    private int sec_id;
    private String sec_name;

    public Section() {
    }

    public Section(int sec_id, String sec_name) {
        this.sec_id = sec_id;
        this.sec_name = sec_name;
    }

    public int getSec_id() {
        return sec_id;
    }

    public void setSec_id(int sec_id) {
        this.sec_id = sec_id;
    }

    public String getSec_name() {
        return sec_name;
    }

    public void setSec_name(String sec_name) {
        this.sec_name = sec_name;
    }
    
    
}
