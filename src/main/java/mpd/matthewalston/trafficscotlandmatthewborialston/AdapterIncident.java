package mpd.matthewalston.trafficscotlandmatthewborialston;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterIncident extends RecyclerView.Adapter<AdapterIncident.MyViewHolder> {
    ArrayList<FeedItem> feedItemsInc;
    Context context;

    public AdapterIncident(Context context,ArrayList<FeedItem>feedItems){
       this.feedItemsInc=feedItems;
       this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.incidents_row,parent,false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        FeedItem current=feedItemsInc.get(position);
        holder.Title.setText(current.getIncidentsTitle());
        holder.PubDate.setText(current.getIncidentsPubDate());
        holder.Description.setText(current.getIncidentsDescription());
        holder.GeoPoint.setText(current.getIncidentsGeoPoint());
        holder.Link.setText(current.getIncidentsLink());

    }

    @Override
    public int getItemCount() {
        return feedItemsInc.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView Title, PubDate, Description, GeoPoint, Link;
        public MyViewHolder( View itemView) {
            super(itemView);

            Title =itemView.findViewById(R.id.title_test);
            PubDate =itemView.findViewById(R.id.pubDate_text);
            Description=itemView.findViewById(R.id.description_text);
            GeoPoint=itemView.findViewById(R.id.geoPoint_text);
            Link=itemView.findViewById(R.id.link_text);

        }
    }
}
