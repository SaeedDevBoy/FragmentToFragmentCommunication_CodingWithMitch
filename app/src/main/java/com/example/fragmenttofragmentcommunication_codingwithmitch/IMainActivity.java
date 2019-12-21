package com.example.fragmenttofragmentcommunication_codingwithmitch;

public interface IMainActivity {
    void setToolBarTitle(String fragmentTag);
    void inflateFragment(String fragmentTag,String message);
}
