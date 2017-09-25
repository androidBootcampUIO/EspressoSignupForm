package androidbootcamp.uio.espressosignupform;

import android.support.test.espresso.Espresso;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityEspressoTest {

    @Rule
    public ActivityTestRule<MainActivity> mainActivityRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void displaysTitle() throws Exception {
        String title = "Formulario de inscripción";
        onView(withText(title)).check(matches(isDisplayed()));
    }

    @Test
    public void greetsUser() throws Exception {
        onView(withId(R.id.editText_name)).perform(typeText("Sebastian"));
        onView(withId(R.id.editText_lastname)).perform(typeText("Puente"));
        onView(withId(R.id.editText_email)).perform(typeText("sebas@sample.com"));
        onView(withId(R.id.textView_title)).perform(click());
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.button_registrar)).perform(click());
        onView(withText("Hola: Sebastian Puente" )).inRoot(withDecorView(not(is(mainActivityRule.getActivity().getWindow().getDecorView())))).check(matches(isDisplayed()));
    }
}
