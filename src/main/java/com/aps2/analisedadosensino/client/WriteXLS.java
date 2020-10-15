package com.aps2.analisedadosensino.client;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;

public class WriteXLS {

	public static void main(String[] args) throws IOException {
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("WorkSheet");
		
		int rownum = 0;
		int cellnum = 0;
		Cell cell;
		Row row;
		
		Read_xls reader = new Read_xls();
		
		ArrayList<Requirement> requirements = reader.read_xls();
		ArrayList<Requirement> requirements_inicial = new ArrayList<Requirement>();
		ArrayList<Requirement> requirements_final = new ArrayList<Requirement>();
		ArrayList<Integer> indexes = new ArrayList<Integer>();
		
		//Eliminando File

		for(int i=0; i<requirements.size() ; i++)
		{
			if(requirements.get(i).getComponentType() != null)
			{
				if(requirements.get(i).getComponentType().contains("File") || requirements.get(i).getRequerimentText().toLowerCase().contains("file"))
				{
					requirements_final.add(requirements.get(i));
					indexes.add(i);
				}
				else
				{
					requirements_inicial.add(requirements.get(i));
				}
			}
			
		}

		//Set Style
		CellStyle cellStyle = workbook.createCellStyle();
		cellStyle.setFillForegroundColor(IndexedColors.BRIGHT_GREEN.getIndex());
		cellStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
		Font font = workbook.createFont();
		font.setFontHeightInPoints((short) 11);
		font.setFontName("Calibri");  
		cellStyle.setFont(font);
		
		CellStyle basicCellStyle = workbook.createCellStyle();
		basicCellStyle.setFont(font);

		//Header
		row = sheet.createRow(rownum++);
		cellnum = 0;
	
		cell = row.createCell(cellnum++);
		cell.setCellValue("SCA Tag");
		cell.setCellStyle(basicCellStyle);

		cell = row.createCell(cellnum++);
		cell.setCellValue("Requirement Text");
		cell.setCellStyle(basicCellStyle);
		
		cell = row.createCell(cellnum++);
		cell.setCellValue("Document Section");
		cell.setCellStyle(basicCellStyle);
		
		cell = row.createCell(cellnum++);
		cell.setCellValue("Component Type");
		cell.setCellStyle(basicCellStyle);

		cell = row.createCell(cellnum++);
		cell.setCellValue("UoF");
		cell.setCellStyle(basicCellStyle);

		cell = row.createCell(cellnum++);
		cell.setCellValue("Test Method");
		cell.setCellStyle(basicCellStyle);
		
		cell = row.createCell(cellnum++);
		cell.setCellValue("CF");
		cell.setCellStyle(basicCellStyle);
		
		cell = row.createCell(cellnum++);
		cell.setCellValue("Add-In");
		cell.setCellStyle(basicCellStyle);

		cell = row.createCell(cellnum++);
		cell.setCellValue("Done");
		cell.setCellStyle(basicCellStyle);

		cell = row.createCell(cellnum++);
		cell.setCellValue("Comments");
		cell.setCellStyle(basicCellStyle);

		
	
		
		for (Requirement requirement : requirements_inicial) {
			row = sheet.createRow(rownum++);
			cellnum = 0;
		
			cell = row.createCell(cellnum++);
			cell.setCellValue(requirement .getSCATag());
			cell.setCellStyle(basicCellStyle);

			cell = row.createCell(cellnum++);
			cell.setCellValue(requirement .getRequerimentText());
			cell.setCellStyle(basicCellStyle);

			cell = row.createCell(cellnum++);
			cell.setCellValue(requirement .getDocumentSection());
			cell.setCellStyle(basicCellStyle);
			
			cell = row.createCell(cellnum++);
			cell.setCellValue(requirement .getComponentType());
			cell.setCellStyle(basicCellStyle);

			cell = row.createCell(cellnum++);
			cell.setCellValue(requirement .getUoF());
			cell.setCellStyle(basicCellStyle);

			cell = row.createCell(cellnum++);
			cell.setCellValue(requirement .getTestMethod());
			cell.setCellStyle(basicCellStyle);
			
			cell = row.createCell(cellnum++);
			cell.setCellValue(requirement .getCF());
			cell.setCellStyle(basicCellStyle);
			
			cell = row.createCell(cellnum++);
			cell.setCellValue(requirement .getAddIn());
			cell.setCellStyle(basicCellStyle);

			cell = row.createCell(cellnum++);
			cell.setCellValue(requirement .getDone());
			cell.setCellStyle(basicCellStyle);

			cell = row.createCell(cellnum++);
			cell.setCellValue(requirement .getObs());
			cell.setCellStyle(basicCellStyle);
			
			
			if(requirement.getDone() != null && requirement.getDone().equals("ok"))
			{
				cellnum=0;
				for(int i=0;i<=9;i++)
				{	
					cell = row.getCell(cellnum++);
					cell.setCellStyle(cellStyle);
				}
			}
			
			}

		for (Requirement requirement : requirements_final) {
			row = sheet.createRow(rownum++);
			cellnum = 0;

			cell = row.createCell(cellnum++);
			cell.setCellValue(requirement .getSCATag());
			cell.setCellStyle(basicCellStyle);

			cell = row.createCell(cellnum++);
			cell.setCellValue(requirement .getRequerimentText());
			cell.setCellStyle(basicCellStyle);

			cell = row.createCell(cellnum++);
			cell.setCellValue(requirement .getDocumentSection());
			cell.setCellStyle(basicCellStyle);
			
			cell = row.createCell(cellnum++);
			cell.setCellValue(requirement .getComponentType());
			cell.setCellStyle(basicCellStyle);

			cell = row.createCell(cellnum++);
			cell.setCellValue(requirement .getUoF());
			cell.setCellStyle(basicCellStyle);

			cell = row.createCell(cellnum++);
			cell.setCellValue(requirement .getTestMethod());
			cell.setCellStyle(basicCellStyle);
			
			cell = row.createCell(cellnum++);
			cell.setCellValue(requirement .getCF());
			cell.setCellStyle(basicCellStyle);
			
			cell = row.createCell(cellnum++);
			cell.setCellValue(requirement .getAddIn());
			cell.setCellStyle(basicCellStyle);

			cell = row.createCell(cellnum++);
			cell.setCellValue(requirement .getDone());
			cell.setCellStyle(basicCellStyle);

			cell = row.createCell(cellnum++);
			cell.setCellValue(requirement .getObs());
			cell.setCellStyle(basicCellStyle);
			
			}
		
		
		FileOutputStream out = new FileOutputStream(new File("C:\\Users\\User\\Documents\\Gabriel\\Java\\Final.xls"));
		workbook.write(out);
		out.close();
		workbook.close();
		System.out.println("Success!!");
		 	
	}
		 	
}
