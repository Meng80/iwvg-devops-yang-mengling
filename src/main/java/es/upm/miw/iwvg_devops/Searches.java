package es.upm.miw.iwvg_devops;

import org.apache.logging.log4j.LogManager;
import java.util.Objects;
import java.util.stream.Stream;
import java.util.Optional;

public class Searches {

    public Fraction findFractionAdditionByUserId(String id){
        return new UserDatabase().findAll()
                .filter(user -> id.equals(user.getId()))
                .flatMap(user -> user.getFractions().stream())
                .reduce(Fraction::add)
                .orElse(new Fraction(0, 1));
    }

    public Stream<String> findUserFamilyNameInitialBySomeProperFraction(){
        return new UserDatabase().findAll()
                .filter(user -> user.getFractions().stream().anyMatch(Fraction::isProper))
                .map(user -> user.getFamilyName().substring(0, 1))
                .distinct();
    }

    public  Stream<String> findUserNameBySomeImproperFraction(){
        return new UserDatabase().findAll()
                .filter(user -> user.getFractions().stream().anyMatch(Fraction::isImproper))
                .map(user -> user.getName())
                .distinct();
    }

    public Double findFirstDecimalFractionByUserName(String name){
        Optional<User> user = new UserDatabase().findAll()
                .filter(u -> name.equals(u.getName()))
                .findFirst();

        return user.map(u -> u.getFractions().stream()
                        .mapToDouble(Fraction::decimal)
                        .findFirst()
                        .orElse(0.0))
                .orElse(0.0);
      }

    }

