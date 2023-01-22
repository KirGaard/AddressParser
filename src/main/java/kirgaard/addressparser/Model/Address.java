package kirgaard.addressparser.Model;

public class Address {
    private String roadName;
    private String roadNumber;
    private String completeRoadName;
    private String postalNumber;
    private String cityName;

    public Address(String roadName, String roadNumber, String completeRoadName, String postalNumber, String cityName) {
        this.roadName = roadName;
        this.roadNumber = roadNumber;
        this.completeRoadName = completeRoadName;
        this.postalNumber = postalNumber;
        this.cityName = cityName;
    }

    public String getRoadName() {
        return roadName;
    }

    public String getRoadNumber() {
        return roadNumber;
    }

    public String getCompleteRoadName() {
        return completeRoadName;
    }

    public String getPostalNumber() {
        return postalNumber;
    }

    public String getCityName() {
        return cityName;
    }

    public void print(){
        System.out.println("Road name: " + roadName);
        System.out.println("Road number: " + roadNumber);
        System.out.println("Postal code: " + postalNumber);
        System.out.println("City name: " + cityName);
    }
}
