package amalia.labproject.view.command;

import amalia.labproject.export.ExcelExporter;
import amalia.labproject.export.FileExporter;
import amalia.labproject.service.DataService;

import java.util.Scanner;

public class ExportCommand extends Command {

    DataService service;

    public ExportCommand(String key, String description, DataService service) {
        super(key, description);
        this.service = service;
    }
    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose how you want to export data: file / xlxs");
        String option = scanner.nextLine().toLowerCase();
        switch (option) {
            case "file" -> service.setExporter(new FileExporter());
            case "xlsx" -> service.setExporter(new ExcelExporter());
            default -> {
                System.out.println("Invalid option.");
                return;
            }
        }
        service.export();
    }
}
