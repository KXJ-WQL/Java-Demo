package mypoi.util;

import mypoi.entity.ExamEntity;
import org.apache.poi.ss.formula.functions.T;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/*
 * @Author WQL-KXJ
 * @ProjectName apachePoi-Test
 * @PackageName mypoi.util
 * @Date 2023/5/28 10:49
 * @Version 1.0
 */
public class excelUtil {


    //获取表头数据
    public <T> List<T> getExcelHead(FileInputStream fileInputStream, Class<ExamEntity> tClass) throws IOException {
        //存储实体类数据集合
        ArrayList<T> result = new ArrayList<>();
        //获取Workbook
        Workbook workbook = new XSSFWorkbook(fileInputStream);
        //通过下标获取第一张表
        Sheet sheetAt = workbook.getSheetAt(0);
        //获取第一行
        Row row = sheetAt.getRow(1);
        //创建list用于存储表头数据
        ArrayList<String> arrayList = new ArrayList<>();
        //遍历row中的头数据
        for(Cell cell:row){
            //cell不为空放入集合中
            arrayList.add(cell.getStringCellValue());
        }

        //获取具体数据
        for(int a=2;a<sheetAt.getPhysicalNumberOfRows();a++){
            //获取具体数据行
            Row row1 = sheetAt.getRow(a);
            //row行不为空
            if(row1!=null){
                //标记
                int j =0;
                //存储数据map
                HashMap<String,String> map = new HashMap<>();
                //遍历单元格数据
                for(Cell cell:row1){
                    //获取单元格数据
                    map.put(arrayList.get(j),getExcelData(cell));
                    j++;
                }
                //将map转换成为实体类
                T t = (T) mapToEntity(map, tClass);
                result.add(t);
            }
        }
        return result;
    }
    //cell数值类型格式化对象
    public static NumberFormat nf = NumberFormat.getNumberInstance();

    static {
        //去掉小数点
        nf.setGroupingUsed(false);
    }

    //获取具体数据
    public String getExcelData(Cell cell) throws IOException {
        //获取表格内的数据类型
        CellType cellType = cell.getCellType();
        //值
        String value = "";
        //类型判断
        switch (cellType){
            case STRING://字符类型
                //获取字符串值
                 value = cell.getStringCellValue();
                break;
            case NUMERIC://数值类型
                value = nf.format(cell.getNumericCellValue());
                break; }
         return value;
    }

    //map转换成实体类
    private <T> T mapToEntity(Map<String,String> map, Class<T> entity){
        T t = null;
        try{
            t = entity.newInstance();
            //遍历获取类中的属性
            for(Field field:entity.getDeclaredFields()){
                if(map.containsKey(field.getName())){
                    //属性是否可读写
                    boolean accessible = field.isAccessible();
                    //设置可读
                    field.setAccessible(true);
                    //获取Map中的属性对应的值
                    String str = map.get(field.getName());
                    //获取实体类属性的类型
                    String type = field.getGenericType().toString();
                    //不同类型的判断赋值
                    if(str!=null){
                        if(type.equals("class java.lang.String")){
                            field.set(t,str);
                        }else if(type.equals("class java.lang.Double")){
                            field.set(t,Double.parseDouble(String.valueOf(str)));
                        }else if(type.equals("class java.util.Date")){
                            Date date = new SimpleDateFormat("yyyy年MM月dd日 HH:mm-HH:mm").parse(str);
                            field.set(t,date);
                        }
                    }
                    field.setAccessible(!accessible);
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return t;
    }

}
