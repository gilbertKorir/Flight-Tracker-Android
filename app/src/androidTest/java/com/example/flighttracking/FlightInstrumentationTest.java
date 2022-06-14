package com.example.flighttracking;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import android.support.test.rule.ActivityTestRule;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import com.example.flighttracking.fragments.FlightsFragment;
import com.example.flighttracking.ui.AllActivity;
import com.example.flighttracking.ui.HomePage;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class FlightInstrumentationTest {

//    @Rule
    public ActivityScenarioRule<AllActivity> activityRule = new ActivityScenarioRule<>(AllActivity.class);
//    @Rule
//    public ActivityTestRule<AllActivity> activityRule = new ActivityTestRule<>(AllActivity.class);
//    @Before
//    public void FlightsFragment() {
//        activityRule.getActivity().getFragmentManager().beginTransaction();
//    }

    @Test
    public void validateRegisterButton() {
        onView(withId(R.id.searchButton)).perform(click());
    }
}
