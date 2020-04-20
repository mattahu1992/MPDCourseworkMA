/**
 * Matthew Alston
 * S1824614
 **/
package mpd.matthewalston.trafficscotlandmatthewborialston;

public class FeedItem {
    String title;
    String description;
    String link;
    String geoPoint;
    String pubDate;

    String IncidentsTitle;
    String IncidentsDescription;
    String IncidentsLink;
    String IncidentsGeoPoint;
    String IncidentsPubDate;

    public String getIncidentsTitle() {
        return IncidentsTitle;
    }

    public void setIncidentsTitle(String incidentsTitle)
    {
        IncidentsTitle = incidentsTitle;
    }

    public String getIncidentsDescription() {
        return IncidentsDescription;
    }

    public void setIncidentsDescription(String incidentsDescription) {
        IncidentsDescription = incidentsDescription;
    }

    public String getIncidentsLink() {
        return IncidentsLink;
    }

    public void setIncidentsLink(String incidentsLink)
    {
        IncidentsLink = incidentsLink;
    }

    public String getIncidentsGeoPoint()
    {
        return IncidentsGeoPoint;
    }

    public void setIncidentsGeoPoint(String incidentsGeoPoint) {
        IncidentsGeoPoint = incidentsGeoPoint;
    }

    public String getIncidentsPubDate()
    {
        return IncidentsPubDate;
    }

    public void setIncidentsPubDate(String incidentsPubDate) {
        IncidentsPubDate = incidentsPubDate;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getLink()
    {
        return link;
    }

    public void setLink(String link)
    {
        this.link = link;
    }

    public String getGeoPoint()
    {
        return geoPoint;
    }

    public void setGeoPoint(String geoPoint)
    {
        this.geoPoint = geoPoint;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate)
    {
        this.pubDate = pubDate;
    }

}
