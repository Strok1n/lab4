package action;

import locationobject.person.Person;

public class Think implements Action{

    private final Person person;
    private final String string;

    public Think(Person person, String string){
        this.person = person;
        this.string = string;
    }
    @Override
    public void execute() throws InterruptedException {
        person.think(string);
    }
}
