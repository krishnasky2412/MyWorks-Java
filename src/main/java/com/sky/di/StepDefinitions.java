package com.sky.di;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.junit.Assert.*;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

//import cucumber.api.PendingException;
//import java.io.IOException;
import com.sky.di.ReadFromGcs;

public class StepDefinitions {
	
	public boolean status;
	public String kafka_topic_name;
	public String input_file_path;
	public String avro_file_path;
	public String output_file_path;
	public String gcp_project_id;
	public String gcs_bucket_name;
	public String pii_field_name;
	public List<String> avro_file_list = new ArrayList<String>();
	public String dt_feed_name, src_fmt, tgt_fmt;
	public String pii_feed_name, src_pii, tgt_pii;
	
	//Declaring objects for classes
	KafkaConsumerCode kafkaObj = new KafkaConsumerCode();
	ReadFromGcs gcsObj = new ReadFromGcs();
	AvroToJavaConversion avrotojava = new AvroToJavaConversion();
	PaymentManagerPurchaseSuccess pmpursuccess = new PaymentManagerPurchaseSuccess();
	
	public void readPropertiesFile(String file_name) throws FileNotFoundException, IOException {
		
		Properties props = new Properties();
	    props.load(new FileInputStream("config.properties"));
	    gcp_project_id = props.getProperty("gcp_project_id");
	    gcs_bucket_name = props.getProperty("bucket_name");
	    input_file_path = props.getProperty("kafka_source_file_path")+file_name+"INPUT.txt";
	    avro_file_path = props.getProperty("avro_file_path");
	    output_file_path = props.getProperty("output_file_path")+file_name+"-OUTPUT.txt";
	}
		
	@Given("^Once the raw data is extracted from \"([^\"]*)\" Kafka source system$")
	public void read_source_messages(String topic_name) throws Throwable {
		kafka_topic_name = topic_name;
		readPropertiesFile(kafka_topic_name);
		//kafkaObj.ReadFromKafka(topic_name, source_file_path);
	}	
	
	@When("^the target messages from GCS avro file stored in \"([^\"]*)\" are extracted$")
	public void read_target_messages(String gcs_file_path) throws Throwable {
		//FromPubSub pubSubObj = new FromPubSub();
		//pubSubMsgCount = pubSubObj.ReadFromPubSub(subscription_id, project_id);
		avro_file_list = gcsObj.FromGcs(gcs_bucket_name, gcp_project_id, gcs_file_path, avro_file_path+kafka_topic_name);
		if (!avro_file_list.isEmpty()) {
			assertTrue("Avro file is read from GCS", !avro_file_list.isEmpty());
		}
		else {
			assertFalse("There are no contents available in avro file", !avro_file_list.isEmpty());
			System.exit(0);
		}
	}
	
	@Then("^convert the target avro file into json format$")
	public void avro_to_json() throws Throwable {
		avrotojava.AvroToJava(avro_file_list,output_file_path);
	}
	
	@Then("^other than the \"([^\"]*)\" attributes, ensure that all the attributes between source and target are matching with \"([^\"]*)\" as primary keys$")
	public void data_comparison(List<String> attributes, String primary_key) throws Throwable {
		if(kafka_topic_name.contains("PURCHASE-SUCCESS")) {
			pmpursuccess.IncludedDataExtraction(attributes, input_file_path, output_file_path);
//			pmpursuccess.ExcludedDataExtraction(pii_field_name, input_file_path, output_file_path, null, null, null, "PII" );
		}
	}
	
	
//	Date Comparison
	
	@Given("^locate the file \"([^\"]*)\" to perform date validation$")
	public void get_date_feed(String dt_feed_name) throws Throwable {
		readPropertiesFile(dt_feed_name);
	}	
	
	@When("^the given file is opened and \"([^\"]*)\", \"([^\"]*)\" formats are received$")
	public void read_date_formats(String arg1, String arg2) throws Throwable {
	     src_fmt = arg1;
	     tgt_fmt = arg2; 	    
	}
	
	@Then("^On comparing the \"([^\"]*)\" it should match for the given \"([^\"]*)\"$")
	public void pii_compare(String dt_col,  String region) throws Throwable {
		System.out.println("Date");
		pmpursuccess.ExcludedDataExtraction(dt_col, input_file_path, output_file_path, src_fmt, tgt_fmt, region, "Date" );
//		System.out.println(result);
//		assertEquals(result, arg1);

	}
	
//	PII Comparison
	
	@Given("^locate the file \"([^\"]*)\" to perform PII validation$")
	public void get_pii_feed(String pii_feed_name) throws Throwable {
		readPropertiesFile(pii_feed_name);	
	}	
	
	@When("^the file is opened from the given location for PII comparison$")
	public void read_pii_values(String arg1, String arg2) throws Throwable {
	     src_pii = arg1;
	     tgt_pii = arg2; 	    
	}
	
	@Then("^On comparing the \"([^\"]*)\" it should match$")
	public void pii_compare(String pii_col) throws Throwable {
		System.out.println("PII");
		pmpursuccess.ExcludedDataExtraction(pii_col, input_file_path, output_file_path, null, null, null, "PII");
//		System.out.println(result);
//		assertEquals(result, arg1);
	}

//	PII Email Comparison
	
	@Then("^On comparing the ([^\"]*), the obfuscated email should match with expected value$")
	public void pii_email_compare(String pii_email_col) throws Throwable {
		System.out.println("EMAIL");
		pmpursuccess.ExcludedDataExtraction(pii_email_col, input_file_path, output_file_path, null, null, null, "EmailPII");
//		System.out.println(result);
//		assertEquals(result, arg1);		

	}	

//	Currency Comparison
	
	@Given("^locate the file \"([^\"]*)\" to perform Currency validation$")
	public void get_curr_feed(String pii_feed_name) throws Throwable {
		readPropertiesFile(pii_feed_name);	
	}	
	
	@When("^the file is opened from the given location for currency comparison$")
	public void read_curr_value(String arg1) throws Throwable {
	     src_pii = arg1;
	}
	
	@Then("^On comparing the ([^\"]*), the source amount should match with target amount$")
	public void currency_compare(String pii_col) throws Throwable {
		System.out.println("Currency");
		pmpursuccess.ExcludedDataExtraction(pii_col, input_file_path, output_file_path, null, null, null, "Currency");
//		System.out.println(result);
//		assertEquals(result, arg1);
	}	
	
}
