package locationobject;

import enumeration.OpenClosed;

public class Gates extends LocationObject{
    private final String name;
    private OpenClosed openClosed;
    public Gates(String name){
        this.name = name;
        this.openClosed = OpenClosed.CLOSED;
    }

    public OpenClosed getOpenClosed() {
        return openClosed;
    }

    public void setOpenClosed(OpenClosed openClosed) {
        this.openClosed = openClosed;
    }
}
