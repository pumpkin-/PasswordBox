package pb.dada.com.passwordbox.ui.activitys;

import android.os.Bundle;
import android.view.View;

import com.lidroid.xutils.ViewUtils;

import pb.dada.com.passwordbox.R;
import pb.dada.com.passwordbox.ui.common.BaseFragmentActivity;
import pb.dada.com.passwordbox.ui.fragments.PasswordBoxFragment;

public class MainActivity extends BaseFragmentActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewUtils.inject(this);
        initListener();

        PasswordBoxFragment passwordBoxFragment = new PasswordBoxFragment(this);
        getSupportFragmentManager().beginTransaction().
                replace(R.id.frg_password_box_container, passwordBoxFragment)
                .addToBackStack(PasswordBoxFragment.class.getSimpleName()).commit();

    }

    @Override
    protected void initListener() {

    }

    @Override
    public void onClick(View v) {
    }


    //Loading页面  Fragments


}
