package pb.dada.com.passwordbox.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2015/9/22.
 */
public class DBHelper extends SQLiteOpenHelper {

    //
    private static int DATABASE_VERSION = 1; //2015.9.22
    private Context context;


    //密码箱数据库
    private static String DATABASE_NAME = "security_box.db";
    //密码箱数据库表
    public static String TABLE_SECURITY_BOX = "security_box";
    //密码箱数据库-账户名
    public static String COLUMN_SECURITY_BOX_NAME = "acount_name";

    public static String COLUMN_SECURITY_BOX_OBJECT = "security_box_object";

    private static DBHelper helper = null;

    //获取DBHelper的实例
    public static DBHelper newInstance(Context context) {
        if (helper == null) {
            helper = new DBHelper(context);
        }
        return helper;
    }


    //单例
    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        synchronized (helper) {
            try {
                // 用户保险箱信息表
                db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_SECURITY_BOX
                        + "( "
                        + COLUMN_SECURITY_BOX_NAME + " CHAR ,"
                        + COLUMN_SECURITY_BOX_OBJECT + " BLOB)");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        synchronized (helper) {
            try {
                // 用户保险箱信息表
                db.execSQL("DROP TABLE IF EXISTS " + TABLE_SECURITY_BOX);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


}
