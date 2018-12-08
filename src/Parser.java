import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.*;
import java.util.Iterator;
import java.util.*;
import java.io.*;
public class Parser {
    public static void main(String[] args) throws IOException {
        File src=new File("EXCEL.xlsx");
        FileInputStream fis=new FileInputStream(src);
        XSSFWorkbook wb=new XSSFWorkbook(fis);
        XSSFSheet sheet1=wb.getSheetAt(0);
        DataFormatter formatter = new DataFormatter();
        int rowcount=sheet1.getLastRowNum();
        System.out.println("Total Row " + rowcount);
        for(int i=0;i<=rowcount;i++) {
            System.out.println();
            for (int j = 0; j < 4; j++) {
                int k=i+1;
                k=j+1;
                Cell cell = sheet1.getRow(i).getCell(j);
                String var_name = formatter.formatCellValue(cell);
                System.out.print(" " + var_name);
            }
        }
        wb.close();
    }
}