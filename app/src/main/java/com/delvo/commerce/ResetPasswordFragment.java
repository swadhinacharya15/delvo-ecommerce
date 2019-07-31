package com.delvo.commerce;


import android.graphics.Color;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;


/**
 * A simple {@link Fragment} subclass.
 */
public class ResetPasswordFragment extends Fragment {


    public ResetPasswordFragment() {
        // Required empty public constructor
    }
private EditText registeredEmail;
    private Button resetPasswordBtn;
    private TextView goBack;
    private FrameLayout parentFrameLayout;
private FirebaseAuth firebaseAuth;
private ViewGroup emailIconContener;
private ImageView emailIcon;
private TextView emailIconText;
private ProgressBar progressBar;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_reset_password, container, false);
registeredEmail=view.findViewById(R.id.forgot_password_email);
resetPasswordBtn=view.findViewById(R.id.reset_password_btn);
goBack=view.findViewById(R.id.tv_forgot_password_go_back);
firebaseAuth=FirebaseAuth.getInstance();
parentFrameLayout=getActivity().findViewById(R.id.register_framelayout);
emailIconContener=view.findViewById(R.id.forgot_password_email_contener);
emailIcon=view.findViewById(R.id.forgot_password_email_icon);
emailIconText=view.findViewById(R.id.forgot_password_email_icon_text);
progressBar=view.findViewById(R.id.forgot_password_progress_bar);

    return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);
            registeredEmail.addTextChangedListener(new TextWatcher() {
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
            goBack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
setFragment(new SigninFragment());
                }
            });
            resetPasswordBtn.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    TransitionManager.beginDelayedTransition(emailIconContener);
                    emailIconText.setVisibility(View.GONE);
                    TransitionManager.beginDelayedTransition(emailIconContener);
                    emailIcon.setVisibility(View.VISIBLE);
                    progressBar.setVisibility(View.VISIBLE);
                    resetPasswordBtn.setEnabled(false);
                    resetPasswordBtn.setTextColor(Color.argb(50,255,255,255));

                    firebaseAuth.sendPasswordResetEmail(registeredEmail.getText().toString())
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if(task.isSuccessful()){
                                        String msg="Email Sent Successfully Please check your inbox";
                                        TransitionManager.beginDelayedTransition(emailIconContener);
                                        emailIconText.setText(msg);
                                        emailIconText.setTextColor(getResources().getColor(R.color.successGreen));
                                        emailIconText.setVisibility(View.VISIBLE);
                                        Toast.makeText(getActivity(),"Email Sent Succesfully",Toast.LENGTH_LONG).show();
                                    }else{

                                        String error=task.getException().getMessage();
                                       // Toast.makeText(getActivity(),error,Toast.LENGTH_SHORT).show();

                                        TransitionManager.beginDelayedTransition(emailIconContener);
                                        emailIconText.setText(error);
                                        emailIconText.setTextColor(getResources().getColor(R.color.colorPrimary));
                                        emailIconText.setVisibility(View.VISIBLE);
                                        resetPasswordBtn.setEnabled(true);
                                        resetPasswordBtn.setTextColor(Color.rgb(255,255,255));
                                    }
                                    progressBar.setVisibility(View.GONE);

                                }
                            });
                }
            });
    }
    private void checkInputs(){
        if(TextUtils.isEmpty(registeredEmail.getText())){
            resetPasswordBtn.setEnabled(false);
            resetPasswordBtn.setTextColor(Color.argb(50,255,255,255));
        }else{
            resetPasswordBtn.setEnabled(true);
            resetPasswordBtn.setTextColor(Color.rgb(255,255,255));
        }
    }
    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction=getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.slide_from_left,R.anim.slide_out_from_right);
        fragmentTransaction.replace(parentFrameLayout.getId(),fragment);
        fragmentTransaction.commit();
    }
}
