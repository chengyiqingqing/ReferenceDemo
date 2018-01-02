package sww.com.reference;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * Created by Sky on 2016/9/17.
 */
public class RefrenceUtil {

    public static Bitmap decodeStrong(Resources res, int id) {
        Bitmap bmp = BitmapFactory.decodeResource(res, id);
        return bmp;
    }

    //建立软引用，并返回这个软引用。
    public static Reference<Bitmap> decodeSoft(Resources res, int id) {
        Bitmap bmp = BitmapFactory.decodeResource(res, id);
        Reference<Bitmap> reference = new SoftReference<Bitmap>(bmp);
        return reference;
    }

    public static Reference<Bitmap> decodeWeak(Resources res, int id) {
        Bitmap bmp = BitmapFactory.decodeResource(res, id);
        Reference<Bitmap> reference = new WeakReference<Bitmap>(bmp);
        return reference;
    }

}
