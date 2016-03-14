package com.eric.demo.iosalertdialog;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.eric.alertdialoglibrary.AlertDialog;
import com.eric.alertdialoglibrary.OnItemClickListener;


public class MainActivity extends Activity implements OnItemClickListener {

    private AlertDialog mAlertView;//避免创建重复View，先创建View，然后需要的时候show出来，推荐这个做法
    private AlertDialog mAlertViewExt;//窗口拓展例子
    private EditText etName;//拓展View内容
    private InputMethodManager imm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        mAlertView = new AlertDialog(this, "标题", "内容", "取消", new String[]{"确定"}, null, AlertDialog.Style.Alert, this);
        //拓展窗口
        mAlertViewExt = new AlertDialog(this, "提示", "请完善你的个人资料！", "取消", null, new String[]{"完成"}, AlertDialog.Style.Alert, this);
        ViewGroup extView = (ViewGroup) LayoutInflater.from(this).inflate(R.layout.alertext_form, null);
        etName = (EditText) extView.findViewById(R.id.etName);
        mAlertViewExt.addExtView(extView);

    }

    public void alertShow1(View view) {
        mAlertView.show();
    }

    public void alertShow2(View view) {
        new AlertDialog(this, "标题", "内容", null, new String[]{"确定"}, null, AlertDialog.Style.Alert, this).show();
    }

    public void alertShow3(View view) {
        new AlertDialog(this, null, null, null, new String[]{"高亮按钮1", "高亮按钮2", "高亮按钮3"},
                new String[]{"其他按钮1", "其他按钮2", "其他按钮3", "其他按钮4", "其他按钮5", "其他按钮6",
                        "其他按钮7", "其他按钮8", "其他按钮9", "其他按钮10", "其他按钮11", "其他按钮12"},
                AlertDialog.Style.Alert, this).show();
    }

    public void alertShow4(View view) {
        new AlertDialog(this, "标题", null, "取消", new String[]{"高亮按钮1"}, new String[]{"其他按钮1", "其他按钮2", "其他按钮3"}, AlertDialog.Style.ActionSheet, this).show();
    }

    public void alertShow5(View view) {
        new AlertDialog(this, "标题", "内容", "取消", null, null, AlertDialog.Style.ActionSheet, this).show();
    }

    public void alertShow6(View view) {
        new AlertDialog(this, "上传头像", null, "取消", null,
                new String[]{"拍照", "从相册中选择"},
                AlertDialog.Style.ActionSheet, this).show();
    }

    public void alertShowExt(View view) {
        mAlertViewExt.show();
    }

    @Override
    public void onItemClick(Object o, int position) {

    }
}
