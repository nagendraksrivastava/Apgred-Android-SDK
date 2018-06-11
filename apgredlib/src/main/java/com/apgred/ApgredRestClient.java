package com.apgred;

import com.apgred.pojo.RegisterModel;
import com.apgred.pojo.SoftupdateCancelModel;
import com.apgred.pojo.ValidateResponse;
import com.apgred.request.ValidateRequest;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by nagendrasrivastava on 10/06/18.
 */

public interface ApgredRestClient {

    @POST("/validateclient")
    Call<ValidateResponse> validateClient(@Body ValidateRequest validateRequest);

    @POST("/register")
    Call<RegisterModel> registerDevice();

    @POST("/softupdatecancel")
    Call<SoftupdateCancelModel> softUpdateCancelled();

    @POST("/softupdate")
    Call<RegisterModel> softUpdateOkay();

    @POST("/hardupdate")
    Call<RegisterModel> hardUpdateOkay();

    @POST("/forceupdate")
    Call<RegisterModel> forceUpdate();
}
