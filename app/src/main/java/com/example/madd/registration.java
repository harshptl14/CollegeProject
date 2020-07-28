package com.example.madd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class registration extends AppCompatActivity {

    private EditText userName,userPassword,userEmail,userSurname;
    private Button RegButton;
    private TextView userLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        userName = (EditText) findViewById(R.id.etRegName);
        userPassword = (EditText)findViewById(R.id.etRegPassword);
        userSurname = (EditText)findViewById(R.id.etRegSurname);
        userEmail = (EditText)findViewById(R.id.etRegEmail);
        RegButton = (Button)findViewById(R.id.button);
        userLogin = (TextView)findViewById(R.id.tvLogin);

        RegButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validate()){
                                Toast.makeText(registration.this, "registration Successful", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(registration.this, MainnActivity.class));

                    }
                else{
                    Toast.makeText(registration.this, "registration Unsuccessful", Toast.LENGTH_SHORT).show();

                }
            }
        });

        userLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(registration.this, MainnActivity.class));
            }
        });
    }



    //@RequiresApi(api = Build.VERSION_CODES.GINGERBREAD)
    private boolean validate(){
        Boolean result= false;

        String name = userName.getText().toString();
        String surname = userSurname.getText().toString();
        String password = userPassword.getText().toString();
        String email = userEmail.getText().toString();

        if(name.isEmpty() && surname.isEmpty() && password.isEmpty() && email.isEmpty())
        {

            Toast.makeText(this, "Please Enter All Details" ,Toast.LENGTH_SHORT).show();

        }
        else{
            result= true;
        }
        return result;
    }
}
