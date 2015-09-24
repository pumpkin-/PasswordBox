package pb.dada.com.passwordbox.app;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Administrator on 2015/9/22.
 */
public class AppData {

    private static String IS_FIRST_LOGIN = "isFirstLogin";
    private static String USER_INFO = "UserInfo";
    private static String PASSWORD = "password";

    //全局变量存放
    public static boolean isFirstLogin(Context context) {
        SharedPreferences UserInfo = context.getSharedPreferences(USER_INFO, Context.MODE_PRIVATE);
        return UserInfo.getBoolean(IS_FIRST_LOGIN, true);
    }

    public static String getPassword(Context context) {
        SharedPreferences UserInfo = context.getSharedPreferences(USER_INFO, Context.MODE_PRIVATE);
        return UserInfo.getString(PASSWORD, null);
    }

    /**
     * true第一次登录  false第二次以后登录
     *
     * @param context
     * @param isFirstLogin
     */
    public static void setFirstLogin(Context context, boolean isFirstLogin) {
        SharedPreferences UserInfo = context.getSharedPreferences(USER_INFO, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = UserInfo.edit();
        editor.putBoolean(IS_FIRST_LOGIN, isFirstLogin);
        editor.commit();
    }

    /**
     * 设置密码
     *
     * @param context
     * @param password
     */
    public static void setPassword(Context context, String password) {
        SharedPreferences UserInfo = context.getSharedPreferences(USER_INFO, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = UserInfo.edit();
        editor.putString(PASSWORD, password);
        editor.commit();
    }

}
