package com.theweatherguy;

public class RecyclerViewItem {
    private int mAnimation;
    private String mText1;
    private String mText2;

    public RecyclerViewItem(int imageResource, String text1, String text2) {
        mAnimation = imageResource;
        mText1 = text1;
        mText2 = text2;
    }

    public int getImageResource() {
        return mAnimation;
    }

    public String getText1() {
        return mText1;
    }

    public String getText2() {
        return mText2;
    }
}
