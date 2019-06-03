package com.sky.di;

import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sky.beans.PaymentManager.PurchaseSuccess.PurchaseSuccess;
import com.sky.beans.PaymentManager.PurchaseSuccess.SDPKafkaIngestBean;


public class PaymentManagerPurchaseSuccess {
	
	//PIICompare piicomp = new PIICompare();

//Method to call for obfuscated fields (PII/Date/Currency) comparison functions
@SuppressWarnings("rawtypes")
public static void ExcludedFieldsComparison(Class classDef, Object PurchaseSuccessSrc, Object PurchaseSuccessTrg, String srcPrimaryKey, String input_field_name,  
		String src_date_format, String trg_date_format, String region, String flag)
		throws Exception
		
{
	PIICompare piicomp = new PIICompare();
	EmailPIICompare emailpiicomp = new EmailPIICompare();
	CurrencyConv currency = new CurrencyConv();
	DateCompare datecomp = new DateCompare();
	try {
		String strSourceValue = "";
		String strTargetValue = "";
		String[] strSourceValueArray ;
		String[] strTargetValueArray ;
		Object objSourceValue = "";
		Object objTargetValue = "";
		Object objSourceValueArray[] ;
		Object objTargetValueArray[] ;
		int iCounterArray = 0;
		Method methodName ;
		int package_name_length = 0;
		int class_name_length = 0;
		String field_name = "";
		
		if("java.lang.Class".equals(classDef.getName()))
			return;
		for (PropertyDescriptor pd : Introspector.getBeanInfo(classDef).getPropertyDescriptors()) {
			methodName = pd.getReadMethod();
			if((methodName.invoke(PurchaseSuccessSrc))!=null && ((methodName.invoke(PurchaseSuccessTrg))!=null)){
			
			if (pd.getReadMethod().getReturnType().getName().equals("java.lang.String")) {
				strSourceValue = (String)methodName.invoke(PurchaseSuccessSrc);
				strTargetValue = (String)methodName.invoke(PurchaseSuccessTrg);
				
				field_name = "";
				package_name_length = classDef.getPackage().getName().toString().length();
				class_name_length = classDef.getName().length();
				field_name = classDef.getName();
				field_name = field_name.substring(package_name_length+1,class_name_length);
				//include all the parent bean class names across feeds - can be parameterized later
				if(field_name.equals("PurchaseSuccess")) {
					field_name = pd.getName();
				}
				else {
					field_name = field_name+"_"+pd.getName();
				}
				
				// Checking PII fields
				if(field_name.toLowerCase().equals(input_field_name.toLowerCase()) && flag=="PII") {

					if (strSourceValue == null && strTargetValue != null) 
					{
						Assert.fail("The value for the method:"+methodName.getName()+" has null value in the source and non null value in target");
						break;
					}
					else if (strSourceValue != null && strTargetValue == null)
					{
						Assert.fail("The value for the method:"+methodName.getName()+" has non null value in the source and  null value in target");
						break;
					} else if (strSourceValue != null && strTargetValue != null )
					{
						boolean status = piicomp.pii_compare(input_field_name, strSourceValue, strTargetValue);
						if(!status) {
							System.out.println("For the OrderID:" +srcPrimaryKey  + " Source: " + methodName.getName() + " : " + strSourceValue);
							System.out.println("For the OrderID:" +srcPrimaryKey  + " Target: " + methodName.getName() + " : " + strTargetValue);
							
							}						
						break;
					}
				}
				// Checking Email PII fields
				else if (field_name.toLowerCase().equals(input_field_name.toLowerCase()) && flag=="EmailPII") {
					
					if (strSourceValue == null && strTargetValue != null) 
					{
						Assert.fail("The value for the method:"+methodName.getName()+" has null value in the source and non null value in target");
						break;
					}
					else if (strSourceValue != null && strTargetValue == null)
					{
						Assert.fail("The value for the method:"+methodName.getName()+" has non null value in the source and  null value in target");
						break;
					}
					
					else if (strSourceValue != null && strTargetValue != null )
					{
						boolean status = emailpiicomp.email_pii_compare(input_field_name, strSourceValue, strTargetValue);
						if(!status) {
							System.out.println("For the OrderID:" +srcPrimaryKey  + " Source: " + methodName.getName() + " : " + strSourceValue);
							System.out.println("For the OrderID:" +srcPrimaryKey  + " Target: " + methodName.getName() + " : " + strTargetValue);
							
							}
						break;
					}
				}
				
				// Checking Currency fields				
				else if (field_name.toLowerCase().equals(input_field_name.toLowerCase()) && flag=="Currency") {
					
					if (strSourceValue == null && strTargetValue != null) 
					{
						Assert.fail("The value for the method:"+methodName.getName()+" has null value in the source and non null value in target");
						break;
					}
					else if (strSourceValue != null && strTargetValue == null)
					{
						Assert.fail("The value for the method:"+methodName.getName()+" has non null value in the source and  null value in target");
						break;
					}
					
					else if (strSourceValue != null && strTargetValue != null )
					{
						strSourceValue = currency.curr_convert(input_field_name, strSourceValue);
						
						if((!strSourceValue.equals(strTargetValue))){
						System.out.println("For the OrderID:" +srcPrimaryKey  + " Source: " + methodName.getName() + " : " + strSourceValue);
						System.out.println("For the OrderID:" +srcPrimaryKey  + " Target: " + methodName.getName() + " : " + strTargetValue);
						}
						break;
					}
				} 
				
				//Checking Date fields
				else if (field_name.toLowerCase().equals(input_field_name.toLowerCase()) && flag=="Date") {
					
					if (strSourceValue == null && strTargetValue != null) 
					{
						Assert.fail("The value for the method:"+methodName.getName()+" has null value in the source and non null value in target");
						break;
					}
					else if (strSourceValue != null && strTargetValue == null)
					{
						Assert.fail("The value for the method:"+methodName.getName()+" has non null value in the source and  null value in target");
						break;
					}
					
					
					else if (strSourceValue != null && strTargetValue != null )
					{
						strSourceValue = datecomp.dt_compare(input_field_name, src_date_format,trg_date_format,strSourceValue,strTargetValue,region);
						
						if((!strSourceValue.equals(strTargetValue))){
						System.out.println("For the OrderID:" +srcPrimaryKey  + " Source: " + methodName.getName() + " : " + strSourceValue);
						System.out.println("For the OrderID:" +srcPrimaryKey  + " Target: " + methodName.getName() + " : " + strTargetValue);
						}
						break;
					}
				}
			} else {
				if (pd.getReadMethod().getReturnType().isArray()) {

					//System.out.println("Array Return Type:" + pd.getReadMethod().getReturnType().getComponentType().getName());
					if ("java.lang.String"
							.equals(pd.getReadMethod().getReturnType().getComponentType().getName())) {
						
						strSourceValueArray = (String[])methodName.invoke(PurchaseSuccessSrc);
						strTargetValueArray = (String[])methodName.invoke(PurchaseSuccessTrg);
						if (strSourceValueArray == null && strTargetValueArray != null) 
						{
							Assert.fail("The value for the method:"+methodName.getName()+" has null value in the source and non null value in target");
							//TODO add the primary Key
						}
						else if (strSourceValueArray != null && strTargetValueArray == null)
						{
							Assert.fail("The value for the method:"+methodName.getName()+" has non null value in the source and  null value in target");
							//TODO add the primary Key
						} else if (strSourceValueArray != null && strTargetValueArray != null )
						{
					
						//TODO - Do the null checks , Sorting and for each elements in the length of the Array perform Comparison
					Arrays.sort(strSourceValueArray);
					Arrays.sort(strTargetValueArray);	
					if(!Arrays.deepEquals(strSourceValueArray, strTargetValueArray)){
						System.out.println("For the OrderID:" +srcPrimaryKey + " Source : " + methodName.getName() + " : " + strSourceValueArray.toString());
						System.out.println("For the OrderID:" +srcPrimaryKey + " Target : " + methodName.getName() + " : " + strTargetValueArray.toString());
						
					}
					}
					}

					else {
						
						objSourceValueArray = (Object[])methodName.invoke(PurchaseSuccessSrc);
						objTargetValueArray = (Object[])methodName.invoke(PurchaseSuccessTrg);
						if (objSourceValueArray == null && objTargetValueArray != null) 
						{
							Assert.fail("The value for the method:"+methodName.getName()+" has null value in the source and non null value in target");
							//TODO add the primary Key
						}
						else if (objSourceValueArray != null && objTargetValueArray == null)
						{
							Assert.fail("The value for the method:"+methodName.getName()+" has non null value in the source and  null value in target");
							//TODO add the primary Key
						} else if (objTargetValueArray != null && objSourceValueArray != null )
						{
							
							if (objSourceValueArray.length != objSourceValueArray.length)
							{
								Assert.fail("The Arraylength is different for Source and Target for the method:"+methodName.getName()+". The source "
										+ "array length is: "+objSourceValueArray.length+" and the target array length is :"+objTargetValueArray.length
										+" for the primary key:");//TODO add the primary Key
							}
							iCounterArray = objSourceValueArray.length;
							for (int itr01 = 0; itr01 < iCounterArray; itr01++)
							{
								ExcludedFieldsComparison(pd.getReadMethod().getReturnType().getComponentType(), objSourceValueArray[itr01], objTargetValueArray[itr01], srcPrimaryKey, input_field_name, src_date_format, trg_date_format, region, flag);
							}
						}
							
					}

				} else {
					if (PurchaseSuccessSrc !=null) 
						objSourceValue = methodName.invoke(PurchaseSuccessSrc);
					if (PurchaseSuccessTrg !=null) 
						objTargetValue = methodName.invoke(PurchaseSuccessTrg);
					if (!(PurchaseSuccessSrc == null && PurchaseSuccessTrg == null))
						ExcludedFieldsComparison(pd.getReadMethod().getReturnType(), objSourceValue, objTargetValue, srcPrimaryKey, input_field_name, src_date_format, trg_date_format, region, flag);

				}

			}
			}
			
		}

	}

	catch (Exception e) {

		e.printStackTrace();
		throw e;
	}
}

//Method to check for primary key
public static SDPKafkaIngestBean getprimaryKeyRecord(SDPKafkaIngestBean[] sdpTargetBeans, String strPrimaryKey) {
    
    
	for (int itr01 = 0; itr01 < sdpTargetBeans.length; itr01++)
    {
          if (sdpTargetBeans[itr01] != null && sdpTargetBeans[itr01].getPrimaryKey() != null && strPrimaryKey.equals(sdpTargetBeans[itr01].getPrimaryKey()))
                return sdpTargetBeans[itr01];
    } 
    return null;
   }

//Method called for obfuscated fields (PII/Date/Currency) field validations
@SuppressWarnings("unused")
public void ExcludedDataExtraction(String field_name, String source_path, String output_path, String src_date_format, String trg_date_format, String region, String flag) throws Exception {
	String lineSrc = null;
	String lineTrg = null;
	 PrintStream outStream   = null;
     PrintStream errStream = null;
     PrintStream fileStream  = null;
    List<PurchaseSuccess> objSourceData = new ArrayList<PurchaseSuccess>();    
	List<PurchaseSuccess> objTargetData = new ArrayList<PurchaseSuccess>(); 
	BufferedReader readerTrg = null;
	BufferedReader readerSrc = null;
	 List<String> extraPKSource = new ArrayList<String>();  
	 List<String>  extraPKTarget = new ArrayList<String>();
	ObjectMapper objectMapper = new ObjectMapper();
	objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	try {
		
		//Test other functionality 
	readerSrc = new BufferedReader(new FileReader(source_path));
 readerTrg = new BufferedReader(new FileReader(output_path));
	
	 //Path for comparison log
 	  outStream = System.out;
       errStream = System.err;
       fileStream = new PrintStream(new FileOutputStream("C:\\Users\\KKH13\\Input\\ComparisonLog.txt",false));
       System.setErr(fileStream);
       System.setOut(fileStream);
    
        
   	  //Read source File
         while ((lineSrc = readerSrc.readLine()) != null)  {
        	
        	 PurchaseSuccess PurchaseSuccessSrc = objectMapper.readValue(lineSrc, PurchaseSuccess.class);
        	 objSourceData.add(PurchaseSuccessSrc);	 
       
		}
       //Read Target File
         while ((lineTrg = readerTrg.readLine()) != null) {
        	 PurchaseSuccess purchaseSuccessTrg = objectMapper.readValue(lineTrg, PurchaseSuccess.class);
        	 objTargetData.add(purchaseSuccessTrg);	
        }
        PurchaseSuccess[] sdpTargetBeans = (PurchaseSuccess[]) objTargetData.toArray(new PurchaseSuccess[objTargetData.size()]); 
     
       PurchaseSuccess[] sdpSourceBeans = (PurchaseSuccess[]) objSourceData.toArray(new PurchaseSuccess[objSourceData.size()]); 
     //Get the count of source & Target File
     int countSrc=sdpSourceBeans.length;
     int countTrg=sdpTargetBeans.length;
     
     System.out.println("Source File Count:" + countSrc);
     System.out.println("Target File Count:"  + countTrg );
    
     //Get the source primary key
      
   
       for (int itr01 = 0; itr01 < sdpSourceBeans.length; itr01++){
    	  String srcPrimaryKey= sdpSourceBeans[itr01].orderId;
    	  SDPKafkaIngestBean   purchaseSuccessTrg = getprimaryKeyRecord(sdpTargetBeans, srcPrimaryKey);
    	if(purchaseSuccessTrg!=null) {
    		ExcludedFieldsComparison(PurchaseSuccess.class, sdpSourceBeans[itr01], purchaseSuccessTrg,srcPrimaryKey, field_name, src_date_format, trg_date_format, region, flag);	
    	}else{
    		extraPKSource.add(srcPrimaryKey);
    		
    	}
    		}
       if(!extraPKSource.isEmpty()){
    	   
       System.out.println("These OrderId's are missing in Target" + extraPKSource);
       }
       //Get the target extra primary key
       for (int itr01 = 0; itr01 < sdpTargetBeans.length; itr01++){
    	  String trgPrimaryKey= sdpTargetBeans[itr01].orderId;
    	  SDPKafkaIngestBean   purchaseSuccessSrc = getprimaryKeyRecord(sdpSourceBeans, trgPrimaryKey);
    	if(purchaseSuccessSrc==null) {
    		extraPKTarget.add(trgPrimaryKey);
    		 }
    	 }
       if(!extraPKTarget.isEmpty()){
       System.out.println("These OrderId's are missing in Source"  +extraPKTarget);	
        
       }
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		readerSrc.close();
		readerTrg.close();

	}

}

//Method to call for non-obfuscated fields comparison functions
@SuppressWarnings("rawtypes")
public static void IncludedFieldsComparison(List<String> attribute_list, Class classDef, Object PurchaseSuccessSrc, Object PurchaseSuccessTrg, String srcPrimaryKey)
		throws Exception

{
	try {
		String strSourceValue = "";
		String strTargetValue = "";
		String[] strSourceValueArray ;
		String[] strTargetValueArray ;
		Object objSourceValue = "";
		Object objTargetValue = "";
		Object objSourceValueArray[] ;
		Object objTargetValueArray[] ;
		int iCounterArray = 0;
		Method methodName ;
		int package_name_length = 0;
		int class_name_length = 0;
		String field_name = "";
		
		if("java.lang.Class".equals(classDef.getName()))
			return;
		for (PropertyDescriptor pd : Introspector.getBeanInfo(classDef).getPropertyDescriptors()) {
			methodName = pd.getReadMethod();
			if((methodName.invoke(PurchaseSuccessSrc))!=null && ((methodName.invoke(PurchaseSuccessTrg))!=null)){
			
			if (pd.getReadMethod().getReturnType().getName().equals("java.lang.String")) {
				strSourceValue = (String)methodName.invoke(PurchaseSuccessSrc);
				strTargetValue = (String)methodName.invoke(PurchaseSuccessTrg);
				
				field_name = "";
				package_name_length = classDef.getPackage().getName().toString().length();
				class_name_length = classDef.getName().length();
				field_name = classDef.getName();
				field_name = field_name.substring(package_name_length+1,class_name_length);
				if(field_name.equals("PurchaseSuccess")) {
					field_name = pd.getName();
				}
				else {
					field_name = field_name+"_"+pd.getName();
				}
				
				if(attribute_list.contains(field_name)) {
					//call Krishnas function
					continue;
				}
				
				
				
				if (strSourceValue == null && strTargetValue != null) 
				{
					Assert.fail("The value for the method:"+methodName.getName()+" has null value in the source and non null value in target");
					//TODO add the primary Key
				}
				else if (strSourceValue != null && strTargetValue == null)
				{
					Assert.fail("The value for the method:"+methodName.getName()+" has non null value in the source and  null value in target");
					//TODO add the primary Key
				} else if (strSourceValue != null && strTargetValue != null )
				{
				if((!strSourceValue.equals(strTargetValue))){
				System.out.println("For the OrderID:" +srcPrimaryKey  + " Source: " + methodName.getName() + " : " + strSourceValue);
				System.out.println("For the OrderID:" +srcPrimaryKey  + " Target: " + methodName.getName() + " : " + strTargetValue);
				
				}
				}
			} else {
				if (pd.getReadMethod().getReturnType().isArray()) {

					//System.out.println("Array Return Type:" + pd.getReadMethod().getReturnType().getComponentType().getName());
					if ("java.lang.String"
							.equals(pd.getReadMethod().getReturnType().getComponentType().getName())) {
						field_name = "";
						package_name_length = classDef.getPackage().getName().toString().length();
						class_name_length = classDef.getName().length();
						field_name = classDef.getName();
						field_name = field_name.substring(package_name_length+1,class_name_length);
						if(field_name.equals("PurchaseSuccess")) {
							field_name = pd.getName();
						}
						else {
							field_name = field_name+"_"+pd.getName();
						}
						if(attribute_list.contains(field_name)) {
							//call PII / DATE functions
							continue;
						}
						strSourceValueArray = (String[])methodName.invoke(PurchaseSuccessSrc);
						strTargetValueArray = (String[])methodName.invoke(PurchaseSuccessTrg);
						if (strSourceValueArray == null && strTargetValueArray != null) 
						{
							Assert.fail("The value for the method:"+methodName.getName()+" has null value in the source and non null value in target");
							//TODO add the primary Key
						}
						else if (strSourceValueArray != null && strTargetValueArray == null)
						{
							Assert.fail("The value for the method:"+methodName.getName()+" has non null value in the source and  null value in target");
							//TODO add the primary Key
						} else if (strSourceValueArray != null && strTargetValueArray != null )
						{
					
						//TODO - Do the null checks , Sorting and for each elements in the length of the Array perform Comparison
					Arrays.sort(strSourceValueArray);
					Arrays.sort(strTargetValueArray);	
					if(!Arrays.deepEquals(strSourceValueArray, strTargetValueArray)){
						System.out.println("For the OrderID:" +srcPrimaryKey + " Source : " + methodName.getName() + " : " + strSourceValueArray.toString());
						System.out.println("For the OrderID:" +srcPrimaryKey + " Target : " + methodName.getName() + " : " + strTargetValueArray.toString());
						
					}
					}
					}

					else {
						
						objSourceValueArray = (Object[])methodName.invoke(PurchaseSuccessSrc);
						objTargetValueArray = (Object[])methodName.invoke(PurchaseSuccessTrg);
						if (objSourceValueArray == null && objTargetValueArray != null) 
						{
							Assert.fail("The value for the method:"+methodName.getName()+" has null value in the source and non null value in target");
							//TODO add the primary Key
						}
						else if (objSourceValueArray != null && objTargetValueArray == null)
						{
							Assert.fail("The value for the method:"+methodName.getName()+" has non null value in the source and  null value in target");
							//TODO add the primary Key
						} else if (objTargetValueArray != null && objSourceValueArray != null )
						{
							
							if (objSourceValueArray.length != objSourceValueArray.length)
							{
								Assert.fail("The Arraylength is different for Source and Target for the method:"+methodName.getName()+". The source "
										+ "array length is: "+objSourceValueArray.length+" and the target array length is :"+objTargetValueArray.length
										+" for the primary key:");//TODO add the primary Key
							}
							iCounterArray = objSourceValueArray.length;
							for (int itr01 = 0; itr01 < iCounterArray; itr01++)
							{
								IncludedFieldsComparison(attribute_list, pd.getReadMethod().getReturnType().getComponentType(), objSourceValueArray[itr01], objTargetValueArray[itr01], srcPrimaryKey);
							}
						}
							
					}

				} else {
					if (PurchaseSuccessSrc !=null) 
						objSourceValue = methodName.invoke(PurchaseSuccessSrc);
					if (PurchaseSuccessTrg !=null) 
						objTargetValue = methodName.invoke(PurchaseSuccessTrg);
					if (!(PurchaseSuccessSrc == null && PurchaseSuccessTrg == null))
						IncludedFieldsComparison(attribute_list, pd.getReadMethod().getReturnType(), objSourceValue, objTargetValue, srcPrimaryKey);

				}

			}
			}
			
		}

	}

	catch (Exception e) {

		e.printStackTrace();
		throw e;
	}
}

//Method called for  non-obfuscated field validations
@SuppressWarnings("unused")
public void IncludedDataExtraction(List<String> attribute_list, String source_path, String output_path) throws Exception {
	String lineSrc = null;
	String lineTrg = null;
	 PrintStream outStream   = null;
     PrintStream errStream = null;
     PrintStream fileStream  = null;
    List<PurchaseSuccess> objSourceData = new ArrayList<PurchaseSuccess>();    
	List<PurchaseSuccess> objTargetData = new ArrayList<PurchaseSuccess>(); 
	BufferedReader readerTrg = null;
	BufferedReader readerSrc = null;
	 List<String> extraPKSource = new ArrayList<String>();  
	 List<String>  extraPKTarget = new ArrayList<String>();  
	ObjectMapper objectMapper = new ObjectMapper();
	objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	try {
		
		//Test other functionality 
	readerSrc = new BufferedReader(new FileReader(source_path));
 readerTrg = new BufferedReader(new FileReader(output_path));
	
	 //Path for comparison log
 	  outStream = System.out;
       errStream = System.err;
       fileStream = new PrintStream(new FileOutputStream("C:\\Users\\KKH13\\Input\\ComparisonLog.txt",false));
       System.setErr(fileStream);
       System.setOut(fileStream);
    
        
   	  //Read source File
         while ((lineSrc = readerSrc.readLine()) != null)  {
        	
        	 PurchaseSuccess PurchaseSuccessSrc = objectMapper.readValue(lineSrc, PurchaseSuccess.class);
        	 objSourceData.add(PurchaseSuccessSrc);	 
       
		}
       //Read Target File
         while ((lineTrg = readerTrg.readLine()) != null) {
        	 PurchaseSuccess purchaseSuccessTrg = objectMapper.readValue(lineTrg, PurchaseSuccess.class);
        	 objTargetData.add(purchaseSuccessTrg);	
        }
        PurchaseSuccess[] sdpTargetBeans = (PurchaseSuccess[]) objTargetData.toArray(new PurchaseSuccess[objTargetData.size()]); 
     
       PurchaseSuccess[] sdpSourceBeans = (PurchaseSuccess[]) objSourceData.toArray(new PurchaseSuccess[objSourceData.size()]); 
     //Get the count of source & Target File
     int countSrc=sdpSourceBeans.length;
     int countTrg=sdpTargetBeans.length;
     
     System.out.println("Source File Count:" + countSrc);
     System.out.println("Target File Count:"  + countTrg );
    
     //Get the source primary key
      
   
       for (int itr01 = 0; itr01 < sdpSourceBeans.length; itr01++){
    	  String srcPrimaryKey= sdpSourceBeans[itr01].orderId;
    	  SDPKafkaIngestBean   purchaseSuccessTrg = getprimaryKeyRecord(sdpTargetBeans, srcPrimaryKey);
    	if(purchaseSuccessTrg!=null) {
    		IncludedFieldsComparison(attribute_list,PurchaseSuccess.class, sdpSourceBeans[itr01], purchaseSuccessTrg,srcPrimaryKey);	
    	}else{
    		extraPKSource.add(srcPrimaryKey);
    		
    	}
    		}
       if(!extraPKSource.isEmpty()){
    	   
       System.out.println("These OrderId's are missing in Target" + extraPKSource);
       }
       //Get the target extra primary key
       for (int itr01 = 0; itr01 < sdpTargetBeans.length; itr01++){
    	  String trgPrimaryKey= sdpTargetBeans[itr01].orderId;
    	  SDPKafkaIngestBean   purchaseSuccessSrc = getprimaryKeyRecord(sdpSourceBeans, trgPrimaryKey);
    	if(purchaseSuccessSrc==null) {
    		extraPKTarget.add(trgPrimaryKey);
    		 }
    	 }
       if(!extraPKTarget.isEmpty()){
       System.out.println("These OrderId's are missing in Source"  +extraPKTarget);	
        
       }
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		readerSrc.close();
		readerTrg.close();

	}

}

}


 


