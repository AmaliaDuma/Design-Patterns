package amalia.labproject.view.command;

import amalia.labproject.domain.Person;
import amalia.labproject.service.DataService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class AddCommand extends Command {
    DataService service;

    public AddCommand(String key, String description, DataService service) {
        super(key, description);
        this.service = service;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter first name: ");
        String firstName = scanner.nextLine();
        System.out.println("Enter last name: ");
        String lastName = scanner.nextLine();
        System.out.println("Enter age: ");
        Integer age = Integer.valueOf(scanner.nextLine());
        System.out.println("Enter cnp: ");
        String cnp = scanner.nextLine();

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("Enter date of birth with the following format: dd/mm/yyyy");
        LocalDate dob = LocalDate.parse(scanner.nextLine(), dateFormatter);

        try {
            Person newPerson = new Person.PersonBuilder()
                    .firstName(firstName)
                    .lastName(lastName)
                    .age(age)
                    .cnp(cnp)
                    .dob(dob).build();
            service.addPerson(newPerson);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
