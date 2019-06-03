package com.sky.di;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.avro.file.DataFileReader;
import org.apache.avro.generic.GenericDatumReader;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.io.DatumReader;

import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;

@SuppressWarnings("unused")
public class Test {

	public static void main(String args[])
		      throws IOException {
		 // Creating a File object that represents the disk file. 
        PrintStream o = new PrintStream(new File("C:\\Users\\KKH13\\Input\\A.txt")); 
  
        // Store current System.out before assigning a new value 
        PrintStream console = System.out; 
  
        // Assign o to output stream 
        System.setOut(o);
        System.out.println("This will be written to the text file");
        System.out.println("This will be written to the second line of text file");
  
        // Use stored value for output stream 
        System.setOut(console); 
        System.out.println("This will be written on the console!"); 
		  }
}
