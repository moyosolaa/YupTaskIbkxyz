package info.androidhive.snackbar;

import android.app.AlertDialog;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

/**
 * Created by abc on 14/07/2017.
 */

public class TeamsAdapter extends RecyclerView.Adapter<TeamsAdapter.ViewHolder> {

    // Store a member variable for the teams
    private List<Team> mTeams;
    // Store the context for easy access
    private Context mContext;




    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView nameTextView;
        public Button messageButton;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            nameTextView = (TextView) itemView.findViewById(R.id.contact_name);
            messageButton = (Button) itemView.findViewById(R.id.message_button);
        }

    }

    // Pass in the contact array into the constructor
    public TeamsAdapter(Context context, List<Team> teams) {
        mTeams = teams;
        mContext = context;
    }

    // Easy access to the context object in the recyclerview
    private Context getContext() {
        return mContext;
    }


    /*METHODS AUTO-CREATED BY CLASS
    *
    *
    *
    * */

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);


        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.team_list, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;

    }


    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        // Get the data model based on position
        Team team = mTeams.get(position);

        // Set item views based on your views and data model
        final TextView textView = viewHolder.nameTextView;
        textView.setText(team.getName());
        Button button = viewHolder.messageButton;
        button.setText("Join");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alert = new AlertDialog.Builder(getContext());
                alert.setTitle("Terms & Conditions");
                alert.setMessage("By joining " + textView.getText() + ", you agree to the team's Terms and Conditions. Read terms here");
                alert.setPositiveButton("OK", null);
                alert.show();
            }
        });
    }


    @Override
    public int getItemCount() {
        return mTeams.size();
    }

}