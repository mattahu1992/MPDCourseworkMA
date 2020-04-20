/**
 * Matthew Alston
 * S1824614
 **/
package mpd.matthewalston.trafficscotlandmatthewborialston;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MyAdaptor extends RecyclerView.Adapter<MyAdaptor.MyViewHolder> implements Filterable {
    ArrayList<FeedItem> feedItems;
    ArrayList<FeedItem> cloneFeedItems;
    Context context;

    public MyAdaptor(Context context, ArrayList<FeedItem> feedItems) {
        this.feedItems = feedItems;
        this.context = context;
        cloneFeedItems = new ArrayList<>(feedItems);
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.roadworks_row,parent,false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder( MyViewHolder holder, int position) {
        FeedItem current=feedItems.get(position);
        holder.Title.setText(current.getTitle());
        holder.PubDate.setText(current.getPubDate());
        holder.Description.setText(current.getDescription());
        holder.GeoPoint.setText(current.getGeoPoint());
        holder.Link.setText(current.getLink());
    }



    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView Title, PubDate, Description, GeoPoint, Link;
        public MyViewHolder(View itemView) {
            super(itemView);
            Title =itemView.findViewById(R.id.title_test);
            PubDate =itemView.findViewById(R.id.pubDate_text);
            Description=itemView.findViewById(R.id.description_text);
            GeoPoint=itemView.findViewById(R.id.geoPoint_text);
            Link=itemView.findViewById(R.id.link_text);
        }
    }
    @Override
    public int getItemCount() {
        return feedItems.size();
    }

    @Override
    public Filter getFilter() {
        return exampleFilter;
    }
    private Filter exampleFilter= new Filter(){

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            ArrayList<FeedItem> filteredList = new ArrayList<>();

            if(constraint==null || constraint.length()==0){
                filteredList.addAll(cloneFeedItems);
            }else{
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (FeedItem item: cloneFeedItems ){
                    if(item.getTitle().toLowerCase().contains(filterPattern)){
                        filteredList.add(item);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = filteredList;

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            feedItems.clear();
            feedItems.addAll((ArrayList)results.values);
            notifyDataSetChanged();
        }
    };
}