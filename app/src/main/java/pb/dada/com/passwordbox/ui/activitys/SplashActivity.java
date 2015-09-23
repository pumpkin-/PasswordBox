package pb.dada.com.passwordbox.ui.activitys;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import pb.dada.com.passwordbox.R;


/**
 * Created by Administrator on 2015/9/22.
 */
public class SplashActivity extends Activity {


    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
            startActivity(intent);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        handler.sendEmptyMessageDelayed(0, 3000);
//        Intent intent = new Intent(this, MainActivity.class);
//        startActivity(intent);

    }

    //进入Splash页面  检查版本更新
}
