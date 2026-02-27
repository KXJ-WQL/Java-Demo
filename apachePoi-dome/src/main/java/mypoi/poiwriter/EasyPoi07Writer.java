package mypoi.poiwriter;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

/*
 * @Author WQL-KXJ
 * @ProjectName apachePoi-Test
 * @PackageName mypoi
 * @Date 2023/5/18 13:17
 * @Version 1.0
 */
public class EasyPoi07Writer {
    public static void main(String[] args) throws IOException {
        //1.创建工作簿(03版本)
        Workbook workbook = new XSSFWorkbook();
        //2.创建工作表
        Sheet sheet = workbook.createSheet("07版本测试");
        //3.创建行(第一行)
        Row row1 = sheet.createRow(0);
        //4.创建单元格并写入数据
        //(1,1)
        Cell cell1 = row1.createCell(0);
        cell1.setCellValue("商品ID");
        //(1,2)
        Cell cell2 = row1.createCell(1);
        cell2.setCellValue("商品姓名");
        //5.创建行(第二行)
        Row row2 = sheet.createRow(1);
        //(2,1)
        Cell cell3 = row2.createCell(0);
        cell3.setCellValue("1");
        //(2,2)
        Cell cell4 = row2.createCell(1);
        cell4.setCellValue("鼠标");

        //6.创建输出流将workbook进行输出到本地
        FileOutputStream fileOutputStream = new FileOutputStream("./07版本测试.xlsx");
        workbook.write(fileOutputStream);
        //7.关闭流
        fileOutputStream.close();
        System.out.println("xlsx文件保存成功！");
    }
}
