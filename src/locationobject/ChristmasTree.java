package locationobject;

import enumeration.TreeState;

import java.util.ArrayList;
import java.util.List;

public class ChristmasTree extends LocationObject{
    private TreeState state;
    private List<NewYearsGarland> garlandList;


    public ChristmasTree(TreeState state, NewYearsGarland ... garlands) {
        this.state = state;
        this.garlandList = new ArrayList<>();
        for (int i = 0; i < garlands.length; i++) {
            garlandList.add(garlands[i]);
        }
    }

    public TreeState getState() {
        return state;
    }

    public void setState(TreeState state) {
        this.state = state;
    }
}
