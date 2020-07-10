package udemy_exercises.cell_phone;

class Contact {
    private String name;
    private String phoneNumber;
    Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
    String getName() {
        return this.name;
    }
    String getPhoneNumber() {
        return this.phoneNumber;
    }
}