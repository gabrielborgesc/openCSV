package com.aps2.analisedadosensino.leaf;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProfessorTest 
{
	@Test
	public void analisaTest()
	{
		TestCase[] testCases = new TestCase[] {
				new TestCase(new Matematico(Nivel.DOUTORADO), "MATEMATICADOUTORADO"),
				new TestCase(new Matematico(Nivel.GRADUAÇÃO), "MATEMATICAGRADUAÇÃO"),
				new TestCase(new Matematico(Nivel.MESTRADO), "MATEMATICAMESTRADO"),
				new TestCase(new Matematico(Nivel.POS_GRADUAÇÃO), "MATEMATICAPOS_GRADUAÇÃO"),
				
				new TestCase(new Quimico(Nivel.DOUTORADO), "QUIMICADOUTORADO"),
				new TestCase(new Quimico(Nivel.GRADUAÇÃO), "QUIMICAGRADUAÇÃO"),
				new TestCase(new Quimico(Nivel.MESTRADO), "QUIMICAMESTRADO"),
				new TestCase(new Quimico(Nivel.POS_GRADUAÇÃO), "QUIMICAPOS_GRADUAÇÃO"),
				
				new TestCase(new Fisico(Nivel.DOUTORADO), "FISICADOUTORADO"),
				new TestCase(new Fisico(Nivel.GRADUAÇÃO), "FISICAGRADUAÇÃO"),
				new TestCase(new Fisico(Nivel.MESTRADO), "FISICAMESTRADO"),
				new TestCase(new Fisico(Nivel.POS_GRADUAÇÃO), "FISICAPOS_GRADUAÇÃO"),
				
				new TestCase(new Outro(Nivel.DOUTORADO), "OUTRASDOUTORADO"),
				new TestCase(new Outro(Nivel.GRADUAÇÃO), "OUTRASGRADUAÇÃO"),
				new TestCase(new Outro(Nivel.MESTRADO), "OUTRASMESTRADO"),
				new TestCase(new Outro(Nivel.POS_GRADUAÇÃO), "OUTRASPOS_GRADUAÇÃO")
		};
		
		for(TestCase testCase : testCases)
		{
			Assertions.assertEquals(testCase.result, testCase.value.analisa());
		}
		Professor professor = new Matematico(Nivel.DOUTORADO);
		System.out.println(professor.analisa());
	}
	
	private class TestCase {
		Professor value;
		String result;
		
		public TestCase(Professor value, String result) {
			this.value = value;
			this.result = result;
		}
		
	}
}
