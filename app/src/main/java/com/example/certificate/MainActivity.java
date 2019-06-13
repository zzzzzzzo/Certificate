package com.example.certificate;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends FragmentActivity {

    private Fragment mFragments[]; //管理Fragment数组
    private RadioGroup radioGroup;
    private FragmentManager fragmentManager; //管理切换
    private FragmentTransaction fragmentTransaction; //事务管理（开始、结束）
    private RadioButton rbtExer,rbtCour,rbtMess,rbtMy; //四个按钮项

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFragments = new Fragment[4];
        fragmentManager = getSupportFragmentManager();
        mFragments[0] = fragmentManager.findFragmentById(R.id.fragment_exercises);
        mFragments[1] = fragmentManager.findFragmentById(R.id.fragment_course);
        mFragments[2] = fragmentManager.findFragmentById(R.id.fragment_message);
        mFragments[3] = fragmentManager.findFragmentById(R.id.fragment_my);
        fragmentTransaction = fragmentManager.beginTransaction().hide(mFragments[0]).hide(mFragments[1]).hide(mFragments[2]).hide(mFragments[3]); //要么一起执行，要么都不执行  hide表示隐藏
        fragmentTransaction.show(mFragments[0]).commit(); //显示第一个页面

        rbtExer = (RadioButton)findViewById(R.id.radioExer);
        rbtCour = (RadioButton)findViewById(R.id.radioCour);
        rbtMess = (RadioButton)findViewById(R.id.radioMess);
        rbtMy = (RadioButton)findViewById(R.id.radioMy);
        rbtExer.setBackgroundResource(R.drawable.shape3);
        radioGroup = (RadioGroup)findViewById(R.id.bottomGroup); //页面切换
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { //监听
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Log.i("radioGroup","checkId=" + checkedId);
                fragmentTransaction = fragmentManager.beginTransaction().hide(mFragments[0]).hide(mFragments[1]).hide(mFragments[2]);

                rbtExer.setBackgroundResource(R.drawable.shape2);
                rbtCour.setBackgroundResource(R.drawable.shape2);
                rbtMess.setBackgroundResource(R.drawable.shape2);
                rbtMy.setBackgroundResource(R.drawable.shape2);

                switch (checkedId){
                    case R.id.radioExer:
                        fragmentTransaction.show(mFragments[0]).commit();
                        rbtExer.setBackgroundResource(R.drawable.shape3);
                        break;
                    case R.id.radioCour:
                        fragmentTransaction.show(mFragments[1]).commit();
                        rbtCour.setBackgroundResource(R.drawable.shape3);
                        break;
                    case R.id.radioMess:
                        fragmentTransaction.show(mFragments[2]).commit();
                        rbtMess.setBackgroundResource(R.drawable.shape3);
                        break;
                    case R.id.radioMy:
                        fragmentTransaction.show(mFragments[2]).commit();
                        rbtMy.setBackgroundResource(R.drawable.shape3);
                        break;
                    default:
                        break;
                }
            }
        });

    }
}
