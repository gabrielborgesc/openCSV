package com.aps2.analisedadosensino.client;

import java.io.IOException;
import java.io.Reader;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;


public class Reader_SCA_CSV {
	  private String SCA_Tag;
	  private String Requirement_Text;
	  private String Document_Section;
	  private String Component_Type;	  
	  private String UoF;
	  private String Test_Method;
	
	  
	  public Reader_SCA_CSV() {}
	  
	  
	public Reader_SCA_CSV(String SCA_Tag, String Requirement_Text, String Document_Section,
			String Component_Type, String UoF, String Test_Method) {
		this.SCA_Tag = SCA_Tag;
		this.Requirement_Text = Requirement_Text;
		this.Document_Section = Document_Section;
		this.Component_Type = Component_Type;
		this.UoF = UoF;
		this.Test_Method = Test_Method;
	}


	public String getSCA_Tag() {
		return SCA_Tag;
	}
	public void setSCA_Tag(String SCA_Tag) {
		this.SCA_Tag = SCA_Tag;
	}
	public String getRequirement_Text() {
		return Requirement_Text;
	}
	public void setRequirement_Text(String Requirement_Text) {
		this.Requirement_Text = Requirement_Text;
	}
	public String getDocument_Section() {
		return Document_Section;
	}
	public void setDocument_Section(String Document_Section) {
		this.Document_Section = Document_Section;
	}
	public String getComponent_Type() {
		return Component_Type;
	}
	public void setComponent_Type(String Component_Type) {
		this.Component_Type = Component_Type;
	}
	public String getTest_Method() {
		return Test_Method;
	}
	public void setTest_Method(String Test_Method) {
		this.Test_Method = Test_Method;
	}
	public String getUoF() {
		return UoF;
	}
	public void setUoF(String UoF) {
		this.UoF = UoF;
	}

	
	public List<Reader_SCA_CSV> readCSV(String CSVName) throws IOException{
		URL url = Reader_SCA_CSV.class.getClassLoader().getResource(CSVName+".csv");
		Reader reader;
			reader = Files.newBufferedReader(Paths.get(CSVName));
			CsvToBean<Reader_SCA_CSV> csvToBean = new CsvToBeanBuilder(reader)
					.withType(Reader_SCA_CSV.class)
					.withQuoteChar('\n')
					.withIgnoreQuotations(true)
					.withSeparator(',')
					.build();
			
			return csvToBean.parse();

	}

}
