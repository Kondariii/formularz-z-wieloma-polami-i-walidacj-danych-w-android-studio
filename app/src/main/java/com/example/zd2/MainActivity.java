package com.example.zd2;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextName;
    private EditText editTextSurname;
    private EditText editTextEmailAddress;
    private EditText editTextPhoneNumber;
    private EditText editTextPassword;
    private EditText editTextPasswordConfirmation;
    private Button buttonSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = findViewById(R.id.editTextName);
        editTextSurname = findViewById(R.id.editTextSurname);
        editTextEmailAddress = findViewById(R.id.editEmailAddress);
        editTextPhoneNumber = findViewById(R.id.editTextPhoneNumber);
        editTextPassword = findViewById(R.id.editTextPasssword);
        editTextPasswordConfirmation = findViewById(R.id.editTextPassswordConfirmation);
        buttonSubmit = findViewById(R.id.buttonSubmit);

        buttonSubmit.setOnClickListener(v -> {
            String name = editTextName.getText().toString().trim();
            String surname = editTextSurname.getText().toString().trim();
            String email = editTextEmailAddress.getText().toString().trim();
            String phoneNumber = editTextPhoneNumber.getText().toString().trim();
            String password = editTextPassword.getText().toString();
            String passwordConfirmation = editTextPasswordConfirmation.getText().toString();

            if (name.isEmpty() || surname.isEmpty()) {
                Toast.makeText(this, "Imię i nazwisko nie mogą być puste", Toast.LENGTH_SHORT).show();
            } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                Toast.makeText(this, "Nieprawidłowy adres email", Toast.LENGTH_SHORT).show();
            } else if (phoneNumber.length() != 9) {
                Toast.makeText(this, "Numer telefonu musi mieć 9 cyfr", Toast.LENGTH_SHORT).show();
            } else if (password.length() < 6) {
                Toast.makeText(this, "Hasło musi mieć co najmniej 6 znaków", Toast.LENGTH_SHORT).show();
            } else if (!password.equals(passwordConfirmation)) {
                Toast.makeText(this, "Hasła nie są identyczne", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Formularz został wysłany", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
