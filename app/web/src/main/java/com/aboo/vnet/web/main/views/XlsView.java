//package com.aboo.vnet.web.main.views;
//
//import java.util.Map;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.springframework.web.servlet.view.document.AbstractXlsView;
//
//public class XlsView extends AbstractXlsView {
//
//	@Override
//	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
//			HttpServletResponse response) throws Exception {
//		Sheet sheet = workbook.createSheet("Test");
//		sheet.createRow(0);
//	}
//
//}
