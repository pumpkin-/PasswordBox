package pb.dada.com.passwordbox.db;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import pb.dada.com.passwordbox.bean.SecurityBox;

/**
 * Created by Administrator on 2015/9/22.
 */
public class DBManager {

    private static SQLiteDatabase db = null;

    /**
     * 插入一条密码信息
     *
     * @param securityBox
     */
    public synchronized static void insertSBData(Context context, SecurityBox securityBox) {
        if (db == null || !db.isOpen()) {
            db = DBHelper.newInstance(context).getWritableDatabase();
        }
        db.beginTransaction();
        try {
            db.execSQL("INSERT INTO " + DBHelper.TABLE_SECURITY_BOX + " VALUES(?, ?)", new Object[]{securityBox.getAcountName(), securityBox});
            db.setTransactionSuccessful();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.endTransaction();
        }
    }

    /**
     * 更新一条密码信息
     *
     * @param securityBox
     */
    public static void updateSBData(Context context, SecurityBox securityBox) {
        if (db == null || !db.isOpen()) {
            db = DBHelper.newInstance(context).getWritableDatabase();
        }
        db.beginTransaction();
        try {
            db.execSQL("UPDATE " + DBHelper.TABLE_SECURITY_BOX + " set "
                            + DBHelper.COLUMN_SECURITY_BOX_OBJECT + " =? WHERE "
                            + DBHelper.COLUMN_SECURITY_BOX_NAME + " =? ",
                    new Object[]{securityBox, securityBox.getAcountName()});
            db.setTransactionSuccessful();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.endTransaction();
        }
    }

    /**
     * 删除一条密码信息
     *
     * @param securityBox
     */
    public static void deleteSBData(Context context, SecurityBox securityBox) {
        if (db == null || !db.isOpen()) {
            db = DBHelper.newInstance(context).getWritableDatabase();
        }
        db.beginTransaction();
        try {
            db.execSQL("DELETE FROM " + DBHelper.TABLE_SECURITY_BOX + " WHERE " + DBHelper.COLUMN_SECURITY_BOX_NAME + " = ? ",
                    new Object[]{securityBox.getAcountName()});
            db.setTransactionSuccessful();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.endTransaction();
        }
    }

    /**
     * 查询所有密码信息
     *
     * @return
     */
    public static Cursor queryAll(Context context) {
        Cursor cursor = null;
        if (db == null || !db.isOpen()) {
            db = DBHelper.newInstance(context).getWritableDatabase();
        }
        db.beginTransaction();
        try {
            cursor = db.rawQuery("SELECT * FROM " + DBHelper.TABLE_SECURITY_BOX, new String[]{});
            db.setTransactionSuccessful();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.endTransaction();
        }
        return cursor;
    }


    public static void closeDB() {
        if (db.isOpen()) {
            db.close();
        }
    }
}
