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

public class SiginActivity extends Activity {

    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button signInButton;
    private Button RegisterButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sigin);

        // 初始化用户名输入框、密码输入框、登录按钮和注册按钮
        usernameEditText = findViewById(R.id.Username);
        passwordEditText = findViewById(R.id.Password);
        signInButton = findViewById(R.id.Sign_in);
        RegisterButton = findViewById(R.id.Register);

        // 为登录按钮设置点击监听器
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                // 检查用户名和密码
                if (username.equals("myapp") && password.equals("12345")) {
                    // 登录成功，显示成功消息，然后跳转到用户信息页面
                    showToastAndNavigate("登录成功", UserInfoActivity.class);
                } else if (username.equals("myapp") && !password.equals("12345")) {
                    // 密码错误，显示错误消息
                    showCustomToast("密码错误");
                } else {
                    // 用户不存在，自动跳转到注册页面
                    Intent intent = new Intent(SiginActivity.this, RegistrationActivity.class);
                    startActivity(intent);
                }
            }
        });

        // 为注册按钮设置点击监听器
        RegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SiginActivity.this, RegistrationActivity.class);
                startActivity(intent);
            }
        });
    }

    private void showToastAndNavigate(String message, Class destination) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(SiginActivity.this, destination);
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
