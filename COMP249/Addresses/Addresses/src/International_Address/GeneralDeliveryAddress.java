// -----------------------------------------------------
// Part: 1
// Written by: Chloe Hei Yu Law - 40173275
// -----------------------------------------------------

package International_Address;
import Address.Address;
import Local_Address.TelecomAddress;

/**
 * Service where the post office holds the mail until the recipients calls for it
 */
public class GeneralDeliveryAddress extends GeographicAddress{
    private TelecomAddress telecomAddress;

    /**
     * Default constructor
     */
    public GeneralDeliveryAddress(){
        super();
    }

    /**
     * Parametrized constructor
     * @param validFrom String representing a starting date in the format "YYYY-MM-DD"
     * @param validTo String representing a expiring date in the format "YYYY-MM-DD"
     * @param addressLine String representing the address line
     * @param city String representing the city
     * @param regionOrState String representing the region or state
     * @param zipOrPostCode String representing teh zip or postal code
     * @param telecomAddress Class representing the calling service
     */
    public GeneralDeliveryAddress(String validFrom, String validTo, String addressLine, String city, String regionOrState, String zipOrPostCode, TelecomAddress telecomAddress){
        super(validFrom,validTo,addressLine,city,regionOrState,zipOrPostCode);
        this.telecomAddress = telecomAddress;

    }

    /**
     * Copy constructor
     * @param otherGeneralDeliveryAddress the copied object
     */
    public GeneralDeliveryAddress(GeneralDeliveryAddress otherGeneralDeliveryAddress){
        super(otherGeneralDeliveryAddress);
        this.telecomAddress = new TelecomAddress(otherGeneralDeliveryAddress.telecomAddress);
    }

    /**
     * @return telecomAddress
     */
    public TelecomAddress getTelecomAddress() {
        return telecomAddress;
    }

    /**
     * @param telecomAddress Set the telecomAddress
     */
    public void setTelecomAddress(TelecomAddress telecomAddress) {
        this.telecomAddress = telecomAddress;
    }

    /**
     * @return the validFrom and validTo dates of the address and the specific general delivery address
     */
    @Override
    public String toString() {
        return "The GeneralDelivery Address is valid from " + this.getValidFrom() + " to " + this.getValidTo() + ".\n" +
                "The general delivery address is " + this.getAddressLine() + ", " + this.getCity() + ", " + this.getRegionOrState()
                + ", " + this.getZipOrPostCode() + ".\n" +
                this.getTelecomAddress();
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
            GeneralDeliveryAddress otherGeneralDeliveryAddress = (GeneralDeliveryAddress) otherAddress;
            return this.getValidFrom().equals(otherGeneralDeliveryAddress.getValidFrom())
                    && this.getValidTo().equals(otherGeneralDeliveryAddress.getValidTo())
                    && this.getAddressLine().equals(otherGeneralDeliveryAddress.getAddressLine())
                    && this.getCity().equals(otherGeneralDeliveryAddress.getCity())
                    && this.getRegionOrState().equals(otherGeneralDeliveryAddress.getRegionOrState())
                    && this.getZipOrPostCode().equals(otherGeneralDeliveryAddress.getZipOrPostCode())
                    && this.getTelecomAddress().equals(otherGeneralDeliveryAddress.getTelecomAddress());
        }
    }

    /**
     * Calculate the value consistent with the definition of equality for the class
     * @return the current instance of the class
     */
    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (telecomAddress != null ? telecomAddress.hashCode() : 0);
        return result;
    }
}
