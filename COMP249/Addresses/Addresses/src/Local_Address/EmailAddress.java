// -----------------------------------------------------
// Part: 1
// Written by: Chloe Hei Yu Law - 40173275
// -----------------------------------------------------

package Local_Address;
import Address.Address;

/**
 * A way of contacting a Party via email
 */
public class EmailAddress extends Address {
    private String userName;
    private String atSign; //@
    private String domainName;
    private String dot; //.
    private String tld; //com, org, gov...

    /**
     * Default constructor
     */
    public EmailAddress(){
        super();
        userName = "mother";
        atSign = "@";
        domainName = "hotmail";
        dot = ".";
        tld = "com";
    }

    /**
     * Parametrized constructor
     * @param validFrom String representing a starting date in the format "YYYY-MM-DD"
     * @param validTo String representing a expiring date in the format "YYYY-MM-DD"
     * @param userName String representing the username
     * @param atSign String representing @
     * @param domainName String representing the domain name
     * @param dot String representing "."
     * @param tld String representing the tld
     */
    public EmailAddress(String validFrom, String validTo, String userName, String atSign, String domainName, String dot, String tld){
        super(validFrom, validTo);
        this.userName = userName;
        this.atSign = atSign;
        this.domainName = domainName;
        this.dot = dot;
        this.tld = tld;
    }

    /**
     * Copy constructor
     * @param otherEmailAddress the copied object
     */
    public EmailAddress(EmailAddress otherEmailAddress){
        super(otherEmailAddress);
        this.userName = otherEmailAddress.userName;
        this.atSign = otherEmailAddress.atSign;
        this.domainName = otherEmailAddress.domainName;
        this.dot = otherEmailAddress.dot;
        this.tld = otherEmailAddress.tld;
    }

    /**
     * @return userName
     */
    public String getUserName(){
        return userName;
    }

    /**
     *
     * @return atSign
     */
    public String getAtSign(){
        return atSign;
    }

    /**
     * @return domainName
     */
    public String getDomainName(){
        return domainName;
    }

    /**
     * @return dot
     */
    public String getDot(){
        return dot;
    }

    /**
     * @return tld
     */
    public String getTld(){
        return tld;
    }

    /**
     * @param userName Set userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @param atSign Set atSign
     */
    public void setAtSign(String atSign) {
        this.atSign = atSign;
    }

    /**
     *
     * @param domainName Set domainName
     */
    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }

    /**
     * @param dot Set dot
     */
    public void setDot(String dot) {
        this.dot = dot;
    }

    /**
     * @param tld Set tld
     */
    public void setTld(String tld) {
        this.tld = tld;
    }

    /**
     * @return the validFrom and validTo of the address and the specific email address
     */
    @Override
    public String toString() {
        return "The EmailAddress is valid from " + this.getValidFrom() + " to " + this.getValidTo() +".\n" +
                "The email address is " + this.getUserName() + this.getAtSign() + this.getDomainName() + this.getDot() + this.getTld() + ".";
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
            EmailAddress otherEmailAddress = (EmailAddress) otherAddress;
            return this.getValidFrom().equals(otherEmailAddress.getValidFrom())
                    && this.getValidTo().equals(otherEmailAddress.getValidTo())
                    && this.getUserName().equals(otherEmailAddress.getUserName())
                    && this.getAtSign().equals(otherEmailAddress.getAtSign())
                    && this.getDomainName().equals(otherEmailAddress.getDomainName())
                    && this.getDot().equals(otherEmailAddress.getDot())
                    && this.getTld().equals(otherEmailAddress.getTld());
        }
    }

    /**
     * Calculate the value consistent with the definition of equality for the class
     * @return the current instance of the class
     */
    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (atSign != null ? atSign.hashCode() : 0);
        result = 31 * result + (domainName != null ? domainName.hashCode() : 0);
        result = 31 * result + (dot != null ? dot.hashCode() : 0);
        result = 31 * result + (tld != null ? tld.hashCode() : 0);
        return result;
    }
}
