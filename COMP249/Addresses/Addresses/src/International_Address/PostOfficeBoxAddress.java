// -----------------------------------------------------
// Part: 1
// Written by: Chloe Hei Yu Law - 40173275
// -----------------------------------------------------

package International_Address;
import Address.Address;

/**
 * A special type of geographic address
 */
public class PostOfficeBoxAddress extends GeographicAddress{
    private int boxLobbyDoorCode;

    /**
     * Default constructor
     */
    public PostOfficeBoxAddress(){
        super();
        boxLobbyDoorCode = 5459;
    }

    /**
     * Parametrized constructor
     * @param validFrom String representing a starting date in the format "YYYY-MM-DD"
     * @param validTo String representing a expiring date in the format "YYYY-MM-DD"
     * @param addressLine String representing the address line
     * @param city String representing the city
     * @param regionOrState String representing the region or state
     * @param zipOrPostCode String representing teh zip or postal code
     * @param locale Class locale with three elements
     * @param boxLobbyDoorCode Integer representing the code for the box lobby door
     */
    public PostOfficeBoxAddress(String validFrom, String validTo, String addressLine, String city, String regionOrState, String zipOrPostCode, Locale locale, int boxLobbyDoorCode){
        super(validFrom, validTo, addressLine, city, regionOrState, zipOrPostCode, locale);
        this.boxLobbyDoorCode = boxLobbyDoorCode;
    }

    /**
     * Copy constructor
     * @param otherPostOfficeBoxAddress the copied object
     */
    public PostOfficeBoxAddress(PostOfficeBoxAddress otherPostOfficeBoxAddress){
        super(otherPostOfficeBoxAddress);
        this.boxLobbyDoorCode = new Integer(otherPostOfficeBoxAddress.boxLobbyDoorCode);
    }

    /**
     * @return boxLobbyDoorCode
     */
    public int getBoxLobbyDoorCode() {
        return boxLobbyDoorCode;
    }

    /**
     * @param boxLobbyDoorCode Set the boxLobbyDoorCode
     */
    public void setBoxLobbyDoorCode(int boxLobbyDoorCode) {
        this.boxLobbyDoorCode = boxLobbyDoorCode;
    }

    /**
     * @return the validFrom and validTo dates of the address and the specific geographic address
     */
    @Override
    public String toString() {
        return "This PostOfficeBoxAddress is valid from " + this.getValidFrom() + " to " + this.getValidTo() + ".\n" +
                "The geographic address is " + this.getAddressLine() + ", " + this.getCity() + ", " + this.getRegionOrState()
                + ", " + this.getZipOrPostCode() + ".\n" +
                "The locale is " + this.getLocale() + ".\n" +
                "The box lobby door code is " + this.getBoxLobbyDoorCode() + ".";
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
            PostOfficeBoxAddress otherPostOfficeBoxAddress = (PostOfficeBoxAddress) otherAddress;
            return this.getValidFrom().equals(otherPostOfficeBoxAddress.getValidFrom())
                    && this.getValidTo().equals(otherPostOfficeBoxAddress.getValidTo())
                    && this.getAddressLine().equals(otherPostOfficeBoxAddress.getAddressLine())
                    && this.getCity().equals(otherPostOfficeBoxAddress.getCity())
                    && this.getRegionOrState().equals(otherPostOfficeBoxAddress.getRegionOrState())
                    && this.getZipOrPostCode().equals(otherPostOfficeBoxAddress.getZipOrPostCode())
                    && this.getLocale().equals(otherPostOfficeBoxAddress.getLocale())
                    && this.getBoxLobbyDoorCode() == otherPostOfficeBoxAddress.getBoxLobbyDoorCode();
        }
    }

    /**
     * Calculate the value consistent with the definition of equality for the class
     * @return the current instance of the class
     */
    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + boxLobbyDoorCode;
        return result;
    }
}
