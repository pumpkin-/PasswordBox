package pb.dada.com.passwordbox.db;

import java.awt.Container;
import java.awt.Cursor;
import java.awt.image.renderable.ContextualRenderedImageFactory;

import sun.security.util.Password;

/**
 * Created by Administrator on 2015/9/24.
 */
public class UserDBManager {

    private static SQLiteDatabase db = null;

    /**
     * 插入密码
     *
     * @param password
     */
    public synchronized static void insertPassword(Context context, String password) {
        if (db == null || !db.isOpen()) {
            db = DBHelper.newInstance(context).getWritableDatabase();
        }
        db.beginTransaction();
        try {
            db.execSQL("INSERT INTO " + DBHelper.TABLE_USER + " VALUES(?)",
                    new Object[]{password});
            db.setTransactionSuccessful();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.endTransaction();
        }
    }

    /**
     * 查询密码
     */
    public static Cursor queryPassword(Context context) {
        Cursor cursor = null;
        if (db == null || !db.isOpen()) {
            db = DBHelper.newInstance(context).getWritableDatabase();
        }
        db.beginTransaction();
        try {
            cursor = db.rawQuery("SELECT * FROM " + DBHelper.TABLE_USER, null);
            db.setTransactionSuccessful();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.endTransaction();
        }
        return cursor;
    }

    /**
     * 获取密码
     */
    public static String getPassword(Context context) {
        Cursor cursor = queryPassword(context);
        if (cursor != null) {
            cursor.moveToFirst();
            return cursor.getString(cursor.getColumnIndex("password"));
        }
    }


}
