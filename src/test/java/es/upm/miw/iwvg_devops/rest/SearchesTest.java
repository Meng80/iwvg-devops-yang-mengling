package es.upm.miw.iwvg_devops.rest;
import org.junit.jupiter.api.Test;
import es.upm.miw.iwvg_devops.Searches;
import es.upm.miw.iwvg_devops.Fraction;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchesTest {


    @Test
    void testFindFractionAdditionByUserId() {
        assertTrue(new Fraction(8,4).isEquivalent(new Searches().findFractionAdditionByUserId("4")));
    }

    @Test
    void testFindUserFamilyNameInitialBySomeProperFraction(){
        assertEquals(List.of("F", "B", "L"), new Searches().findUserFamilyNameInitialBySomeProperFraction()
                .collect(Collectors.toList()));
    }

    @Test
    void testFindUserNameBySomeImproperFraction(){
        assertEquals(List.of("Oscar","Ana","Paula"), new Searches().findUserNameBySomeImproperFraction()
                .collect(Collectors.toList()));

    }


}
