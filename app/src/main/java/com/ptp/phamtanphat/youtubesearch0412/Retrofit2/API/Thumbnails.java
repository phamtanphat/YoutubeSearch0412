package com.ptp.phamtanphat.youtubesearch0412.Retrofit2.API;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Thumbnails {

@SerializedName("medium")
@Expose
private Medium medium;

public Medium getMedium() {
return medium;
}

public void setMedium(Medium medium) {
this.medium = medium;
}

}
