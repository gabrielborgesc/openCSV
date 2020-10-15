package com.aps2.analisedadosensino.client;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class Read_xls {
	
	public ArrayList<Requirement> read_xls() throws IOException {
	
	FileInputStream file = new FileInputStream(new File("C:\\Users\\User\\Documents\\Gabriel\\Java\\SCA_Requirements.xls"));
	HSSFWorkbook workbook = new HSSFWorkbook(file);
	HSSFSheet sheet = workbook.getSheetAt(0);
	
	ArrayList<Requirement> requirements = new ArrayList<Requirement>();

	Iterator rowIterator = sheet.rowIterator();
	while (rowIterator.hasNext()) {
	Row row = (Row) rowIterator.next();
	
	// Descantando a primeira linha com o header
	if(row.getRowNum() == 0){
	continue;
	}
	
	Iterator cellIterator = row.cellIterator();
	Requirement requirement = new Requirement();
	
	while (cellIterator.hasNext()) {
	Cell cell = (Cell) cellIterator.next();
	
	switch (cell.getColumnIndex()) 
	{
	
	case 0 : requirement.setSCATag(cell.getStringCellValue()); break;
	
	case 1 : requirement.setRequerimentText(cell.getStringCellValue()); break;
	
	case 2 : requirement.setDocumentSection(cell.getStringCellValue()); break;
	
	case 3 : requirement.setComponentType(cell.getStringCellValue()); break;
	
	case 4 : requirement.setUoF(cell.getStringCellValue()); break;
	
	case 5 : requirement.setTestMethod(cell.getStringCellValue()); break;
	
	case 6 : requirement.setCF(cell.getStringCellValue()); break;
	
	case 7 : requirement.setAddIn(cell.getStringCellValue()); break;
	
	case 8 : requirement.setDone(cell.getStringCellValue()); break;
	
	case 9 : requirement.setObs(cell.getStringCellValue()); break;
	
	default :
	}
	
	
	}
	requirements.add(requirement);
}
	
	for(Requirement req : requirements) {
		System.out.println(req.getSCATag());
	}
	System.out.println(requirements.size());
	
	return requirements;
	
}
	
}
