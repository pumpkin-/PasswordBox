package pb.dada.com.passwordbox.ui.common;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Administrator on 2015/9/24.
 */
public abstract class BaseActivity extends Activity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    protected abstract void initListener();
}
