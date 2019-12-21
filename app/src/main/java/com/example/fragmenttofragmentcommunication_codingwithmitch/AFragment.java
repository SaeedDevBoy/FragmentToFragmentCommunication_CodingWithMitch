package com.example.fragmenttofragmentcommunication_codingwithmitch;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.nio.charset.MalformedInputException;

public class AFragment extends Fragment {
    private static final String TAG = "Fragment A";
    //vars
    private IMainActivity mIMainActivity;
    private String strIncomingMessage="";
    //widgets
    private TextView incomingMessage;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(mIMainActivity!=null)
        {
            mIMainActivity.setToolBarTitle(getTag());
        }
        Bundle bundle=this.getArguments();
        if(bundle!=null)
        {
            strIncomingMessage=bundle.getString(getString(R.string.intent_message));

        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_a,container,false);
        incomingMessage=view.findViewById(R.id.incoming_message);
        setIncomingMessage();
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mIMainActivity=(IMainActivity) getActivity();
    }
    private void setIncomingMessage()
    {
        if(!strIncomingMessage.equals(""))
        {
            incomingMessage.setText(strIncomingMessage);
        }
    }
}
