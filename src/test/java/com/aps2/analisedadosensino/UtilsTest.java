package com.aps2.analisedadosensino;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UtilsTest {
	
	@Test
	public void parseBooleanTest()
	{
		TestCase[] testCases = new TestCase[] {
				new TestCase("1.0", true), 
				new TestCase("0.0", false), 
				new TestCase("2", null), 
				new TestCase("teste", null)};
		
		for(TestCase testCase : testCases)
		{
			try {
				boolean result = Utils.parseBoolean(testCase.value);
				
				Assertions.assertEquals(testCase.result, result);
				
			} catch (IllegalArgumentException e) {
				Assertions.assertNull(testCase.result);
			}
		}
		
	}

	@Test
	public void test() {
		System.out.println(Utils.parseBoolean("0.0"));
	}
		
	private class TestCase {
		
		private Boolean result;
		private String value;
		
		public TestCase(String value, Boolean result)
		{
			this.value = value;
			this.result = result;
		}
		
	}
	

}
