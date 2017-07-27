import java.net.*;         // needed for URL
import java.io.*;          // needed for Stream and Buffer readers
/**
 * This program will display the weather at Duluth.
 * 
 * @Daniela Moreno 
 * @November 18,2016
 */
public class Weather
{

    public static void main(String[] args) throws Exception
    {
        // assign the URL for the web address from the Duluth weather file
        URL weatherURL = new URL("http://w1.weather.gov/xml/current_obs/KDLH.xml");
        // read the weather file in to a buffer
        BufferedReader inFile = new BufferedReader(new InputStreamReader(weatherURL.openStream()));                
        String weatherLine;            // used to hold one line from the weather file

        System.out.println("The current Duluth weather" );

        weatherLine = inFile.readLine();       // read in the first line of the weather file
        // Loop through the entire weather file one line at a time until the end when the weatherLine will be null
        while (weatherLine != null) {

            // You must change the following code to only print out the weather you want to display
            if(weatherLine.indexOf("<weather>") >= 0) {
                System.out.print("The condition is: " );
                int endPoint = weatherLine.indexOf("</weather>");
                System.out.println(weatherLine.substring(10,endPoint));          // prints out every line of the weather file for now
            }

            if(weatherLine.indexOf("<temp_f>") >= 0) {
                System.out.print("The temperature is: ");
                int endPoint = weatherLine.indexOf("</temp_f>");
                System.out.print(weatherLine.substring(9,endPoint));
                System.out.println(" " + "degrees fahrenheit");
            }

            if(weatherLine.indexOf("<wind_mph>") >= 0) {
                System.out.print("The wind speed is: ");
                int endPoint = weatherLine.indexOf("</wind_mph>");
                System.out.print(weatherLine.substring(11,endPoint));
                System.out.println(" " + "mph");
            }

            // read in the next line of the file -- do not change this
            weatherLine = inFile.readLine();
        }

     
    }
}