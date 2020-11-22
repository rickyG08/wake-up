package edu.cnm.deepdive.wakeup.controller;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import edu.cnm.deepdive.wakeup.R;
import edu.cnm.deepdive.wakeup.databinding.ActivityLoginBinding;
import edu.cnm.deepdive.wakeup.service.GoogleSignInService;
import edu.cnm.deepdive.wakeup.service.UserRepository;

public class LoginActivity extends AppCompatActivity {

  private static final int LOGIN_REQUEST_CODE = 1000;

  private GoogleSignInService service;
  private ActivityLoginBinding binding;
  private UserRepository userRepository;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    service = GoogleSignInService.getInstance();
    service.refresh()
        .addOnSuccessListener((account) -> {/* TODO Switch to MainActivity */})
        .addOnFailureListener((throwable) -> {
          binding = ActivityLoginBinding.inflate(getLayoutInflater());
          binding.signIn.setOnClickListener((v) -> {/* TODO Start login process */});
          setContentView(R.layout.activity_login);
        });
  }


}