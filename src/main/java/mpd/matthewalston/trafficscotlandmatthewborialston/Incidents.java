/**
 * Matthew Alston
 * S1824614
 **/
package mpd.matthewalston.trafficscotlandmatthewborialston;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

public class Incidents extends AppCompatActivity {
    RecyclerView recyclerView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_incidents);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Incidents");
        setSupportActionBar(toolbar);

        recyclerView2= (RecyclerView) findViewById(R.id.recyclerView);
        ReadIncidentRSS readRss=new ReadIncidentRSS(this,recyclerView2);

        readRss.execute();

    }
}
