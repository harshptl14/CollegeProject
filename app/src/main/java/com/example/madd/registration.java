package com.example.madd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class registration extends AppCompatActivity {

    private EditText userName, userPassword, userEmail, userSurname;
    private Button RegButton;
    private TextView userLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        userName = (EditText) findViewById(R.id.etRegName);
        userPassword = (EditText) findViewById(R.id.etRegPassword);
        userSurname = (EditText) findViewById(R.id.etRegSurname);
        userEmail = (EditText) findViewById(R.id.etRegEmail);
        RegButton = (Button) findViewById(R.id.button);
        userLogin = (TextView) findViewById(R.id.tvLogin);

        RegButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((validate()== true)) {
                    Toast.makeText(registration.this, "registration Successful", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(registration.this, startpage.class));

                } else {
                    Toast.makeText(registration.this, "registration Unsuccessful", Toast.LENGTH_SHORT).show();

                }
            }
        });

        userLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(registration.this, startpage.class));
            }
        });
    }


    //@RequiresApi(api = Build.VERSION_CODES.GINGERBREAD)
    private boolean validate() {
        Boolean result = false;

        String name = userName.getText().toString();
        String surname = userSurname.getText().toString();
        String password = userPassword.getText().toString();
        String email = userEmail.getText().toString();

        if (name.isEmpty() && surname.isEmpty() && password.isEmpty() && email.isEmpty()) {

            Toast.makeText(this, "Please Enter All Details", Toast.LENGTH_SHORT).show();

        } else if (check_email() || check_username() || password()) {
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
        } else {
            result = true;
        }
        return result;
    }

    public boolean check_email() {
        String emailid = userEmail.getText().toString();
        if (emailid.isEmpty()) {
            userEmail.requestFocus();
            userEmail.setError("Field can't be empty");
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(emailid).matches()) {
            userEmail.requestFocus();
            userEmail.setError("Enter Valid Email ID.");
            return false;
        }
        return true;
    }

    public boolean check_username() {
        String user1 = userName.getText().toString();
        if (user1.isEmpty()) {
            userName.requestFocus();
            userName.setError("Field can't be empty");
            return false;
        } else if (!user1.equals("abc")) {
            userName.requestFocus();
            userName.setError("Enter Valid user name.");
            return false;
        }
        return true;
    }

    public boolean password() {
        String passd = userPassword.getText().toString();
        if (passd.isEmpty()) {
            userPassword.requestFocus();
            userPassword.setError("Field can't be empty");
            return false;
        } else if (!passd.equals("123")) {
            userPassword.requestFocus();
            userPassword.setError("Password is wrong");
            return false;
        }
        return true;
    }
}
