package es.upm.miw.iwvg_devops.rest;
import org.junit.jupiter.api.Test;
import es.upm.miw.iwvg_devops.Searches;
import es.upm.miw.iwvg_devops.Fraction;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchesTest {


    @Test
    void testFindFractionAdditionByUserId() {
        assertTrue(new Fraction(8,4).isEquivalent(new Searches().findFractionAdditionByUserId("4")));
    }


}