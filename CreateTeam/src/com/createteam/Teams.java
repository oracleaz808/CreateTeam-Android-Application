package com.createteam;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.*;
import android.util.*;

public class Teams extends Activity {

    String TeamTag = "Teams Activity";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teams);
		Log.d(TeamTag, TeamTag + " - start of onCreate.");
		
		//EditText etTeamName = (EditText) findViewById(R.id.etTeamName);
		//Button bCreatTeam = (Button) findViewById(R.id.bCreateTeam);
		//ListView lvTeams = (ListView) findViewById(R.id.lvTeams);
		
		Log.d(TeamTag, TeamTag + " - end of onCreate.");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.teams, menu);
        return true;
    }
}
