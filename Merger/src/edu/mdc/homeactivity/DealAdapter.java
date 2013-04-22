package edu.mdc.homeactivity;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

public class DealAdapter extends ArrayAdapter<Integer>
{
	// Constants
	private final int GOOD_URL = 0, BAD_URL = 1;
	
	// Variables
    private Context context; 
    private int layoutResourceId;   
    
    // Objects
    private RowInfo info;
    
    // Constructor
    public DealAdapter(Context context, int layoutResourceId, Integer[] size, RowInfo info) 
    {
    	// Call base constructor
        super(context, layoutResourceId, size);
        
        // Copy parameters into the members
        this.layoutResourceId = layoutResourceId;
        this.context 		  = context;
        this.info 			  = info;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {    	
        View row = convertView;        
        ImageView imgIcon;
        
        // If the row is empty
        if(row == null)
        {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);
            
            // Assign the ListView's ImageView component
            imgIcon = (ImageView) row.findViewById(R.id.imgIcon);
            
            // Set the row's Tag
            // Tag Definition Can Be Found Here: http://developer.android.com/reference/android/view/View.html 
            // In this case, the Tag is the image itself which can then be retrieved later
            row.setTag(imgIcon);
        }
        
        else
        {
        	// Assign the row's ImageView
        	imgIcon = (ImageView) row.getTag();
        }
  
        // If for some reason the Row Info hasn't been initialized
        // Then set the bad URL image and return the row
        if (info == null)
        {
        	imgIcon.setImageResource(R.drawable.cancel);
        	return row;
        }
        
        // If the current row URL is good        
        if (info.getProductUrlStatus(position) == GOOD_URL)
        {
		    // Update the image with current bitmap
		    imgIcon.setImageBitmap(info.getProductBitmap(position)); 
        }        
        
        // If the current row URL is bad
        else if(info.getProductUrlStatus(position) == BAD_URL)
        {
        	// Set the resource with a specific image to warn the user that the URL was not found
        	imgIcon.setImageResource(R.drawable.cancel);
        }
 
        // Return the row with updated info
        return row;
    }
}