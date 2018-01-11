package com.udacity.gradle.builditbigger;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.action.ViewActions.click;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by root on 11/01/18.
 */

@RunWith(AndroidJUnit4.class)
public class GetJokeAsyncTaskTest {

    @Rule
    public ActivityTestRule<MainActivity> mainActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testIsItNull() throws Exception{
        assertNotNull(R.id.fragment);
        onView(withId(R.id.bt_tell_joke)).perform(click());
        assertNotEquals("", GetJokeAsync.mJoke);
    }
}