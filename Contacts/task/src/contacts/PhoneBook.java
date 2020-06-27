package contacts;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PhoneBook {
    List<Record> records = new ArrayList<>();

    public String count() {
        return String.format("The Phone Book has %s records.", records.size());
    }

    public String add() {
        String firstName = getFirstName();
        String lastName = getLastName();
        String phoneNumber = getPhoneNumber();
        Record record = new Record(firstName, lastName, phoneNumber);
        records.add(record);
        return "The record added";
    }

    private String getLastName() {
        return ScannerUtil.readAnswer("Enter the surname of the person:");
    }

    private String getFirstName() {
        return ScannerUtil.readAnswer("Enter the name of the person:");
    }

    private String getPhoneNumber() {
        String phoneNumber = ScannerUtil.readAnswer("Enter the number:");
        if (!isValidNumberFormat(phoneNumber)) {
            System.out.println("Wrong number format!");
            return "";
        }
        return phoneNumber;
    }

    private boolean isValidNumberFormat(String phoneNumber) {
        String noBrackets = "[+]?([ -][\\d\\w]{2,})*";
        String firstGroupBrackets = "[+]?\\([\\d\\w]{1,}\\)([ -][\\d\\w]{2,})*";
        String secondGroupBrackets = "[+]?[\\d\\w]{1,}[- ]?(\\([\\d\\w]{2,}\\))?([ -][\\d\\w]{2,})*";

        return phoneNumber.matches(noBrackets)
                || phoneNumber.matches(firstGroupBrackets)
                || phoneNumber.matches(secondGroupBrackets);
    }

    public String remove() {
        if (records.size() == 0) {
            return "No records to remove!";
        }
        int index = readIndex();
        records.remove(index);
        return "The record removed!";
    }

    public String edit() {
        if (records.size() == 0) {
            return "No records to edit!";
        }
        int index = readIndex();
        String field = readField();
        Record record = getEditedRecord(records.get(index), field);
        records.set(index, record);
        return "The record updated";
    }

    private Record getEditedRecord(Record record, String field) {
        switch (field) {
            case "name":
                return new Record(getFirstName(), record.getLastName(), record.getPhoneNumber());
            case "surname":
                return new Record(record.getFirstName(), getLastName(), record.getPhoneNumber());
            case "number":
                return new Record(record.getFirstName(), record.getLastName(), getPhoneNumber());
            default:
                throw new IllegalArgumentException("No valid field!");
        }
    }

    private String readField() {
        return ScannerUtil.readAnswer("Select a field (name, surname, number):");
    }

    private int readIndex() {
        String answer = ScannerUtil.readAnswer("Select a record");
        return Integer.parseInt(answer) - 1;
    }

    public String list() {
        return IntStream.range(0, records.size())
                .mapToObj(this::getListItem)
                .collect(Collectors.joining("\n"));

    }

    private String getListItem(int index) {
        Record record = records.get(index);
        return String.format("%s. %s %s, %s", index+1, record.getFirstName(), record.getLastName(), record.getPhoneNumber());
    }


}
