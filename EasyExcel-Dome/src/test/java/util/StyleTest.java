package util;

import com.alibaba.excel.EasyExcel;
import com.excelpojo.WidthAndHeighpojo;
import com.excelpojo.stylepojo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

/*
 * @Author WQL-KXJ
 * @ProjectName easyexcel-dome
 * @PackageName util
 * @Date 2023/5/30 21:58
 * @Version 1.0
 */
@DisplayName("样式设置")
public class StyleTest {
    @Test
    public void test() throws IOException {
        ArrayList<stylepojo> stylepojos = new ArrayList<stylepojo>();
        stylepojos.add(new stylepojo("空想家","中二少年不少年"));

        EasyExcel.write("styleExcle.xlsx",stylepojo.class).sheet("样式").doWrite(stylepojos);

    }

}
