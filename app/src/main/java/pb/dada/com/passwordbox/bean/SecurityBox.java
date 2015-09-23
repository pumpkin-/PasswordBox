package pb.dada.com.passwordbox.bean;

/**
 * Created by Administrator on 2015/9/22.
 */
public class SecurityBox {

    //标题
    private String title;
    //用户名
    private String username;
    //密码
    private String password;
    //注释
    private String annotation;
    //时间
    private String createTime;


    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
