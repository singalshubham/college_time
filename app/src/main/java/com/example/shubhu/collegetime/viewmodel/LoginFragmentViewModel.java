package com.example.shubhu.collegetime.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.ViewModel;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.Observable;
import android.databinding.ObservableBoolean;
import android.databinding.PropertyChangeRegistry;
import android.support.annotation.NonNull;
import android.text.Editable;
import android.text.TextWatcher;

import com.android.databinding.library.baseAdapters.BR;
import com.example.shubhu.practicedemo.R;

public class LoginFragmentViewModel extends BaseAndroidViewModel {

    private String userEmail;

    private String userPassword;

    public LoginFragmentViewModel(@NonNull Application application) {
        super(application);
    }

    @Bindable
    public String getUserPassword() {
        return userPassword;
    }

    @Bindable
    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
        notifyPropertyChanged(BR.userEmail);
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
        notifyPropertyChanged(BR.userPassword);
    }


    public String performValidation(String userEmail, String userPassword) {
        if (null == userEmail || null == userPassword) {
            return getApplication().getString(R.string.empty_field_message);
        }
       else if (userEmail.isEmpty() ||  userPassword.isEmpty()) {
            return getApplication().getString(R.string.empty_field_message);
        }
        return null;
    }
}
