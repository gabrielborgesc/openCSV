package com.aps2.analisedadosensino.client;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVWriter;

public class Test {
	
	public static void main(String args[]) throws IOException {
		ArrayList<Integer> test = new ArrayList<Integer>();
		
		for(int i = 0; i<=7; i++)
		{
			test.add(i);
		}
		
		test.remove(3);
		
		for(Integer i:test) {
				System.out.println(i);
		}
		
}
}
