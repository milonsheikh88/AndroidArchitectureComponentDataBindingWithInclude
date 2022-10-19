package com.milonsheikh.databindingwhitInclude;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.milonsheikh.databindingwhitInclude.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding myBinding;
    private MainActivityClickHandler myHandler;

    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        myBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        myHandler = new MainActivityClickHandler(this);

        user = new User();
        user.setName("Milon Sheikh");
        user.setAddress("Dhaka, Bangladesh");
        user.setFollowerCount("1000");
        user.setFollowingCount("500");

        myBinding.setUser(user);
        myBinding.setHandler(myHandler);

    }

    public class MainActivityClickHandler {
        Context myContext;
        int score=0;
        public MainActivityClickHandler(Context myContext) {
            this.myContext = myContext;
        }

        public void onBtnFollowClick(View view, User user) {
            score= Integer.parseInt(user.getFollowerCount());
            String follower=String.valueOf(++score);

            user.setFollowerCount(follower);
            Toast.makeText(myContext, "Now you are following " + user.getName(), Toast.LENGTH_SHORT).show();
        }
    }
}