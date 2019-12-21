package com.example.fragmenttofragmentcommunication_codingwithmitch;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


public class SelectorFragment extends Fragment implements View.OnClickListener {
    private static final String TAG = "SelectorFragment";


    //vars
    String strError;
    String strMessage;
    private IMainActivity mIMainActivity;
    //widgets
    EditText message;
    Button btnFragmentA, btnFragmentB, btnFragmentC;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //mIMainActivity.setToolBarTitle(TAG);
        try {
            if (mIMainActivity != null) {
                mIMainActivity.setToolBarTitle(getTag());
            }
        } catch (Exception exp) {
            strError = exp.getMessage();
        }

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_selector, container, false);
        btnFragmentA = view.findViewById(R.id.btn_fragment_a);
        btnFragmentB = view.findViewById(R.id.btn_fragment_b);
        btnFragmentC = view.findViewById(R.id.btn_fragment_c);
        btnFragmentA.setOnClickListener(this);
        btnFragmentB.setOnClickListener(this);
        btnFragmentC.setOnClickListener(this);

        message=view.findViewById(R.id.message);

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        //mIMainActivity = (IMainActivity) context;//both of them are true
        mIMainActivity = (IMainActivity) getActivity();//both of them are true
    }

    @Override
    public void onClick(View v) {
        strMessage=message.getText().toString();
        switch (v.getId()) {
            case R.id.btn_fragment_a:
                if(mIMainActivity!=null)
                    mIMainActivity.inflateFragment(getString(R.string.fragment_a),strMessage);
                break;
            case R.id.btn_fragment_b:
                break;
            case R.id.btn_fragment_c:
                break;
        }
    }
}
