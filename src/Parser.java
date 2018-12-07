import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.*;
import java.util.Iterator;
import java.util.*;
import java.io.*;
public class Parser {
    public static void main(String[] args) throws IOException {
        File excelfile=new File("EXCEL.xlsx");
        FileInputStream fis= new FileInputStream(excelfile);
        XSSFWorkbook workbook=new XSSFWorkbook(fis);
        XSSFSheet sheet=workbook.getSheetAt(0);
        Iterator<Row> rowIt=sheet.iterator();
        while (rowIt.hasNext())
        {
            Row row=rowIt.next();
            Iterator<Cell> cellIterator=row.cellIterator();
            while(cellIterator.hasNext())
            {
                Cell cell=cellIterator.next();
                System.out.print(cell.toString()+"; ");

            }
            System.out.println();
        }
        workbook.close();
        fis.close();
    }
}