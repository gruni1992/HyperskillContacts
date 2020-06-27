package contacts;

public class Record {
    private final String firstName;
    private final String lastName;
    private final String phoneNumber;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber.equals("") ? "[no number]" : phoneNumber;
    }

    public Record(String firstName, String lastName, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

}
