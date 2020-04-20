/**
 * Matthew Alston
 * S1824614
 **/
package mpd.matthewalston.trafficscotlandmatthewborialston;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Filter;

import java.util.ArrayList;


public class Roadworks extends AppCompatActivity {
    RecyclerView recyclerView;
    MyAdaptor adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roadworks);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Roadworks");
        setSupportActionBar(toolbar);

        recyclerView= findViewById(R.id.recyclerView);
        ReadRss readRss = new ReadRss(this,recyclerView);
        readRss.execute();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater= getMenuInflater();
        inflater.inflate(R.menu.search_menu,menu);


        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) searchItem.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                if(adapter!=null){
                    adapter.getFilter().filter(s);
                }return false;
            }
        });

        return true;
    }
}
