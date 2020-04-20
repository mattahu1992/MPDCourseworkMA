/**
 * Matthew Alston
 * S1824614
 **/
package mpd.matthewalston.trafficscotlandmatthewborialston;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class ReadIncidentRSS extends AsyncTask<Void,Void,Void> {
    Context context;
    String address = "https://trafficscotland.org/rss/feeds/currentincidents.aspx";
    ProgressDialog progressDialog;
    ArrayList<FeedItem>feedItemsInc;
    RecyclerView recyclerView2;
    URL url;
    public ReadIncidentRSS(Context context, RecyclerView recyclerView){
        this.recyclerView2=recyclerView;
        this.context=context;
        progressDialog=new ProgressDialog(context);
        progressDialog.setMessage("Loading Feed...");
    }
    @Override
    protected void onPreExecute() {
        progressDialog.show();
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        progressDialog.dismiss();
        AdapterIncident adapter =new AdapterIncident(context,feedItemsInc);
        recyclerView2.setLayoutManager(new LinearLayoutManager(context));
        recyclerView2.setAdapter(adapter);

    }

    @Override
    protected Void doInBackground(Void... voids) {
        ProcessXML(Getdata());

        return null;
    }

    private void ProcessXML(Document data) {
        if(data!=null) {
            feedItemsInc=new ArrayList<>();
            Element root = data.getDocumentElement();
            Node channel = root.getChildNodes().item(1);
            NodeList items = channel.getChildNodes();
            for(int i=0;i<items.getLength();i++){
                Node currentchild=items.item(i);
                if(currentchild.getNodeName().equalsIgnoreCase("item")){
                    FeedItem item = new FeedItem();
                    NodeList itemchilds=currentchild.getChildNodes();
                    for(int j=0;j<itemchilds.getLength();j++) {
                        Node cureent = itemchilds.item(j);
                        if (cureent.getNodeName().equalsIgnoreCase("title")) {
                            item.setIncidentsTitle(cureent.getTextContent());
                        } else if (cureent.getNodeName().equalsIgnoreCase("description")) {
                            item.setIncidentsDescription(cureent.getTextContent());
                        } else if (cureent.getNodeName().equalsIgnoreCase("link")) {
                            item.setIncidentsLink(cureent.getTextContent());
                        } else if (cureent.getNodeName().equalsIgnoreCase("georss:point")) {
                            item.setIncidentsGeoPoint(cureent.getTextContent());
                        } else if (cureent.getNodeName().equalsIgnoreCase("pubDate")) {
                            item.setIncidentsPubDate(cureent.getTextContent());
                        }
                    }
                    feedItemsInc.add(item);
                    Log.d("itemTitle", item.getIncidentsTitle());
                    Log.d("itemDescription", item.getIncidentsDescription());
                    Log.d("itemLink", item.getIncidentsLink());
                    Log.d("itemGeo", item.getIncidentsGeoPoint());
                    Log.d("itemPubDate", item.getIncidentsPubDate());
                }
            }
        }
    }

    public Document Getdata() {
        try {
            url=new URL(address);
            HttpURLConnection connection= (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            InputStream inputStream=connection.getInputStream();
            DocumentBuilderFactory builderFactory=DocumentBuilderFactory.newInstance();
            DocumentBuilder builder=builderFactory.newDocumentBuilder();
            Document xmlDoc=builder.parse(inputStream);
            return xmlDoc;
        } catch (IOException | ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        }
        return null;
    }

}

