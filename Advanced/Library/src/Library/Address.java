package Library;

/**
 * Created by Matthew on 09/08/2017.
 */
public class Address {
    private String lineOne;
    private String lineTwo;
    private String lineThree;
    private String city;
    private String postcode;
    private String county;
    private String country;

    public Address(String lineOne, String lineTwo, String lineThree, String city, String postcode, String county, String country) {
        this.lineOne = lineOne;
        this.lineTwo = lineTwo;
        this.lineThree = lineThree;
        this.city = city;
        this.postcode = postcode;
        this.county = county;
        this.country = country;
    }

    public String getLineOne() {

        return lineOne;
    }

    public void setLineOne(String lineOne) {
        this.lineOne = lineOne;
    }

    public String getLineTwo() {
        return lineTwo;
    }

    public void setLineTwo(String lineTwo) {
        this.lineTwo = lineTwo;
    }

    public String getLineThree() {
        return lineThree;
    }

    public void setLineThree(String lineThree) {
        this.lineThree = lineThree;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String toString(){
        return "[" + lineOne + "," + lineTwo + "," + lineThree + "," + city + "," + postcode + "," + county + "," + country + "]";
    }
}
