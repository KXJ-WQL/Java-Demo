package mypoi.util;

import mypoi.entity.ExamEntity;
import org.apache.poi.ss.formula.functions.T;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/*
 * @Author WQL-KXJ
 * @ProjectName apachePoi-Test
 * @PackageName mypoi.util
 * @Date 2023/5/28 23:14
 * @Version 1.0
 */
public class test {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(new File("G:\\Java-Dome\\apachePoi-dome\\bk.xlsx"));
        excelUtil excelUtil = new excelUtil();
        List<ExamEntity> excelHead = excelUtil.getExcelHead(fileInputStream, ExamEntity.class);
        System.out.println(excelHead.toString());
    }
}
