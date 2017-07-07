package info.androidhive.snackbar;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private CoordinatorLayout coordinatorLayout;
    private Button btnSimpleSnackbar;
    private FloatingActionButton fab;
    private EditText text_user, text_pwd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        coordinatorLayout = (CoordinatorLayout) findViewById(R.id
                .coordinatorLayout);


        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        btnSimpleSnackbar = (Button) findViewById(R.id.btnSimpleSnackbar);
        text_user = (EditText) findViewById(R.id.text_username);
        text_pwd = (EditText) findViewById(R.id.text_password);


        // Setup FAB to show toast
        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                alert.setTitle("Sorry");
                alert.setMessage("You cannot sign-up at this time");
                alert.setPositiveButton("OK", null);
                alert.show();
            }
        });


        btnSimpleSnackbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!validateName() || !validatePassword()) {
                    return;
                }


                Snackbar snackbar = Snackbar
                        .make(coordinatorLayout, "Login Successful, Redirecting...", Snackbar.LENGTH_LONG);

                snackbar.show();
            }
        });
    }


    private boolean validateName() {
        if (text_user.getText().toString().isEmpty()) {

            Toast.makeText(getApplicationContext(), "Enter Your Username", Toast.LENGTH_SHORT).show();
            text_user.requestFocus();
            return false;
        }
        return true;
    }


    private boolean validatePassword() {
        if (text_pwd.getText().toString().isEmpty()) {

            Toast.makeText(getApplicationContext(), "You forgot to enter your password", Toast.LENGTH_SHORT).show();
            text_pwd.requestFocus();
            return false;
        }
        return true;
    }

}