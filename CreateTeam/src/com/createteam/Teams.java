package com.createteam;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.*;
import android.util.*;
import android.view.*;

public class Teams extends Activity implements View.OnClickListener
{
    private static final String TeamTag = "Teams Activity";
	EditText etTeamName;
	DbAdapter dbAdapter = new DbAdapter(this);

    @Override
    public void onCreate ( Bundle savedInstanceState )
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teams);
		Log.d(TeamTag, TeamTag + " - start of onCreate.");

		etTeamName = (EditText) findViewById(R.id.etTeamName);
		Button bCreateTeam = (Button) findViewById(R.id.bCreateTeam);
		//ListView lvTeams = (ListView) findViewById(R.id.lvTeams);

		bCreateTeam.setOnClickListener(this);

		Log.d(TeamTag, TeamTag + " - end of onCreate.");
    }

	public void onClick ( View v )
	{
		switch(v.getId())
		{
		case R.id.bCreateTeam:
			String TeamName = etTeamName.getText().toString();

			try
			{
				dbAdapter.createTeam(TeamName);

				Log.d(TeamTag, "attempted to create team");
				Toast.makeText(this, "Creating team...", Toast.LENGTH_SHORT).show();
			} catch(Exception e) {
				Log.e(TeamTag, "Error creating team", e);
				Toast.makeText(this, "Sorry. there has been an error creating the team: " + e.toString(), Toast.LENGTH_LONG).show();
			} finally {
				Log.d(TeamTag, "Successfully created " + TeamName);
				Toast.makeText(this, "Successfully created " + TeamName, Toast.LENGTH_LONG).show();

				etTeamName.setText("");
				TeamName = null;
			}
			break;
		}
	}

    @Override
    public boolean onCreateOptionsMenu ( Menu menu )
	{
        getMenuInflater().inflate(R.menu.teams, menu);
        return true;
    }
}
