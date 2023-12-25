package location;

import enumeration.TreeState;
import exception.LocationSizeException;
import locationobject.LocationObject;
import locationobject.ChristmasTree;

public class TwoDimensionalCemetery extends TwoDimensionalLocation{
    public TwoDimensionalCemetery(String name, int width, int length) throws LocationSizeException {
        super(name, width, length);
    }



    public void setWindyWeather(){
        for (LocationObject o: this.locationObjects) {
            if (o instanceof ChristmasTree){
                ChristmasTree christmasTree = (ChristmasTree) o;
                christmasTree.setState(TreeState.RUSTLING);
            }
        }

        System.out.println("weather of " + this + "has become windy");


    }


}
