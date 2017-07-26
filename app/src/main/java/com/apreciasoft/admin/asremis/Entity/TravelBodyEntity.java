package com.apreciasoft.admin.asremis.Entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Admin on 05/01/2017.
 */

public class TravelBodyEntity {



    @Expose
    @SerializedName("idUserCompanyKf")
    public int midUserCompanyKf;

    @Expose
    @SerializedName("idClientKf")
    public int mIdClientKf;

    @Expose
    @SerializedName("isTravelComany")
    public boolean mIsTravelComany;

    @Expose
    @SerializedName("idTypeVehicle")
    public int mIdTypeVehicle;



    @Expose
    @SerializedName("origin")
    public OriginEntity mOrigin;

    @Expose
    @SerializedName("destination")
    public DestinationEntity mDestination;



    public OriginEntity getOrigin() {
        return mOrigin;
    }

    public void setOrigin(OriginEntity origin) {
        mOrigin = origin;
    }

    @Expose
    @SerializedName("dateTravel")
    public String mDateTravel;

    @Expose
    @SerializedName("isTravelSendMovil")
    public boolean misTravelSendMovil;


    public int getMidUserCompanyKf() {
        return midUserCompanyKf;
    }

    public void setMidUserCompanyKf(int midUserCompanyKf) {
        this.midUserCompanyKf = midUserCompanyKf;
    }

    public boolean isMisTravelSendMovil() {
        return misTravelSendMovil;
    }

    public void setMisTravelSendMovil(boolean misTravelSendMovil) {
        this.misTravelSendMovil = misTravelSendMovil;
    }

    public String getDateTravel() {
        return mDateTravel;
    }

    public void setDateTravel(String dateTravel) {
        mDateTravel = dateTravel;
    }


    public boolean isTravelComany() {
        return mIsTravelComany;
    }


    public void setTravelComany(boolean travelComany) {
        mIsTravelComany = travelComany;
    }



    public int getIdClientKf() {

        return mIdClientKf;
    }

    public int getmIdTypeVehicle() {
        return mIdTypeVehicle;
    }

    public void setmIdTypeVehicle(int mIdTypeVehicle) {
        this.mIdTypeVehicle = mIdTypeVehicle;
    }

    public void setIdClientKf(int idClientKf) {
        mIdClientKf = idClientKf;
    }

    public TravelBodyEntity(int idClientKf, boolean isTravelComany, OriginEntity origin,
                            DestinationEntity dstination, String dateTravel,int idTypeVehicle, boolean isTravelSendMovil,
                            int idUserCompanyKf) {
        mIdClientKf = idClientKf;
        mIsTravelComany = isTravelComany;
        mOrigin = origin;
        mDestination = dstination;
        mDateTravel = dateTravel;
        mIdTypeVehicle = idTypeVehicle;
        misTravelSendMovil = isTravelSendMovil;
        midUserCompanyKf = idUserCompanyKf;
    }
}
