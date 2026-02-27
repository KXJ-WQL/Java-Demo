package mypoi.poiwriter;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

/*
 * @Author WQL-KXJ
 * @ProjectName apachePoi-Test
 * @PackageName mypoi
 * @Date 2023/5/20 9:20
 * @Version 1.0
 */
public class EastBigDataWriter {
    public static void main(String[] args) throws IOException {

        //开始时间
        long start = System.currentTimeMillis();

        //1.创建工作簿
        Workbook workbook = new SXSSFWorkbook();

        //2.创建表
        Sheet sheet = workbook.createSheet("大数据量写入");

        //3.批量写入数据
        for(int rownum =0;rownum<65536;rownum++){
            Row row = sheet.createRow(rownum);
            for(int cellnum=0;cellnum<20;cellnum++){
                Cell cell = row.createCell(cellnum);
                cell.setCellValue(cellnum+1);
            }
        }

        //4.写文件
        FileOutputStream fileOutputStream = new FileOutputStream("./大数据量写入.xls");
        workbook.write(fileOutputStream);

        //5.释放
        fileOutputStream.close();

        //结束时间
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }
}
