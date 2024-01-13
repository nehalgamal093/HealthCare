package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
EditText edUsername,edEmail,edPassword,edConfirmPassword;
Button btn;
TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        edUsername = findViewById(R.id.editTextRegUsername);
        edEmail = findViewById(R.id.editTextRegEmail);
        edPassword = findViewById(R.id.editTextRegPassword);
        edConfirmPassword = findViewById(R.id.editTextregConfirmPassword);

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = edUsername.getText().toString();
                String email = edEmail.getText().toString();
                String password = edPassword.getText().toString();
                String confirmPassword = edConfirmPassword.getText().toString();

                if (username.length() == 0 || email.length() == 0 || password.length() == 0 || confirmPassword.length() == 0) {

                    Toast.makeText(getApplicationContext(),"Please fill all details",Toast.LENGTH_SHORT).show();
                }else{
                    if(password.compareTo(confirmPassword)==0){
                        if(isValid(password)){
                      //54:00
                        }else{
                            Toast.makeText(getApplicationContext(),"Passowrd must contain at least a character, letter, digit, special symbol",Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(getApplicationContext(),"Password and confirm password didn't match",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    public static boolean isValid(String passwordHere){
        int f1 =0,f2=0,f3=0;
        if(passwordHere.length() < 8){
            return false;
        } else{
            for(int p=0;p<passwordHere.length();p++){
                if(Character.isLetter(passwordHere.charAt(p))){
                    f1 = 1;
                }
            }
            for(int r = 0;r<passwordHere.length();r++){
                if(Character.isDigit(passwordHere.charAt(r))){
                    f2 =1;
                }
            }
            for(int s = 0;s<passwordHere.length();s++){
                char c = passwordHere.charAt(s);
                if(c>33&&c<=46||c==64){
                    f3 = 1;
                }
            }
            if(f1==1&&f2==1&&f3==1){
                return true;
            }
            return false;
        }
    }

}