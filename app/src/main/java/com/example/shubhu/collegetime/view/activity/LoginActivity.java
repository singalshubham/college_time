package com.example.shubhu.collegetime.view.activity;

import android.os.Bundle;
import android.widget.EditText;

import com.example.shubhu.practicedemo.R;
import com.example.shubhu.collegetime.utility.Constants;
import com.example.shubhu.collegetime.view.fragments.LoginFragment;

public class LoginActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        addFragment(R.id.container_for_fragment,LoginFragment.newInstance(),Constants.LOGIN_FRAGMENT_TAG,false);
    }
}
