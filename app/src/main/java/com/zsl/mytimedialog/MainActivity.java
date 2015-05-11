package com.zsl.mytimedialog;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {
    Button bt_test,bt_test1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initEvent();
    }

    private void initEvent() {
        bt_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new MyTimeDialog(MainActivity.this,"设置时间", new MyTimeDialog.TimeSetListener() {
                    @Override
                    public void onSetTime(int startHour, int startMin, int endHour, int endMin) {
                        String content=startHour+":"+startMin+"   "+endHour+":"+endMin;
                        showToast(content);
                    }

                    @Override
                    public void onCancel() {

                    }
                }).show();
            }
        });

        bt_test1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new MyTimeDialog(MainActivity.this, "自定义时间",3,24,5,45, new MyTimeDialog.TimeSetListener() {
                    @Override
                    public void onSetTime(int startHour, int startMin, int endHour, int endMin) {
                        String content=startHour+":"+startMin+"   "+endHour+":"+endMin;
                        showToast(content);
                    }

                    @Override
                    public void onCancel() {

                    }
                }).show();
            }
        });
    }

    private void showToast(String content) {
        Toast.makeText(getApplicationContext(), content, Toast.LENGTH_SHORT).show();
    }

    private void initView() {
        bt_test= (Button) findViewById(R.id.main_bt_test);
        bt_test1= (Button) findViewById(R.id.main_bt_test1);

    }


}
