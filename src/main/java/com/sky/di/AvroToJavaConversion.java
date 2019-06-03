package com.sky.di;



import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.apache.avro.file.DataFileReader;
import org.apache.avro.generic.GenericDatumReader;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.io.DatumReader;
	

	public class AvroToJavaConversion {

		@SuppressWarnings("resource")
		public void AvroToJava(List<String> avro_file_list, String json_file_path) throws  IOException {
			
			File strGenericFile=new File(json_file_path);
			FileWriter fwDecodedData = null;
            BufferedWriter brWriteSingleLine = null;
            fwDecodedData = new FileWriter(strGenericFile);
            brWriteSingleLine = new BufferedWriter(fwDecodedData);
            StringBuffer sbfToWriteString = new StringBuffer();
            DatumReader<GenericRecord> datumReader_Gen = new GenericDatumReader<GenericRecord>();
            int iRecordCount = 0;
            GenericRecord record_gen = null;
            
            for(String file_list : avro_file_list) {
            	File file = new File(file_list);
            	DataFileReader<GenericRecord> dataFileReader_Gen = new DataFileReader<GenericRecord>(file, datumReader_Gen);
            	while (dataFileReader_Gen.hasNext()) 
                {
                record_gen = dataFileReader_Gen.next();
                sbfToWriteString.append(record_gen).append("\n");
                iRecordCount++;
                if (iRecordCount == 500)
                {
                      brWriteSingleLine.write(sbfToWriteString.toString());
                      brWriteSingleLine.flush();
                      sbfToWriteString.setLength(0);
                      iRecordCount = 0;
                }
                }
                brWriteSingleLine.write(sbfToWriteString.toString());
                
            }
            brWriteSingleLine.flush();
            brWriteSingleLine.close();
            //System.out.println("Total Row Count:"+iRecordCount);   
		}
	}
			


