package util;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.builder.ExcelWriterBuilder;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.excelpojo.dataformatpojo;
import com.excelpojo.exceluserpojo;
import com.excelpojo.themeuserpojo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

/*
 * @Author WQL-KXJ
 * @ProjectName easyexcel-dome
 * @PackageName util
 * @Date 2023/5/30 10:04
 * @Version 1.0
 */
@DisplayName("EasyExcel的简单使用")
public class easyOperateTest {

    @Test
    public void test01(){
        //创建Excel文档
        String fileName = "user1.xlsx";
        //根据exceluserpojo模板构建数据
        List<exceluserpojo> exceluserpojos = new ArrayList<exceluserpojo>();
        exceluserpojos.add(new exceluserpojo(1,"空想家","男","4000.99",new Date()));
        exceluserpojos.add(new exceluserpojo(2,"晴天","女","6000.99",new Date()));
        exceluserpojos.add(new exceluserpojo(3,"项庄","男","3000.99",new Date()));
        //向Excel表格中写数据
        EasyExcel.write(fileName,exceluserpojo.class).sheet("用户信息表").doWrite(exceluserpojos);

    }
    @Test
    public void test02(){
        //创建Excel文档
        String fileName = "user1.xlsx";
        //根据exceluserpojo模板构建数据
        List<exceluserpojo> exceluserpojos = new ArrayList<exceluserpojo>();
        exceluserpojos.add(new exceluserpojo(1,"玄门","男","4000.99",new Date()));
        exceluserpojos.add(new exceluserpojo(2,"晴天","女","6000.99",new Date()));
        exceluserpojos.add(new exceluserpojo(3,"项庄","男","3000.99",new Date()));
        //获取ExcelWriterBuilder对象
        ExcelWriter execlWrite = EasyExcel.write(fileName, exceluserpojo.class).build();
        //创建sheet对象
        WriteSheet sheet = EasyExcel.writerSheet("用户信息").build();
        //将数据写入sheet标签中
        execlWrite.write(exceluserpojos,sheet);
        //关闭流，文件流手动关闭
        execlWrite.finish();

    }

    //排除字段写入
    @Test
    public void test03(){
        //创建Excel文档
        String fileName = "excludeuser.xlsx";
        //根据exceluserpojo模板构建数据
        List<exceluserpojo> exceluserpojos = new ArrayList<exceluserpojo>();
        exceluserpojos.add(new exceluserpojo(1,"空想家","男","4000.99",new Date()));
        exceluserpojos.add(new exceluserpojo(2,"晴天","女","6000.99",new Date()));
        exceluserpojos.add(new exceluserpojo(3,"项庄","男","3000.99",new Date()));
        //设置排除的属性集合
        Set<String> set = new HashSet<>();
        set.add("salary");
        set.add("gender");

        //向Excel表格中写数据
        EasyExcel.write(fileName,exceluserpojo.class)
                //排除属性
                .excludeColumnFieldNames(set)
                .sheet("用户信息表")
                .doWrite(exceluserpojos);

    }
    //只允许字段写入
    @Test
    public void test04(){
        //创建Excel文档
        String fileName = "includeuser.xlsx";
        //根据exceluserpojo模板构建数据
        List<exceluserpojo> exceluserpojos = new ArrayList<exceluserpojo>();
        exceluserpojos.add(new exceluserpojo(1,"空想家","男","4000.99",new Date()));
        exceluserpojos.add(new exceluserpojo(2,"晴天","女","6000.99",new Date()));
        exceluserpojos.add(new exceluserpojo(3,"项庄","男","3000.99",new Date()));
        //设置排除的属性集合
        Set<String> set = new HashSet<>();
        set.add("userName");
        set.add("gender");

        //向Excel表格中写数据
        EasyExcel.write(fileName,exceluserpojo.class)
                //只包含属性
                .includeColumnFieldNames(set)
                .sheet("用户信息表")
                .doWrite(exceluserpojos);
    }
    @Test
    public void test06(){
        //创建Excel文档
        String fileName = "themeuser.xlsx";
        //根据exceluserpojo模板构建数据
        List<themeuserpojo> themeuserpojos = new ArrayList<themeuserpojo>();
        themeuserpojos.add(new themeuserpojo(1,"空想家","男",4000.99));
        themeuserpojos.add(new themeuserpojo(2,"晴天","女",6000.99));
        //向Excel表格中写数据
        EasyExcel.write(fileName,themeuserpojo.class).sheet("用户信息表").doWrite(themeuserpojos);

    }

    @Test//写入不同的sheet
    public void test07(){
        //创建Excel文档
        String fileName = "diffsheet.xlsx";
        //根据exceluserpojo模板构建数据
        List<exceluserpojo> exceluserpojos = new ArrayList<exceluserpojo>();
        exceluserpojos.add(new exceluserpojo(1,"空想家","男","4000.99",new Date()));
        exceluserpojos.add(new exceluserpojo(2,"晴天","女","6000.99",new Date()));
        //获取ExcelWriter对象
        ExcelWriter excelWriter = EasyExcel.write(fileName, exceluserpojo.class).build();

        for(int i=0;i<4;i++){
            WriteSheet build = EasyExcel.writerSheet("用户表" + i).build();
            excelWriter.write(exceluserpojos,build);
        }
        excelWriter.finish();

    }

    @Test//日期格式化
    public void test09(){
        //创建Excel文档
        String fileName = "dataformat.xlsx";
        //根据exceluserpojo模板构建数据
        List<dataformatpojo> dataformatpojos = new ArrayList<dataformatpojo>();
        dataformatpojos.add(new dataformatpojo("4000.9999",new Date()));
        dataformatpojos.add(new dataformatpojo("6000.9999",new Date()));
        //向Excel表格中写数据
        EasyExcel.write(fileName,dataformatpojo.class).sheet("用户信息格式化表").doWrite(dataformatpojos);

    }

}
