/**
 * Created by nimbekl on 10/27/17.
 */

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.net.URLConnection;
import java.net.URL;
import org.w3c.dom.NodeList;
import java.util.*;
public class findDistanceProgress {
    public static void main(String args[]){
        ArrayList<Coordinates> coord = getXmlData();
        sortByDistance(coord);
    }
    static ArrayList<Coordinates> sortByDistance(ArrayList<Coordinates> coord){
        Collections.sort(coord, new SortByDistance());
        return coord;
    }
    static ArrayList<Coordinates> getXmlData(){
        ArrayList<Coordinates> coord = new ArrayList<Coordinates>();
        try {

            String url = "https://dl.dropboxusercontent.com/s/8nvqnasci6l76nz/Problem.gpx?dl=0";
            DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
            f.setNamespaceAware(false);
            f.setValidating(false);
            DocumentBuilder b = f.newDocumentBuilder();
            URLConnection urlConnection = new URL(url).openConnection();
            urlConnection.addRequestProperty("Accept", "application/xml");
            Document doc = b.parse(urlConnection.getInputStream());
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("trkpt");
            for (int temp = 0; temp < nList.getLength(); temp++) {

                Node nNode = nList.item(temp);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;

                    String timestamp = eElement.getElementsByTagName("time").item(0).getTextContent();
                    double lat = Double.valueOf(eElement.getAttribute("lat"));
                    double longitude = Double.valueOf(eElement.getAttribute("lon"));
                    double elevation = Double.valueOf(eElement.getElementsByTagName("ele").item(0).getTextContent());

                    Coordinates coordinates = new Coordinates(timestamp,elevation,lat,longitude);
                    coord.add(coordinates);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return coord;
    }
    //returns Distance in KM
    static double distanceBetweenTwoPoints(double lat1, double lat2, double lon1, double lon2, double el1, double el2){

            final int R = 6371;

            double latDistance = Math.toRadians(lat2 - lat1);
            double lonDistance = Math.toRadians(lon2 - lon1);
            double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                    + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                    * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
            double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
            double distance = R * c;

            double height = el1 - el2;

            distance = Math.pow(distance, 2) + Math.pow(height, 2);

            return Math.sqrt(distance);
    }
}
class Coordinates implements Comparable<Coordinates>{
    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public double getElevation() {
        return elevation;
    }

    public void setElevation(double elevation) {
        this.elevation = elevation;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    String timestamp;
    double elevation;
    double lat;
    double longitude;
    Coordinates(String timestamp,double elevation,double lat,double longitude){
        this.timestamp = timestamp;
        this.lat = lat;
        this.longitude = longitude;
        this.elevation = elevation;
    }
    public int compareTo(Coordinates c) {
        return (int)(this.elevation - c.elevation);
    }
}

class SortByDistance implements Comparator<Coordinates>{

    public int compare(Coordinates c1, Coordinates c2) {
        double lat1 = c1.getLat();
        double lat2 = c2.getLat();
        double lon1 = c1.getLongitude();
        double lon2 = c2.getLongitude();
        double ele1 = c1.getElevation();
        double ele2 = c2.getElevation();
        return (int)findDistanceProgress.distanceBetweenTwoPoints(lat1,lat2,lon1,lon2,ele1,ele2);
    }
}
class ElevationGained  {
    double ele;


}

