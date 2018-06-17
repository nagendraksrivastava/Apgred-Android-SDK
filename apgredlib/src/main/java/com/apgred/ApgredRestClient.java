package com.apgred;

import com.apgred.pojo.ForceUpdateModel;
import com.apgred.pojo.HardUpdateOkayModel;
import com.apgred.pojo.RegisterModel;
import com.apgred.pojo.SoftUpdateOkayModel;
import com.apgred.pojo.SoftupdateCancelModel;
import com.apgred.pojo.ValidateResponse;
import com.apgred.request.ForceUpdateRequest;
import com.apgred.request.HardPushOkayRequest;
import com.apgred.request.RegisterDeviceRequest;
import com.apgred.request.SoftPushCancelRequest;
import com.apgred.request.SoftPushOkayRequest;
import com.apgred.request.ValidateRequest;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by nagendrasrivastava on 10/06/18.
 */

public interface ApgredRestClient {

    @POST("unnayan/v1/validateclient/")
    Call<ValidateResponse> validateClient(@Body ValidateRequest validateRequest);

    @POST("unnayan/v1/register/")
    Call<RegisterModel> registerDevice(@Body RegisterDeviceRequest registerDeviceRequest);

    @POST("unnayan/v1/softupdatecancel/")
    Call<SoftupdateCancelModel> softUpdateCancelled(@Body SoftPushCancelRequest softPushCancelRequest);

    @POST("unnayan/v1/softupdate/")
    Call<SoftUpdateOkayModel> softUpdateOkay(@Body SoftPushOkayRequest softPushOkayRequest);

    @POST("unnayan/v1/hardupdate/")
    Call<HardUpdateOkayModel> hardUpdateOkay(@Body HardPushOkayRequest hardPushOkayRequest);

    @POST("unnayan/v1/forceupdate/")
    Call<ForceUpdateModel> forceUpdate(@Body ForceUpdateRequest forceUpdateRequest);
}
