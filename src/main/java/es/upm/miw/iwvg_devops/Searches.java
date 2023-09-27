package es.upm.miw.iwvg_devops;
import org.apache.logging.log4j.LogManager;


import java.util.Objects;
import java.util.stream.Stream;

public class Searches {

    public Fraction findFractionAdditionByUserId(String id){
        return new UserDatabase().findAll()
                .filter(user -> id.equals(user.getId()))
                .flatMap(user -> user.getFractions().stream())
                .reduce(Fraction::add)
                .orElse(new Fraction(0, 1));
    }
    
}
