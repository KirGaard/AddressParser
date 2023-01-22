package kirgaard.addressparser.Model;

import kirgaard.addressparser.Model.Exceptions.NoMatchFoundException;

public interface IParser {
    public Address Parse(String string) throws NoMatchFoundException;

}
