package com.mtinsky.excel;

import jxl.Workbook;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用于生成excel表格，生成excel采用了jxl库
 * 其中使用了建造者模式
 */
public class TestExcelDemoMain {
    public static void main(String[] args) throws IOException, WriteException {
        //TODO
        List<Map> contentListMap = new ArrayList<Map>();
        HashMap tMap = new HashMap();
        contentListMap.add(tMap);
        String author = "testuser";
        String titleName = "testTitle";

        File outputFile = new File("demo.excel");
        //创建工作簿
        WritableWorkbook wwb = null;
        //设置outputstream，用于导出excel
        wwb = Workbook.createWorkbook(new FileOutputStream(outputFile));

        //通过建造者模式构建sheet
        String sheetName = "执法无视频(简易程序)";
        WritableSheet writableSheet = wwb.createSheet(sheetName, 0);
        ExcelSheetDirector excelSheetDirector = new ExcelSheetDirector();
        excelSheetDirector.constructExcelSheet(new ExcelDemoBuilder(contentListMap,author,writableSheet,titleName));

        //导出
        wwb.write();
        wwb.close();
    }
}
