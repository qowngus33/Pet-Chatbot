package com.example.myapplication.ui.setting;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.example.myapplication.R;

public class PetProfileActivity extends SettingActivity {
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.petprofile);

        TextView ID = findViewById(R.id.userID);
        TextView petNickName = findViewById(R.id.petNickname);
        TextView petAge = findViewById(R.id.petAge);
        Button btnName = findViewById(R.id.btnName);
        Button btnAge = findViewById(R.id.btnAge);
        Button btnSave = findViewById(R.id.btnSave);
        Button btnDelete = findViewById(R.id.btnDelete);

        //반려동물 이름 변경
        btnName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder name = new AlertDialog.Builder(PetProfileActivity.this);
                name.setTitle("닉네임 설정");
                name.setMessage("10자 이내로 닉네임을 설정하세요.");

                final EditText NickName = new EditText(PetProfileActivity.this);
                name.setView(NickName);
                name.setPositiveButton("저장", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        String result = NickName.getText().toString();
                        petNickName.setText(result);
                        dialog.dismiss();
                        Toast.makeText(getApplicationContext(), "닉네임이 변경되었습니다.", Toast.LENGTH_SHORT).show();
                    }
                });
                name.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        dialog.dismiss();
                    }
                });
                name.show();
            }
        });

        //나이 변경
        btnAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder name = new AlertDialog.Builder(PetProfileActivity.this);
                name.setTitle("나이 변경");

                //스크롤뷰(?)로 나이 선택할 수 있게 변경하기.
                final EditText NickName = new EditText(PetProfileActivity.this);
                name.setView(NickName);
                name.setPositiveButton("설정", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        String result = NickName.getText().toString();
                        petAge.setText(result);
                        dialog.dismiss();
                        Toast.makeText(getApplicationContext(), "나이가 변경되었습니다.", Toast.LENGTH_SHORT).show();
                    }
                });
                name.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        dialog.dismiss();
                    }
                });
                name.show();
            }
        });

        //저장 버튼
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //바뀐 정보 모두 DB로 이동
            }
        });

        //삭제 버튼
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //정보 삭제 후, 반려동물 등록화면으로 이동
                Intent intent = new Intent(getApplicationContext(), New.class);
                startActivity(intent);
            }
        });
    }
}