package com.nit.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.nit.model.OrderMethod;

public class OrderMethodExcelView extends AbstractXlsView {
	
	@SuppressWarnings("unchecked")
	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.addHeader("ContentDisposition", "attachment;filename=ordermethodexcelview.xlsx");
		Sheet s=workbook.createSheet("ORDER METHOD");
		setHeader(s);
		List<OrderMethod> list=(List<OrderMethod>) model.get("list");
		setBody(s,list);
	}
	private void setHeader(Sheet s) {
		Row r=s.createRow(0);
		r.createCell(0).setCellValue("ID");
		r.createCell(0).setCellValue("MODE");
		r.createCell(0).setCellValue("CODE");
		r.createCell(0).setCellValue("TYPE");
		r.createCell(0).setCellValue("ACCEPT");
		r.createCell(0).setCellValue("NOTE");
		
	}
	private void setBody(Sheet s, List<OrderMethod> list) {
		int count=1;
		for(OrderMethod om:list) {
			Row r=s.createRow(count++);
			r.createCell(0).setCellValue(om.getOrderId());
			r.createCell(1).setCellValue(om.getOrderMode());
			r.createCell(2).setCellValue(om.getOrderCode());
			r.createCell(3).setCellValue(om.getOrderType());
			r.createCell(4).setCellValue(om.getOrderAccept().toString());
			r.createCell(5).setCellValue(om.getDescription());
		}
		
	}

}
