package com.delvo.commerce;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import static com.delvo.commerce.R.id.sign_in_dont_have_account;
import static com.delvo.commerce.RegisterActivity.onresetPasswordFragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class SigninFragment extends Fragment {



    public SigninFragment() {
        // Required empty public constructor
    }
    private TextView dontHaveAnAccount;
    private FrameLayout parentFrameLayout;
    private EditText email;
    private EditText password;
    private ImageButton closeBtn;
    private Button signInBtn;
    private FirebaseAuth firebaseAuth;
    private String emailPattern="[a-zA-Z0-9._-]+@[a-z]+.[a-z]+";
    private ProgressBar progressBar;
    private TextView forgotPassword;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_signin, container, false);
        View view=inflater.inflate(R.layout.fragment_signin,container,false);

        dontHaveAnAccount=view.findViewById(sign_in_dont_have_account);
        parentFrameLayout=getActivity().findViewById(R.id.register_framelayout);
        email=view.findViewById(R.id.sign_in_email);
        password=view.findViewById(R.id.sign_in_password);
        closeBtn=view.findViewById(R.id.sign_in_close_btn);
        signInBtn=view.findViewById(R.id.sign_in_btn);
        progressBar=view.findViewById(R.id.signin_progressBar);
        firebaseAuth=FirebaseAuth.getInstance();
        forgotPassword=view.findViewById(R.id.sign_in_forgot_password);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        dontHaveAnAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment(new SignupFragment());
            }


        });

        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onresetPasswordFragment=true;
                setFragment(new ResetPasswordFragment());
            }
        });
        closeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainIntent();
            }
        });
        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                checkInputs();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkEmailAndPassword();
            }
        });

    }
    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction=getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.slide_from_right,R.anim.slide_out_from_left);
        fragmentTransaction.replace(parentFrameLayout.getId(),fragment);
        fragmentTransaction.commit();
    }
    private void checkInputs(){
        if(!TextUtils.isEmpty(email.getText())){
if(!TextUtils.isEmpty(password.getText())){
signInBtn.setEnabled(true);
signInBtn.setTextColor(Color.rgb(255,255,255));
}else {
    signInBtn.setEnabled(false);
    signInBtn.setTextColor(Color.argb(50,255,255,255));
}
        }else{
            signInBtn.setEnabled(false);
            signInBtn.setTextColor(Color.argb(50,255,255,255));

        }

    }
    private void checkEmailAndPassword(){
        if(email.getText().toString().matches(emailPattern)){
            if(password.length() >=8){
                progressBar.setVisibility(View.VISIBLE);
                signInBtn.setEnabled(false);
                signInBtn.setTextColor(Color.argb(50,255,255,255));
                firebaseAuth.signInWithEmailAndPassword(email.getText().toString(),password.getText().toString())
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){
                                    mainIntent();

                                }else{
                                    progressBar.setVisibility(View.INVISIBLE);
                                    signInBtn.setEnabled(true);
                                    signInBtn.setTextColor(Color.rgb(255,255,255));
                                    String error=task.getException().getMessage();
                                    Toast.makeText(getActivity(),error,Toast.LENGTH_SHORT).show();
                                }
                            }
                        });

          signInBtn.setEnabled(true);

            }else{
                Toast.makeText(getActivity(),"Incorrect Email or Password",Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(getActivity(),"Incorrect Email or Password",Toast.LENGTH_SHORT).show();

        }

    }
    private void mainIntent(){
        Intent mainIntent=new Intent(getActivity(),MainActivity.class);
        startActivity(mainIntent);
        getActivity().finish();
    }
}
