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
import com.nit.model.PurchaseDtl;
import com.nit.model.PurchaseOrder;

public class VendorInvoicePdf extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.addHeader("Content-Disposition", "attachment;filename=VendorInvoice.pdf");
		//read purchase order
		PurchaseOrder po=(PurchaseOrder) model.get("po");


		//read all Childs 
		List<PurchaseDtl> parts=po.getChild();


		//final cost calculation
		double finalCost=0.0;
		for(PurchaseDtl dtl:parts) {
			finalCost=finalCost+(dtl.getPart().getBaseCost()*dtl.getQty());
		}
		//----end here--

		PdfPTable t=new PdfPTable(4);

		t.addCell("VENDOR CODE");
		t.addCell(po.getVendor().getUserCode());
		t.addCell("PO OREDR CODE");
		t.addCell(po.getOrderCode());
		t.addCell("Final COST");
		t.addCell(Double.toString(finalCost));
		t.addCell("SHIPMENT CODE");
		t.addCell(po.getSob().getShipCode());
		document.add(t);
		
		
		PdfPTable partTable=new PdfPTable(4);
		partTable.addCell("PART CODE");
		partTable.addCell("BASE COST");
		partTable.addCell("QUANTITY");
		partTable.addCell("LINE TOTAL");

		for(PurchaseDtl dtl:parts) {
			partTable.addCell(dtl.getPart().getPartCode());
			partTable.addCell(dtl.getPart().getBaseCost().toString());
			partTable.addCell(dtl.getQty().toString());
			partTable.addCell(Double.toString(dtl.getPart().getBaseCost()*dtl.getQty()));
		}
		
		
		document.add(new Paragraph("---PART TABLE---"));
		document.add(partTable);
		document.add(new Paragraph(new Date().toString()));
	}

}
