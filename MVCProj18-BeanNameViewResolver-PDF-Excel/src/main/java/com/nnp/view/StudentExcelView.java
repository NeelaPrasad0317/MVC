package com.nnp.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.nnp.dto.StudentDTO;

@Component("excelView")
public class StudentExcelView extends AbstractXlsView{

	@Override
	public void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		@SuppressWarnings("unchecked")
		List<StudentDTO>lidtos=(List<StudentDTO>) model.get("studentsInfo");
		
		
        Sheet sheet = workbook.createSheet("Students");
        Row header = sheet.createRow(0);
        
        header.createCell(0).setCellValue("sno");
		header.createCell(1).setCellValue("sname");
		header.createCell(2).setCellValue("addr");
		header.createCell(3).setCellValue("avg");
        
		int i=1;
		for(StudentDTO dto:lidtos) {
			Row row=sheet.createRow(i);
			row.createCell(0).setCellValue(String.valueOf(dto.getSno()));
			row.createCell(1).setCellValue(dto.getSname());
			row.createCell(2).setCellValue(dto.getAddr());
			row.createCell(3).setCellValue(String.valueOf(dto.getAvg()));
			i++;
		}
		
	}

}
