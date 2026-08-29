import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*; 
 
public class ContactTest { 

    private Contact contact;

    @BeforeEach
    void setUp() {
        contact = new Contact("Ada Lovelace", "+1 617 555 0101");
    }

    @Test
    void constructor_setsNameCorrectly() {
        assertEquals("Ada Lovelace", contact.getName());
    }

    @Test
    void constructor_setsPhoneCorrectly() {
        assertEquals("+1 617 555 0101", contact.getPhone());
    }

    @Test
    void getName_returnsExactString_notTransformed() {
        Contact c = new Contact("Derrick Lin", "+1 650 773-5687");
        assertEquals("Derrick Lin", c.getName());
    }

    @Test
    void toString_containsName() {
        Contact c = new Contact("Thank You", "+1 617 555 0104");
        assertTrue(c.toString().contains("Thank You"));
    }

    @Test
    void toString_containsPhone() {
        Contact c = new Contact("Please do not call lol", "+1 617 555 0103");
        assertTrue(c.toString().contains("+1 617 555 0103"));
    }
} 