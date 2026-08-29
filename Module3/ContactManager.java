import java.util.*; 
 
public class ContactManager { 
 
    public static void main(String[] args) { 
 
        HashMap<String, Contact> contacts = new HashMap<>(); 
        // Step 4: add contacts here 
        contacts.put("Ada Lovelace", new Contact("Ada Lovelace", "+1 617 555 0101"));
        contacts.put("Derrick Lin", new Contact("Derrick Lin", "+1 650 773 5687"));
        contacts.put("That is my real number above", new Contact("That is my real number above", "+1 617 555 0102"));
        contacts.put("Please do not call lol", new Contact("Please do not call lol", "+1 617 555 0103"));
        contacts.put("Thank You", new Contact("Thank You", "+1 617 555 0104")); 
 
        // Step 5: look up a contact 
        Contact found = contacts.get("Derrick Lin");
        if (found == null) {
            System.out.println("Contact not found.");
        } else {
            System.out.println(found);
        }

        Contact missing = contacts.get("Dummy Contact");
        if (missing == null) {
            System.out.println("Contact not found.");
        } else {
            System.out.println(missing);
        }
        // Step 6: print sorted list
        ArrayList<Contact> sorted = new ArrayList<>(contacts.values());
        sorted.sort((a, b) -> a.getName().compareTo(b.getName()));

        System.out.println("=== All Contacts ===");
        for (Contact c : sorted) {
            System.out.println(c);
        }
    } 
}