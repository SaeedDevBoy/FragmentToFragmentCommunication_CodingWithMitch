package com.example.fragmenttofragmentcommunication_codingwithmitch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements IMainActivity {

    private static final String TAG="MainActivity";
    //widget
    private TextView mToolbarTitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolbarTitle=findViewById(R.id.toolbar_title);

        init();
    }
    private void init()
    {
        SelectorFragment fragment=new SelectorFragment();
        doFragmentTransaction(fragment,getString(R.string.fragment_selector),false,"");
    }
    private void doFragmentTransaction(Fragment fragment, String tag, boolean addToBackStack, String message)
    {
        FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
        if(!message.equals(""))
        {
            Bundle bundle=new Bundle();
            bundle.putString(getString(R.string.intent_message),message);
            fragment.setArguments(bundle);
        }

        transaction.replace(R.id.mainContainer,fragment,tag);
        if(addToBackStack)
        {
            transaction.addToBackStack(tag);
        }
        transaction.commit();
    }

    @Override
    public void setToolBarTitle(String fragmentTag) {
        mToolbarTitle.setText(fragmentTag);
    }

    @Override
    public void inflateFragment(String fragmentTag, String message) {
        if(fragmentTag.equals(getString(R.string.fragment_a)))
        {
            AFragment fragment=new AFragment();
            doFragmentTransaction(fragment,fragmentTag,true,message);
        }
        else if(fragmentTag.equals(getString(R.string.fragment_b)))
        {

        }
        else if(fragmentTag.equals(getString(R.string.fragment_c)))
        {

        }
    }
}
