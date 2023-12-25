package location;

import exception.LocationSizeException;
import locationobject.person.Person;

public class TwoDimensionalShop extends TwoDimensionalLocation{
    public TwoDimensionalShop(String name, int width, int length) throws LocationSizeException {
        super(name, width, length);
    }

    public void buy(Person person, Buyable buyable){
        person.setCash(person.getCash() - buyable.getPrice());
    }

}
