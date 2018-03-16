package com.ptp.phamtanphat.youtubesearch0412.Retrofit2.API;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class YoutubeSearch {

@SerializedName("items")
@Expose
private List<Item> items = null;
public List<Item> getItems() {
return items;
}

public void setItems(List<Item> items) {
this.items = items;
}

}
