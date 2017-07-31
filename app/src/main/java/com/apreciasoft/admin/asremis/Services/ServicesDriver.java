package com.apreciasoft.admin.asremis.Services;

import com.apreciasoft.admin.asremis.Entity.DriverCurrentAcountEntity;
import com.apreciasoft.admin.asremis.Entity.InfoTravelEntity;
import com.apreciasoft.admin.asremis.Entity.driver;
import com.apreciasoft.admin.asremis.Entity.fleetType;
import com.apreciasoft.admin.asremis.Entity.modelEntity;
import com.apreciasoft.admin.asremis.Entity.responseFilterVehicle;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by Admin on 19/1/2017.
 */

public interface ServicesDriver {

    @Headers("Content-Type: application/json")
    @GET("driver/getAllTravel/{id}")
    Call<List<InfoTravelEntity>> getAllTravel(@Path("id") int id);

    @Headers("Content-Type: application/json")
    @GET("driver/inactive/{id}")
    Call<Boolean> inactive(@Path("id") int id);

    @Headers("Content-Type: application/json")
    @GET("driver/active/{id}")
    Call<Boolean> active(@Path("id") int id);

    @Headers("Content-Type: application/json")
    @GET("invoice/listLiquidationDriver/{id}")
    Call<DriverCurrentAcountEntity> listLiquidationDriver(@Path("id") int id);


    @Headers("Content-Type: application/json")
    @POST("driver/updateLiteMobil")
    Call<driver> updateLiteMobil(@Body driver dr);


    @Headers("Content-Type: application/json")
    @GET("Brand")
    Call<List<modelEntity>> filterForm();

    @Headers("Content-Type: application/json")
    @GET("fleetType")
    Call<List<fleetType>> filterFormfleetType();


    @Headers("Content-Type: application/json")
    @GET("model/byidBrand//{id}")
    Call<responseFilterVehicle> getModelDetail(@Path("id") int id);



}
