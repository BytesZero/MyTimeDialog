package com.zsl.mytimedialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;

/**
 * Created by zsl on 15/5/11.
 */
public class MyTimeDialog extends Dialog implements TimePicker.OnTimeChangedListener, View.OnClickListener {
    TimePicker tp_start, tp_end;
    Button bt_ok, bt_cancel;

    TimeSetListener timeSetListener;
    Context context;

    int startHour, startMin, endHour, endMin;
    boolean isSetTime;
    String title;


    /**
     * 只有一个接口的MyTimeDialog，这里的默认时间是当前时间
     *
     * @param context
     * @param title           标题
     * @param timeSetListener
     */
    public MyTimeDialog(Context context, String title, TimeSetListener timeSetListener) {
        super(context);
        this.context = context;
        this.title = title;
        this.timeSetListener = timeSetListener;
    }

    /**
     * 可以设置时间的MyTimeDialog
     *
     * @param context
     * @param timeSetListener
     * @param startHour       开始的小时
     * @param startMin        开始的分钟
     * @param endHour         结束的小时
     * @param endMin          结束的分钟
     */

    public MyTimeDialog(Context context, String title, int startHour, int startMin, int endHour, int endMin, TimeSetListener timeSetListener) {
        super(context);
        this.context = context;
        this.title = title;
        this.timeSetListener = timeSetListener;
        this.startHour = startHour;
        this.startMin = startMin;
        this.endHour = endHour;
        this.endMin = endMin;
        isSetTime = true;
    }


    /**
     * 创建视图
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mytimgdialog);
        initView();


    }

    /**
     * 初始化View
     */
    private void initView() {
        setTitle(title);
        //设置TimePicker
        tp_start = (TimePicker) findViewById(R.id.mytimedialog_tp_start_time);
        tp_end = (TimePicker) findViewById(R.id.mytimedialog_tp_end_time);
        if (isSetTime) {
            setTimePicker(tp_start, startHour, startMin);
            setTimePicker(tp_end, endHour, endMin);
        } else {
            setTimePicker(tp_start);
            setTimePicker(tp_end);
        }

        //设置按钮
        bt_ok = (Button) findViewById(R.id.mytimedialog_bt_ok);
        bt_cancel = (Button) findViewById(R.id.mytimedialog_bt_cancel);
        bt_ok.setOnClickListener(this);
        bt_cancel.setOnClickListener(this);

        startHour = tp_start.getCurrentHour();
        startMin = tp_start.getCurrentMinute();

        endHour = tp_end.getCurrentHour();
        endMin = tp_end.getCurrentMinute();

    }

    /**
     * 设置TimePicker
     *
     * @param timePicker
     */

    private void setTimePicker(TimePicker timePicker) {
        timePicker.setIs24HourView(true);
        timePicker.setOnTimeChangedListener(this);
    }

    /**
     * 设置TimePicker带有时间
     *
     * @param timePicker
     * @param Hour       默认小时
     * @param Min        默认分钟
     */

    private void setTimePicker(TimePicker timePicker, int Hour, int Min) {
        timePicker.setIs24HourView(true);
        timePicker.setOnTimeChangedListener(this);
        timePicker.setCurrentHour(Hour);
        timePicker.setCurrentMinute(Min);
    }

    /**
     * 时间发生改变的时设置时间
     *
     * @param view
     * @param hourOfDay
     * @param minute
     */

    @Override
    public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
        if (view == tp_start) {
            startHour = hourOfDay;
            startMin = minute;
        } else {
            endHour = hourOfDay;
            endMin = minute;
        }
    }

    /**
     * 按钮的点击事件
     *
     * @param v
     */
    @Override
    public void onClick(View v) {
        if (v == bt_ok) {
            dismiss();
            timeSetListener.onSetTime(startHour, startMin, endHour, endMin);
        } else {
            dismiss();
            timeSetListener.onCancel();
        }
    }

    static interface TimeSetListener {
        void onSetTime(int startHour, int startMin, int endHour, int endMin);

        void onCancel();
    }


}
