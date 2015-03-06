package org.qunar.qst.qst.util;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Font;
import org.qunar.qst.qst.annotition.ExcelColumn;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by ronghaizheng on 15/3/6.
 */
public class ExcelExportUtil {

    private static Logger logger = LoggerFactory.getLogger(ExcelExportUtil.class);
    private static int EXCEL_MAX_ROW_NO = 65535;
    private static int EXCEL_MAX_SHEET_CNT = 255;

    /**
     * 导出Excel
     *
     * @param sheetName excle表格名
     * @param excelData 要导出的数据
     * @return
     * @author mars.mao created on 2014年10月17日下午7:36:26
     */
    public static <T> HSSFWorkbook export(String sheetName, List<T> excelData) {
        // 声明一个工作薄
        HSSFWorkbook workbook = new HSSFWorkbook();
        return export(sheetName, excelData, workbook);
    }

    /**
     * 导出Excel
     *
     * @param sheetName excle表格名
     * @param excelData 要导出的数据
     * @param workbook  要导出的工作薄
     * @return
     * @author mars.mao created on 2014年10月17日下午7:36:26
     */
    public static <T> HSSFWorkbook export(String sheetName, List<T> excelData, HSSFWorkbook workbook) {

        if (excelData == null || excelData.isEmpty() || workbook == null || StringUtils.isBlank(sheetName)) {
            return null;
        }

        try {

            // 定义标题行字体
            Font font = workbook.createFont();
            font.setBoldweight(Font.BOLDWEIGHT_BOLD);

            int totalDataSize = excelData.size();
            int sheetCnt = totalDataSize / EXCEL_MAX_ROW_NO + 1;

            if (sheetCnt > EXCEL_MAX_SHEET_CNT) {
                throw new Exception("数据量超过了Excel的容量范围！");
            }

            for (int i = 0; i < sheetCnt; i++) {
                int fromIndex = i * EXCEL_MAX_ROW_NO;
                int toIndex = fromIndex + EXCEL_MAX_ROW_NO;
                toIndex = toIndex > totalDataSize ? totalDataSize : toIndex;
                List<T> sheetData = excelData.subList(fromIndex, toIndex);

                // 生成一个表格
                HSSFSheet sheet = workbook.createSheet(sheetName + "_" + i);

                // 生成标题行
                createHeader(sheetData, sheet, font);

                // 遍历集合数据，产生数据行
                createBody(sheetData, sheet);
            }

            return workbook;
        } catch (Exception e) {
            logger.error("导出Excel异常！", e);
        }

        return null;
    }

    /**
     * 创建表格数据
     *
     * @param excelData
     * @param sheet
     * @author mars.mao created on 2014年10月17日下午3:43:43
     */
    private static <T> void createBody(List<T> excelData, HSSFSheet sheet) {
        int dataRowIndex = 1;
        for (T data : excelData) {
            // 创建数据行
            HSSFRow dataRow = sheet.createRow(dataRowIndex);

            Class<? extends Object> dataClass = data.getClass();
            Field[] fields = dataClass.getDeclaredFields();
            int columnIndex = 0;
            for (Field field : fields) {
                // 如果没有配置注解，则不在excel中导出该字段
                ExcelColumn columnHeader = field.getAnnotation(ExcelColumn.class);
                if (columnHeader == null) {
                    continue;
                }

                // 创建列
                HSSFCell cell = dataRow.createCell(columnIndex);

                // 反射获取字段的值
                String aimPattern = columnHeader.pattern();
                Object fieldValue = getFieldValue(data, field);
                String textValue = " ";
                if (fieldValue != null) {
                    textValue = fieldValue.toString();
                }
                if (fieldValue instanceof Date) {
                    try {
                        String pattern = StringUtils.isBlank(aimPattern) ? "yyyy-MM-dd HH:mm:ss" : aimPattern;
                        Date date = (Date) fieldValue;
                        textValue = DateFormatUtils.format(date, pattern);
                    } catch (Exception e) {
                        logger.error("导出Excel日期格式化错误！", e);
                    }
                } else if (fieldValue instanceof Number) {
                    if (StringUtils.isNotBlank(aimPattern)) {
                        try {
                            double doubleValue = Double.parseDouble(fieldValue.toString());
                            DecimalFormat df1 = new DecimalFormat(aimPattern);
                            textValue = df1.format(doubleValue);
                        } catch (Exception e) {
                            logger.error("导出Excel数字格式化错误！", e);
                        }
                    }
                }

                HSSFRichTextString text = new HSSFRichTextString(textValue);
                cell.setCellValue(text);

                columnIndex++;
            }

            dataRowIndex++;
        }
    }

    /**
     * 生成Excel的标题行
     *
     * @param excelData 导出的数据列表
     * @param sheet     excel表
     * @return
     * @author mars.mao created on 2014年10月17日下午2:08:41
     */
    private static <T> void createHeader(List<T> excelData, HSSFSheet sheet, Font font) {
        HSSFRow headerRow = sheet.createRow(0);
        Field[] fields = excelData.get(0).getClass().getDeclaredFields();
        int columnIndex = 0;
        for (Field field : fields) {

            // 如果没有配置注解，则不在excel中导出该字段
            ExcelColumn columnHeader = field.getAnnotation(ExcelColumn.class);
            if (columnHeader == null) {
                continue;
            }

            // 获取指定的列标题和列宽高度
            String columnTitle = columnHeader.headerName();
            int columnWidth = columnHeader.columnWidth();
            int columnHeight = columnHeader.columnHeight() * 256;

            // 创建列
            HSSFCell cell = headerRow.createCell(columnIndex);
            headerRow.setHeight((short) columnHeight);
            HSSFRichTextString text = new HSSFRichTextString(columnTitle);
            text.applyFont(font);
            // 设置列标题
            cell.setCellValue(text);
            // 设置列宽度
            sheet.setColumnWidth(columnIndex, columnWidth * 256);
            sheet.setDefaultRowHeight((short) columnHeight);

            columnIndex++;
        }
    }

    /**
     * 反射获取字段的值
     *
     * @param obj   对象
     * @param field 字段
     * @return
     * @author mars.mao created on 2014年10月17日下午2:58:53
     */
    private static <T> Object getFieldValue(T obj, Field field) {
        Object fieldValue = " ";

        try {
            field.setAccessible(true);
            fieldValue = field.get(obj);
            if (fieldValue != null) {
                return fieldValue;
            }
        } catch (Exception e) {
            logger.error("导出Excel动态获取字段值异常", e);
        }
        return fieldValue;
    }

}
