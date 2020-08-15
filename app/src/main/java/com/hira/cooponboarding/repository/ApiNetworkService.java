package com.hira.cooponboarding.repository;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiNetworkService {
    @POST("api/create_customer")
    Call<CustomerCreateResponse> createCustomer(@Body JsonObject body);

    @POST("api/customer_validate")
    Call<CustomerCreateAuthresponse> validateCustomer(@Body JsonObject body);
    @POST("api/customer_auth")
    Call<CustomerCreateAuthresponse> authorizeCustomer(@Body JsonObject body);

    @POST("api/open_account")
    Call<AccountauthResponse> openAccount(@Body JsonObject body);
    @POST("api/account_validate")
    Call<AccountauthResponse> validateAccount(@Body JsonObject body);
    @POST("api/account_auth")
    Call<AccountOpenResponse> authorizeAccount(@Body JsonObject body);

}
