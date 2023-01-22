package kirgaard.addressparser.Model;

import kirgaard.addressparser.Model.Exceptions.NoMatchFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParserTest {

    private Parser parser;
    private String defaultWorkingAddress = "ndr. strandvej 261a 3140 Ålsgårde";

    @BeforeEach
    void setUp(){
        parser = new Parser();
    }

    @Test
    void parseEmptyStringTest() {
        Assertions.assertThrows(NoMatchFoundException.class, () -> parser.Parse(""));
    }

    @Test
    void parseNullTest() {
        Assertions.assertThrows(NullPointerException.class, () -> parser.Parse(null));
    }

    @Test
    void findRoadNameInDefaultTest(){
        try {
            Address address = parser.Parse(defaultWorkingAddress);
            Assertions.assertEquals("ndr. strandvej", address.getRoadName());
        } catch (NoMatchFoundException e) {

        }
    }

    @Test
    void findRoadNumInDefaultTest(){
        try {
            Address address = parser.Parse(defaultWorkingAddress);
            Assertions.assertEquals("261a", address.getRoadNumber());
        } catch (NoMatchFoundException e) {

        }
    }

    @Test
    void findPostalCodeInDefaultTest(){
        try {
            Address address = parser.Parse(defaultWorkingAddress);
            Assertions.assertEquals("3140", address.getPostalNumber());
        } catch (NoMatchFoundException e) {

        }
    }

    @Test
    void findCityNameInDefaultTest(){
        try {
            Address address = parser.Parse(defaultWorkingAddress);
            Assertions.assertEquals("Ålsgårde", address.getCityName());
        } catch (NoMatchFoundException e) {

        }
    }

    @Test
    void printAddressTest(){
        try {
            Address address = parser.Parse("3140 Ålsgårde");
            address.print();
        } catch (NoMatchFoundException e) {}
    }

}