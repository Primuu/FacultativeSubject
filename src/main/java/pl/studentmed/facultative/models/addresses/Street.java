package pl.studentmed.facultative.models.addresses;

import javax.persistence.Embeddable;
import lombok.NoArgsConstructor;
import pl.studentmed.facultative.exceptions.EmptyFieldException;
import pl.studentmed.facultative.exceptions.InvalidLengthException;
import pl.studentmed.facultative.exceptions.InvalidSignsException;

import static pl.studentmed.facultative.models.validators.ValueObject.constainsLettersDigitsAndSpaces;

@Embeddable
@NoArgsConstructor
public class Street {

    private String street;
    private final static int MAXIMUM_LENGTH = 45;

    public Street(String street) {
        if(street == null || street.length() == 0) {
            throw new EmptyFieldException("street", "Street can't be empty.");
        }
        street = street.strip();
        if (street.length() > MAXIMUM_LENGTH) {
            throw new InvalidLengthException("street", "Street name is too long.");
        }
        if (!constainsLettersDigitsAndSpaces(street)) {
            throw new InvalidSignsException("street", "Street contains invalid signs.");
        }
        this.street = street;
    }

}
