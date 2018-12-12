import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.*;
import java.util.Iterator;
import java.util.*;
import java.io.*;
import java.lang.Double;
public class Parser {
    public static void main(String[] args) throws IOException {
        double  total_strake, odd, temp;
        int status;
        String name;
        File src = new File("src/Dataset/EXCEL.xlsx");
        FileInputStream fis = new FileInputStream(src);
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet1 = wb.getSheetAt(0);
        DataFormatter formatter = new DataFormatter();

        // Connecting to database
        DataModel data = new DataModel("Tester");
        data.insertToAccount(10000);

        int rowcount = sheet1.getLastRowNum();
        System.out.println("Total Row " + rowcount);

        for (int i = 1; i <= rowcount; i++) {
            // Bet
            Cell cell = sheet1.getRow(i).getCell(0);
            name = formatter.formatCellValue(cell);
            System.out.println(name);

            // Total Strake
            Cell cell1 = sheet1.getRow(i).getCell(1);
            total_strake = cell1.getNumericCellValue();
            System.out.print(total_strake);

            // Odd
            Cell cell2 = sheet1.getRow(i).getCell(2);
            odd = cell2.getNumericCellValue();
            System.out.print(odd);

            // Status
            Cell cell3 = sheet1.getRow(i).getCell(3);
            temp = cell3.getNumericCellValue();
            status = (int)temp;
            System.out.println(status);

            // Inserting to database
            data.insertToBetting_history(name, total_strake, odd, status);
        }
        wb.close();
    }
}