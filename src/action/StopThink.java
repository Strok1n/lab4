package action;

import locationobject.person.Person;

public class StopThink implements Action{

    private final Person person;

    public StopThink(Person person){
        this.person = person;
    }
    @Override
    public void execute() throws InterruptedException {
        person.stopThink();
    }
}