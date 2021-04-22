// -----------------------------------------------------
// Part: 1
// Written by: Chloe Hei Yu Law - 40173275
// -----------------------------------------------------

package International_Address;
import Address.Address;

/**
 * A geographic location at which a Party may be contacted
 */
public class GeographicAddress extends Address {
    private String addressLine;
    private String city;
    private String regionOrState;
    private String zipOrPostCode;
    private Locale locale;

    /**
     * A specific class type
     */
    public static class Locale {
        private String element1; //two-letter country code
        private int element2; //three-digit country code
        private String element3; //english language country name

        /**
         * Default constructor
         */
        public Locale(){
            element1 = "CA";
            element2 = 124;
            element3 = "Canada";
        }

        /**
         * Parametrized constructor
         * @param element1 String representing a two-letter country code
         * @param element2 Integer representing a three-digit country code
         * @param element3 String representing the English language country name
         */
        public Locale(String element1, int element2, String element3){
            this.element1 = element1;
            this.element2 = element2;
            this.element3 = element3;
        }

        /**
         * @return element1
         */
        public String getElement1() {
            return element1;
        }

        /**
         * @return element2
         */
        public int getElement2(){
            return element2;
        }

        /**
         * @return element3
         */
        public String getElement3(){
            return element3;
        }

        /**
         * @param element1 Set element1
         */
        public void setElement1(String element1) {
            this.element1 = element1;
        }

        /**
         * @param element2 Set element2
         */
        public void setElement2(int element2) {
            this.element2 = element2;
        }

        /**
         * @param element3 Set element3
         */
        public void setElement3(String element3) {
            this.element3 = element3;
        }

        /**
         * @return The elements for locale
         */
        @Override
        public String toString() {
            return this.getElement1() + " \"" + getElement2() + "\" " + getElement3() ;
        }
    }

    /**
     * Default constructor
     */
    public GeographicAddress(){
        super();
        addressLine = "1400 Maisonneuve Blvd W";
        city = "Montreal";
        regionOrState = "QC";
        zipOrPostCode = "H3G 1M8";
        locale = getLocale();
    }

    /**
     * Parametrized constructor with locale
     * @param validFrom String representing a starting date in the format "YYYY-MM-DD"
     * @param validTo String representing a expiring date in the format "YYYY-MM-DD"
     * @param addressLine String representing the address line
     * @param city String representing the city
     * @param regionOrState String representing the region or state
     * @param zipOrPostCode String representing teh zip or postal code
     * @param locale Class locale with three elements
     */
    public GeographicAddress(String validFrom, String validTo, String addressLine, String city, String regionOrState, String zipOrPostCode, Locale locale){
        super(validFrom, validTo);
        this.addressLine = addressLine;
        this.city = city;
        this.regionOrState = regionOrState;
        this.zipOrPostCode = zipOrPostCode;
        this.locale = locale;
    }

    /**
     * Parametrized constructor without locale
     * @param validFrom String representing a starting date in the format "YYYY-MM-DD"
     * @param validTo String representing a expiring date in the format "YYYY-MM-DD"
     * @param addressLine String representing the address line
     * @param city String representing the city
     * @param regionOrState String representing the region or state
     * @param zipOrPostCode String representing teh zip or postal code
     */
    public GeographicAddress(String validFrom, String validTo, String addressLine, String city, String regionOrState, String zipOrPostCode) {
        super(validFrom, validTo);
        this.addressLine = addressLine;
        this.city = city;
        this.regionOrState = regionOrState;
        this.zipOrPostCode = zipOrPostCode;

    }

    /**
     * Copy constructor
     * @param otherGeographicAddress the copied object
     */
    public GeographicAddress(GeographicAddress otherGeographicAddress){
        this.setValidFrom(otherGeographicAddress.getValidFrom());
        this.setValidTo(otherGeographicAddress.getValidTo());
        this.addressLine = otherGeographicAddress.addressLine;
        this.city = otherGeographicAddress.city;
        this.regionOrState = otherGeographicAddress.regionOrState;
        this.zipOrPostCode = otherGeographicAddress.zipOrPostCode;
    }

    /**
     * @return addressLine
     */
    public String getAddressLine() {
        return addressLine;
    }

    /**
     * @return city
     */
    public String getCity() {
        return city;
    }

    /**
     * @return regionOrState
     */
    public String getRegionOrState() {
        return regionOrState;
    }

    /**
     * @return zipOrPostCode
     */
    public String getZipOrPostCode() {
        return zipOrPostCode;
    }

    /**
     * @return locale
     */
    public Locale getLocale(){
        return locale;
    }

    /**
     * @param addressLine Set the addressLine
     */
    public void setAddressLine(String addressLine) {
        this.addressLine = addressLine;
    }

    /**
     * @param city Set the city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @param regionOrState Set the regionOrState
     */
    public void setRegionOrState(String regionOrState) {
        this.regionOrState = regionOrState;
    }

    /**
     * @param zipOrPostCode Set the zipOrPostCode
     */
    public void setZipOrPostCode(String zipOrPostCode) {
        this.zipOrPostCode = zipOrPostCode;
    }

    /**
     * @param locale Set the locale
     */
    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    /**
     * @return the validFrom and validTo dates of the address and the specific geographic address
     */
    @Override
    public String toString() {
        return "The GeographicAddress is valid from " + this.getValidFrom() + " to " + this.getValidTo() + ".\n" +
                "The geographic address is " + this.getAddressLine() + ", " + this.getCity() + ", " + this.getRegionOrState()
                + ", " + this.getZipOrPostCode() + ".\n"+
                "The locale is " + this.getLocale() + ".";
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
            GeographicAddress otherGeographicAddress = (GeographicAddress) otherAddress;
            return this.getValidFrom().equals(otherGeographicAddress.getValidFrom())
                    && this.getValidTo().equals(otherGeographicAddress.getValidTo())
                    && this.getAddressLine().equals(otherGeographicAddress.getAddressLine())
                    && this.getCity().equals(otherGeographicAddress.getCity())
                    && this.getRegionOrState().equals(otherGeographicAddress.getRegionOrState())
                    && this.getZipOrPostCode().equals(otherGeographicAddress.getZipOrPostCode())
                    && this.getLocale().equals(otherGeographicAddress.getLocale());
        }
    }

    /**
     * Calculate the value consistent with the definition of equality for the class
     * @return the current instance of the class
     */
    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (addressLine != null ? addressLine.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (regionOrState != null ? regionOrState.hashCode() : 0);
        result = 31 * result + (zipOrPostCode != null ? zipOrPostCode.hashCode() : 0);
        result = 31 * result + (locale != null ? locale.hashCode() : 0);
        return result;
    }
}
