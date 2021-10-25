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

@RunWith(AndroidJUnit4.class)
@LargeTest
public class eurToClpAndroidTest {


    @Rule
    public ActivityTestRule<eur_to_clp> activityRule =
            new ActivityTestRule(eur_to_clp.class);

    @Test
    public void correctConversionClpToEur() {
        onView(withId(R.id.convertir_to_clp))
                .perform(click());
        withId(R.id.total_clp).matches(withText("952.570"));
    }

}
