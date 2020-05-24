package com.aps2.analisedadosensino.factory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.aps2.analisedadosensino.client.ReaderClient;
import com.aps2.analisedadosensino.component.Docente;
import com.aps2.analisedadosensino.leaf.Fisico;
import com.aps2.analisedadosensino.leaf.Matematico;
import com.aps2.analisedadosensino.leaf.Nivel;
import com.aps2.analisedadosensino.leaf.Outro;
import com.aps2.analisedadosensino.leaf.Quimico;

public class FabricaDocenteTest {
	
	@Test
	public void criaDocenteTest()
	{
		FabricaDocente fabricaDocente = new FabricaDocente();
		TestCase[] testCases = new TestCase[] {
				//
				// Casos em que deve dar erro
				//
				new TestCase(
						new ReaderClient("", "1", "0", "1", "0", "1"),
						null),
				new TestCase(
						new ReaderClient("1", "", "1", "0", "1", "0"),
						null),
				new TestCase(
						new ReaderClient("1", "1", "", "1", "0", "1"),
						null),
				new TestCase(
						new ReaderClient("1", "1", "1", "", "1", "0"),
						null),
				new TestCase(
						new ReaderClient("1", "0", "0", "0", "", "0"),
						null),
				new TestCase(
						new ReaderClient("1", "0", "0", "1", "1", ""),
						null),
				
				//
				// Casos que devem resultar em um docente
				//
				new TestCase(
						new ReaderClient("1", "0", "0", "0", "0", "0"),
						new Matematico(Nivel.POS_GRADUAÇÃO)),
				new TestCase(
						new ReaderClient("1", "0", "0", "1", "0", "0"),
						new Matematico(Nivel.GRADUAÇÃO)),
				new TestCase(
						new ReaderClient("1", "0", "0", "1", "1", "0"),
						new Matematico(Nivel.MESTRADO)),
				new TestCase(
						new ReaderClient("1", "0", "0", "1", "1", "1"),
						new Matematico(Nivel.DOUTORADO)),
				new TestCase(
						new ReaderClient("0", "1", "0", "0", "0", "0"),
						new Fisico(Nivel.POS_GRADUAÇÃO)),
				new TestCase(
						new ReaderClient("0", "1", "0", "1", "0", "0"),
						new Fisico(Nivel.GRADUAÇÃO)),
				new TestCase(
						new ReaderClient("0", "1", "0", "1", "1", "0"),
						new Fisico(Nivel.MESTRADO)),
				new TestCase(
						new ReaderClient("0", "1", "0", "1", "1", "1"),
						new Fisico(Nivel.DOUTORADO)),
				new TestCase(
						new ReaderClient("0", "0", "1", "0", "0", "0"),
						new Quimico(Nivel.POS_GRADUAÇÃO)),
				new TestCase(
						new ReaderClient("0", "0", "1", "1", "0", "0"),
						new Quimico(Nivel.GRADUAÇÃO)),
				new TestCase(
						new ReaderClient("0", "0", "1", "1", "1", "0"),
						new Quimico(Nivel.MESTRADO)),
				new TestCase(
						new ReaderClient("0", "0", "1", "1", "1", "1"),
						new Quimico(Nivel.DOUTORADO)),
				new TestCase(
						new ReaderClient("0", "0", "0", "0", "0", "0"),
						new Outro(Nivel.POS_GRADUAÇÃO)),
				new TestCase(
						new ReaderClient("0", "0", "0", "1", "0", "0"),
						new Outro(Nivel.GRADUAÇÃO)),
				new TestCase(
						new ReaderClient("0", "0", "0", "1", "1", "0"),
						new Outro(Nivel.MESTRADO)),
				new TestCase(
						new ReaderClient("0", "0", "0", "1", "1", "1"),
						new Outro(Nivel.DOUTORADO))
				
		};
		for(TestCase testCase : testCases)
		{
			try {
				Docente docente = fabricaDocente.criaDocente(testCase.value);
				Assertions.assertEquals(testCase.result.getNivel(), docente.getNivel());
				Assertions.assertEquals(testCase.result.getNomeDisciplina(), docente.getNomeDisciplina());
			}
			catch(IllegalArgumentException e) {
				Assertions.assertNull(testCase.result);
			}
		}
	}
	
	
	private class TestCase{
		private ReaderClient value;
		private Docente result;
		
		public TestCase(ReaderClient value, Docente result)
		{
			this.value = value;
			this.result = result;
		}
		
	}
}
