package info.androidhive.snackbar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    ArrayList<Team> teams;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // Lookup the recyclerview in activity layout
        RecyclerView rvContacts = (RecyclerView) findViewById(R.id.rvContacts);

        // Initialize teams
        teams = Team.createContactsList(26);



        // Create adapter passing in the sample user data
        TeamsAdapter adapter = new TeamsAdapter(this, teams);

        // Attach the adapter to the recyclerview to populate items
        rvContacts.setAdapter(adapter);

        // Set layout manager to position the items
        rvContacts.setLayoutManager(new LinearLayoutManager(this));

        //Round ImageView

//        ImageView imageround = (ImageView) findViewById(R.id.profile_picture);
//        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.yupdev_code);
//        RoundedBitmapDrawable roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(getResources(), bitmap);
//        roundedBitmapDrawable.setCircular(true);
//        imageround.setImageDrawable(roundedBitmapDrawable);

    }

}
