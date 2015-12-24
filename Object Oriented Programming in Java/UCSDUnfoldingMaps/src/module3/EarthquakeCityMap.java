package module3;

//Java utilities libraries
import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Comparator;
import java.util.List;

//Processing library
import processing.core.PApplet;

//Unfolding libraries
import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.marker.Marker;
import de.fhpotsdam.unfolding.data.PointFeature;
import de.fhpotsdam.unfolding.marker.SimplePointMarker;
import de.fhpotsdam.unfolding.providers.Google;
import de.fhpotsdam.unfolding.providers.MBTilesMapProvider;
import de.fhpotsdam.unfolding.utils.MapUtils;

//Parsing library
import parsing.ParseFeed;

/** EarthquakeCityMap
 * An application with an interactive map displaying earthquake data.
 * Author: UC San Diego Intermediate Software Development MOOC team
 * @author Your name here
 * Date: July 17, 2015
 * */
public class EarthquakeCityMap extends PApplet {

	// You can ignore this.  It's to keep eclipse from generating a warning.
	private static final long serialVersionUID = 1L;

	// IF YOU ARE WORKING OFFLINE, change the value of this variable to true
	private static final boolean offline = false;
	
	// Less than this threshold is a light earthquake
	public static final float THRESHOLD_MODERATE = 5;
	// Less than this threshold is a minor earthquake
	public static final float THRESHOLD_LIGHT = 4;

	/** This is where to find the local tiles, for working without an Internet connection */
	public static String mbTilesString = "blankLight-1-3.mbtiles";
	
	// The map
	private UnfoldingMap map;
	
	//feed with magnitude 2.5+ Earthquakes
	private String earthquakesURL = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/2.5_week.atom";

	
	public void setup() {
		size(950, 600, OPENGL);

		if (offline) {
		    map = new UnfoldingMap(this, 200, 50, 700, 500, new MBTilesMapProvider(mbTilesString));
		    earthquakesURL = "2.5_week.atom"; 	// Same feed, saved Aug 7, 2015, for working offline
		}
		else {
			map = new UnfoldingMap(this, 200, 50, 700, 500, new Google.GoogleMapProvider());
			// IF YOU WANT TO TEST WITH A LOCAL FILE, uncomment the next line
			//earthquakesURL = "2.5_week.atom";
		}
		
	    map.zoomToLevel(2);
	    MapUtils.createDefaultEventDispatcher(this, map);	
			
	    // The List you will populate with new SimplePointMarkers
	    List<Marker> markers = new ArrayList<Marker>();

	    //Use provided parser to collect properties for each earthquake
	    //PointFeatures have a getLocation method
	    List<PointFeature> earthquakes = ParseFeed.parseEarthquake(this, earthquakesURL);
	    
	    // These print statements show you (1) all of the relevant properties 
	    // in the features, and (2) how to get one property and use it
	    if (earthquakes.size() > 0) {
	    	PointFeature f = earthquakes.get(0);
	    	System.out.println(f.getProperties());
	    	Object magObj = f.getProperty("magnitude");
	    	float mag = Float.parseFloat(magObj.toString());
	    	// PointFeatures also have a getLocation method
	    }
	    
	    
	    // construct SimplePointMarkers according to earthquakes
	    constructSimplePointMarker(earthquakes, markers);
	    // change color and radius based on magnitude
	    changeColorAndRadius(markers);
	    // add markers
	    map.addMarkers(markers);
	}
		
	private void changeColorAndRadius(List<Marker> markers) {
		for(int i = 0; i < markers.size(); i++){
			// get magnitude of marker
			float mag = Float.parseFloat(markers.get(i).getProperty("magnitude").toString());
			if(mag > THRESHOLD_MODERATE){
				// set heavy earthquake to red, radius = 5
				markers.get(i).setColor(color(255, 0, 0));
				((SimplePointMarker) markers.get(i)).setRadius(20);
			}else if(THRESHOLD_LIGHT < mag){
				// set moderate earthquake to lime
				markers.get(i).setColor(color(0, 255, 0));
				((SimplePointMarker) markers.get(i)).setRadius(10);
			}else{
				// set light earthquake to yellow
				markers.get(i).setColor(color(0, 0, 255));
				((SimplePointMarker) markers.get(i)).setRadius(5);
			}
		}
		
	}

	// A suggested helper method that takes in an earthquake feature and 
	// returns a SimplePointMarker for that earthquake
	private SimplePointMarker createMarker(PointFeature feature)
	{
		// construct SimplePointMarker based on loc and properties
		return new SimplePointMarker(feature.getLocation(), feature.getProperties());
	}
	
	// construct a list of SimplePointMarkers based on PointFeatures
	private void constructSimplePointMarker(List<PointFeature> pointFeatures, List<Marker> markers){
		for(PointFeature pointFeature : pointFeatures){
			markers.add(createMarker(pointFeature));
		}
	}
	
	public void draw() {
	    background(10);
	    map.draw();
	    addKey();
	}


	// helper method to draw key in GUI
	// TODO: Implement this method to draw the key
	private void addKey() 
	{	
		// add key using processing library
		fill(color(255, 255, 255));
		rect(25, 50, 150, 250, 7);
		
		String header = "Earthquake Key";
		String heavyEarthquake = "5.0+ Magnitude";
		String moderateEarthquake = "4.0+ Magnitude";
		String lightEarthquake = "Below 4.0";
		
		// add circle
		fill(color(255, 0, 0));
		ellipse(40, 110, 20, 20);
		fill(color(0, 255, 0));
		ellipse(40, 160, 10, 10);
		fill(color(0, 0, 255));
		ellipse(40, 210, 5, 5);
		
		// add text
		fill(color(0, 0, 0));
		text(header, 50, 75);
		text(heavyEarthquake, 70, 115);
		text(moderateEarthquake, 70, 165);
		text(lightEarthquake, 70, 215);
	
	}
}
