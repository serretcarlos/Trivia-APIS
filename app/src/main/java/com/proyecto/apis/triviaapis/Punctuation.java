package com.proyecto.apis.triviaapis;

import java.util.UUID;

/**
 * Created by carlo on 04/05/2018.
 */

public class Punctuation {
    private String mId;
    private int mPunctation;
    private String mDate;

    public Punctuation() {
        this.mId = UUID.randomUUID().toString();
        this.mPunctation = 0;
        this.mDate = "";
    }

    public Punctuation(int mPunctation, String mDate) {
        this.mId = UUID.randomUUID().toString();
        this.mPunctation = mPunctation;
        this.mDate = mDate;
    }

    public String getmId() {
        return mId;
    }

    public void setmId(String mId) {
        this.mId = mId;
    }

    public int getmPunctation() {
        return mPunctation;
    }

    public void setmPunctation(int mPunctation) {
        this.mPunctation = mPunctation;
    }

    public String getmDate() {
        return mDate;
    }

    public void setmDate(String mDate) {
        this.mDate = mDate;
    }
}
