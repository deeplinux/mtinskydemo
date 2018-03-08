package com.mtinsky.excel;

import jxl.Sheet;

/**
 * Created with IntelliJ IDEA.
 * User: lu
 * Date: 16-2-19
 * Time: 下午2:50
 * To change this template use File | Settings | File Templates.
 */
public interface ExcelSheetBuilder {

    //头
    public void setHead();

    //行头（字段名）
    public void setRowHead();

    //内容
    public void setContent();

    public Sheet getSheet();
}
