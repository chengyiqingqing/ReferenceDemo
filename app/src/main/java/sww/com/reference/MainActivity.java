package sww.com.reference;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.lang.ref.Reference;
import java.util.ArrayList;
import java.util.List;

import sww.com.reference.R;

public class MainActivity extends Activity implements View.OnClickListener {
    //存弱引用的ArrayList;
    private List<Bitmap> listStrong=new ArrayList<>();
    private List<Reference> listSoft = new ArrayList<>();
    private List<Reference> listWeak = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn).setOnClickListener(this);
        findViewById(R.id.check).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn:
                //直接存这个drawable对象；
                listStrong.add(RefrenceUtil.decodeStrong(getResources(), R.drawable.bg));
                listSoft.add(RefrenceUtil.decodeSoft(getResources(), R.drawable.bg));
                listWeak.add(RefrenceUtil.decodeWeak(getResources(), R.drawable.bg));
                break;
            case R.id.check:
                System.gc();
                for( Bitmap bitmap : listStrong){
                    //从里面去引用，为空着打印空，不为空则打印ok。
                    if( null == bitmap){
                        Log.e("sww","listStrong:null");
                    }else{
                        Log.e("sww","listStrong:OK");
                    }
                }
                listStrong.clear();
                for( Reference ref : listSoft){
                    //从里面去引用，为空着打印空，不为空则打印ok。
                    if( null == ref.get()){
                        Log.e("sww","listSoft:null");
                    }else{
                        Log.e("sww","listSoft:OK");
                    }
                }
                listSoft.clear();
                for( Reference ref : listWeak){
                    //从里面去引用，为空着打印空，不为空则打印ok。
                    if( null == ref.get()){
                        Log.e("sww","listWeak:null");
                    }else{
                        Log.e("sww","listWeak:OK");
                    }
                }
                listWeak.clear();
                break;
        }
    }
}
