package com.it190988.payment;

import org.junit.After;
import org.junit.Before;

import androidx.test.rule.ActivityTestRule;
import org.junit.Rule;

import android.app.Activity;
import android.app.Instrumentation;
import android.view.View;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;
import static org.junit.Assert.*;
import static org.junit.Assert.assertNotNull;

public class MainActivityTest {

    @Rule

    public ActivityTestRule<MainActivity> mActivityTestRule=new ActivityTestRule<MainActivity>(MainActivity.class);
    private MainActivity mActivity=null;

    Instrumentation.ActivityMonitor monitor=getInstrumentation().addMonitor(payment2.class.getName(),null,false);

    @Before
    public void setUp() throws Exception {

        mActivity=mActivityTestRule.getActivity();
    }
    //functional unit test
    public void testLaunchOfSecondActivityOnbuttonClick(){
        assertNotNull(mActivity.findViewById(R.id.payBtn));
        onView(withId(R.id.payBtn)).perform(click());
        Activity payment2=getInstrumentation().waitForMonitorWithTimeout(monitor,5000);
        assertNotNull(payment2);
    }
    //unit testing
    public void testLaunch(){


        View view=mActivity.findViewById(R.id.textView);
        assertNotNull(view);
    }

    @After
    public void tearDown() throws Exception {
        mActivity=null;
    }
}