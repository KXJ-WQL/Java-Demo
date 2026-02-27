package util;

import com.alibaba.excel.EasyExcel;
import com.excelpojo.WidthAndHeighpojo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

/*
 * @Author WQL-KXJ
 * @ProjectName easyexcel-dome
 * @PackageName util
 * @Date 2023/5/30 20:26
 * @Version 1.0
 */
@DisplayName("列宽行高演示")
public class WidthAndHeighTest {
    @Test
    public void test() throws IOException {
        ArrayList<WidthAndHeighpojo> widthAndHeighpojos = new ArrayList<WidthAndHeighpojo>();
        widthAndHeighpojos.add(new WidthAndHeighpojo("空想家","中二少年不少年","G:\\Java-Dome\\EasyExcel-Dome\\src\\main\\resources\\wql.jpg"));

        EasyExcel.write("WidthAndHeigh.xlsx",WidthAndHeighpojo.class).sheet("列宽行高").doWrite(widthAndHeighpojos);




    }
}
