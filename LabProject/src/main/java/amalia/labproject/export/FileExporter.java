package amalia.labproject.export;

import amalia.labproject.domain.Person;

import java.io.File;
import java.io.FileWriter;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class FileExporter implements Exporter {
    @Override
    public void export(List<Person> data) throws Exception {
        File file = new File("D:\\Faculty\\Sem6\\Design Patterns\\LabProject\\files\\Data.txt");
        file.createNewFile();
        FileWriter myWriter = new FileWriter("D:\\Faculty\\Sem6\\Design Patterns\\LabProject\\files\\Data.txt");

        StringBuilder builder = new StringBuilder();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        for (Person person : data) {
            builder.append(person.getCnp()).append(",").append(person.getFirstName()).append(",")
                    .append(person.getLastName()).append(",").append(person.getAge()).append(",")
                    .append(person.getDob().format(dateFormatter)).append('\n');
        }
        myWriter.write(builder.toString());
        myWriter.close();
    }

}
