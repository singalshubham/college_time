package com.example.shubhu.collegetime.view.fragments;


import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.android.databinding.library.baseAdapters.BR;
import com.example.shubhu.collegetime.utility.Constants;
import com.example.shubhu.collegetime.view.activity.LoginActivity;
import com.example.shubhu.collegetime.viewmodel.LoginFragmentViewModel;
import com.example.shubhu.practicedemo.R;
import com.example.shubhu.practicedemo.databinding.FragmentLoginBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {
    LoginFragmentViewModel loginFragmentViewModel;
    EditText editText;

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
        loginFragmentViewModel=
               ViewModelProviders.of(this).get(LoginFragmentViewModel.class);
        fragmentLoginBinding.setLoginFragment(this);
        fragmentLoginBinding.setLoginViewModel(loginFragmentViewModel);
        editText=fragmentLoginBinding.etUserMail;
        return fragmentLoginBinding.getRoot();

    }

    public void openRegisterFragment() {
        ((LoginActivity) getActivity()).addFragment(R.id.container_for_fragment, RegisterFrament.newInstance()
                , Constants.REGISTER_FRAG_TAG, true);
    }

    public void openForgotPasswordFragment() {
        ((LoginActivity) getActivity()).addFragment(R.id.container_for_fragment, ForgotPasswordFragment.newInstance()
                , Constants.FORGOT_PASSWORD_FRAG, true);
    }

    public void clickOnLogin() {

        String message = loginFragmentViewModel.performValidation(loginFragmentViewModel.getUserEmail(),
                loginFragmentViewModel.getUserPassword());
        if (null != message) {
            Toast.makeText(getActivity(), "" + message, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getActivity(), "all condition satify", Toast.LENGTH_SHORT).show();
        }
    }

}
