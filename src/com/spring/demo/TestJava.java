package com.spring.demo;

import java.io.File;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class TestJava {

	public static void main(String[] args) throws Exception{
	    String path =new String("F://chrome_download".getBytes(),"utf-8");
	    traverseBreadthFirst(path);
	  }

	  /**
	   * traverse by breadth
	   * */
	  public static void traverseBreadthFirst(String path){
	    if(path==null)return;
	    File file =new File(path);
	    if(!file.exists()){
	      System.out.println("file has no exist!!!");
	      return;
	    }
	    File[] files =file.listFiles();
	    Queue<File> queue =new ArrayDeque<>();
	    for(File each:files){
	      queue.add(each);
	    }
	    File currentFile;
	    File[] childList;
	    while(queue.size()>0){
	      currentFile =queue.poll();
	      if(currentFile==null)break;
	      System.out.println(currentFile.getAbsolutePath());
	      childList =currentFile.listFiles();
	      if(childList!=null){
	        queue.addAll(Arrays.asList(childList));
	      }
	    }
	  }

	  /**
	   * traverse by depth
	   * */
	  public static void traverseDepthFirst(String path){
	    if(path==null)return;
	    File file =new File(path);
	    if(!file.exists()){
	      System.out.println("file has no exist!!!");
	      return;
	    }
	    File[] files =file.listFiles();
	    Queue<File> queue =new ArrayDeque<>();
	    File[] childList;
	    for(File each:files){
	      childList =each.listFiles();
	      if(childList==null)return;
	      queue.addAll(Arrays.asList(childList));

	    }
	  }

}
