package es.upm.miw.iwvg_devops.rest;

import es.upm.miw.iwvg_devops.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import es.upm.miw.iwvg_devops.Fraction;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {
    private User user;

    @BeforeEach
    void setUp() {
        // Configura un usuario de prueba antes de cada prueba
        List<Fraction> fractions = new ArrayList<>();
        fractions.add(new Fraction(1, 2));
        fractions.add(new Fraction(3, 4));
        user = new User("1", "John", "Doe", fractions);
    }

    @Test
    void testGetId() {
        assertEquals("1", user.getId());
    }

    @Test
    void testGetName() {
        assertEquals("John", user.getName());
    }

    @Test
    void testSetName() {
        user.setName("Jane");
        assertEquals("Jane", user.getName());
    }

    @Test
    void testGetFamilyName() {
        assertEquals("Doe", user.getFamilyName());
    }

    @Test
    void testSetFamilyName() {
        user.setFamilyName("Smith");
        assertEquals("Smith", user.getFamilyName());
    }


    @Test
    void testAddFraction() {
        Fraction newFraction = new Fraction(5, 6);
        user.addFraction(newFraction);
        List<Fraction> fractions = user.getFractions();
        assertEquals(3, fractions.size());
        assertEquals(newFraction, fractions.get(2));
    }

    @Test
    void testFullName() {
        assertEquals("John Doe", user.fullName());
    }

    @Test
    void testInitials() {
        assertEquals("J.", user.initials());
    }

    @Test
    void testToString() {
        String expected = "User{id='1', name='John', familyName='Doe', fractions=[Fraction{numerator=1, denominator=2}, Fraction{numerator=3, denominator=4}]}";
        assertEquals(expected, user.toString());
    }
}

