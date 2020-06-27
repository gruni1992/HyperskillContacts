package contacts;

public class Main {

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        String question = "Enter action (add, remove, edit, count, list, exit):";
        String action;
        while (!(action = ScannerUtil.readAnswer(question)).equals("exit")){
            switch (action) {
                case "add":
                    System.out.println(phoneBook.add());
                    break;
                case "remove":
                    System.out.println(phoneBook.remove());
                    break;
                case "edit":
                    System.out.println(phoneBook.edit());
                    break;
                case "count":
                    System.out.println(phoneBook.count());
                    break;
                case "list":
                    System.out.println(phoneBook.list());
                    break;
                default:
                    throw new IllegalArgumentException("Unknown action!");
            }
        }
    }

}
