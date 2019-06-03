package com.sky.di;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import com.google.api.gax.paging.Page;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.Storage.BlobListOption;
import com.google.cloud.storage.StorageOptions;


public class ReadFromGcs {
	static final Logger logger = Logger.getLogger(ReadFromGcs.class);
	static Storage storage = StorageOptions.getDefaultInstance().getService();
	
	public List<String> FromGcs(String bucket_name, String gcp_project_id, String gcs_file_path, String avro_file_path) throws IOException {
		 List<String> file_list = new ArrayList<String>();
		 String avro_download_path = null;
		 int count=1;
		 Page<Blob> blobs_list = storage.list(bucket_name, BlobListOption.currentDirectory(),BlobListOption.prefix(gcs_file_path));
		 for (Blob blobs : blobs_list.iterateAll())  {
			 if(blobs.getName().contains(".avro")) {
				 avro_download_path = avro_file_path +"-"+count+".avro";
				 Path destFilePath = Paths.get(avro_download_path);
				 Blob blob = storage.get(BlobId.of(bucket_name, blobs.getName()));
				 blob.downloadTo(destFilePath, Blob.BlobSourceOption.userProject(gcp_project_id));
				 file_list.add(avro_download_path);
				 count++;
			 }			
		 }	     
	     
     	return file_list;		
	}
}