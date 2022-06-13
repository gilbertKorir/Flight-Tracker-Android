package com.example.flighttracking;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.CoreMatchers.endsWith;
import static org.hamcrest.Matchers.allOf;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import com.example.flighttracking.ui.CreateAccountActivity;
import com.example.flighttracking.ui.LoginActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class CreateAccountActivityInstrumentationTest {

    @Rule
    public ActivityScenarioRule<CreateAccountActivity> activityRule = new ActivityScenarioRule<>(CreateAccountActivity.class);

    @Test
    public void validatetActivity() {
        String name = "John Doe";
        String email = "johnbook@gmail.com";
        String password = "121212";
        String conpassword = "121212";

        onView(allOf(isDescendantOfA(withId(R.id.nameEditText)),
                withClassName(endsWith("TextInputEditText"))
        )).perform(typeText(name)).perform(closeSoftKeyboard());

        onView(allOf(isDescendantOfA(withId(R.id.emailEditText)),
                withClassName(endsWith("TextInputEditText"))
        )).perform(typeText(email)).perform(closeSoftKeyboard());

        onView(allOf(isDescendantOfA(withId(R.id.passwordEditText)),
                withClassName(endsWith("TextInputEditText"))
        )).perform(typeText(password)).perform(closeSoftKeyboard());

        onView(allOf(isDescendantOfA(withId(R.id.confirmPasswordEditText)),
                withClassName(endsWith("TextInputEditText"))
        )).perform(typeText(conpassword)).perform(closeSoftKeyboard());

        try {                             // the sleep method requires to be checked and handled so we use try block
            Thread.sleep(250);
        } catch (InterruptedException e){
            System.out.println("got interrupted!");
        }
        onView(withId(R.id.createUserButton)).perform(click());
    }

}
