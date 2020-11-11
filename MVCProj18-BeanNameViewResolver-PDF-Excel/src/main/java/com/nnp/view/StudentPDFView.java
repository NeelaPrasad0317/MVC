package com.nnp.view;

import java.awt.Color;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfWriter;
import com.nnp.dto.StudentDTO;

//@Component("pdfView")
public class StudentPDFView extends AbstractPdfView{
	@Override
	public void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		List<StudentDTO>lidtos=(List<StudentDTO>) model.get("studentsInfo");
		Paragraph ph=new Paragraph("Student info document", new Font(Font.HELVETICA,20,Font.BOLDITALIC,Color.BLUE));
		
		document.add(ph);
		
		Table table=new Table(4);
		
		table.addCell("Sno");
		table.addCell("Sname");
		table.addCell("addr");
		table.addCell("avg");
		
		for(StudentDTO dto:lidtos) {
			table.addCell(String.valueOf(dto.getSno()));
			table.addCell(dto.getSname());
			table.addCell(dto.getAddr());
			table.addCell(String.valueOf(dto.getAvg()));
		}
		document.add(table);
		
	}

}
