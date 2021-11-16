package com.heqing.java.poi;

import com.alibaba.fastjson.JSONObject;
import com.heqing.java.poi.excel.PoiRow;
import com.heqing.java.poi.excel.PoiSheet;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.*;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StudyPoiExcel {

    @Test
    public void test() {
        String path = "D:\\test\\1.xlsx";
        readExcel(path);
    }

    public void readExcel(String path) {
        try {
            File file = new File(path);
            Workbook workbook = WorkbookFactory.create(file);
            List<PoiSheet> sheetList = readSheet(workbook);
            System.out.println("-->" + JSONObject.toJSONString(sheetList));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<PoiSheet> readSheet(Workbook workbook) {
        List<PoiSheet> sheetList = new ArrayList<>();
        // excel 中页的数量
        int sheetNum = workbook.getNumberOfSheets();
        // 查询每一页内容
        for(int s=0; s<sheetNum; s++) {
            PoiSheet poiSheet = new PoiSheet();
            // 获取第s页的内容
            Sheet sheet = workbook.getSheetAt(s);
            List<PoiRow> rowList = readRow(sheet);

            poiSheet.setNum(s);
            poiSheet.setPoiRowList(rowList);
            sheetList.add(poiSheet);
        }
        return sheetList;
    }

    public List<PoiRow> readRow(Sheet sheet) {
        List<PoiRow> rowList = new ArrayList<>();

        // 获取当前页中行的数量
        int rowNum = sheet.getPhysicalNumberOfRows();
        // 查询当前页中每一行的内容
        for(int r=0; r<rowNum; r++) {
            Row row = sheet.getRow(r);
            List<String> cellList = readCell(row);

            PoiRow poiRow = new PoiRow();
            poiRow.setNum(r);
            poiRow.setCellList(cellList);
            rowList.add(poiRow);
        }
        return rowList;
    }

    public List<String> readCell(Row row) {
        List<String> callList = new ArrayList<>();
        // 获取当前行中列的数量
        int rowCell = row.getLastCellNum();
        // 查询当前行中每一列的内容
        for(int c=0; c<rowCell; c++) {
            Cell cell = row.getCell(c);
            callList.add(getCellValue(cell));
        }
        return callList;
    }

    //获取单元格各类型值，返回字符串类型
    private String getCellValue(Cell cell) {
        //判断是否为null或空串
        if (cell == null || cell.toString().trim().equals("")) {
            return "";
        }
        String cellValue = "";

        // 以下是判断数据的类型
        switch (cell.getCellType()) {
            case NUMERIC: // 数字
                if (HSSFDateUtil.isCellDateFormatted(cell)) {// 判断是否为日期类型
                    Date date = cell.getDateCellValue();
                    DateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                    cellValue = formater.format(date);
                } else {
                    cellValue = cell.getNumericCellValue() + "";
                }
                break;
            case STRING: // 字符串
                cellValue = cell.getStringCellValue();
                break;
            case BOOLEAN: // Boolean
                cellValue = cell.getBooleanCellValue() + "";
                break;
            case FORMULA: // 公式
                cellValue = cell.getCellFormula() + "";
                break;
            case BLANK: // 空值
                cellValue = "";
                break;
            case ERROR: // 故障
                cellValue = "非法字符";
                break;
            default:
                cellValue = "未知类型";
                break;
        }
        return cellValue;
    }
}
