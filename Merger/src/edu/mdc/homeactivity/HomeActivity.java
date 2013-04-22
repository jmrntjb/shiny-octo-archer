package edu.mdc.homeactivity;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class HomeActivity extends Activity 
{
	// Variables
	private int headerCounter = 0;
	private RowInfo info;
	
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);         
        setContentView(R.layout.activity_home);    
        
        // Deal Data Process
        DealDataProcess process = LoadingScreen.getDealDataProcess();
        
        // Display KSOAP result
     	process.makeToast(getBaseContext()); 
     	
     	// Row Info
     	info = LoadingScreen.getRowInfo();
     	
     	// Set the size of the custom adapter
     	Integer[] adapterSize = new Integer[info.getSize()];
     	
        // Custom Adapter
        DealAdapter adapter = new DealAdapter(this, R.layout.listview_item_row, adapterSize, info);   
               
        // List View
        ListView listView = (ListView)findViewById(R.id.myList);
         
        // Add another header from an XML Layout File
        View header = (View)getLayoutInflater().inflate(R.layout.listview_spinner_row, null);
        listView.addHeaderView(header);
        headerCounter++;
        
        // Add a header from an XML Layout File
        header = (View)getLayoutInflater().inflate(R.layout.listview_header_row, null);
        listView.addHeaderView(header);
        headerCounter++;         
        
        // Set the custom adapter to the ListView
        listView.setAdapter(adapter);
        
        // When the user clicks on an item on the list
        listView.setOnItemClickListener(new ListView.OnItemClickListener() 
        {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int position, long l) 
            {
            	position -= headerCounter;
            	
            	// Displays which item was selected IF the headerCounter is accurate
            	// Note: Headers in the ListView are also considered as items
            	String message = "You have selected item #" + (position + 1);            	
            	
            	// Only works starting at the first item IF the headerCounter is accurate
            	if (position >= 0)
            	{
            		Toast.makeText(getBaseContext(), message, Toast.LENGTH_SHORT).show();
            	
	            	// If the corresponding URL is set a good
	            	if (info.getProductUrlStatus(position) == 0)
	            	{
	            		// Lunch the deal's details
		            	startActivity(new Intent(HomeActivity.this, TabsActivity.class));
		            	DetailActivity.setDealNumber(position);
	            	}
	            	
	            	else
	            	{
	            		// Display an error toast
	            		message = "Cannot launch details: Bad URL!";
	            		Toast.makeText(getBaseContext(), message, Toast.LENGTH_LONG).show();
	            	}
            	}
            }
        });
    }
    
    // Disable the back button
    @Override
    public void onBackPressed() {
    }
}