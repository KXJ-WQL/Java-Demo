package util;

import com.alibaba.excel.EasyExcel;
import com.excelpojo.fullexcelpojo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/*
 * @Author WQL-KXJ
 * @ProjectName easyexcel-dome
 * @PackageName util
 * @Date 2023/6/2 16:55
 * @Version 1.0
 */
@DisplayName("数据填充")
public class fulleasyTest {

    @Test
    public void dangfulleasttest(){
        String exceltempalate = "G:\\Java-Dome\\EasyExcel-Dome\\TemplateExcel.xlsx";
        String filepath = "G:\\Java-Dome\\EasyExcel-Dome\\tptoExcel.xlsx";

        fullexcelpojo fullexcelpojo = new fullexcelpojo();
        fullexcelpojo.setNickname("空想家");
        fullexcelpojo.setAge(18);
        EasyExcel.write(filepath).withTemplate(exceltempalate).sheet().doFill(fullexcelpojo);
    }

    @Test
    public void duofulleasttest(){
        String exceltempalate = "G:\\Java-Dome\\EasyExcel-Dome\\TemplateExcel.xlsx";
        String filepath = "G:\\Java-Dome\\EasyExcel-Dome\\tptoExcel.xlsx";

        ArrayList<fullexcelpojo> arrayList = new ArrayList<>();
        arrayList.add(new fullexcelpojo("空想家",18));
        arrayList.add(new fullexcelpojo("晴天",20));
        arrayList.add(new fullexcelpojo("火狐",12));
        arrayList.add(new fullexcelpojo("烤肉",2));
        EasyExcel.write(filepath).withTemplate(exceltempalate).sheet().doFill(arrayList);
    }
}
