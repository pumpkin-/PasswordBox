package pb.dada.com.passwordbox.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2015/9/22.
 */
public class DBHelper extends SQLiteOpenHelper{

    private Context context;

    private static String DATABASE_NAME = "security_box.db";
    private static String TABLE_SECURITY_BOX = "security_box";
    private static int DATABASE_VERSION =  1; //2015.9.22


    private DBHelper helper = null;

    //获取DBHelper的实例
    public DBHelper newInstance(Context context) {
        if(helper == null) {
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
                db.execSQL("CREATE TABLE IF NOT EXISTS "+ TABLE_SECURITY_BOX
                        + "(key_id INTEGER PRIMARY KEY , security_box_object BLOB)");
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        synchronized (helper) {
            try {
                // 用户保险箱信息表
                db.execSQL("DROP TABLE IF EXISTS "+ TABLE_SECURITY_BOX);
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }


}
