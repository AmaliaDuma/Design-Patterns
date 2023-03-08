package amalia.labproject.view;

import amalia.labproject.service.DataService;
import amalia.labproject.view.command.*;

import javax.xml.crypto.Data;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class View {
    private DataService service;
    private Map<String, Command> commands = new HashMap<>();

    public View(DataService service) {
        this.service = service;
        this.fillCommandsMap();
    }

    private void addCommand(Command c) {
        this.commands.put(c.getKey(), c);
    }

    private void fillCommandsMap() {
        this.addCommand(new ExitCommand("0", "Exit"));
        this.addCommand(new ExportCommand("1", "Export data", service));
        this.addCommand(new AddCommand("2", "Add person", service));
        this.addCommand(new ListCommand("3", "See all persons", service));
    }

    private void printMenu() {
        commands.values().stream()
                .sorted((com1, com2) -> {
                    Integer aux = Integer.parseInt(com1.getKey());
                    return aux.compareTo(Integer.parseInt(com2.getKey()));
                })
                .forEach((com) -> {
                    String line = String.format("%3s : %s", com.getKey(), com.getDescription());
                    System.out.println(line);
                });

    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            printMenu();
            System.out.println("Input the option: ");
            String key = scanner.nextLine();
            Command com = commands.get(key);
            if (com == null){
                System.out.println("Invalid Option");
                continue;
            }
            try {
                com.execute();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
