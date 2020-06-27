package contacts;

import contacts.exception.WrongNumberFormatException;

public class Record {
    private String firstName;
    private String lastName;
    private String phoneNumber;

    public Record(String firstName, String lastName, String phoneNumber) {
        if (!isValidNumberFormat(phoneNumber)) {
            throw new WrongNumberFormatException();
        }
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    private boolean isValidNumberFormat(String phoneNumber) {
        //TODO
        return false;
    }

}
