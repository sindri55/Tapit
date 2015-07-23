package work.sindri.tapit1.activity;

import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;

import work.sindri.tapit1.R;
import work.sindri.tapit1.dialog.*;


public class LoginActivity extends FragmentActivity implements LoginDialogFragment.LoginDialogListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);
    }


    public void logIn(View view) {
        /*
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent); */
        LoginDialogFragment loginDialog = new LoginDialogFragment();
        loginDialog.show(getFragmentManager(), "Login_Dialog");
    }

    // The dialog fragment receives a reference to this Activity through the
    // Fragment.onAttach() callback, which it uses to call the following methods
    // defined by the NoticeDialogFragment.NoticeDialogListener interface
    @Override
    public void onDialogPositiveClick(DialogFragment dialog) {
        // User touched the dialog's positive button
        Intent intent = new Intent(this, SimplePayActivity.class);
        startActivity(intent);
        LoginActivity.this.finish();

    }

    @Override
    public void onDialogNegativeClick(DialogFragment dialog) {
        // User touched the dialog's negative button
    }

    @Override
    public void onDialogNeutralClick(DialogFragment dialog) {
        Intent intent = new Intent(this, RegisterUserActivity.class);
        startActivity(intent);
        LoginActivity.this.finish();

    }
}
