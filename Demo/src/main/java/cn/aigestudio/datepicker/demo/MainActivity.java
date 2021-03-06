package cn.aigestudio.datepicker.demo;

import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import cn.aigestudio.datepicker.bizs.calendars.DPCManager;
import cn.aigestudio.datepicker.bizs.decors.DPDecor;
import cn.aigestudio.datepicker.cons.ActionMode;
import cn.aigestudio.datepicker.cons.DPMode;
import cn.aigestudio.datepicker.views.DatePicker;

/**
 * Demo应用的主Activity
 * The main activity of demo
 *
 * @author AigeStudio 2015-03-26
 */
public class MainActivity extends Activity {
    List<String> tmp = new ArrayList<>();
    DatePicker picker1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

//        // 默认多选模式
//        DatePicker picker = (DatePicker) findViewById(R.id.main_dp);
//        picker.setDate(2015, 7);
//        picker.setOnDateSelectedListener(new DatePicker.OnDateSelectedListener() {
//            @Override
//            public void onDateSelected(List<String> date) {
//                String result = "";
//                Iterator iterator = date.iterator();
//                while (iterator.hasNext()) {
//                    result += iterator.next();
//                    if (iterator.hasNext()) {
//                        result += "\n";
//                    }
//                }
//                Toast.makeText(MainActivity.this, result, Toast.LENGTH_LONG).show();
//            }
//        });

        // 自定义背景绘制示例 Example of custom date's background
//        List<String> tmp = new ArrayList<>();
//        tmp.add("2015-7-1");
//        tmp.add("2015-7-8");
//        tmp.add("2015-7-16");
//        DPCManager.getInstance().setDecorBG(tmp);
//
//        DatePicker picker = (DatePicker) findViewById(R.id.main_dp);
//        picker.setDate(2015, 7);
//        picker.setDPDecor(new DPDecor() {
//            @Override
//            public void drawDecorBG(Canvas canvas, Rect rect, Paint paint) {
//                paint.setColor(Color.RED);
//                canvas.drawCircle(rect.centerX(), rect.centerY(), rect.width() / 2F, paint);
//            }
//        });
//        picker.setOnDateSelectedListener(new DatePicker.OnDateSelectedListener() {
//            @Override
//            public void onDateSelected(List<String> date) {
//                String result = "";
//                Iterator iterator = date.iterator();
//                while (iterator.hasNext()) {
//                    result += iterator.next();
//                    if (iterator.hasNext()) {
//                        result += "\n";
//                    }
//                }
//                Toast.makeText(MainActivity.this, result, Toast.LENGTH_LONG).show();
//            }
//        });

        // 自定义前景装饰物绘制示例 Example of custom date's foreground decor
        List<String> tmpTL = new ArrayList<>();
        tmpTL.add("2015-10-5");
        tmpTL.add("2015-10-6");
        tmpTL.add("2015-10-7");
        tmpTL.add("2015-10-8");
        tmpTL.add("2015-10-9");
        tmpTL.add("2015-10-10");
        tmpTL.add("2015-10-11");
        DPCManager.getInstance().setDecorTL(tmpTL);

        List<String> tmpTR = new ArrayList<>();
        tmpTR.add("2015-10-10");
        tmpTR.add("2015-10-11");
        tmpTR.add("2015-10-12");
        tmpTR.add("2015-10-13");
        tmpTR.add("2015-10-14");
        tmpTR.add("2015-10-15");
        tmpTR.add("2015-10-16");
        DPCManager.getInstance().setDecorTR(tmpTR);
        tmp.add("2016-5-8");
        tmp.add("2016-5-16");
        tmp.add("2016-5-16");
        DPCManager.getInstance().clearDecorBG();
        DPCManager.getInstance().setDecorBG(tmp);
        final DatePicker picker = (DatePicker) findViewById(R.id.main_dp);
        picker.setDate(2016, 5);
        picker.setFestivalDisplay(true);
        picker.setTodayDisplay(true);
        picker.setHolidayDisplay(true);
        picker.setDeferredDisplay(true);
        picker.setMode(DPMode.MULTIPLE);
        picker.setActionMode(ActionMode.ALL);
        picker.setDPDecor(new DPDecor() {
            @Override
            public void drawDecorTL(Canvas canvas, Rect rect, Paint paint, String data) {
                super.drawDecorTL(canvas, rect, paint, data);
                switch (data) {
                    case "2015-10-5":
                    case "2015-10-7":
                    case "2015-10-9":
                    case "2015-10-11":
                        paint.setColor(Color.GREEN);
                        canvas.drawRect(rect, paint);
                        break;
                    default:
                        paint.setColor(Color.RED);
                        canvas.drawCircle(rect.centerX(), rect.centerY(), rect.width() / 2, paint);
                        break;
                }
            }

            @Override
            public void drawDecorTR(Canvas canvas, Rect rect, Paint paint, String data) {
                super.drawDecorTR(canvas, rect, paint, data);
                switch (data) {
                    case "2015-10-10":
                    case "2015-10-11":
                    case "2015-10-12":
                        paint.setColor(Color.BLUE);
                        canvas.drawCircle(rect.centerX(), rect.centerY(), rect.width() / 2, paint);
                        break;
                    default:
                        paint.setColor(Color.YELLOW);
                        canvas.drawRect(rect, paint);
                        break;
                }
            }
        });
        picker.setOnDateSelectedListener(new DatePicker.OnDateSelectedListener() {
            @Override
            public void onDateSelected(List<String> date) {
                String result = "";
                Iterator iterator = date.iterator();
                while (iterator.hasNext()) {
                    result += iterator.next();
                    if (iterator.hasNext()) {
                        result += "\n";
                    }
                }
                Toast.makeText(MainActivity.this, result, Toast.LENGTH_LONG).show();
                tmp.addAll(date);
                DPCManager.getInstance().clearDecorBG();
                DPCManager.getInstance().setDecorBG(tmp);



            }
        });

        picker.setDPDecor(new DPDecor() {
            @Override
            public void drawDecorBG(Canvas canvas, Rect rect, Paint paint, String date) {
                switch (date) {
                    case "2015-5-1":
                        paint.setColor(Color.RED);
                        canvas.drawCircle(rect.centerX(), rect.centerY(), rect.width() / 2F, paint);
                        break;
                    case "2016-5-8":
                    case "2016-5-16":
                        paint.setColor(Color.YELLOW);
                        canvas.drawCircle(rect.centerX(), rect.centerY(), rect.width() / 2F, paint);
                        break;
                    case "2016-6-16":
                    case "2016-5-2":
                        paint.setColor(Color.GREEN);
                        canvas.drawCircle(rect.centerX(), rect.centerY(), rect.width() / 2F, paint);
                        break;
                }

            }
        });


        // 对话框下的DatePicker示例 Example in dialog
        Button btnPick = (Button) findViewById(R.id.main_btn);
        btnPick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                picker.onDateSelected();
                picker.clearDateSelected();
//                final AlertDialog dialog = new AlertDialog.Builder(MainActivity.this).create();
//                dialog.show();
//                picker1 = new DatePicker(MainActivity.this);
//                picker1.setDate(2015, 7);
//                picker1.setMode(DPMode.MULTIPLE);
////                picker.setOnDateSelectedListener(new DatePicker.OnDateSelectedListener() {
////                    @Override
////                    public void onDatePicked(String date) {
////                        Toast.makeText(MainActivity.this, date, Toast.LENGTH_LONG).show();
////                        dialog.dismiss();
////                    }
////                });
//                picker1.setOnDateSelectedListener(new DatePicker.OnDateSelectedListener() {
//                    @Override
//                    public void onDateSelected(List<String> date) {
//                        String result = "";
//                        Iterator iterator = date.iterator();
//                        while (iterator.hasNext()) {
//                            result += iterator.next();
//                            if (iterator.hasNext()) {
//                                result += "\n";
//                            }
//
//                        }
//                        Message message = mHandler.obtainMessage();
//                        message.what = 0x11;
//                        message.obj = date;
//                        mHandler.sendMessage(message);
//                        Toast.makeText(MainActivity.this, result, Toast.LENGTH_LONG).show();
//                    }
//                });
//                ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(
//                        ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//                dialog.getWindow().setContentView(picker1, params);
//                dialog.getWindow().setGravity(Gravity.CENTER);
//
//                picker1.setOnMonthChangeListener(new DatePicker.OnMonthChangeListener() {
//                    @Override
//                    public void onMonthChange(String month) {
//                        Toast.makeText(MainActivity.this, month, Toast.LENGTH_SHORT).show();
//                    }
//                });
//
//
//                tmp.add("2015-7-1");
//                tmp.add("2015-7-8");
//                tmp.add("2015-7-16");
//                DPCManager.getInstance().clearDecorBG();
//                DPCManager.getInstance().setDecorBG(tmp);
//                picker1.setDPDecor(new DPDecor() {
//                    @Override
//                    public void drawDecorBG(Canvas canvas, Rect rect, Paint paint, String date) {
//                        switch (date) {
//                            case "2015-7-1":
//                                paint.setColor(Color.RED);
//                                canvas.drawCircle(rect.centerX(), rect.centerY(), rect.width() / 2F, paint);
//                                break;
//                            case "2015-7-8":
//                                paint.setColor(Color.YELLOW);
//                                canvas.drawCircle(rect.centerX(), rect.centerY(), rect.width() / 2F, paint);
//                                break;
//                            case "2015-7-16":
//                            case "2015-7-2":
//                                paint.setColor(Color.GREEN);
//                                canvas.drawCircle(rect.centerX(), rect.centerY(), rect.width() / 2F, paint);
//                                break;
//                        }
//
//                    }
//                });
            }
        });
    }

}
