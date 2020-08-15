package com.hira.cooponboarding.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.gson.JsonObject;
import com.hira.cooponboarding.R;
import com.hira.cooponboarding.view_model.OnBoardingViewModel;

public class CreateCustomer extends AppCompatActivity {
    //        "messageId":"Elmalawemwgrm",
//            "Mnemonic":"YM1234254",
//            "short_name":"amano",
//            "full_name":"Aman Saido Gubba",
//            "sector":"1300",
//            "industry":"1311",
//            "nationality":"ET",
//            "residence":"ET",
//            "title":"MR",
//            "gender":"MALE",
//            "given_name":"Aman Saido Gubba",
//            "marital_status":"MARRIED"
//    private String messageId;
//    private String Mnemonic;
//    private String short_name;
//    private String full_name;
//    private String sector;
//    private String industry;
//    private String nationality;
//    private String residence;
//    private String title;
//    private String gender;
//    private String given_name;
//    private String marital_status;

    //private EditText messageId;

    private EditText mobile_number;
    private EditText short_name;
    private EditText full_name;
    private EditText sector;
    private EditText industry;
    private Spinner nationality;
    private Spinner residence;
    private Spinner title;
    private Spinner gender;
    private EditText given_name;
    private Spinner marital_status;
    OnBoardingViewModel onBoardingViewModel;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_customer);
        mobile_number=findViewById(R.id.mobile_number);
        short_name=findViewById(R.id.short_name);
        full_name=findViewById(R.id.full_name);
        sector=findViewById(R.id.sector);
        industry=findViewById(R.id.industry);
        nationality=findViewById(R.id.nationality);
        marital_status=findViewById(R.id.marital_status);
        given_name=findViewById(R.id.given_name);
        residence=findViewById(R.id.country_of_residence);
        gender=findViewById(R.id.gender);
        title=findViewById(R.id.title);

        //initialize the spinners

        spinnerInitialization(R.array.gender,gender);
        spinnerInitialization(R.array.title,title);
        spinnerInitialization(R.array.country_of_residence,residence);
        spinnerInitialization(R.array.marital_status,marital_status);
        spinnerInitialization(R.array.nationality,nationality);
        onBoardingViewModel=new ViewModelProvider
                .AndroidViewModelFactory(getApplication())
                .create(OnBoardingViewModel.class);
    }



    public void spinnerInitialization(int id,Spinner currentSpinner){
        ArrayAdapter<CharSequence> Adapter = ArrayAdapter.createFromResource(this,
                id, android.R.layout.simple_spinner_item);
        Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        currentSpinner.setAdapter(Adapter);

    }

    public void createCustomer(View view) {

        JsonObject customerData=new JsonObject();

        customerData.addProperty("messageId","");
        customerData.addProperty("Mnemonic","");
        customerData.addProperty("mobile_number",mobile_number.getText().toString());
        customerData.addProperty("short_name",short_name.getText().toString());
        customerData.addProperty("full_name",full_name.getText().toString());
        customerData.addProperty("sector",sector.getText().toString());
        customerData.addProperty("industry",industry.getText().toString());
        customerData.addProperty("nationality",nationality.getSelectedItem().toString());
        customerData.addProperty("residence",residence.getSelectedItem().toString());
        customerData.addProperty("title",title.getSelectedItem().toString());
        customerData.addProperty("gender",gender.getSelectedItem().toString());
        customerData.addProperty("given_name",given_name.getText().toString());
        customerData.addProperty("marital_status",marital_status.getSelectedItem().toString());


        onBoardingViewModel.cerateCustomerAPI(customerData);
//        onBoardingViewModel.getCreateCustomer().observe(this, new Observer< CustomerCreateResponse >(){
//            @Override
//            public void onChanged(CustomerCreateResponse customerCreateResponse) {
//
//
//            }
//        });



    }
}
