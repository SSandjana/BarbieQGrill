package sr.unasat.entities;

public class Customers {

    private String firstName;
    private String lastName;
    private Long frequency;

    public Customers(String firstName, String lastName, Long frequency) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.frequency = frequency;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getFrequency() {
        return frequency;
    }

    public void setFrequency(Long frequency) {
        this.frequency = frequency;
    }

    @Override
    public String toString() {
        return "Customers{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", frequency=" + frequency +
                '}';
    }
}
