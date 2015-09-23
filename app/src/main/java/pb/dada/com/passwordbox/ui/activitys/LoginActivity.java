package pb.dada.com.passwordbox.ui.activitys;

import android.app.Activity;
import android.os.Bundle;

import pb.dada.com.passwordbox.R;
import pb.dada.com.passwordbox.bean.SecurityBox;
import pb.dada.com.passwordbox.db.DBManager;

/**
 * Created by Administrator on 2015/9/22.
 */
public class LoginActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

       /* this.title = title;
        this.acountName = acountName;
        this.password = password;
        this.annotation = annotation;
        this.createTime = createTime;*/

        SecurityBox securityBox = new SecurityBox("QQ", "897692892", "123456789" ,"", "");
        SecurityBox securityBox1 = new SecurityBox("QQ", "303628303", "123456789" ,"", "");

        DBManager.insertSBData(this, securityBox);
        DBManager.updateSBData(this, securityBox1);
        DBManager.deleteSBData(this, securityBox);

    }
}
