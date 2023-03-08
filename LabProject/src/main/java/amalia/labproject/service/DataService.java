package amalia.labproject.service;

import amalia.labproject.domain.Person;
import amalia.labproject.export.ExcelExporter;
import amalia.labproject.export.Exporter;
import amalia.labproject.utils.Logger;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DataService {
    private List<Person> data;
    private Exporter exporter;

    public DataService() {
        this.exporter = new ExcelExporter();
        this.data = new ArrayList<>();
        this.loadData();
    }
    public void export() {
        Logger.log("Exporting data...");
        try{
            exporter.export(data);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void setExporter(Exporter exporter) {
        this.exporter = exporter;
    }

    public void addPerson(Person person) {
        Logger.log("Adding new person {" + person.toString() + "}");
        data.add(person);
    }

    public List<Person> getPersons() {
        return data;
    }

    private void loadData() {
        data.add(new Person("Maria", "Popovici", "6160315086831", 7, LocalDate.of(2016, 3, 15)));
        data.add(new Person("Mihai", "Ionescu", "5060912025251", 17, LocalDate.of(2006, 9, 12)));
    }
}
