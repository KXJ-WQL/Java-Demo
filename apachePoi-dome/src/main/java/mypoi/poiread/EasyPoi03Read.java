package mypoi.poiread;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/*
 * @Author WQL-KXJ
 * @ProjectName apachePoi-Test
 * @PackageName mypoi.poiread
 * @Date 2023/5/20 12:21
 * @Version 1.0
 */
public class EasyPoi03Read {
    public static void main(String[] args) throws IOException {
        //1.获取Excel文件流
        File file = new File("G:\\Java-Dome\\apachePoi-dome\\bk.xlsx");
        FileInputStream fileInputStream = new FileInputStream(file);

        //2.获取工作簿
        Workbook workbook = new XSSFWorkbook(fileInputStream);

        //3.获取表(通过下标进行获取也可以通过表名来获取)
        Sheet sheet = workbook.getSheetAt(0);

        //4.获取行(通过下标进行获取第一行)
        Row row = sheet.getRow(1);

        //5.获取单元格(通过下标获取低一个单元格)
        Cell cell = row.getCell(0);

        //6.读取数据(需要注意不同数据类型)
        cell.getCellComment();
        String stringCellValue = cell.getStringCellValue();
        System.out.println(stringCellValue);

        //7.关闭源
        fileInputStream.close();
    }
}
