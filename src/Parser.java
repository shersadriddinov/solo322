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
        double  total_strake, c,d;
        File src = new File("D:/javebet/solo322/src/Dataset/EXCEL.xlsx");
        FileInputStream fis = new FileInputStream(src);
        XSSFWorkbook wb = new XSSFWorkbook(fis);

        XSSFSheet sheet1 = wb.getSheetAt(0);
        DataFormatter formatter = new DataFormatter();

        int rowcount = sheet1.getLastRowNum();
        System.out.println("Total Row " + rowcount);

        for (int i=1; i<=rowcount; i++)
        {
            Cell cell = sheet1.getRow(i).getCell(0);
            String name = formatter.formatCellValue(cell);
            System.out.println(" "+name);
        }
        for (int i=1; i<=rowcount; i++)
        {
            System.out.println(" ");
            Cell cell1=sheet1.getRow(i).getCell(1);
            total_strake = cell1.getNumericCellValue();
            System.out.print(" "+total_strake);
        }
        for (int i=1; i<=rowcount; i++)
        {
            System.out.println(" ");
            Cell cell2=sheet1.getRow(i).getCell(2);
            c= cell2.getNumericCellValue();
            System.out.print(c+" ");
        }
        for (int i=1; i<=rowcount ; i++)
        {
            System.out.println(" ");
            Cell cell3=sheet1.getRow(i).getCell(3);
            d= cell3.getNumericCellValue();
            System.out.print(d);
        }
        wb.close();
    }
}