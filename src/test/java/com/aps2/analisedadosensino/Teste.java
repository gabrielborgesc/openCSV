package com.aps2.analisedadosensino;

import org.junit.jupiter.api.Test;


public class Teste {
	
	@Test
	public void stringToBooleanTest()
	{
		Utils.parseBoolean("1");
		System.out.println(Utils.parseBoolean("0"));
		System.out.println(Utils.parseBoolean("oioioi"));
		
	}
	
	
}
