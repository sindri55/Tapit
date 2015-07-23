package work.sindri.tapit1.activity;

/**
 * Created by Sindri on 23/07/15.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import work.sindri.tapit1.R;


public class RegisterUserActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);
    }



    public void finishRegistration(View view) {
        Intent intent = (new Intent(this, LoginActivity.class ));
        startActivity(intent);
    }
}
