package pb.dada.com.passwordbox.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2015/9/24.
 */
public class User implements Serializable {

    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
