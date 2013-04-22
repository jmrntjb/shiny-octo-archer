package edu.mdc.homeactivity;

import android.os.Bundle;
import android.app.TabActivity;
import android.content.Intent;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

@SuppressWarnings("deprecation")
public class TabsActivity extends TabActivity 
{
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tabs);
		
		// Tab Host
		TabHost tabHost = getTabHost();
				
		// First tab Detail activity
		TabSpec detailSpec = tabHost.newTabSpec("Detail");
		detailSpec.setIndicator("Detail", getResources().getDrawable(R.drawable.home_icon));
		Intent detailIntent = new Intent(TabsActivity.this, DetailActivity.class);		
		detailSpec.setContent(detailIntent);

		// Second tab Profile
		TabSpec profileSpec = tabHost.newTabSpec("profile");
		profileSpec.setIndicator("Profile", getResources().getDrawable(R.drawable.profile_icon));
		Intent profileIntent = new Intent(this, ProfileActivity.class);
		profileSpec.setContent(profileIntent);
		
		// Third tab Shopping Cart
		TabSpec cartspec = tabHost.newTabSpec("Shopping Cart");
		cartspec.setIndicator("Shopping Cart", getResources().getDrawable(R.drawable.cart_con));
		Intent cartIntent = new Intent(this, ShoppingCartActivity.class);
		cartspec.setContent(cartIntent);
		
		// Add the tabs
		tabHost.addTab(detailSpec);
		tabHost.addTab(profileSpec);
		tabHost.addTab(cartspec);		
	}
}
