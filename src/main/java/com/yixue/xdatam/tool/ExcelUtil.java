package com.yixue.xdatam.tool;

import com.yixue.xdatam.entity.data.SubjectAnalyseEntity;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.*;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * 题目分析报表导出工具
 *
 * @author IBM CHEN ZHI KAN
 * @create 2017/8/27
 */
public class ExcelUtil {
    public static void exportExcel(String title,
                                   List<SubjectAnalyseEntity> results, OutputStream out) throws IOException {
        // 声明一个工作薄
        XSSFWorkbook workbook = new XSSFWorkbook();
        // 生成一个表格
        XSSFSheet sheet = workbook.createSheet(title);
        setDefaultStyle(sheet);
        setHeaders(workbook, getHeaders(), sheet);
        setBody(sheet, results);
        workbook.write(out);
    }

    public static void genatorExcel(OutputStream out, String content) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        // 生成一个表格
        XSSFSheet sheet = workbook.createSheet("content");
        XSSFRow row = sheet.createRow(0);
        XSSFCell cell = row.createCell(0);
        cell.setCellValue(content);
        workbook.write(out);
    }

    //设置表头信息
    private static void setHeaders(XSSFWorkbook workbook, String[] headers, XSSFSheet sheet) {
        // 产生表格标题行
        XSSFRow row = sheet.createRow(0);
        for (short i = 0; i < headers.length; i++) {
            XSSFCell cell = row.createCell(i);
            cell.setCellStyle(getHeaderStyle(workbook));
            //cell.setCellStyle(style);
            XSSFRichTextString text = new XSSFRichTextString(headers[i]);
            cell.setCellValue(text);
        }
    }

    private static String[] getHeaders() {
        String[] headers = {"序号ID", "知识点编号", "知识点描述", "题目自定义编号", "题目ID", "题目难度", "次数", "平均时间时长（s）", "预估答题时间（s）", "正答率"};
        return headers;
    }

    /**
     * 获取表头样式
     */
    private static XSSFCellStyle getHeaderStyle(XSSFWorkbook workbook) {
        XSSFCellStyle style = workbook.createCellStyle();
        // 生成一个字体
        XSSFFont font = workbook.createFont();
        // font.setFontHeightInPoints((short) 12);
        font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
        // 把字体应用到当前的样式
        style.setFont(font);
        // 指定当单元格内容显示不下时自动换行
        style.setWrapText(true);
        return style;
    }

    private static void setBody(XSSFSheet sheet, List<SubjectAnalyseEntity> results) {
        int tagNameWidth = "知识点描述".length() * 4 * 255;
        for (int rowIndex = 1; rowIndex <= results.size(); rowIndex++) {
            SubjectAnalyseEntity result = results.get(rowIndex - 1);
            if (null != result) {
                XSSFRow row = sheet.createRow(rowIndex);
                //设置id
                Cell idCell = row.createCell(0);
                idCell.setCellType(Cell.CELL_TYPE_STRING);
                idCell.setCellValue(rowIndex);

                //设置知识点编号
                Cell tagCodeCell = row.createCell(1);
                tagCodeCell.setCellType(Cell.CELL_TYPE_STRING);
                if (null != result.getTagCode()) {
                    tagCodeCell.setCellValue(result.getTagCode());
                } else {
                    tagCodeCell.setCellValue("");
                }

                //设置知识点描述
                Cell tagNameCell = row.createCell(2);
                tagNameCell.setCellType(Cell.CELL_TYPE_STRING);
                if (null != result.getTagName()) {
                    tagNameCell.setCellValue(result.getTagName());
                    if (result.getTagName().length() * 2 * 256 > tagNameWidth) {
                        tagNameWidth = result.getTagName().length() * 2 * 256;
                    }
                } else {
                    tagNameCell.setCellValue("");
                }

                //设置题目自定义编号
                Cell serialNumberCell = row.createCell(3);
                serialNumberCell.setCellType(Cell.CELL_TYPE_STRING);
                if (null != result.getSerialNumber()) {
                    serialNumberCell.setCellValue(result.getSerialNumber());
                } else {
                    serialNumberCell.setCellValue("");
                }

                //设置题目id
                Cell questionIdCell = row.createCell(4);
                questionIdCell.setCellType(Cell.CELL_TYPE_STRING);
                if (null != result.getQuestionId()) {
                    questionIdCell.setCellValue(result.getQuestionId());
                } else {
                    questionIdCell.setCellValue("");
                }

                //设置题目难度
                Cell difficultyCell = row.createCell(5);
                difficultyCell.setCellType(Cell.CELL_TYPE_STRING);
                if (null != result.getDifficulty()) {
                    difficultyCell.setCellValue(result.getDifficulty());
                } else {
                    difficultyCell.setCellValue("");
                }

                //设置次数
                Cell tagCodeCountCell = row.createCell(6);
                tagCodeCountCell.setCellType(Cell.CELL_TYPE_STRING);
                if (null != result.getTagCodeCount()) {
                    tagCodeCountCell.setCellValue(result.getTagCodeCount());
                } else {
                    tagCodeCountCell.setCellValue("");
                }

                //设置平均答题时长
                Cell spentTimeAvgCell = row.createCell(7);
                spentTimeAvgCell.setCellType(Cell.CELL_TYPE_STRING);
                if (null != result.getSpentTimeAvg()) {
                    spentTimeAvgCell.setCellValue(result.getSpentTimeAvg());
                } else {
                    spentTimeAvgCell.setCellValue("");
                }

                //预估平均答题时长
                Cell estimatesTimeAvgCell = row.createCell(8);
                estimatesTimeAvgCell.setCellType(Cell.CELL_TYPE_STRING);
                if (null != result.getEstimatesTimeAvg()) {
                    estimatesTimeAvgCell.setCellValue(result.getEstimatesTimeAvg());
                } else {
                    estimatesTimeAvgCell.setCellValue("");
                }

                //正答率
                Cell rightRateCell = row.createCell(9);
                rightRateCell.setCellType(Cell.CELL_TYPE_STRING);
                if (null != result.getRightRate()) {
                    rightRateCell.setCellValue(result.getRightRate());
                } else {
                    rightRateCell.setCellValue("");
                }
            }
        }
        sheet.setColumnWidth(1, "知识点编号".length() * 256 * 4);
        sheet.setColumnWidth(2, tagNameWidth);
        sheet.setColumnWidth(3, "题目自定义编号".length() * 256 * 4);
        sheet.setColumnWidth(4, "题目ID".length() * 256 * 4);
        sheet.setColumnWidth(5, "题目难度".length() * 256 * 4);
        sheet.setColumnWidth(6, "次数".length() * 256 * 4);
        sheet.setColumnWidth(7, "平均时间时长（s）".length() * 256 * 4);
        sheet.setColumnWidth(8, "预估答题时间（s）".length() * 256 * 4);
        sheet.setColumnWidth(9, "知识点编号".length() * 256 * 4);
        sheet.setColumnWidth(10, "正答率".length() * 256 * 4);

    }

    public static void setDefaultStyle(XSSFSheet sheet) {
        sheet.autoSizeColumn(1, true);
    }
}
