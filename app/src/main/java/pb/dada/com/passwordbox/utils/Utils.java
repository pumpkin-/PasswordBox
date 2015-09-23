package pb.dada.com.passwordbox.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by Administrator on 2015/9/22.
 */
public class Utils {

    /**
     * 获取当前版本名字
     * @param context
     * @return
     */
    public static String getVersionName(Context context) {
        PackageInfo packageInfo = null;
                PackageManager packageManager = context.getPackageManager();
        try {
            packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return  packageInfo.versionName;
    }

    /**
     * 将object转化为二进制流
     * @param obj
     * @return
     * @throws Exception
     */
    public static byte[] object2Bytes(Object obj) throws Exception{
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos =  new ObjectOutputStream(baos);

        oos.writeObject(obj);
        oos.flush();

        byte[] bytes = baos.toByteArray();

        oos.close();
        baos.close();

        return bytes;
    }

    /**
     * 将二进制流转换为Object<T>
     * @param bytes
     * @param <T>
     * @return
     * @throws Exception
     */
    public static <T>T Bytes2Object(byte[] bytes) throws Exception {
        ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
        ObjectInputStream ois = new ObjectInputStream(bais);

        T t = (T)ois.readObject();

        bais.close();
        ois.close();

       return t;
    }

}
