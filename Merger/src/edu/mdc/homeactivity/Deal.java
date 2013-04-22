package edu.mdc.homeactivity;

public class Deal 
{
	// Members
    private String url;
    
    // Default Constructor
    public Deal()
    {
        super();
    }
    
    // Constructor
    public Deal(String url) 
    {
        super();
        this.url = url;
    }
    
    // Setters
    public void setURL(String url)
    {
    	this.url = url;
    }
    
    // Getters
    public String getURL()
    {
    	return url;
    }
}
