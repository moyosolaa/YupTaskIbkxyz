package info.androidhive.snackbar;

import java.util.ArrayList;

/**
 * Created by abc on 14/07/2017.
 */

public class Team {

    private String mName;
    private boolean mOnline;

    public Team(String name, boolean online) {
        mName = name;
        mOnline = online;
    }

    public String getName() {
        return mName;
    }

    public boolean isOnline() {
        return mOnline;
    }

    private static int lastContactId = 0;

    public static ArrayList<Team> createContactsList(int numContacts) {
        ArrayList<Team> teams = new ArrayList<Team>();

        for (int i = 1; i <= numContacts; i++) {

            teams.add(new Team("Team " + ++lastContactId, i <= numContacts / 2));
        }

        return teams;
    }
}