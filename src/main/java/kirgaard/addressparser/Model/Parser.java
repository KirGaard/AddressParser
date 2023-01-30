package kirgaard.addressparser.Model;

import kirgaard.addressparser.Model.Exceptions.NoMatchFoundException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser implements IParser{

    private final String parseRegex = "^(?<roadName>\\D+)?\\s*(?<roadNum>([0-9]{1,3}(?![0-9])[a-z]?))?[\\sa-z]*(?<postalCode>[0-9]{4})?[^a-zæøå]*(?<cityName>[a-zæøå]+)?";
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

        String roadName = matcher.group("roadName");
        String roadNum = matcher.group("roadNum");
        String postalCode = matcher.group("postalCode");
        String cityName = matcher.group("cityName");

        if (cityName == null && roadName != null){
            cityName = roadName;

            String[] words = cityName.split(" ");
            cityName = words[words.length - 1];
        }



        return new Address(roadName, roadNum, roadName + roadNum, postalCode, cityName);
    }
}
