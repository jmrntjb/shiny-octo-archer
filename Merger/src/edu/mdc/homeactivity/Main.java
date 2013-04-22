package edu.mdc.homeactivity;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class Main extends Activity 
{
	// Variables
	private int headerCounter = 0;
	
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
     	RowInfo info = LoadingScreen.getRowInfo();
     	
     	// Set the size of the custom adapter
     	Integer[] adapterSize = new Integer[info.getSize()];
     	
     	// Explicitly mark the first URL as bad for testing purposes
     	info.setProductUrlStatus(0, 1);
     	
        // Custom Adapter
        DealAdapter adapter = new DealAdapter(this, R.layout.listview_item_row, adapterSize, info);   
               
        // List View
        ListView listView = (ListView)findViewById(R.id.myList);
         
        // Add a header from an XML Layout File
        View header = (View)getLayoutInflater().inflate(R.layout.listview_header_row, null);
        listView.addHeaderView(header);
        headerCounter++;
        
        // Add another header from an XML Layout File
        header = (View)getLayoutInflater().inflate(R.layout.listview_spinner_row, null);
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
            	System.out.println("Position: " + position);
            	
            	// Displays which item was selected IF the headerCounter is accurate
            	// Note: Headers in the ListView are also considered as items
            	String message = "You have selected item #" + (position - headerCounter + 1);            	
            	
            	// Only works starting at the first item IF the headerCounter is accurate
            	if (position >= headerCounter)
            		Toast.makeText(getBaseContext(), message, Toast.LENGTH_SHORT).show();
            }
        });
    }
    
    // Disable the back button
    @Override
    public void onBackPressed() {
    }
}