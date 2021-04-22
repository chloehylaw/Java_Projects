// -----------------------------------------------------
// Part: 1
// Written by: Chloe Hei Yu Law - 40173275
// -----------------------------------------------------

package Local_Address;
import Address.Address;

/**
 * A number that can contact a telephone, mobile phone, fax, pager or other telephonic devices
 */
public class TelecomAddress extends Address {
    private String countryCode;
    private String nationalDirectDialingPrefix;
    private int areaCode;
    private long number;
    private int extension;
    private String physicalType; //phone, fax, mobile, pager...

    /**
     * default constructor
     */
    public TelecomAddress(){
        super();
        countryCode = "+1";
        nationalDirectDialingPrefix = "(0)";
        areaCode = 800;
        number = 4633783;
        extension = 387;
        physicalType = "phone";
    }

    /**
     * Parametrized constructor
     * @param validFrom String representing a starting date in the format "YYYY-MM-DD"
     * @param validTo String representing a expiring date in the format "YYYY-MM-DD"
     * @param countryCode String representing the International Direct dialing for a country
     * @param nationalDirectDialingPrefix String representing the National Direct Dialing prefix called within a country, between different cities or areas
     * @param areaCode Integer representing the area code for an area or city
     * @param number Long representing a telephone number
     * @param extension Integer representing the extention number
     * @param physicalType String representing the type of device such as a phone, fax, mobile, pager and so on
     */
    public TelecomAddress(String validFrom, String validTo, String countryCode, String nationalDirectDialingPrefix, int areaCode, long number, int extension, String physicalType){
        super(validFrom, validTo);
        this.countryCode = countryCode;
        this.nationalDirectDialingPrefix = nationalDirectDialingPrefix;
        this.areaCode = areaCode;
        this.number = number;
        this.extension = extension;
        this.physicalType = physicalType;
    }

    /**
     * Copy constructor
     * @param otherTelecomAddress the copied object
     */
    public TelecomAddress(TelecomAddress otherTelecomAddress){
        super(otherTelecomAddress);
        this.countryCode = otherTelecomAddress.countryCode;
        this.nationalDirectDialingPrefix = otherTelecomAddress.nationalDirectDialingPrefix;
        this.areaCode = new Integer(otherTelecomAddress.areaCode);
        this.number = new Long(otherTelecomAddress.number);
        this.extension = new Integer(otherTelecomAddress.extension);
        this.physicalType = otherTelecomAddress.physicalType;
    }

    /**
     * @return countryCode
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * @return nationalDirectDialingPrefix
     */
    public String getNationalDirectDialingPrefix() {
        return nationalDirectDialingPrefix;
    }

    /**
     * @return areaCode
     */
    public int getAreaCode() {
        return areaCode;
    }

    /**
     * @return number
     */
    public long getNumber() {
        return number;
    }

    /**
     * @return extension
     */
    public int getExtension() {
        return extension;
    }

    /**
     * @return physicalType
     */
    public String getPhysicalType() {
        return physicalType;
    }

    /**
     * @param countryCode Set the countryCode
     */
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    /**
     * @param nationalDirectDialingPrefix Set the nationalDirectDialingPrefix
     */
    public void setNationalDirectDialingPrefix(String nationalDirectDialingPrefix) {
        this.nationalDirectDialingPrefix = nationalDirectDialingPrefix;
    }

    /**
     * @param areaCode Set the areaCode
     */
    public void setAreaCode(int areaCode) {
        this.areaCode = areaCode;
    }

    /**
     * @param number Set the number
     */
    public void setNumber(long number) {
        this.number = number;
    }

    /**
     * @param extension Set the extension
     */
    public void setExtension(int extension) {
        this.extension = extension;
    }

    /**
     * @param physicalType Set the physicalType
     */
    public void setPhysicalType(String physicalType) {
        this.physicalType = physicalType;
    }

    /**
     * @return the validFrom and validTo dates of the address and the specific telecom address
     */
    @Override
    public String toString() {
        return "This TelecomAddress is valid from " + this.getValidFrom() + " to " + this.getValidTo() + ".\n" +
                "The telecom address is " + this.getCountryCode() + " " + this.getNationalDirectDialingPrefix() + this.getAreaCode() + " " +
                this.getNumber() + " ext. " + this.getExtension() + " " + this.getPhysicalType() + ".";
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
            TelecomAddress otherTelecomAddress = (TelecomAddress) otherAddress;
            return this.getValidFrom().equals(otherTelecomAddress.getValidFrom())
                    && this.getValidTo().equals(otherTelecomAddress.getValidTo())
                    && this.getCountryCode().equals(otherTelecomAddress.getCountryCode())
                    && this.getNationalDirectDialingPrefix().equals(otherTelecomAddress.getNationalDirectDialingPrefix())
                    && this.getAreaCode() == otherTelecomAddress.getAreaCode()
                    && this.getNumber() == otherTelecomAddress.getNumber()
                    && this.getExtension() == otherTelecomAddress.getExtension()
                    && this.physicalType.equals(otherTelecomAddress.getPhysicalType());
        }
    }

    /**
     * Calculate the value consistent with the definition of equality for the class
     * @return the current instance of the class
     */
    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (countryCode != null ? countryCode.hashCode() : 0);
        result = 31 * result + (nationalDirectDialingPrefix != null ? nationalDirectDialingPrefix.hashCode() : 0);
        result = 31 * result + areaCode;
        result = 31 * result + (int) (number ^ (number >>> 32));
        result = 31 * result + extension;
        result = 31 * result + (physicalType != null ? physicalType.hashCode() : 0);
        return result;
    }
}
