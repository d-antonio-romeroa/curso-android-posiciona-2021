package com.root.c2_modulo4_danielromero

import android.view.View
import android.view.ViewGroup
import androidx.test.runner.AndroidJUnit4
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.hamcrest.Matchers.`is`
import org.hamcrest.Matchers.allOf
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.espresso.action.ViewActions.*
import androidx.test.filters.SmallTest
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.filters.LargeTest
import org.hamcrest.core.IsInstanceOf


@LargeTest
@RunWith(AndroidJUnit4::class)
class TestOperaciones {

//    @Rule
//    @JvmField
//    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun TestSuma() {
        val appCompatEditText = onView(
            allOf(
                withId(R.id.c1_in),
                childAtPosition(
                    childAtPosition(
                        withId(android.R.id.content),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        appCompatEditText.perform(replaceText("25"), closeSoftKeyboard())

        val editText = onView(
            allOf(
                withId(R.id.c1_in), withText("25"),
                withParent(withParent(withId(android.R.id.content))),
                isDisplayed()
            )
        )
        editText.check(matches(withText("25")))

        val appCompatEditText2 = onView(
            allOf(
                withId(R.id.c2_in),
                childAtPosition(
                    childAtPosition(
                        withId(android.R.id.content),
                        0
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        appCompatEditText2.perform(replaceText("5"), closeSoftKeyboard())

        val editText2 = onView(
            allOf(
                withId(R.id.c2_in), withText("5"),
                withParent(withParent(withId(android.R.id.content))),
                isDisplayed()
            )
        )
        editText2.check(matches(withText("5")))

        val materialButton = onView(
            allOf(
                withId(R.id.sum_btn), withText("+"),
                childAtPosition(
                    childAtPosition(
                        withClassName(`is`("android.widget.TableLayout")),
                        3
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        materialButton.perform(click())

        val button = onView(
            allOf(
                withId(R.id.sum_btn), withText("+"),
                withParent(withParent(IsInstanceOf.instanceOf(android.widget.TableLayout::class.java))),
                isDisplayed()
            )
        )
        button.check(matches(isDisplayed()))

        val textView = onView(
            allOf(
                withId(R.id.total_out), withText("5"),
                withParent(withParent(withId(android.R.id.content))),
                isDisplayed()
            )
        )
        textView.check(matches(withText("5")))

    }

    private fun childAtPosition(
        parentMatcher: Matcher<View>, position: Int
    ): Matcher<View> {

        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return parent is ViewGroup && parentMatcher.matches(parent)
                        && view == parent.getChildAt(position)
            }
        }
    }

}