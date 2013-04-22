package edu.mdc.homeactivity;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;

public class LoadingScreen extends Activity
{
	// Constants
	private final int GOOD_URL = 0, BAD_URL = 1;
	
	// Objects
	private ProgressDialog progressDialog;	
    private static DealInfoManager manager; 
    private static DealDataProcess process;
    private static RowInfo info;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
    	super.onCreate(savedInstanceState);
    	
    	// Initialize a LoadViewTask object and call the execute() method
    	new LoadViewTask().execute();    	
    }

    // To use the AsyncTask, it must be sub-classed
    private class LoadViewTask extends AsyncTask<Void, Integer, Void>
    {
    	// Before running code in separate thread
		@Override
		protected void onPreExecute()
		{
			// Progress Dialog
			progressDialog = ProgressDialog.show(LoadingScreen.this,"Loading...",  
				    "Collecting information, please wait...", false, false); 
			
			// Deal Data Process 
	        process = new DealDataProcess("getMicroLocation", "http://tempuri.org/", 
	        		"http://cop2662.site90.net/cop2662/MicroLocServer.php");
	        
	        // Deal Info Manager. NOTE: This constructor is for testing purposes only! All DealInfoContainer objects have the same values until modified.
	        manager = new DealInfoManager(0, "http://www.mdc.edu/kendall/mathcompetition/images/MDClogo.jpg", "http://www.tnooz.com/wp-content/uploads/2011/02/ITA-QR-code-1.jpg");
	        	        
	        // Initialize RowInfo
	        info = new RowInfo(manager.getSize());
		}

		//The code to be executed in a background thread.
		@Override
		protected Void doInBackground(Void... params)
		{			
			// Process SOAP method
	        process.getSOAP();
	        
	        // Get bitmaps from the URLs
			getBitmaps();
	        
			// This method has to return null
			return null;
		}

		// Update the progress
		@Override
		protected void onProgressUpdate(Integer... values)
		{

		}

		// After executing the code in the thread
		@Override
		protected void onPostExecute(Void result)
		{
			// Close the progress dialog
			progressDialog.dismiss();
			
			// Start the HomeActivity
			startActivity(new Intent(LoadingScreen.this, HomeActivity.class));	
		}
		
		// Get Bitmaps from the URLs
		private void getBitmaps()
		{
			// Get the URLs
			info.setProductUrlsArray(manager.getImageURLs());
			info.setQrCodeUrlsArray(manager.getQRCodeURLs());
			
			// Get the bitmaps and URL statuses for the products
			for (int i = 0; i < manager.getSize(); i++)
        	{
		        try 
				{		        	
					// Try to store the Bitmap from the URL
					// Note: This line is what throw the exceptions
					info.setProductBitmap(i, BitmapFactory.decodeStream((InputStream)new URL(info.getProductUrls(i)).getContent()));
					
					// If we've reached this line, then it means we're fine
					// So set the current URL as good
					info.setProductUrlStatus(i, GOOD_URL);
				} 
				
				catch (MalformedURLException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
					
					// If we've reached this line, then it means we've caught an exception
					// So set the current URL as bad
					info.setProductUrlStatus(i, BAD_URL);
				} 
				
				catch (IOException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
					
					// If we've reached this line, then it means we've caught an exception
					// So set the current URL as bad
					info.setProductUrlStatus(i, BAD_URL);
				}     
        	}
			
			// Get the bitmaps and URL statuses for the QR codes
			for (int j = 0; j < manager.getSize(); j++)
        	{
		        try 
				{		        	
					// Try to store the Bitmap from the URL
					// Note: This line is what throw the exceptions
					info.setQrCodeBitmap(j, BitmapFactory.decodeStream((InputStream)new URL(info.getQrCodeUrls(j)).getContent()));
					
					// If we've reached this line, then it means we're fine
					// So set the current URL as good
					info.setQrCodeUrlStatus(j, GOOD_URL);
				} 
				
				catch (MalformedURLException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
					
					// If we've reached this line, then it means we've caught an exception
					// So set the current URL as bad
					info.setQrCodeUrlStatus(j, GOOD_URL);
				} 
				
				catch (IOException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
					
					// If we've reached this line, then it means we've caught an exception
					// So set the current URL as bad
					info.setQrCodeUrlStatus(j, GOOD_URL);
				}
        	}
		}		
    }
    
    // This method returns the Deal Data Process 
    public static DealDataProcess getDealDataProcess()
    {
		return process;    	
    }
    
    // This method returns the Row Info
    public static RowInfo getRowInfo()
	{
		return info;		
	}
    
    // This method returns the Manager
    public static DealInfoManager getManager()
	{
		return manager;		
	}
}
