package src.models.address;

public class Address {
    private String houseNumber;
    private String city;
    private String street;
    private String neighborhood;

    public Address(String houseNumber, String city, String street, String neighborhood) {
        this.houseNumber = houseNumber;
        this.city = city;
        this.street = street;
        this.neighborhood = neighborhood;
    }

    @Override
    public String toString() {
        return "Address{" +
                "houseNumber=" + houseNumber +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", neighborhood='" + neighborhood + '\'' +
                '}';
    }
}
