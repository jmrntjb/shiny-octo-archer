package edu.mdc.homeactivity;

public class DealInfoManager
{
	 // Variables
	 private final int SIZE = 5;	// NOTE: The size should be taken from a server
	 private DealInfoContainer dealInfo[] = new DealInfoContainer[SIZE];
	 
	 // Constructor
	 // NOTE: This constructor is for testing purposes only! All DealInfoContainer objects have the same values until modified.
	 public DealInfoManager(int id, String imageURL, String imageQRCode)
	 {
		 for (int i = 0; i < dealInfo.length; i++)
		 {
			dealInfo[i] = new DealInfoContainer(i, imageURL, imageQRCode);
		 }
		  
		 // Explicitly mark the first product URL as bad for testing purposes
	     dealInfo[0].setProduct("");
		 
		 // Explicitly set the second product URL to something different for testing purposes
		 dealInfo[1].setProduct("http://upload.wikimedia.org/wikipedia/commons/thumb/d/d7/Android_robot.svg/512px-Android_robot.svg.png");
	 }
	 
	 // Methods:
	 
	 /******************************************************************************************/
	 /* This method looks for the parameter id and returns the DealInfoContainer with said ID. */
	 /******************************************************************************************/
	 public DealInfoContainer getDealInfoContainer(int id)
	 {
		for (int i = 0; i < dealInfo.length; i++)
		{
			if (id == dealInfo[i].getID())
			{
				return dealInfo[i];
			}
		}
		 
		return null;		 
	 }
	 
	 /******************************************************************/
	 /* This method returns an array of Strings with the images' URLs. */
	 /******************************************************************/
	 public String[] getImageURLs()
	 {
		 String[] urls = new String[dealInfo.length];
		 
		 for (int i = 0; i < dealInfo.length; i++)
		 {
			urls[i] = dealInfo[i].getProduct();
		 }
		 
		 return urls;
	 }
	 
	 /********************************************************************/
	 /* This method returns an array of Strings with the QR codes' URLs. */
	 /********************************************************************/
	 public String[] getQRCodeURLs()
	 {
		 String[] urls = new String[dealInfo.length];
		 
		 for (int i = 0; i < dealInfo.length; i++)
		 {
			urls[i] = dealInfo[i].getQRCode();
		 }
		 
		 return urls;
	 }
	 
	 /****************************************************************/
	 /* This method returns the size of the DealInfoContainer array. */
	 /****************************************************************/
	 public int getSize()
	 {
		 return dealInfo.length;
	 }
}

