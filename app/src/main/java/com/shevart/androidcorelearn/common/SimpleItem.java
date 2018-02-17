package com.shevart.androidcorelearn.common;

import android.os.Parcel;
import android.os.Parcelable;

@SuppressWarnings("WeakerAccess")
public class SimpleItem implements Parcelable {
    private long id;
    private String title;
    private String description;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.id);
        dest.writeString(this.title);
        dest.writeString(this.description);
    }

    public SimpleItem() {
    }

    protected SimpleItem(Parcel in) {
        this.id = in.readLong();
        this.title = in.readString();
        this.description = in.readString();
    }

    public static final Parcelable.Creator<SimpleItem> CREATOR = new Parcelable.Creator<SimpleItem>() {
        @Override
        public SimpleItem createFromParcel(Parcel source) {
            return new SimpleItem(source);
        }

        @Override
        public SimpleItem[] newArray(int size) {
            return new SimpleItem[size];
        }
    };

    @Override
    public String toString() {
        return "SimpleItem{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
