# MyTimeDialog
自定义的Timepicker，有可以设置起始时间和结束时间
###效果1,系统默认时间
![](https://github.com/yy1300326388/MyTimeDialog/blob/master/imagedemo/QQ20150511-3%402x.png)
```java
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
```
###效果2，自定义时间
![](https://github.com/yy1300326388/MyTimeDialog/blob/master/imagedemo/QQ20150511-4%402x.png)
```java
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
```
