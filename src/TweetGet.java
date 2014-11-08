import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import twitter4j.FilterQuery;
import twitter4j.GeoLocation;
import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;
import twitter4j.TwitterException;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.conf.ConfigurationBuilder;

/**
 * <p>This is a code example of Twitter4J Streaming API - sample method support.<br>
 * Usage: java twitter4j.examples.PrintSampleStream<br>
 * </p>
 *
 * @author Yusuke Yamamoto - yusuke at mac.com
 */
public final class TweetGet {
    /**
     * Main entry of this application.
     *
     * @param args
     */
    public static void main(String[] args) throws TwitterException {
    	//just fill this
    	 ConfigurationBuilder cb = new ConfigurationBuilder();
         cb.setDebugEnabled(true)
           .setOAuthConsumerKey("3Kktb0l1UNbhcl7FRE9yG7nup")
           .setOAuthConsumerSecret("5SmGM2fwpFIScXMNni7mjAyRjLdm3VzuCFIWEqxlfxP2XHBa9X")
           .setOAuthAccessToken("2850340685-vBupqaDe3i7JNlERnTW3JPxwZmwoxS20rqj5zRu")
           .setOAuthAccessTokenSecret("CCgu0D6F5iN7RJY0joSwCFs5xl6L7PIsOIZaLfM9CVcuU");
         
        TwitterStream twitterStream = new TwitterStreamFactory(cb.build()).getInstance();
        StatusListener listener = new StatusListener() {
            @Override
            public void onStatus(Status status) {
            	GeoLocation location = status.getGeoLocation();
                if(location != null){
             String Name;
             String Status;
             Double Latitude;
             Double Longitude;
             ArrayList<Dataset> dataset = new ArrayList<Dataset>();
             Dataset objDataset = new Dataset();
             
             try {
            	 Name = status.getUser().getScreenName();
				 Status = status.getText();
				 Latitude = location.getLatitude();
				 Longitude = location.getLongitude();
				 System.out.println("Name: "+ Name ); // " - " + status.getText() + " - " + location.getLatitude() + " - " + location.getLongitude());
				 System.out.println("Status: "+ Status );
				 System.out.println("Latitude: "+ Latitude );
				 System.out.println("Longitude: "+ Longitude );
				 System.out.println(" ");
				 
				 objDataset.setName(Name);
				 objDataset.setStatus(Status);
				 objDataset.setLatitude(Latitude);
				 objDataset.setLongitude(Longitude);
				 dataset.add(objDataset);
				 
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
                }
                Connection conn = null;
                try
        		{
        			Class.forName("oracle.jdbc.driver.OracleDriver");
        			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/tweetmap", "root", "");

        			Statement st=conn.createStatement();
        			ResultSet rs=st.executeQuery("select longitude, latitude from tweetlocation");
        			
        			
        			
        			while(rs.next())
        			{
        				
        			}
        		}
        		catch(Exception Ex)
        		{
        			Ex.printStackTrace();
        			
        		}

            }
            
            @Override
            public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {
                System.out.println("Got a status deletion notice id:" + statusDeletionNotice.getStatusId());
            }

            @Override
            public void onTrackLimitationNotice(int numberOfLimitedStatuses) {
                System.out.println("Got track limitation notice:" + numberOfLimitedStatuses);
            }

            @Override
            public void onScrubGeo(long userId, long upToStatusId) {
                System.out.println("Got scrub_geo event userId:" + userId + " upToStatusId:" + upToStatusId);
            }

            @Override
            public void onStallWarning(StallWarning warning) {
                System.out.println("Got stall warning:" + warning);
            }

            @Override
            public void onException(Exception ex) {
                ex.printStackTrace();
            }
        };
        
        twitterStream.addListener(listener);
        twitterStream.sample();
        
        double boundingBox[][]= {{-180, -90}, {180, 90}}; 
		 FilterQuery filter = new FilterQuery();
		  filter.locations(boundingBox);
		  //twitterStream.addListener(listener);
		  twitterStream.filter(filter);
    }
}
