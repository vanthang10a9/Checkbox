package com.example.checkbox;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.DialogTitle;
import androidx.fragment.app.DialogFragment;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.strictmode.ContentUriWithoutPermissionViolation;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private CheckBox mCheckBoxAmNhac;
    private CheckBox mCheckBoxVoThuat;
    private CheckBox mCheckBoxDuLich;
    private CheckBox mCheckBoxTheThao;
    private RadioGroup mRadioGroupNgheNghiep;

    private EditText mEditTextName;
    private EditText mEditTextNgaySinh;

    private final Context context = this;
    private Dialog dialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditTextName = (EditText) findViewById(R.id.editTextName);
        mEditTextNgaySinh = (EditText) findViewById(R.id.editTextNgaySinh);

        mRadioGroupNgheNghiep = (RadioGroup) findViewById(R.id.radioGroupNgheNghiep);
        mRadioGroupNgheNghiep.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int idRadioChecked) {
                showNgheNghiep(idRadioChecked);
            }
        });

        mCheckBoxAmNhac = (CheckBox) findViewById(R.id.checkboxAmNhac);
        mCheckBoxVoThuat = (CheckBox) findViewById(R.id.checkboxVoThuat);
        mCheckBoxDuLich = (CheckBox) findViewById(R.id.checkboxDuLich);
        mCheckBoxTheThao = (CheckBox) findViewById(R.id.checkboxTheThao);
        allCheckBoxListener();


        Button mButtonXacNhan = (Button) findViewById(R.id.buttonXacNhan);
        mButtonXacNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog = new Dialog(context);
                dialog.setContentView(R.layout.dialog);
                TextView textViewThongBao = (TextView) dialog.findViewById(R.id.textViewThongBao);
                if(!checkNullInformation()){
                    textViewThongBao.setText("Đã cập nhật thông tin!");
                }else {
                    textViewThongBao.setText("Chưa nhập đầy đủ thông tin!");
                }
                dialog.show();

                Button buttonThoat = (Button) dialog.findViewById(R.id.buttonThoat);
                buttonThoat.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        exitMainActivity();
                    }
                });

                Button buttonTiepTuc = (Button) dialog.findViewById(R.id.buttonTiepTuc);
                buttonTiepTuc.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                        showThongTin();
                    }
                });

            }
        });

    }

    private void showNgheNghiep(int idRadioChecked) {
        switch (idRadioChecked) {
            case R.id.radioButtonBacSi:
                Toast.makeText(this, "Nghề nghiệp đã chọn: Bác sĩ", Toast.LENGTH_LONG).show();
                break;
            case R.id.radioButtonYTa:
                Toast.makeText(this, "Nghề nghiệp đã chọn: Y tá", Toast.LENGTH_LONG).show();
                break;
            case R.id.radioButtonDieuDuong:
                Toast.makeText(this, "Nghề nghiệp đã chọn: Điều dưỡng", Toast.LENGTH_LONG).show();
        }
    }

    private void allCheckBoxListener() {
        mCheckBoxVoThuat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                showSoThich(compoundButton, b);
            }
        });
        mCheckBoxTheThao.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                showSoThich(compoundButton, b);
            }
        });
        mCheckBoxDuLich.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                showSoThich(compoundButton, b);
            }
        });

        mCheckBoxAmNhac.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                showSoThich(compoundButton, b);
            }
        });
    }

    private void showSoThich(CompoundButton compoundButton, boolean isChecked) {
        if (isChecked)
            Toast.makeText(compoundButton.getContext(), "Đã chọn Sở thích: " + compoundButton.getText(), Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(compoundButton.getContext(), "Đã hủy chọn: " + compoundButton.getText(), Toast.LENGTH_SHORT).show();
    }

    private void exitMainActivity(){
        //Khoi tao lai Activity main
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);

        // Tao su kien ket thuc app
        Intent startMain = new Intent(Intent.ACTION_MAIN);
        startMain.addCategory(Intent.CATEGORY_HOME);
        startActivity(startMain);
        finish();
    }

    private boolean checkNullInformation(){
        if(mEditTextName.getText().toString().isEmpty() || mEditTextNgaySinh.getText().toString().isEmpty()){
            return true;
        }

        return false;
    }

    private void showThongTin(){
        TextView textViewName = (TextView) findViewById(R.id.textviewName);
        textViewName.setText("Họ tên : " + mEditTextName.getText());
        TextView textViewNgaySinh = (TextView) findViewById(R.id.textviewNgaySinh);
        textViewNgaySinh.setText("Ngày sinh : " + mEditTextNgaySinh.getText());

        TextView textViewNgheNghiep = (TextView) findViewById(R.id.textviewNgheNghiep);
        int idRadioButtonNgheNghiep = mRadioGroupNgheNghiep.getCheckedRadioButtonId();
        RadioButton radioButton = (RadioButton) findViewById(idRadioButtonNgheNghiep);
        textViewNgheNghiep.setText("Nghề nghiệp : " + radioButton.getText());

        String soThich = "Sở thích đã chọn ";
        if(mCheckBoxAmNhac.isChecked()){
            soThich += ", Âm nhạc";
        }
        if(mCheckBoxDuLich.isChecked()){
            soThich += ", Du lịch";
        }
        if(mCheckBoxTheThao.isChecked()){
            soThich += ", Thể thao";
        }
        if(mCheckBoxVoThuat.isChecked()){
            soThich += ", Võ thuật";
        }
        TextView textViewSoThich = (TextView) findViewById(R.id.textviewSoThich);
        textViewSoThich.setText(soThich);


    }
}
