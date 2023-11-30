import io.restassured.response.Response;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Set;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class FormStatementsTest {
    StatementApi statementApi = new StatementApi();
    Workbook workbook = new XSSFWorkbook();
    ExcelReader excelReader = new ExcelReader(workbook);

    private Set<String> getStatementTypes() {
        return StatementsMapper.getAll().keySet();
    }

    @ParameterizedTest(name = "{index} - type {0} report formed")
    @MethodSource("getStatementTypes")
    public void formStatement(String type) {
        Response response = statementApi.fromStatement(type);
        String statementName = StatementsMapper.getStatementNameBasedOnType(type);
        Integer statusCode = response.statusCode();
        String result = getStatusCodeResult(statusCode);
        excelReader.addRow(statementName, String.valueOf(statusCode), result);
    }

    private String getStatusCodeResult(Integer code) {
        switch (code) {
            case 200 -> {
                return "Отчет успешно сформирован";
            }
            case 404 -> {
                return "Нет опубликованных ведомостей";
            }
            case 500 -> {
                return "Возникла ошибка";
            }
            default -> {
                return "Неизвестный код ответа";
            }
        }
    }

    @AfterAll
    public void writeToFile() throws IOException {
        File currDir = new File(".");
        String path = currDir.getAbsolutePath();
        String fileLocation = path.substring(0, path.length() - 1) + "statementResDebian.xlsx";

        FileOutputStream outputStream = new FileOutputStream(fileLocation);
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    }
}
