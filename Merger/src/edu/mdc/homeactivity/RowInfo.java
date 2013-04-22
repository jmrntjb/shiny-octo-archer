package edu.mdc.homeactivity;

import android.graphics.Bitmap;

public class RowInfo
{
	// Members
	private Bitmap[] productBitmap;
	private Bitmap[] qrCodeBitmap;
	private String[] productUrls;
	private String[] qrCodeUrls;
	private int[]    productUrlStatus;
	private int[]	 qrCodeUrlStatus;
	
	// Constructor
	RowInfo(int size)
	{
		productBitmap 	 = new Bitmap[size];
		qrCodeBitmap	 = new Bitmap[size];
		productUrls 	 = new String[size];
		qrCodeUrls  	 = new String[size];
		productUrlStatus = new int[size];
		qrCodeUrlStatus	 = new int[size];
	}
	
	/***********/
	/* Getters */
	/***********/
	public int getSize()
	{
		return productBitmap.length;
	}
	
	public Bitmap getProductBitmap(int element) 
	{
		return productBitmap[element];
	}
	
	public Bitmap[] getProductBitmapArray() 
	{
		return productBitmap;
	}
	
	public Bitmap getQrCodeBitmap(int element) 
	{
		return qrCodeBitmap[element];
	}
	
	public Bitmap[] getQrCodeBitmapArray() 
	{
		return qrCodeBitmap;
	}
	
	public String getProductUrls(int element) 
	{
		return productUrls[element];
	}
	
	public String[] getProductUrlsArray() 
	{
		return productUrls;
	}

	public int getProductUrlStatus(int element) 
	{
		return productUrlStatus[element];
	}

	public int[] getProductUrlStatusArray() 
	{
		return productUrlStatus;
	}		

	public String getQrCodeUrls(int element) 
	{
		return qrCodeUrls[element];
	}
	
	public String[] getQrCodeUrlsArray() 
	{
		return qrCodeUrls;
	}

	public int getQrCodeUrlStatus(int element) 
	{
		return qrCodeUrlStatus[element];
	}
	
	public int[] getQrCodeUrlStatusArray() 
	{
		return qrCodeUrlStatus;
	}

	/***********/
	/* Setters */
	/***********/
	public void setProductBitmap(int element, Bitmap bitmap) 
	{
		this.productBitmap[element] = bitmap;
	}

	public void setProductBitmapArray(Bitmap[] bitmap) 
	{
		this.productBitmap = bitmap;		
	}
	
	public void setQrCodeBitmap(int element, Bitmap qrCodeBitmap) 
	{
		this.qrCodeBitmap[element] = qrCodeBitmap;
	}
	
	public void setQrCodeBitmapArray(Bitmap[] qrCodeBitmap) 
	{
		this.qrCodeBitmap = qrCodeBitmap;
	}

	public void setProductUrls(int element, String urls) 
	{
		this.productUrls[element] = urls;
	}
	
	public void setProductUrlsArray(String[] urls) 
	{
		this.productUrls = urls;
	}
	
	public void setProductUrlStatus(int element, int urlStatus) 
	{
		this.productUrlStatus[element] = urlStatus;
	}
	
	public void setProductUrlStatusArray(int[] urlStatus) 
	{
		this.productUrlStatus = urlStatus;
	}

	public void setQrCodeUrls(int element, String qrCodeUrls) 
	{
		this.qrCodeUrls[element] = qrCodeUrls;
	}
	
	public void setQrCodeUrlsArray(String[] qrCodeUrls) 
	{
		this.qrCodeUrls = qrCodeUrls;
	}

	public void setQrCodeUrlStatus(int element, int qrCodeUrlStatus) 
	{
		this.qrCodeUrlStatus[element] = qrCodeUrlStatus;
	}
	
	public void setQrCodeUrlStatusArray(int[] qrCodeUrlStatus) 
	{
		this.qrCodeUrlStatus = qrCodeUrlStatus;
	}
}
