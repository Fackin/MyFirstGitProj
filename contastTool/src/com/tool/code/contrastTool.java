package com.tool.code;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class contrastTool {

	public static void contrast(String oldAddr, String newAddr, String destAddr){
		
		List<String> addList = null;
		List<String> updList = null;
		List<String> delList = null;
		
		Map<String,String> oldFileList = null;
		Map<String,String> newFileList = null;
		
		readFiles(oldAddr, oldFileList);
		readFiles(newAddr, newFileList);
		
		Iterator<String> it = newFileList.keySet().iterator();
		while(it.hasNext()){
			String key = it.next();
			if(oldFileList.containsKey(key)){
				//
				if(!isSameFile(oldFileList.get(key), newFileList.get(key))){
					//
					updList.add(key);
					copyFile(newFileList.get(key), destAddr);
				}else{
					//相同
				}
			}else{
				//
				addList.add(key);
				copyFile(newFileList.get(key), destAddr);
			}
		}
		Iterator<String> oldIt = oldFileList.keySet().iterator();
		while(oldIt.hasNext()){
			String key = oldIt.next();
			if(!addList.contains(key) && !updList.contains(key)){
				delList.add(key);
			}
		}
		
		
	}
	public static void readFiles(String addr, Map<String,String> result){
		File file = new File(addr);
		if(file != null){
			File[] files = file.listFiles();
			for (int i = 0; i < files.length; i++) {
				if(files[i].isDirectory()){
					readFiles(files[i].getAbsolutePath(), result);
				}else{
//					System.out.println(files[i].getAbsolutePath());
					result.put(files[i].getAbsolutePath().substring(addr.length()-1,
							files[i].getAbsolutePath().length()-1),
							files[i].getAbsolutePath());
				}
			}
			
		}
	}
	
	public static void main(String[] args){
		
	}
}
