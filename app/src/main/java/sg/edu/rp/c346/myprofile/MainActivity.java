package sg.edu.rp.c346.myprofile;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etName;
    EditText etGPA;
    RadioGroup rgGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName=findViewById(R.id.editTextName);
        etGPA=findViewById(R.id.editTextGPA);
        rgGender=findViewById(R.id.radiobuttongroup);

    }

        @Override
    protected void onPause() {
        super.onPause();
            String strName = etName.getText().toString();
          float floatGPA =Float.parseFloat(etGPA.getText().toString());
            int gender = rgGender.getCheckedRadioButtonId();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor preEdit = prefs.edit();
        preEdit.putString("Name", strName);
        preEdit.putFloat("GPA", floatGPA);
        preEdit.putInt("Gender", gender);

        preEdit.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);

        String name = prefs.getString("Name","");
        float gpa = prefs.getFloat("GPA",0);
        int gender = prefs.getInt("Gender",1);

        etName.setText(name);
        etGPA.setText(Float.toString(gpa));
        rgGender.check(gender);


    }





    }
