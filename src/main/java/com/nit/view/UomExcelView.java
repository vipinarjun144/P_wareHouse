package com.nit.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;


import com.nit.model.Uom;

public class UomExcelView extends AbstractXlsView {

	@SuppressWarnings("unchecked")
	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.addHeader("ContentDisposition", "attachment;filename= uomexcelview.xlsx");
		Sheet s=workbook.createSheet("UOM");
		setHeader(s);
		List<Uom> list=(List<Uom>) model.get("list");
		setBody(s,list);
	}
	private void setHeader(Sheet s) {
		Row r=s.createRow(0);
		r.createCell(0).setCellValue("ID");
		r.createCell(0).setCellValue("TYPE");
		r.createCell(0).setCellValue("MODEL");
		r.createCell(0).setCellValue("NOTE");
		
	}
	 private void setBody(Sheet s, List<Uom> list) {
			int count=1;
			for(Uom st:list) {
				Row r=s.createRow(count++);
				r.createCell(0).setCellValue(st.getUomId());
				r.createCell(1).setCellValue(st.getUomType());
				r.createCell(2).setCellValue(st.getUomModel());
				r.createCell(3).setCellValue(st.getUomDesc());
			}
		}
		
		
	}


