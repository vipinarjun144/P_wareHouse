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
import com.nit.model.Uom;

public class UomPdfView extends AbstractPdfView{

	@Override
	@SuppressWarnings("unchecked")
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.addHeader("Content-Disposition","attachment;filename=Uompdf.pdf");
		Paragraph p=new Paragraph("WELCOME TO UOM PDF");
		 document.add(p);
		 
		List<Uom> list=(List<Uom>) model.get("list");
		 
		 PdfPTable t=new PdfPTable(6);
		 t.addCell("ID");
		 t.addCell("UOM TYPE");
		 t.addCell("UOM MODEL");
		 t.addCell("NOTE");
		 for(Uom u:list) {
			 t.addCell(u.getUomId().toString());
			 t.addCell(u.getUomType());
			 t.addCell(u.getUomModel());
			 t.addCell(u.getUomDesc());
		 }
		 document.add(t);
		 document.add(new Paragraph(new Date().toString()));
		 
	}

}
