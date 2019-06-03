package com.sky.di;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Properties;

import org.apache.kafka.clients.CommonClientConfigs;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.config.SslConfigs;
import org.apache.kafka.common.serialization.StringDeserializer;

public class KafkaConsumerCode {
	
//  public static String KAFKA_BROKERS = "s1kka01-v01.activity-capture.i2.ovp.bskyb.com:9093";
    public static String KAFKA_BROKERS = "s1kka01-v01.activity-capture.i2.ovp.bskyb.com:9093";
    public static Integer MESSAGE_COUNT=1000;
    public static String CLIENT_ID="client1";
    public static String GROUP_ID_CONFIG = "IDS-T_S-N2";
    public static Integer MAX_NO_MESSAGE_FOUND_COUNT = 100;
//public static String OFFSET_RESET_LATEST = "latest";
    public static String OFFSET_RESET_EARLIER = "earliest";
    public static Integer MAX_POLL_RECORDS =1;
    public static String SSL_TRUST_STORE_TYPE ="JKS";
    public static String SSL_KEY_STORE_TYPE ="JKS";
    //public static String SSL_KEY_STORE ="/apps/projects/nowtv_kafka_to_raw_processing/ie/ids-nowtv-test-keystore.jks";
    public static String SSL_KEY_STORE ="C:\\Nithin\\Automation\\Certs\\ids-nowtv-test-keystore.jks";

    public static String SSL_KEY_STORE_PASS ="YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY";
    //public static String SSL_TRUST_STORE="/apps/projects/nowtv_kafka_to_raw_processing/ie/truststore.jks";
    public static String SSL_TRUST_STORE="C:\\Nithin\\Automation\\Certs\\truststore.jks";
    public static String SSL_TRUST_STORE_PASS ="TTTTTTTTTTTTTTTTTTTTT";
    private static Consumer<Long, String> consumer = null;
    
	public void ReadFromKafka (String topic_name, String output_file_path) throws Exception {
		
        try {
        		runConsumer(topic_name, output_file_path);
        		// return statements if any!
            }
                    
	    catch (IOException e) {
	        e.printStackTrace();
	                    
	    } finally 
	    {
	        if (consumer != null)
	                        consumer.close();
	    }
	}


        public static Consumer<Long, String> createConsumer() {
                        if (consumer != null)
                        {
                                        return consumer;
                        }
                                 Properties props = new Properties();
                                 
                                 props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, KAFKA_BROKERS);
                                 props.put(ConsumerConfig.GROUP_ID_CONFIG, GROUP_ID_CONFIG);
                                 
                                 props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
                                 props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
                                 props.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, MAX_POLL_RECORDS);
                                 props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "false");
                                 props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, OFFSET_RESET_EARLIER);
                                 props.put(CommonClientConfigs.SECURITY_PROTOCOL_CONFIG, "SSL");
                                 props.put(SslConfigs.DEFAULT_SSL_KEYSTORE_TYPE, SSL_KEY_STORE_TYPE);
                                 props.put(SslConfigs.DEFAULT_SSL_TRUSTSTORE_TYPE, SSL_TRUST_STORE_TYPE);
                                 props.put(SslConfigs.SSL_KEYSTORE_LOCATION_CONFIG, SSL_KEY_STORE);
                                 props.put(SslConfigs.SSL_KEYSTORE_PASSWORD_CONFIG, SSL_KEY_STORE_PASS);
                                 props.put(SslConfigs.SSL_KEY_PASSWORD_CONFIG, SSL_KEY_STORE_PASS);
                                 
                                 props.put(SslConfigs.SSL_TRUSTSTORE_LOCATION_CONFIG, SSL_TRUST_STORE);
                                 props.put(SslConfigs.SSL_TRUSTSTORE_PASSWORD_CONFIG, SSL_TRUST_STORE_PASS);
                                 System.out.println("Creating COnsumer");
                                 consumer = new KafkaConsumer<Long,String>(props);
                                 System.out.println("Creating COnsumer 2");
                                 System.out.println("Consumer in main 2:"+consumer.listTopics());
                                 return consumer;
                             }
        @SuppressWarnings("deprecation")
		static void runConsumer(String strTopicName, String strTargetFilePath) throws Exception {
                Consumer<Long, String> consumer = createConsumer();
                consumer.subscribe(Collections.singletonList(strTopicName));
                System.out.println("Subscribing to Topic:"+strTopicName);
                int noMessageFound = 0;
                int iSuccessMessageFound = 0;
                while (true) {
                  ConsumerRecords<Long, String> consumerRecords = consumer.poll(1000);
//                      ConsumerRecords<Long, String> consumerRecords = null;
                  // 1000 is the time in milliseconds consumer will wait if no record is found at broker.
                  System.out.println("Consumebr Count:"+consumerRecords.count());
                  if (consumerRecords.count() == 0) 
                  {
                          noMessageFound++;
                  } else 
                  {
                          iSuccessMessageFound++;
                  }
                      
     
                  
                  Iterator<ConsumerRecord<Long, String>> itrVal = consumerRecords.iterator();
                  ConsumerRecord<Long, String> record = null;
                  StringBuffer sbfContent = new StringBuffer();
                  while (itrVal.hasNext())
                  {
                          record = itrVal.next();
                          System.out.println("Record Key " + record.key());
//                          System.out.println("Record value " + record.value());
                      sbfContent.append(record.value()).append("\n");
//                          System.out.println("Record partition " + record.partition());
//                          System.out.println("Record offset " + record.offset());
                  }
                  if (noMessageFound > 10)
                        // If no message found count is reached to threshold exit loop.  
                        break;
                      else if(iSuccessMessageFound > 0)
                      {
                          String strFileName = strTargetFilePath+"/"+strTopicName.toUpperCase()+".txt";
                          writeToFile(strFileName, sbfContent.toString());
                          break;
                      }
                          
                      else 
                          continue;
                  
//                       consumer.commitAsync();
                }
//                consumer.close();
            }
                
                 
               /* public static void main(String[] args) throws Exception  {
                                try {
	                                    ArrayList<String> alTopicNames = readFromFile(args[0]);
	                                    System.out.println(alTopicNames);
	                                    int iSize = alTopicNames.size();
	                                    for (int itr01 = 0; itr01 < iSize; itr01++)
	                                    {
	                                                    runConsumer(alTopicNames.get(itr01).toString(), args[1]);          
	                                    }
                                                
                                } catch (IOException e) {
                                    e.printStackTrace();
                                                
                                } finally 
                                {
                                    if (consumer != null)
                                                    consumer.close();
                                }
                                

                }*/
                
        static ArrayList<String> readFromFile(String strFileName) throws Exception {
                        ArrayList<String> alDataFromFile = new ArrayList<String>();
                        BufferedReader brFileContents = null;
                        try
                        {
                                        File fileName = new File(strFileName);
                                        brFileContents = new BufferedReader(new FileReader(fileName));
                                        String strSngleLine = brFileContents.readLine();
                                        while (strSngleLine != null && !strSngleLine.trim().equals("")) {
                                                        alDataFromFile .add(strSngleLine);
                                                        strSngleLine = brFileContents.readLine();
                                        }
                                        
                                        return alDataFromFile;
                        } catch (Exception e)
                        {
                                        e.printStackTrace();
                                        throw e;
                        }
                        finally {
                                        if (brFileContents != null)
                                                        brFileContents.close();

                        }
        }
                        
        static void writeToFile(String strFileName, String strContent) throws Exception {
                        
                        BufferedWriter bwFileContents = null;
                        try
                        {
                                        File fileName = new File(strFileName);
                                        bwFileContents = new BufferedWriter(new FileWriter(fileName));
                                        bwFileContents.write(strContent);
                                        bwFileContents.flush();
                                        
                        } catch (Exception e)
                        {
                                        e.printStackTrace();
                                        throw e;
                        }
                        finally {
                                        if (bwFileContents != null)
                                                        bwFileContents.close();

                        }
      
    }

}

