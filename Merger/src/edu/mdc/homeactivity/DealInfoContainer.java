package edu.mdc.homeactivity;

public class DealInfoContainer
{	
	  // Variables
      private int id;
      private String product;
      private String qrcode;
      
      // Constructor
      public DealInfoContainer(int id, String product, String qrcode)
      {
    	  this.id 	   = id;
    	  this.product = product;
    	  this.qrcode  = qrcode;
      }
      
      // Setters
      public void setID(int id)
      {
    	  this.id = id;
      }
      
      public void setQRCode(String qrcode)
      {
    	  this.qrcode = qrcode;
      }
      
      public void setProduct(String product)
      {
    	  this.product = product;  
      }
      
      // Getters
      public int getID()
      {
    	  return id;
      }
      
      public String getProduct()
      {
    	  return product;
      }
      
      public String getQRCode()
      {
    	  return qrcode;
      }
}
