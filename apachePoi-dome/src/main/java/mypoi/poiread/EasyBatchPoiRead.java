package mypoi.poiread;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * @Author WQL-KXJ
 * @ProjectName apachePoi-Test
 * @PackageName mypoi.poiread
 * @Date 2023/5/25 11:48
 * @Version 1.0
 */
public class EasyBatchPoiRead {
    public static void main(String[] args) throws IOException {

        //1.获取Excel文件流
        File file = new File("G:\\Java-Dome\\apachePoi-dome\\bk.xlsx");
        FileInputStream fileInputStream = new FileInputStream(file);

        //2.获取工作簿
        Workbook workbook = new XSSFWorkbook(fileInputStream);

        //3.获取表
        Sheet sheet = workbook.getSheetAt(0);

        //4.获取标题内容(获取表中的第一行的表头数据)
        Row title = sheet.getRow(0);
        //非空判断
        if(title!=null){
            //获取标题的单元格，用于遍历获取所有单元格
            int cellNum = title.getPhysicalNumberOfCells();
            //遍历获取标题内容
            for (int i=0;i<cellNum;i++){
                //获取单元格
                Cell cell = title.getCell(i);
                //单元格非空
                if(cell!=null){
                    String stringCellValue = cell.getStringCellValue();
                    System.out.print(stringCellValue+"\t");
                }
            }
        }
        //打印换行
        System.out.println();

        /*5.获取表数据
        获取所有表中的所有行数*/
        int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();
        //循环遍历行
        for(int i=1;i<physicalNumberOfRows;i++){
            //获取行对象
            Row rowData = sheet.getRow(i);
            //获取行中的所有表格数据数
            int physicalNumberOfCells = rowData.getPhysicalNumberOfCells();
            //循环遍历表格数据
            for(int a=0;a<physicalNumberOfCells;a++){
                //获取表格对象
                Cell cell = rowData.getCell(a);
                //获取表格内的数据类型
                CellType cellType = cell.getCellType();
                //类型判断
                switch (cellType){
                    case STRING://字符类型
                        //获取字符串值
                        String stringCellValue = cell.getStringCellValue();
                        System.out.print(stringCellValue+"\t");
                        break;
                    case NUMERIC://数值类型
                        //判断是否为日期类型
                        if(DateUtil.isCellDateFormatted(cell)){
                            //获取日期类型值
                            Date dateCellValue = cell.getDateCellValue();
                            String formatDate = new SimpleDateFormat("yyyy-MM-dd").format(dateCellValue);
                            System.out.print(formatDate+"\t");
                        }else {
                            //获取数字类型值
                            double numericCellValue = cell.getNumericCellValue();
                            System.out.print(numericCellValue+"\t");
                        }
                        break;
                }
            }
            //数据换行
            System.out.println();
        }

    }
}
