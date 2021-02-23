package com;

/**
 * Hello world!
 *
 */
public class App 
{
public static void main(String[] args) throws Exception{
	/*
	 * if( args.length !=2) {
	 * System.out.println("Please provide path for input and output file"); }
	 */
	String path ="/home/local/ZOHOCORP/sam-9130/Downloads/examples/example.json";
	String path1="/home/local/ZOHOCORP/sam-9130/Downloads/examples/output.xml";
	ConverterFactory.createInstance().convertJSONtoXML(path, path1);	
	}
}
