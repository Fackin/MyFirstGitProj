package com.tool.test;

import java.io.File;

public class fileSystem {

	
	public static void readFiles(String addrr){
		
		File file = new File(addrr);
		if(file != null){
			File[] files = file.listFiles();
			for (int i = 0; i < files.length; i++) {
				if(files[i].isDirectory()){
					readFiles(files[i].getAbsolutePath());
				}else{
					System.out.println(files[i].getAbsolutePath());
				}
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		readFiles("/Users/fackin/Downloads");
	}
}
