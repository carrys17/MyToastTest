package com.example.ljw.toasttest;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by ljw on 17/9/29.
 */


/*
* 自定义Toast，可以显示带文字或者图标，加上点动画，本来toast是排队显示的，这个不会，直接就可以显示出来了
* 完善的地方，现在这个背景红色的，太丑，图标也可以换换，还有就是可以尝试使用构造者模式来写它的显示方法，
* 最后就是不显示图标时如何去掉图标所占的空位
* */
public class MyToast extends Toast {

    private static MyToast myToast;

    public MyToast(Context context) {
        super(context);
    }

    public static void toastCancel(){
        if (myToast!=null){
            myToast.cancel();
        }
    }

    public void cancel(){
        try {
            super.cancel();
        }catch (Exception e){

        }
    }

    @Override
    public void show() {
        try {
            super.show();
        }catch (Exception e){

        }
    }

    static ImageView toast_iamge;
    static TextView toast_text;

    private static void initToast(Context context, CharSequence text){
        try {
            toastCancel();
            myToast = new MyToast(context);

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view = inflater.inflate(R.layout.toast_layout,null);
            toast_iamge = view.findViewById(R.id.toast_image);
            toast_text= view.findViewById(R.id.toast_text);

            toast_text.setText(text);
            myToast.setView(view);
            myToast.setGravity(Gravity.CENTER,0,70);


        }catch (Exception e){
            e.printStackTrace();
        }
    }


    private static final int TYPE_TEXT = 0;
    private static final int TYPE_PERSON = 1;
    private static final int TYPE_ERROR = 2;

    private static void showToast(Context context,CharSequence text,int time,int imgType){
        initToast(context,text);
        if (time == Toast.LENGTH_SHORT){
            myToast.setDuration(Toast.LENGTH_SHORT);
        }else {
            myToast.setDuration(Toast.LENGTH_LONG);
        }

        if (imgType == TYPE_TEXT){
            toast_iamge.setVisibility(View.INVISIBLE);
        }else {
            if (imgType == TYPE_ERROR){
                toast_iamge.setBackgroundResource(R.drawable.error);
            }else if (imgType == TYPE_PERSON){
                toast_iamge.setBackgroundResource(R.drawable.toast_y);
            }
            toast_iamge.setVisibility(View.VISIBLE);
            ObjectAnimator.ofFloat(toast_iamge,"rotationY",0,360).setDuration(1700).start();
        }
        myToast.show();
    }

    public static void showToast(Context context,CharSequence text){
        showToast(context,text,Toast.LENGTH_SHORT,TYPE_TEXT);
    }

    public static void showToast(Context context,CharSequence text,boolean isSuccessed){
        showToast(context,text,Toast.LENGTH_SHORT,isSuccessed ? TYPE_PERSON :TYPE_ERROR);
    }

    public static void showToast(Context context,CharSequence text,int time){
        showToast(context,text,time,TYPE_TEXT);
    }

    public static void showToast(Context context,CharSequence text,int time,boolean isSuccessed){
        showToast(context, text, time, isSuccessed ? TYPE_PERSON : TYPE_ERROR);
    }

}
