package edu.mdc.homeactivity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends Activity 
{
	// Variables
	private TextView txtUrl;
	private ImageView imgProduct;
	private ImageView imgQR;	
	private static int dealNumber; 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tab2);
		
		// Get the corresponding DealInfoContainer
		DealInfoContainer container = LoadingScreen.getManager().getDealInfoContainer(dealNumber);
		
		// Set the layout's text with the URL
		txtUrl = (TextView)findViewById(R.id.txtUrl);
		txtUrl.setText("Deal Info Container ID: " + container.getID() + "\n\n" + LoadingScreen.getRowInfo().getQrCodeUrls(dealNumber));
		
		// Set the layout's image bitmap
		imgQR = (ImageView)findViewById(R.id.imgView); 				
		imgQR.setImageBitmap(LoadingScreen.getRowInfo().getProductBitmap(dealNumber));
		
		// Set the layout's image bitmap
		imgQR = (ImageView)findViewById(R.id.imgViewQr); 				
		imgQR.setImageBitmap(LoadingScreen.getRowInfo().getQrCodeBitmap(dealNumber));
	}
	
	// Sets the number of the deal selected
	public static void setDealNumber(int _dealNumber)
	{
		dealNumber = _dealNumber;
	}
}