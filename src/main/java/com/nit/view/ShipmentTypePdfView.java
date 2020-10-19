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
import com.nit.model.ShipmentType;

public class ShipmentTypePdfView extends AbstractPdfView{

	@SuppressWarnings("unchecked")
	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.addHeader("Content-Disposition","attachment;filename=ShipmentType.pdf");
		Paragraph p=new Paragraph();
		document.add(p);
		List<ShipmentType> list=(List<ShipmentType>) model.get("list");
		PdfPTable t=new PdfPTable(6);
		t.addCell("ID");
		t.addCell("CODE");
		t.addCell("GRADE");
		t.addCell("MODE");
		t.addCell("ENABLE");
		t.addCell("NOTE");
		for(ShipmentType st:list) {
			t.addCell(st.getShipId().toString());
			t.addCell(st.getShipCode());
			t.addCell(st.getShipGrade());
			t.addCell(st.getShipMode());
			t.addCell(st.getEnbShip());
			t.addCell(st.getShipDesc());
		}
		document.add(t);
		document.add(new Paragraph(new Date().toString()));




	}

}
