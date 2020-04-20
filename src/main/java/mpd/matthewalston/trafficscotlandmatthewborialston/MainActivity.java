/**
 * Matthew Alston
 * S1824614
 **/
package mpd.matthewalston.trafficscotlandmatthewborialston;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button incidents;
    private Button roadworks;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        incidents = (Button) findViewById(R.id.incidents);
        incidents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityIncidents();
            }
        });


        roadworks = (Button) findViewById(R.id.roadworks);
        roadworks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityRoadworks();
            }
        });

    }

    private void openActivityIncidents() {
        Intent intent = new Intent(this, Incidents.class);
        startActivity(intent);
    }

    public void openActivityRoadworks(){
        Intent intent = new Intent(this, Roadworks.class);
        startActivity(intent);
    }
}
