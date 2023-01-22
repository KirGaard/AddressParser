package kirgaard.addressparser.Model;

import kirgaard.addressparser.Model.Exceptions.NoMatchFoundException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser implements IParser{

    private final String parseRegex = "^(?<roadName>\\D+)*(?<roadNum>[0-9]+[a-z]*)*\\D*(?<postalCode>[0-9]{4})*[\\s\\d]*(?<cityName>\\D*)";
    private Pattern pattern;

    public Parser() {
        this.pattern = Pattern.compile(parseRegex, Pattern.CASE_INSENSITIVE);
    }


    @Override
    public Address Parse(String string) throws NoMatchFoundException, NullPointerException {
        if (string == null){
            throw new NullPointerException();
        }

        Matcher matcher = pattern.matcher(string);

        if (!matcher.matches()){
            throw new NoMatchFoundException();
        }

        String roadName = "";
        try {
            roadName = matcher.group("roadName");
        }catch (IllegalArgumentException e){

        }

        String roadNum = "";
        try {
            roadNum = matcher.group("roadNum");
        }catch (IllegalArgumentException e){

        }

        String postalCode = "";
        try {
            postalCode = matcher.group("postalCode");
        }catch (IllegalArgumentException e){

        }

        String cityName = "";
        try {
            cityName = matcher.group("cityName");
        }catch (IllegalArgumentException e){

        }


        return new Address(roadName, roadNum, roadName + roadNum, postalCode, cityName);
    }
}
