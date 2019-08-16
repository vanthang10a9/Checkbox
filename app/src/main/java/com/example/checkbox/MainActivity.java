package com.example.checkbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private CheckBox mCheckBoxAmNhac;
    private CheckBox mCheckBoxVoThuat;
    private CheckBox mCheckBoxDuLich;
    private CheckBox mCheckBoxTheThao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RadioGroup mGroupNgheNghiep = (RadioGroup) findViewById(R.id.radioGroupNgheNghiep);
        mGroupNgheNghiep.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
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

//    private void showSoThich(CheckBox checkBoxSoThich) {
//        int idCheckBox = checkBoxSoThich.getId();
//        String tenCheckBox = null;
//        switch (idCheckBox) {
//            case R.id.checkboxAmNhac:
//                tenCheckBox = "Âm Nhạc";
//                break;
//            case R.id.checkboxDuLich:
//                tenCheckBox = "Du lịch";
//                break;
//            case R.id.checkboxTheThao:
//                tenCheckBox = "Thể thao";
//                break;
//            case R.id.checkboxVoThuat:
//                tenCheckBox = "Võ thuật";
//                break;
//        }
//        if (checkBoxSoThich.isChecked())
//            Toast.makeText(this, "Đã chọn Sở thích: " + tenCheckBox, Toast.LENGTH_LONG).show();
//        else
//            Toast.makeText(this, "Đã hủy chọn: " + tenCheckBox, Toast.LENGTH_LONG).show();
//    }
}
