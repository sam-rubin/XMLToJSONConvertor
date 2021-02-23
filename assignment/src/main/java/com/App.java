package com;

/**
 * Hello world!
 *
 */
public class App 
{
public static void main(String[] args) throws Exception{
	if( args.length !=2) {
		System.out.println("Please provide path for input and output file");
	}
	ConverterFactory.createInstance().convertJSONtoXML(args[0], args[1]);	
}
}
