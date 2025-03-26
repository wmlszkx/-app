package com.example.lgin3;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import com.example.lgin3.R;

public class RegistrationActivity extends Activity {

    private EditText registerUsernameEditText;
    private EditText registerPasswordEditText;
    private Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        registerUsernameEditText = findViewById(R.id.RegisterUsername);
        registerPasswordEditText = findViewById(R.id.RegisterPassword);
        registerButton = findViewById(R.id.DoRegister);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = registerUsernameEditText.getText().toString();
                String password = registerPasswordEditText.getText().toString();

                if (isValidInput(username, password)) {
                    showToastAndNavigate("注册成功", SiginActivity.class);
                } else {
                    showCustomToast("用户名和密码必须符合要求");
                }
            }
        });
    }

    private boolean isValidInput(String username, String password) {
        return !username.isEmpty() && !password.isEmpty();
    }

    private void showToastAndNavigate(String message, Class destination) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(RegistrationActivity.this, destination);
        startActivity(intent);
    }

    private void showCustomToast(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("提示");
        builder.setMessage(message);

        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
