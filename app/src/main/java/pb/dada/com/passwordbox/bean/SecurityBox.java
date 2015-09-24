package pb.dada.com.passwordbox.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2015/9/22.
 */
public class SecurityBox implements Serializable {

    //标题
    private String title;
    //用户名
    private String acountName;
    //密码
    private String password;
    //注释
    private String annotation;
    //时间
    private String createTime;

    public SecurityBox() {
    }

    public SecurityBox(String title, String acountName, String password, String annotation, String createTime) {
        this.title = title;
        this.acountName = acountName;
        this.password = password;
        this.annotation = annotation;
        this.createTime = createTime;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public String getAcountName() {
        return acountName;
    }

    public void setAcountName(String acountName) {
        this.acountName = acountName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getAnnotation() {
        return annotation;
    }

    public void setAnnotation(String annotation) {
        this.annotation = annotation;
    }


}
