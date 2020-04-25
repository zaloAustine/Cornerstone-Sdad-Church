package com.zalocoders.cornerstone.Models;

import android.os.Parcel;
import android.os.Parcelable;



public class News implements Parcelable {
    private String description;
    private String[] imageUrls;

    public News(Parcel in) {
        imageUrls = in.createStringArray();
        description = in.readString();
    }

    public static final Creator<News> CREATOR = new Creator<News>() {
        @Override
        public News createFromParcel(Parcel in) {
            return new News(in);
        }

        @Override
        public News[] newArray(int size) {
            return new News[size];
        }
    };

    public News() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String[] getImageUrls() {
        return imageUrls;
    }

    public void setImageUrls(String[] imageUrls) {
        this.imageUrls = imageUrls;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeArray(imageUrls);
        dest.writeString(description);



    }
}
