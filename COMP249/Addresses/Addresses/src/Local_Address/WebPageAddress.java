// -----------------------------------------------------
// Part: 1
// Written by: Chloe Hei Yu Law - 40173275
// -----------------------------------------------------

package Local_Address;
import Address.Address;

/**
 * URL for a Web page related to the Party
 */
public class WebPageAddress extends Address {
    private String url;

    /**
     * Default constructor
     */
    public WebPageAddress(){
        super();
        url = "www.google.com";
    }

    /**
     * Parametrized constructor
     * @param validFrom String representing a starting date in the format "YYYY-MM-DD"
     * @param validTo String representing a expiring date in the format "YYYY-MM-DD"
     * @param url String representing the URL in the form of "www.domainName/resourceName"
     */
    public WebPageAddress(String validFrom, String validTo, String url){
        super(validFrom, validTo);
        this.url = url;
    }

    /**
     * Copy constructor
     * @param otherWebPageAddress the copied object
     */
    public WebPageAddress(WebPageAddress otherWebPageAddress){
        super(otherWebPageAddress);
        this.url = otherWebPageAddress.url;
    }

    /**
     * @return url
     */
    public String getUrl(){
        return url;
    }

    /**
     * @param url set the URL
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return the validFrom and validTo dates of the address and the webpage URl
     */
    @Override
    public String toString() {
        return "This WebPageAddress is valid from " + this.getValidFrom() + " to " + this.getValidTo() + ".\n" +
                "The URL is " + this.getUrl() + ".";
    }

    /**
     * @param otherAddress the compared object
     * @return whether they are equal or not
     */
    @Override
    public boolean equals(Address otherAddress) {
        if(otherAddress == null)
            return false;
        else if(getClass() != otherAddress.getClass())
            return false;
        else{
            WebPageAddress otherWebPageAddress = (WebPageAddress) otherAddress;
            return this.getValidFrom().equals(otherWebPageAddress.getValidFrom())
                    && this.getValidTo().equals(otherWebPageAddress.getValidTo())
                    && this.getUrl().equals(otherWebPageAddress.getUrl());
        }
    }

    /**
     * Calculate the value consistent with the definition of equality for the class
     * @return the current instance of the class
     */
    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (url != null ? url.hashCode() : 0);
        return result;
    }
}
