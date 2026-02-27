package com.WQL.control;

import com.WQL.pojo.LaserBullHole;
import com.WQL.pojo.LaserCutImage;
import com.WQL.pojo.LaserRecognitionResult;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import javax.imageio.ImageIO;
import javax.xml.bind.DatatypeConverter;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

/*
 * @Author WQL-KXJ
 * @ProjectName SpringBoot-dome
 * @PackageName com.WQL.control
 * @Date 2024/3/26 10:51
 * @Version 1.0
 */
public class test_control {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/ii")
    public String getss(){
        String imagePath = "G:\\PictureData\\7c66__3.jpg"; // 替换为实际的图片路径

        try {
            // 读取图片文件
            byte[] imageBytes = Files.readAllBytes(Paths.get(imagePath));

            // 将图片字节流转换为Base64字符串
            String base64Image = Base64.getEncoder().encodeToString(imageBytes);

            // 远程调用激光弹孔识别程序
            LaserRecognitionResult laserRecognitionResult = remoteIdentification(base64Image);
            System.out.println(laserRecognitionResult);

            //是否为空
            if(laserRecognitionResult!=null){
                //裁图和标注
                if(laserRecognitionResult.getObjectType() == LaserBullHole.class){
                    LaserBullHole laserBullHole = (LaserBullHole) laserRecognitionResult.getObject();
                    byte[] bytes = DatatypeConverter.parseBase64Binary(base64Image);
                    // 将字节数组解码为 BufferedImage 对象
                    ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
                    BufferedImage image = ImageIO.read(bis);

                    // 图像上画一个圆形标注
                    drawCircle(image,laserBullHole.getLaserX(),laserBullHole.getLaserY());

                    // 裁剪图像
                    BufferedImage croppedImage = processImage(image, laserBullHole.getCropX(), laserBullHole.getCropY(), laserBullHole.getCropWidth(), laserBullHole.getCropHeight());

                    // 保存标注后的图像
                    saveImage(croppedImage, "G:\\output.jpg");
                }

                //裁图
                if(laserRecognitionResult.getObjectType() == LaserCutImage.class){
                    LaserCutImage laserCutImage = (LaserCutImage) laserRecognitionResult.getObject();
                    byte[] bytes = DatatypeConverter.parseBase64Binary(base64Image);
                    // 将字节数组解码为 BufferedImage 对象
                    ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
                    BufferedImage image = ImageIO.read(bis);
                    // 裁剪图像
                    BufferedImage croppedImage = processImage(image, laserCutImage.getCropX(), laserCutImage.getCropY(), laserCutImage.getCropWidth(), laserCutImage.getCropHeight());
                    // 保存标注后的图像
                    saveImage(croppedImage, "G:\\output_cut.jpg");
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";
    }

    //远程请求识别单孔程序
    public LaserRecognitionResult remoteIdentification(String base64) throws JsonProcessingException {
        String url = "http://127.0.0.1:8181/laser/recogn";
        String requestBody = "{\"target\": \"" + base64 + "\"}";

        HttpEntity<String> requestEntity = new HttpEntity<>(requestBody);
        //RestTemplate发起远程调用
        ResponseEntity<String> exchange = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
        //获取body信息
        String body = exchange.getBody();
        // 使用 Jackson来解析响应体
        JsonNode jsonNode = new ObjectMapper().readTree(body);

        try {
            if(jsonNode.get("code").asInt()== 1){
                return new LaserRecognitionResult(LaserBullHole.class,new ObjectMapper().readValue(jsonNode.get("data").toString(), LaserBullHole.class));
            }else if(jsonNode.get("code").asInt()== 0){
                return new LaserRecognitionResult(LaserCutImage.class,new ObjectMapper().readValue(jsonNode.get("data").toString(), LaserCutImage.class));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static BufferedImage processImage(BufferedImage originalImage, int cropX, int cropY, int cropWidth, int cropHeight) {
        // 裁剪图像
        BufferedImage croppedImage = originalImage.getSubimage(cropX, cropY, cropWidth, cropHeight);

        return croppedImage;
    }

    private static void drawCircle(BufferedImage image, int centerX, int centerY) {
        Graphics2D g2d = image.createGraphics();
        int circleRadius = 8; // 圆的半径
        Color circleColor = Color.RED; // 圆的颜色
        int strokeWidth = 3; // 线条宽度

        // 设置线条宽度
        g2d.setStroke(new BasicStroke(strokeWidth));
        // 画圆
        g2d.setColor(circleColor);
        g2d.drawOval(centerX - circleRadius, centerY - circleRadius, 2 * circleRadius, 2 * circleRadius);

        // 画圆
        g2d.setColor(circleColor);
        g2d.drawOval(centerX - circleRadius, centerY - circleRadius, 8 * circleRadius, 8 * circleRadius);
        //释放资源
        g2d.dispose();
    }

    // 保存图像
    private static void saveImage(BufferedImage image, String outputPath) {
        try {
            ImageIO.write(image, "jpg", new File(outputPath));
            System.out.println("标注后的图像已保存至：" + outputPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
