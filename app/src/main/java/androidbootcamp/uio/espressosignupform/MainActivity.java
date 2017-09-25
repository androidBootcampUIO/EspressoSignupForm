package androidbootcamp.uio.espressosignupform;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends Activity {

    private EditText calendarEditText;
    private Calendar calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calendar = Calendar.getInstance();
        calendarEditText = findViewById(R.id.editText_birthday);
        final DatePickerDialog.OnDateSetListener datePicker = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, month);
                calendar.set(Calendar.DAY_OF_MONTH, day);
                updateLabel();
            }
        };

        calendarEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (hasFocus) {
                    new DatePickerDialog(MainActivity.this, datePicker, calendar.get(Calendar.YEAR),
                            calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH))
                            .show();
                }
            }
        });

    }

    private void updateLabel() {
        String dateFormat = "MM/dd/yy";
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat, Locale.US);

        calendarEditText.setText(sdf.format(calendar.getTime()));
    }


    public void register(View view) {
        EditText nameEditText = findViewById(R.id.editText_name);
        String name = nameEditText.getText().toString().trim();
        EditText lastnameEditText = findViewById(R.id.editText_lastname);
        String lastname = lastnameEditText.getText().toString().trim();

        String greeting = getString(R.string.greeting) + ": " + name + " " + lastname;

        Toast.makeText(this, greeting, Toast.LENGTH_LONG).show();
    }
}
