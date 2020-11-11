package com.nnp.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.CMYKColor;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.nnp.dto.StudentDTO;

@Component("pdfView")
public class StudentPDFView1 extends AbstractPdfView{
	@Override
	public void buildPdfDocument(Map<String, Object> model, Document doc, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		  // get data model which is passed by the Spring container
		List<StudentDTO>lidtos=(List<StudentDTO>) model.get("studentsInfo");
         Paragraph ph=new Paragraph("Student details info");
         ph.setAlignment(Paragraph.ALIGN_CENTER);
        doc.add(ph);
         
        PdfPTable table = new PdfPTable(4);
        table.setWidthPercentage(100.0f);
        table.setWidths(new float[] {1.0f, 2.0f, 2.0f, 2.0f});
        table.setSpacingBefore(10);
         
        // define font for table header row
        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(CMYKColor.WHITE);
         
        // define table header cell
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(CMYKColor.BLUE);
        cell.setPadding(5);
        cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        cell.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
         
        // write table header
        cell.setPhrase(new Phrase("Sno", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Sname", font));
        table.addCell(cell);
 
        cell.setPhrase(new Phrase("Addr", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Avg", font));
        table.addCell(cell);
         
         
        // write table row data
        for (StudentDTO dto : lidtos) {
        	cell.setPhrase(new Phrase(String.valueOf(dto.getSno())));
        	table.addCell(cell);
        	cell.setPhrase(new Phrase(dto.getSname()));
        	table.addCell(cell);
			cell.setPhrase(new Phrase(dto.getAddr()));
			table.addCell(cell);
			cell.setPhrase(new Phrase(String.valueOf(dto.getAvg())));
			table.addCell(cell);
        }
         
        doc.add(table);
         
	}

}
