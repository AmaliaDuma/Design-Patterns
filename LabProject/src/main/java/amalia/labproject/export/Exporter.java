package amalia.labproject.export;

import amalia.labproject.domain.Person;

import java.util.List;

/**
 *  Strategy (behavioral pattern)
 *   We define a common interface for our different ways to export file
 */
public interface Exporter {
    void export(List<Person> data) throws Exception ;
}
