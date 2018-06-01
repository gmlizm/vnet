//package com.aboo.vnet.web.main.views;
//
//import java.util.Map;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.springframework.web.servlet.view.document.AbstractXlsxView;
//
//public class XlsxView extends AbstractXlsxView {
//
//	@Override
//	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
//			HttpServletResponse response) throws Exception {
//		Sheet sheet = workbook.createSheet("Spring");
//		Row row = sheet.createRow(1);
//		Cell cell = row.createCell(0);
//		cell.setCellValue("Test");
//	}
//
//}
