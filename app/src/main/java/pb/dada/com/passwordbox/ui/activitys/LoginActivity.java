package pb.dada.com.passwordbox.ui.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.lidroid.xutils.view.annotation.ViewInject;

import pb.dada.com.passwordbox.R;
import pb.dada.com.passwordbox.app.AppData;
import pb.dada.com.passwordbox.ui.common.BaseActivity;
import pb.dada.com.passwordbox.utils.Utils;

/**
 * Created by Administrator on 2015/9/22.
 */
public class LoginActivity extends BaseActivity {

    //第一次登录输入密码
    @ViewInject(R.id.ll_user_acount_first_enter)
    private LinearLayout ll_user_acount_first_enter;
    @ViewInject(R.id.et_origin_password)
    private EditText et_origin_password;
    @ViewInject(R.id.et_confirm_password)
    private EditText et_confirm_password;

    //第二次以后登录输入密码
    @ViewInject(R.id.et_after_password)
    private EditText et_after_password;

    //登录
    @ViewInject(R.id.enter_security_box)
    private TextView enter_security_box;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //初始化
        setContentView(R.layout.activity_login);
        com.lidroid.xutils.ViewUtils.inject(this);
        initListener();


        //第一次登陆,输入初始密码
        if (AppData.isFirstLogin(this)) {
            //调整布局
            ll_user_acount_first_enter.setVisibility(View.VISIBLE);
            et_after_password.setVisibility(View.GONE);


        } else {
            //非第一次登陆 调整布局
            ll_user_acount_first_enter.setVisibility(View.GONE);
            et_after_password.setVisibility(View.VISIBLE);


        }
       /* this.title = title;
        this.acountName = acountName;
        this.password = password;
        this.annotation = annotation;
        this.createTime = createTime;*/

//        SecurityBox securityBox = new SecurityBox("QQ", "897692892", "123456789", "", "");
//        SecurityBox securityBox1 = new SecurityBox("QQ", "303628303", "123456789", "", "");
//        PasswordBoxDBManager.insertSBData(this, securityBox);
//        PasswordBoxDBManager.updateSBData(this, securityBox1);
        // PasswordBoxDBManager.deleteSBData(this, securityBox);

        //设置登陆点击事件

    }

    /**
     * 初始化事件监听器
     */
    protected void initListener() {
        enter_security_box.setClickable(false);
        enter_security_box.setOnClickListener(this);
        editTextsChanged(et_origin_password, et_confirm_password);
        editTextChanged();
    }

    //点击第一次登登录
    private void firstLogin() {
        String origin_password = et_origin_password.getText().toString();
        String confirm_password = et_confirm_password.getText().toString();
        if (origin_password.equals(confirm_password)) {
            //密码一致,保存密码(加密),并跳转  TODO
            AppData.setFirstLogin(this, false);
            AppData.setPassword(this, Utils.encodeBase64(origin_password));

            //跳转
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            this.finish();
        } else {
            Toast.makeText(this, "两次密码输入不一致", Toast.LENGTH_SHORT).show();
        }
    }

    //常态登录
    private void normalLogin() {
        String password = et_after_password.getText().toString();
        if ((Utils.encodeBase64(password)).equals(AppData.getPassword(this))) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            this.finish();
        } else {
            Toast.makeText(this, "密码错误", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClick(View v) {
        //登录
        if (v == enter_security_box) {
            if (AppData.isFirstLogin(LoginActivity.this)) {
                firstLogin();
            } else {
                normalLogin();
            }
        }
    }

    boolean leftHasText = false;
    boolean rightHasText = false;

    private void editTextsChanged(EditText etLeft, EditText etRight) {

        etLeft.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (TextUtils.isEmpty(s.toString())) {
                    leftHasText = false;
                    enter_security_box.setClickable(false);
                    enter_security_box.setBackgroundResource(R.drawable.sign_in_normal);
                    enter_security_box.setPadding(0, 0, 0, 0);
                } else {
                    leftHasText = true;
                    if (rightHasText == true) {
                        enter_security_box.setClickable(true);
                        enter_security_box.setBackgroundResource(R.drawable.sign_in);
                        enter_security_box.setPadding(0,0,0,0);
                    } else {
                        enter_security_box.setClickable(false);
                        enter_security_box.setBackgroundResource(R.drawable.sign_in_normal);
                        enter_security_box.setPadding(0,0,0,0);
                    }
                }
            }
        });

        etRight.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (TextUtils.isEmpty(s.toString())) {
                    rightHasText = false;
                    enter_security_box.setClickable(false);
                    enter_security_box.setBackgroundResource(R.drawable.sign_in_normal);
                    enter_security_box.setPadding(0,0,0,0);
                } else {
                    rightHasText = true;
                    if (leftHasText == true) {
                        enter_security_box.setClickable(true);
                        enter_security_box.setBackgroundResource(R.drawable.sign_in);
                        enter_security_box.setPadding(0,0,0,0);
                    } else {
                        enter_security_box.setClickable(false);
                        enter_security_box.setBackgroundResource(R.drawable.sign_in_normal);
                        enter_security_box.setPadding(0,0,0,0);
                    }
                }
            }
        });
    }

    private void editTextChanged() {
        et_after_password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (TextUtils.isEmpty(s.toString())) {
                    enter_security_box.setClickable(false);
                    enter_security_box.setBackgroundResource(R.drawable.sign_in_normal);
                    enter_security_box.setPadding(0,0,0,0);
                } else {
                    enter_security_box.setClickable(true);
                    enter_security_box.setBackgroundResource(R.drawable.sign_in);
                    enter_security_box.setPadding(0,0,0,0);
                }
            }
        });
    }

}
