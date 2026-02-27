package util;

import com.alibaba.excel.EasyExcel;
import com.excelpojo.mergerowpojo;
import com.excelpojo.stylepojo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

/*
 * @Author WQL-KXJ
 * @ProjectName easyexcel-dome
 * @PackageName util
 * @Date 2023/5/30 23:01
 * @Version 1.0
 */
@DisplayName("合并单元格")
public class mergeTest {
    @Test
    public void test() throws IOException {
        ArrayList<mergerowpojo> mergerowpojo = new ArrayList<mergerowpojo>();
        mergerowpojo.add(new mergerowpojo("空想家",new Date(),100.0));
        mergerowpojo.add(new mergerowpojo("晴天",new Date(),100.0));
        mergerowpojo.add(new mergerowpojo("栖息",new Date(),100.0));
        mergerowpojo.add(new mergerowpojo("道德",new Date(),100.0));

        EasyExcel.write("mergerow.xlsx",mergerowpojo.class).sheet("样式").doWrite(mergerowpojo);

    }
}
