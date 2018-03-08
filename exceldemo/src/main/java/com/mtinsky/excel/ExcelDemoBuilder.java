package com.mtinsky.excel;

import jxl.Sheet;
import jxl.format.ScriptStyle;
import jxl.format.UnderlineStyle;
import jxl.write.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static jxl.format.Alignment.CENTRE;
import static jxl.format.Border.ALL;
import static jxl.format.BorderLineStyle.NONE;
import static jxl.format.BorderLineStyle.THIN;
import static jxl.format.Colour.BLACK;
import static jxl.format.Colour.WHITE;

/**
 * Created with IntelliJ IDEA.
 * User: lu
 * Date: 16-2-19
 * Time: 下午3:41
 * To change this template use File | Settings | File Templates.
 */
public class ExcelDemoBuilder implements ExcelSheetBuilder {


    private WritableSheet sheet;

    private List<Map> contentListMap;//正文内容
    private int columnTotal;//对于标题头来说，需要合并的单元格个数
    private String author;//制表人
    private String titleName;//标题名称
    private String[] columnNameArr;

    private int lastDataRowNum;

    public ExcelDemoBuilder(String[] columnNameArr,List<Map> contentListMap, String author, WritableSheet sheet, String titleName) {
        this.columnNameArr = columnNameArr;
        this.contentListMap = contentListMap;
        this.columnTotal = 4;
        this.author = author;
        this.titleName = titleName;

        this.lastDataRowNum = 0;
        this.sheet = sheet;
    }

    //设备标题头
    public void setHead() {
        //设置单元格默认宽度
        sheet.getSettings().setDefaultColumnWidth(28);

        //第一行
        try {
            lastDataRowNum = lastDataRowNum +1;
            sheet.mergeCells(0, lastDataRowNum, columnTotal-1, lastDataRowNum);//合并第一行的第0单元格到第7个单元格，其中列索引从0开始，行索引从1开始
            sheet.addCell(new Label(0, 1, titleName,getTitleFirstRowCellFormat()));//为这个合并的单元格设置格式及填写内容
        } catch (WriteException e) {
            System.out.println("设置第一行合并单元格失败");
            e.printStackTrace();
        }

        //第二行
        try {
            lastDataRowNum = lastDataRowNum +1;
            sheet.mergeCells(0, lastDataRowNum, columnTotal-1, lastDataRowNum);
            sheet.addCell(new Label(0, 2, titleName,getTitleOtherRowCellFormat()));
        } catch (WriteException e) {
            System.out.println("设置第二行合并单元格失败");
            e.printStackTrace();
        }

        //第三行
        try {
            lastDataRowNum = lastDataRowNum +1;
            sheet.mergeCells(0, lastDataRowNum, columnTotal-1, lastDataRowNum);
            String forthRowValue = String.format("制表人：%s", author);
            sheet.addCell(new Label(0, 3, forthRowValue, getTitleOtherRowCellFormat()));
        } catch (WriteException e) {
            System.out.println("设置第三行合并单元格失败");
            e.printStackTrace();
        }

    }

    public void setRowHead() {
        try {
            lastDataRowNum = lastDataRowNum +1;
            String[] columnNameArr = {"序号","关联状态","事故编号","处理民警","民警警号","处理机构","事故地点","现场处理时间"};
            for(int beginColumn=0; beginColumn<columnNameArr.length; beginColumn++) {
                sheet.addCell(new Label(beginColumn, lastDataRowNum,columnNameArr[beginColumn], getCellFormat()));
            }
        } catch (WriteException e) {
            System.out.println("获取表格格式失败");
            e.printStackTrace();
        }
        return;
    }

    public void setContent() {
        int contentSize = contentListMap.size();
        if(contentSize==0) {
            return ;
        }
        lastDataRowNum = lastDataRowNum +1;
        for(int i=0;i<contentSize;i++, lastDataRowNum++) {
            int j = 0;
            Map rowValueMap = contentListMap.get(i);
            try {
                //序号
                sheet.addCell(new Label(j++, lastDataRowNum,new Integer(i+1).toString(),getCellFormat()));
                //关联状态: 0未执行关联，1已关联，2关联失败，3关联已删除
                int relStatusCode = Integer.parseInt(rowValueMap.get("GLBZ").toString());
                String relStatus =  "";
                switch(relStatusCode) {
                    case 0 :
                        relStatus = "未执行关联";
                        break;
                    case 1 :
                        relStatus = "已关联";
                        break;
                    case 2 :
                        relStatus = "关联失败";
                        break;
                    case 3 :
                        relStatus = "关联已删除";
                        break;
                    default:
                        relStatus = "";
                        break;
                }
                sheet.addCell(new Label(j++, lastDataRowNum,relStatus,getCellFormat()));
                //事故编号
                sheet.addCell(new Label(j++, lastDataRowNum,ifNull(rowValueMap.get("SGBH"),""),getCellFormat()));
                //处理民警
                sheet.addCell(new Label(j++, lastDataRowNum,ifNull(rowValueMap.get("CLMJ"),""),getCellFormat()));
                //民警警号
                sheet.addCell(new Label(j++, lastDataRowNum,ifNull(rowValueMap.get("police_id"),""),getCellFormat()));
                //处理机构
                sheet.addCell(new Label(j++, lastDataRowNum,ifNull(rowValueMap.get("CLJG"),""),getCellFormat()));
                //事故地点
                sheet.addCell(new Label(j++, lastDataRowNum,ifNull(rowValueMap.get("SGDD"),""),getCellFormat()));
                //现场处理时间
                sheet.addCell(new Label(j++, lastDataRowNum,ifNull(rowValueMap.get("XCCLSJ"),""),getCellFormat()));
            } catch (WriteException e) {
                System.out.println("获取表格格式失败");
                e.printStackTrace();
            }
        }
        return ;
    }

    public Sheet getSheet() {
        return this.sheet;
    }

    /**
     * 获取标题第一行的单元格格式
     * @return
     * @throws WriteException
     */
    private WritableCellFormat getTitleFirstRowCellFormat() throws WriteException {
        WritableFont writableFont = new WritableFont(WritableFont.createFont("宋体"),// 字体
                20,//WritableFont.DEFAULT_POINT_SIZE,   // 字号
                WritableFont.NO_BOLD,                  // 粗体
                false,                                 // 斜体
                UnderlineStyle.NO_UNDERLINE,            // 下划线
                BLACK,                              // 字体颜色
                ScriptStyle.NORMAL_SCRIPT);
        WritableCellFormat cellFormat = new WritableCellFormat(writableFont);
        cellFormat.setBackground(WHITE);// 设置单元格的背景颜色
        cellFormat.setAlignment(CENTRE); // 设置对齐方式
        cellFormat.setBorder(jxl.format.Border.NONE, NONE); // 添加边框

        return cellFormat;
    }

    /**
     * 获取标题除了第一行的单元格格式
     * @return
     * @throws WriteException
     */
    private WritableCellFormat getTitleOtherRowCellFormat() throws WriteException {
        WritableFont writableFont = new WritableFont(WritableFont.createFont("宋体"),// 字体
                20,//WritableFont.DEFAULT_POINT_SIZE,   // 字号
                WritableFont.NO_BOLD,                  // 粗体
                false,                                 // 斜体
                UnderlineStyle.NO_UNDERLINE,            // 下划线
                BLACK,                              // 字体颜色
                ScriptStyle.NORMAL_SCRIPT);
        WritableCellFormat cellFormat = new WritableCellFormat(writableFont);
        cellFormat.setBackground(WHITE);// 设置单元格的背景颜色
        cellFormat.setAlignment(CENTRE); // 设置对齐方式
        cellFormat.setBorder(jxl.format.Border.NONE, NONE); // 添加边框

        return cellFormat;
    }

    private WritableCellFormat getCellFormat() throws WriteException {
        WritableFont titleWf = new WritableFont(WritableFont.createFont("宋体"),// 字体
                12,//WritableFont.DEFAULT_POINT_SIZE,   // 字号
                WritableFont.NO_BOLD,                  // 粗体
                false,                                 // 斜体
                UnderlineStyle.NO_UNDERLINE,            // 下划线
                BLACK,                              // 字体颜色
                ScriptStyle.NORMAL_SCRIPT);
        WritableCellFormat wcf = new WritableCellFormat(titleWf);
        wcf.setAlignment(jxl.format.Alignment.CENTRE);
        wcf.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);
        wcf.setBackground(WHITE);// 设置单元格的背景颜色
        wcf.setBorder(ALL, THIN, BLACK); // 添加边框
        return wcf;
    }

    //与mysql的 ifnull一样
    private String ifNull(Object o,String value) {
        if(o==null) {
            return value;
        } else {
            return o.toString();
        }
    }
}
