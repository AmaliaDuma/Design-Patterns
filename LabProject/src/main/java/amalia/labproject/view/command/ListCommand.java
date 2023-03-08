package amalia.labproject.view.command;

import amalia.labproject.domain.Person;
import amalia.labproject.service.DataService;

public class ListCommand extends Command {
    DataService service;

    public ListCommand(String key, String description, DataService service) {
        super(key, description);
        this.service = service;
    }

    @Override
    public void execute() {
        for (Person p : service.getPersons()) {
            System.out.println(p.toString());
        }
    }
}
