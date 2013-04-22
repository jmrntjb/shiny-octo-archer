package edu.mdc.homeactivity;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import android.content.Context;
import android.widget.Toast;

public class DealDataProcess 
{
	// Our web service method name
	private String METHOD_NAME;
	
	// Here package name in web service with reverse order.
	private String NAMESPACE;
	
	// You must use IP address here, don’t use Host-name or local-host
	private String URL;
	
	// Used for for testing purposes
	private String  result;
	
	// Constructor
	public DealDataProcess(String METHOD_NAME, String NAMESPACE, String URL)
	{
		// Update members
		this.METHOD_NAME = METHOD_NAME;
		this.NAMESPACE   = NAMESPACE;
		this.URL		 = URL;
	}

	/**************************************************************/
	/* This method does all the steps necessary to perform KSOAP. */
	/**************************************************************/
    public void getSOAP() 
    {
    	// SOAP_ACTION is only a combination of two members
        final String SOAP_ACTION = NAMESPACE + METHOD_NAME;

        try 
        { 
        	// SOAP request
            SoapObject Request = new SoapObject(NAMESPACE, METHOD_NAME);
            
            // List of malls
            MallLocation dadelandMall 		= new MallLocation(25.689309, -80.313578);
            /*MallLocation aventuraMall 	= new MallLocation(25.957016, -80.146286);
            MallLocation balHarbourShops 	= new MallLocation(25.88825,  -80.12519);
            MallLocation baySideMarketplace = new MallLocation(25.77831,  -80.186452);
            MallLocation cocoWalk 			= new MallLocation(25.72874,  -80.24209);
            MallLocation dolphinMall 		= new MallLocation(25.7516,   -80.3806);      
            MallLocation wolfsonCampus 		= new MallLocation(25.77759,  -80.191225);
            MallLocation browardMall 		= new MallLocation(26.117671, -80.254888);*/
            
            // Parameters required by the web service method
            Request.addProperty("latitude", dadelandMall.latitude);
            Request.addProperty("longitude", dadelandMall.longitude);
            
            // Create a SOAP Envelope
            SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
            
            // Web service uses .NET, so set flag to true
            soapEnvelope.dotNet = true;
            
            // Set the request parameters
            soapEnvelope.setOutputSoapObject(Request);
            
            new MarshalDouble().register(soapEnvelope);
            
            // Create an HTTP Transport object to send the web service request
            HttpTransportSE transport= new HttpTransportSE(URL);

            // Make the web service invocation
            // Note: I believe this line is what throws the Exception
            transport.call(SOAP_ACTION, soapEnvelope);          
            
            // Store the web service's response
            SoapObject result = (SoapObject) soapEnvelope.getResponse();
            
            // Store the properties inside a string to display
            this.result = "Mall ID: " + (String) result.getProperty(0) + "\nMall Description: " + (String) result.getProperty(1);
            
            // Store the properties one by one
            String mall_id = (String) result.getProperty(0);
            String mall_description = (String) result.getProperty(1);
            
            // Display the properties
            System.out.println("Successfully connected to server: \n");
            System.out.println("Mall ID: " + mall_id);
            System.out.println("Mall Description: " + mall_description);
        }
        
        catch(Exception ex) 
        {
        	// Output the error
        	System.out.println("Failed to connect to server");
        	System.out.println("Error: " + ex.getMessage());
        }  
    }
    
    /*******************************************************/
	/* This method displays a Toast with the KSOAP result. */
	/*******************************************************/
    public void makeToast(Context context)
    {
    	Toast.makeText(context, result, Toast.LENGTH_LONG).show();
    }
    
    private class MallLocation
    {
    	double latitude;
    	double longitude;
    	
    	public MallLocation(double lat, double lon)
    	{
    		latitude = lat;
    		longitude = lon;
    	}
    }
}