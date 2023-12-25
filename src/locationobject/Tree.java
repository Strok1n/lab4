package locationobject;

import enumeration.TreeState;

public class Tree extends LocationObject{
    private TreeState state;


    public Tree(TreeState state) {
        this.state = state;
    }

    public TreeState getState() {
        return state;
    }

    public void setState(TreeState state) {
        this.state = state;
    }
}
