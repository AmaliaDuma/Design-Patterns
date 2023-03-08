package amalia.labproject.export;

import amalia.labproject.domain.Person;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 *  Facade design pattern:
 *    We create a facade class to hide the framework's complexity and expose only a simple method -> export
 */
public class ExcelExporter implements Exporter{
    @Override
    public void export(List<Person> data) throws Exception {
        SXSSFWorkbook workbook = new SXSSFWorkbook();

        SXSSFSheet sheet = workbook.createSheet("Persons");
        sheet.trackAllColumnsForAutoSizing();
        List<String> headerColumns = getHeaderColumns();
        writeHeader(sheet, headerColumns);
        writeRows(sheet, data);

        for (int i = 0; i < headerColumns.size(); i++) {
            sheet.autoSizeColumn(i);
        }

        FileOutputStream outputStream = new FileOutputStream("D:\\Faculty\\Sem6\\Design Patterns\\LabProject\\files\\Data.xlsx");
        workbook.write(outputStream);
        workbook.close();
    }

    private void writeHeader(SXSSFSheet sheet, List<String> headerColumns) {
        SXSSFRow row = sheet.createRow(0);

        for (String header : headerColumns) {
            writeCell(row, header);
        }
    }

    private void writeRows(SXSSFSheet sheet, List<Person> data) throws IOException {
        for (int index = 0; index < data.size(); index++) {
            Person person = data.get(index);

            Row row = sheet.createRow(index + 1);
            writeCell(row, person.getCnp());
            writeCell(row, person.getFirstName());
            writeCell(row, person.getLastName());
            writeCell(row, person.getAge());

            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            writeCell(row, person.getDob().format(dateFormatter));
            sheet.flushRows();
        }
    }

    private void writeCell(Row row, Object value) {
        if (value == null) {
            value = "";
        }

        int nextCellIndex = row.getLastCellNum() == -1 ? 0 : row.getLastCellNum();
        Cell cell = row.createCell(nextCellIndex);
        cell.setCellValue(richTextString(value));
    }

    private XSSFRichTextString richTextString(Object object) {
        return new XSSFRichTextString(object.toString());
    }

    private List<String> getHeaderColumns() {
        return List.of("CNP", "FirstName", "LastName", "Age", "Date of birth");
    }
}
