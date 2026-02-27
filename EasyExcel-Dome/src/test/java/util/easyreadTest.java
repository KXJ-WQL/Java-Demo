package util;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.read.metadata.ReadSheet;
import com.excelpojo.exceluserpojo;
import com.excelpojo.excludepojo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

/*
 * @Author WQL-KXJ
 * @ProjectName easyexcel-dome
 * @PackageName util
 * @Date 2023/5/30 23:29
 * @Version 1.0
 */
@DisplayName("简单读操作")
public class easyreadTest {

    @Test
    public void easyreadtest() throws IOException {

        String filepathname = "G:\\Java-Dome\\EasyExcel-Dome\\user1.xlsx";

        EasyExcel.read("G:\\Java-Dome\\EasyExcel-Dome\\user1.xlsx", exceluserpojo.class, new AnalysisEventListener<exceluserpojo>() {
            @Override
            public void invoke(exceluserpojo o, AnalysisContext analysisContext) {
                System.out.println(o);
            }

            @Override
            public void doAfterAllAnalysed(AnalysisContext analysisContext) {
                System.out.println("全部读取完毕！");
            }
        }).sheet().doRead();
    }

    @Test
    public void easyreadtest2() throws IOException {
        String filepathname = "G:\\Java-Dome\\EasyExcel-Dome\\user1.xlsx";

        ExcelReader excelReader = EasyExcel.read("G:\\Java-Dome\\EasyExcel-Dome\\user1.xlsx", exceluserpojo.class, new AnalysisEventListener<exceluserpojo>() {
            @Override
            public void invoke(exceluserpojo o, AnalysisContext analysisContext) {
                System.out.println(o);
            }

            @Override
            public void doAfterAllAnalysed(AnalysisContext analysisContext) {
                System.out.println("全部读取完毕！");
            }
        }).build();

        //创建sheet对象，并读取excel的第1个sheet(下标从0开始)
        ReadSheet sheet = EasyExcel.readSheet(0).build();
        excelReader.read(sheet);
        //关闭流操作，在读取文件时会创建临时文件，如果不关闭，磁盘会爆掉
        excelReader.finish();
    }

    @Test
    public void Allreadtest() throws IOException {

        String filepathname = "G:\\Java-Dome\\EasyExcel-Dome\\user1.xlsx";

        EasyExcel.read("G:\\Java-Dome\\EasyExcel-Dome\\user1.xlsx", exceluserpojo.class, new AnalysisEventListener<exceluserpojo>() {
            @Override
            public void invoke(exceluserpojo o, AnalysisContext analysisContext) {
                System.out.println(o);
            }

            @Override
            public void doAfterAllAnalysed(AnalysisContext analysisContext) {
                System.out.println("全部读取完毕！");
            }
        }).doReadAll();
    }


    @Test
    public void zhidreadtest() throws IOException {

        String filepathname = "G:\\Java-Dome\\EasyExcel-Dome\\user1.xlsx";

        ExcelReader excelReader = EasyExcel.read(filepathname).build();

        //读取第一个sheet
        ReadSheet readSheet1 = EasyExcel.readSheet(0).head(exceluserpojo.class).registerReadListener(new AnalysisEventListener<exceluserpojo>() {
            @Override
            public void invoke(exceluserpojo o, AnalysisContext analysisContext) {
                System.out.println(o);
            }

            @Override
            public void doAfterAllAnalysed(AnalysisContext analysisContext) {
                System.out.println("sheet1全部读取完毕！");
            }
        }).build();

        //读取第二个sheet
        ReadSheet readSheet2 = EasyExcel.readSheet(1).head(excludepojo.class).registerReadListener(new AnalysisEventListener<excludepojo>() {
            @Override
            public void invoke(excludepojo o, AnalysisContext analysisContext) {
                System.out.println(o);
            }

            @Override
            public void doAfterAllAnalysed(AnalysisContext analysisContext) {
                System.out.println("sheet2全部读取完毕！");
            }
        }).build();

        //批量读取两个sheet
        excelReader.read(readSheet1,readSheet2);
        //关闭流
        excelReader.finish();

    }







}
