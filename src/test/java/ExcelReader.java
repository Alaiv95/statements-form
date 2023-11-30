import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
    private final Workbook workbook;
    private final CellStyle defaultStyle;
    private final Sheet sheet;

    int currentRowNumber = 1;

    public ExcelReader(Workbook workbook) {
        this.workbook = workbook;
        sheet = workbook.createSheet("Statements");
        sheet.setColumnWidth(0, 7000);
        sheet.setColumnWidth(1, 7000);
        sheet.setColumnWidth(2, 8000);

        Row header = sheet.createRow(0);

        CellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        XSSFFont font = ((XSSFWorkbook) workbook).createFont();
        font.setFontName("Arial");
        font.setFontHeightInPoints((short) 14);
        font.setBold(true);
        headerStyle.setFont(font);

        Cell headerCell = header.createCell(0);
        headerCell.setCellValue("Ведомость");
        headerCell.setCellStyle(headerStyle);

        headerCell = header.createCell(1);
        headerCell.setCellValue("Статус код");
        headerCell.setCellStyle(headerStyle);

        headerCell = header.createCell(2);
        headerCell.setCellValue("Результат");
        headerCell.setCellStyle(headerStyle);

        defaultStyle = workbook.createCellStyle();
        defaultStyle.setWrapText(true);
    }

    public void addRow(String name, String code, String result) {
        Row row = sheet.createRow(currentRowNumber);
        Cell cell = row.createCell(0);
        cell.setCellValue(name);
        cell.setCellStyle(defaultStyle);

        CellStyle basedOnCodeStyle = workbook.createCellStyle();
        chooseCellColor(basedOnCodeStyle, code);
        basedOnCodeStyle.setWrapText(true);
        basedOnCodeStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        cell = row.createCell(1);
        cell.setCellValue(code);
        cell.setCellStyle(basedOnCodeStyle);

        cell = row.createCell(2);
        cell.setCellValue(result);
        cell.setCellStyle(basedOnCodeStyle);

        currentRowNumber++;
    }

    private void chooseCellColor(CellStyle style, String code) {
        if (code.equals("200")) {
            style.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
        }

        if (code.equals("404")) {
            style.setFillForegroundColor(IndexedColors.LIGHT_ORANGE.getIndex());
        }

        if (code.equals("500")) {
            style.setFillForegroundColor(IndexedColors.RED.getIndex());
        }
    }
}
