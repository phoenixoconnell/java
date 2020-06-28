package udemy_exercises.cell_phone;

import java.util.ArrayList;
import java.util.Scanner;

import udemy_exercises.cell_phone.Contact;

class Main {
    
    private static Scanner sc = new Scanner(System.in);
    private static String number;
    private static String name;
    private static MobilePhone myPhone;
    
    public static void main(String[] args) {
        
        String selection;
        boolean leaveMenu = false;
        System.out.println("What's your number?");

        number = sc.nextLine();
        myPhone = new MobilePhone(number);
        System.out.println("Congratulations!  Your phone is set up with number " + myPhone.getMyNumber());
        
        while(!leaveMenu) {
            System.out.println("You have " + myPhone.contactListSize() + " contacts");
            System.out.println("What would you like to do?");
            System.out.println("(Use the first word of a listed item to enter its sub menu):");
            System.out.println("List all contacts");
            System.out.println("Add a contact");
            System.out.println("Find a number");
            System.out.println("Modify a contact");
            System.out.println("Remove a contact");
            System.out.println("Exit");
            
            selection = sc.nextLine();
            
            switch(selection) {
                case "List":
                    menuList();
                    break;
                case "Add":
                    menuAdd();
                    break;
                case "Find":
                    menuFind();
                    break;
                case "Modify":
                    menuModify();
                    break;
                case "Remove":
                    menuRemove();
                    break;
                case "Exit":
                    leaveMenu = true;
                    break;
                default:
                    System.out.println("Invalid option!");
                    System.out.println();
                    break;
            }
        }
    }

    public static void menuList() {
        
        myPhone.listContacts();
        System.out.println();
    }
    
    public static void menuAdd() {
        
      System.out.println();
        System.out.println("Enter the new contact's name:");
        
        name = sc.nextLine();
        System.out.println();
        System.out.println("Enter the new contact's phone number:");
        
        number = sc.nextLine();
        myPhone.addContact(name, number);
        System.out.println();
    }
    
    public static void menuFind() {
        
        System.out.println();
        System.out.println("Enter the contact's name:");
        
        name = sc.nextLine();
        System.out.println(name + "'s number is: " + myPhone.getNumber(name));
        System.out.println();
    }
    
    public static void menuModify() {
        
        System.out.println();
        System.out.println("Enter the contact's name:");
        
        name = sc.nextLine();
        System.out.println();
        System.out.println("Enter the new contact's phone number:");
        
        number = sc.nextLine();
        myPhone.modifyContact(name, number);
        System.out.println();
    }
    
    public static void menuRemove() {
        
        System.out.println();
        System.out.println("Enter the contact's name:");
        
        name = sc.nextLine();
        myPhone.removeContact(name);
        System.out.println();
    }
}

class MobilePhone {
    
    private String myNumber;
    private ArrayList<Contact> contacts;
    
    MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.contacts = new ArrayList<>();
    }
    
    String getMyNumber() {
        return this.myNumber;
    }
    
    int contactListSize() {
        return this.contacts.size();
    }
    
    void addContact(String name, String number) {
        Contact newContact = new Contact(name, number);
        this.contacts.add(newContact);
    }
    
    void modifyContact(String name, String number) {
        
        int index;
        Contact newContact;
        Contact contact = findContact(name);
        if(contact != null) {
            index = contacts.indexOf(contact);
            newContact = new Contact(name, number);
            this.contacts.set(index, newContact);
        } else {
            System.out.println("Contact not found!");
        }
    }
    
    void removeContact(String name) {
        Contact contact = findContact(name);
        int index = this.contacts.indexOf(contact);
        if(contact != null) {
            this.contacts.remove(index);
        } else {
            System.out.println("Contact not found!");
        }
    }
    
    void listContacts() {
        for(Contact contact: this.contacts) {
            System.out.println(contact.getName() + ": " + contact.getPhoneNumber());
        }
    }
    
    String getNumber(String name) {
        Contact contact = findContact(name);
        if(contact != null) {
            return contact.getPhoneNumber();
        } else {
            return "Contact not found!";
        }
    }
    
    private Contact findContact(String inName) {
        Contact contact = this.contacts.stream()
                .filter(c -> {
                    return inName.equals(c.getName());
                })
                .findAny()
                .orElse(null);
        return contact;
    }
}

