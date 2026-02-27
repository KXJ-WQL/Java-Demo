package util;

import com.alibaba.excel.EasyExcel;
import com.excelpojo.ImageData;
import com.excelpojo.exceluserpojo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
 * @Author WQL-KXJ
 * @ProjectName easyexcel-dome
 * @PackageName util
 * @Date 2023/5/30 17:08
 * @Version 1.0
 */
@DisplayName("EsayExcel写入图片")
public class imageDataTest {

    @Test
    public void test() throws IOException {

        String name = "imageuser.xlsx";

        ArrayList<ImageData> arrayList = new ArrayList<>();
        ImageData imageData = new ImageData();
        imageData.setFile(new File("G:\\Java-Dome\\EasyExcel-Dome\\src\\main\\resources\\wql.jpg"));
        imageData.setInputStream(new FileInputStream(new File("G:\\Java-Dome\\EasyExcel-Dome\\src\\main\\resources\\wql.jpg")));
        imageData.setImgStr("G:\\Java-Dome\\EasyExcel-Dome\\src\\main\\resources\\wql.jpg");
        imageData.setUrl(new URL("https://wql.luoqin.ltd/wp-content/uploads/2022/06/1-2.jpg"));

        byte[] b = new byte[(int)new File("G:\\Java-Dome\\EasyExcel-Dome\\src\\main\\resources\\wql.jpg").length()];
        FileInputStream fileInputStream = new FileInputStream("G:\\Java-Dome\\EasyExcel-Dome\\src\\main\\resources\\wql.jpg");
        fileInputStream.read(b,0,(int)new File("G:\\Java-Dome\\EasyExcel-Dome\\src\\main\\resources\\wql.jpg").length());
        imageData.setByteArray(b);
        //添加到集合
        arrayList.add(imageData);

        EasyExcel.write(name,ImageData.class).sheet("图片写入表").doWrite(arrayList);
    }

}
