package pb.dada.com.passwordbox.ui.common;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;

/**
 * Created by Administrator on 2015/9/24.
 */
public abstract class BaseFragmentActivity extends FragmentActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    protected abstract void initListener();

    @Override
    public void onClick(View v) {

    }
}
