package com.hira.cooponboarding.view_model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.google.gson.JsonObject;
import com.hira.cooponboarding.App;
import com.hira.cooponboarding.repository.ApiNetworkService;
import com.hira.cooponboarding.repository.CustomerCreateResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class OnBoardingViewModel extends AndroidViewModel {
    Retrofit retrofit;
    private MutableLiveData<CustomerCreateResponse> createCustomer;
    private MutableLiveData<CustomerCreateResponse> login;
    public MutableLiveData<CustomerCreateResponse> getCreateCustomer() {
        return createCustomer;
    }

    public void setCreateCustomer(MutableLiveData<CustomerCreateResponse> createCustomer) {
        this.createCustomer = createCustomer;
    }

    public OnBoardingViewModel(@NonNull Application application) {
        super(application);
        retrofit=((App)application).getRetrofit();
        createCustomer =new MutableLiveData<>();


    }
    public void cerateCustomerAPI(JsonObject customerData) {
        ApiNetworkService service = retrofit.create(ApiNetworkService.class);
        service.createCustomer(customerData).enqueue(new Callback<CustomerCreateResponse>() {

            @Override
            public void onResponse(Call<CustomerCreateResponse> call, Response<CustomerCreateResponse> response) {
                createCustomer.setValue(response.body());
            }
            @Override
            public void onFailure(Call<CustomerCreateResponse> call, Throwable t) {

            }
        });
    }

}
