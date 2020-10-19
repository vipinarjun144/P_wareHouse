package com.nit.view;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.nit.model.OrderMethod;

public class OrderMethodPdf extends AbstractPdfView {

	@Override
	@SuppressWarnings( "unchecked" )
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.addHeader("Content-Disposition", "attachment;filename=OrderMethodPdf.pdf");
		Paragraph p=new Paragraph("WELCOME TO UOM");
		document.add(p);
		
		List<OrderMethod> list =  (List<OrderMethod>) model.get("list");
		PdfPTable t = new PdfPTable(6);
		t.addCell("ID");
		t.addCell("MODE");
		t.addCell("CODE");
		t.addCell("TYPE");
		t.addCell("ACCEPT");
		t.addCell("NOTE");
		for(OrderMethod om:list) {
			t.addCell(om.getOrderId().toString());
			t.addCell(om.getOrderMode());
			t.addCell(om.getOrderCode());
			t.addCell(om.getOrderType());
			t.addCell(om.getOrderAccept().toString());
			t.addCell(om.getDescription());
			
		}
		document.add(t);
		document.add(new Paragraph(new Date().toString()));

	}

}
