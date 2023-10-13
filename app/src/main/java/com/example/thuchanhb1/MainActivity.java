package com.example.thuchanhb1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ImageView imgIcon;
    private CheckBox cbPhone;
    private CheckBox cbAndroid;
    private CheckBox cbWindowMobile;
    private RadioButton rbMale;
    private RadioButton rbFemale;
    private RatingBar raRate;
    private Spinner spSpinner;
    private ListView lvListView;
    private Button btnSubmit;
    private TextView tvDisplayResult;
    private ArrayList<String> selectedUniversities = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize your UI elements
        imgIcon = findViewById(R.id.imgIcon);
        cbPhone = findViewById(R.id.cbPhone);
        cbAndroid = findViewById(R.id.cbAndroid);
        cbWindowMobile = findViewById(R.id.cbWindowMobile);
        rbMale = findViewById(R.id.rbMale);
        rbFemale = findViewById(R.id.rbFemale);
        raRate = findViewById(R.id.raRate);
        spSpinner = findViewById(R.id.spSpinner);
        lvListView = findViewById(R.id.lvListView);
        btnSubmit = findViewById(R.id.btnSubmit);
        tvDisplayResult = findViewById(R.id.tvDisplayResult);


        String[] countries = {"Viet Nam", "Thai Lan", "Lao", "Han Quoc", "Ha "};
        ArrayAdapter<String> countryAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, countries);
        countryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spSpinner.setAdapter(countryAdapter);


        String[] universities = {"HUST", "NEU", "FTU", "TMU", "Ptit"};
        ArrayAdapter<String> universityAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, universities);
        lvListView.setAdapter(universityAdapter);



        lvListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                String selectedUniversity = (String) adapterView.getItemAtPosition(position);


                if (selectedUniversities.contains(selectedUniversity)) {

                    selectedUniversities.remove(selectedUniversity);

                    view.setBackgroundColor(Color.TRANSPARENT);
                } else {

                    selectedUniversities.add(selectedUniversity);


                    view.setBackgroundColor(Color.YELLOW);
                }
            }
        });


        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                StringBuilder resultText = new StringBuilder("Selected Options:\n");

                if (cbPhone.isChecked()) {
                    resultText.append("Phone (Iphone)\n");
                }
                if (cbAndroid.isChecked()) {
                    resultText.append("Android\n");
                }
                if (cbWindowMobile.isChecked()) {
                    resultText.append("Window Mobile\n");
                }

                resultText.append("Gender: ");
                if (rbMale.isChecked()) {
                    resultText.append("Male\n");
                } else if (rbFemale.isChecked()) {
                    resultText.append("Female\n");
                }

                resultText.append("Rating: ").append(raRate.getRating()).append("\n");

                resultText.append("Country: ").append(spSpinner.getSelectedItem().toString()).append("\n");

                resultText.append("Selected Universities:\n");
                for (String university : selectedUniversities) {
                    resultText.append(university).append("\n");
                }


                tvDisplayResult.setText(resultText.toString());
            }
        });
    }
}
