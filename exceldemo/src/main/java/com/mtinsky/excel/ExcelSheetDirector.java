package com.mtinsky.excel;

import jxl.Sheet;

/**
 * Created with IntelliJ IDEA.
 * User: lu
 * Date: 16-2-19
 * Time: 下午2:50
 * To change this template use File | Settings | File Templates.
 */
public class ExcelSheetDirector {

    private Sheet sheet;

    public void constructExcelSheet(ExcelSheetBuilder excelBuilder) {
        excelBuilder.setHead();
        excelBuilder.setRowHead();
        excelBuilder.setContent();
        this.sheet = excelBuilder.getSheet();
    }

    public Sheet getSheet() {
        return sheet;
    }
}
