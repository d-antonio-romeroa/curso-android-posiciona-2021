package com.example.a3_modulo3_daniel_romero;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class clpToEurAndroidTest {

    @Rule
    public ActivityTestRule<MainActivity> activityRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void tittleContent() {
        onView(withText("Convertidora de Divisas"))
                .check(matches(isDisplayed()));
    }

    @Test
    public void correctConversionEurToClp() {
        onView(withId(R.id.convertir_to_eur))
                .perform(click());
        onView(withId(R.id.total_eur)).check(matches(withText("0.001")));
    }

//    @Rule
//    public ActivityTestRule<MainActivity> activityRule2 =
//            new ActivityTestRule(eur_to_clp.class);

//    @Test
//    public void correctConversionClpToEur() {
//        onView(withId(R.id.convertir_to_eur))
//                .perform(click());
//        withId(R.id.total_clp).matches(withText("952.570"));
//    }

}