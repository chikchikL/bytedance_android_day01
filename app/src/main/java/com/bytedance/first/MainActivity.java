package com.bytedance.first;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = "MainActivity";



    private TextView tv;
    private ImageView iv;
    private Button btn;
    private EditText et;
    private int imgId;
    private Switch swi;
    private HashMap<String, Integer> teams;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initView();

        initData();

    }

    /**
     * 初始化所需图片数据
     */
    private void initData() {
        teams = new HashMap<>();
        teams.put("celtics", R.drawable.celtics);
        teams.put("rockets", R.drawable.rockets);
        teams.put("warriors",R.drawable.warriors);
        teams.put("thunder",R.drawable.thunder);
    }

    /**
     * 初始化控件
     */
    private void initView() {
        tv = findViewById(R.id.tv);
        iv = findViewById(R.id.iv);
        btn = findViewById(R.id.btn);
        et = findViewById(R.id.et);
        swi = findViewById(R.id.swi);


        imgId = R.drawable.rockets;
        iv.setImageResource(imgId);

        btn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){


            case R.id.btn:
                obtainImg();
                break;

            default:
                break;
        }
    }


    /**
     * 在输入框输入球队英文名，根据输入框内容展示指定球队图片
     */
    private void obtainImg() {
        //如果关闭了取图功能，不可获取图片
        if(!swi.isChecked()){
            Toast.makeText(this, "请打开功能再试！", Toast.LENGTH_SHORT).show();
            return;
        }


        String input = et.getText().toString().trim();
        Integer resId = teams.get(input);
        String content = (resId == null?"输入有误！请重新输入！":"获取球队:\t"+input);
        et.setText("");
        Log.i(TAG,content);
        Toast.makeText(this,content,Toast.LENGTH_SHORT).show();
        tv.setText(content);

        if(resId!=null)
            iv.setImageResource(resId);
    }




}
