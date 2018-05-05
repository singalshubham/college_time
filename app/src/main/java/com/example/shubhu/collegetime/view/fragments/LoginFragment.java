package com.example.shubhu.collegetime.view.fragments;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.shubhu.collegetime.utility.Constants;
import com.example.shubhu.collegetime.view.activity.LoginActivity;
import com.example.shubhu.practicedemo.R;
import com.example.shubhu.practicedemo.databinding.FragmentLoginBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {

    public static LoginFragment newInstance() {

        Bundle args = new Bundle();
        LoginFragment fragment = new LoginFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        FragmentLoginBinding fragmentLoginBinding = DataBindingUtil.inflate(getActivity().
                getLayoutInflater(), R.layout.fragment_login, container, false);
        fragmentLoginBinding.setLoginFragment(this);
        return fragmentLoginBinding.getRoot();

    }

    public void openRegisterFragment(){
        ((LoginActivity)getActivity()).addFragment(R.id.container_for_fragment,RegisterFrament.newInstance()
                , Constants.REGISTER_FRAG_TAG,true);
    }

    public void openForgotPasswordFragment(){
        ((LoginActivity)getActivity()).addFragment(R.id.container_for_fragment,ForgotPasswordFragment.newInstance()
                ,Constants.FORGOT_PASSWORD_FRAG,true);
    }

}
