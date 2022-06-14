package com.example.flighttracking;


import static org.junit.Assert.assertEquals;

import com.example.flighttracking.ui.LoginActivity;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

@RunWith(RobolectricTestRunner.class)
public class Login {
    private LoginActivity loginActivity;

    @Before
    public void setUp() throws Exception {
        loginActivity = Robolectric.buildActivity(LoginActivity.class)
                .create()
                .resume()
                .get();
    }
    @Test
    public void checkPassword(){
        TextInputLayout password = loginActivity.findViewById(R.id.passwordEditText);
        assertEquals("Password", password.getEditText().getHint());
    }
}
