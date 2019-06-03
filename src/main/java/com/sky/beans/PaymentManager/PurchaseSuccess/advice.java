package com.sky.beans.PaymentManager.PurchaseSuccess;

import java.util.Arrays;

public class advice {
	private String advice_code;
	
	private String subject_ids[];
    private String advice_message;
    private String reference_ids[];
    private String reference_static_ids[];
    private String subject_static_ids[];
	public String getAdvice_code() {
		return advice_code;
	}
	public void setAdvice_code(String advice_code) {
		this.advice_code = advice_code;
	}
	public String[] getSubject_ids() {
		return subject_ids;
	}
	public void setSubject_ids(String[] subject_ids) {
		this.subject_ids = subject_ids;
	}
	public String getAdvice_message() {
		return advice_message;
	}
	public void setAdvice_message(String advice_message) {
		this.advice_message = advice_message;
	}
	public String[] getReference_ids() {
		return reference_ids;
	}
	public void setReference_ids(String[] reference_ids) {
		this.reference_ids = reference_ids;
	}
	public String[] getReference_static_ids() {
		return reference_static_ids;
	}
	public void setReference_static_ids(String[] reference_static_ids) {
		this.reference_static_ids = reference_static_ids;
	}
	public String[] getSubject_static_ids() {
		return subject_static_ids;
	}
	public void setSubject_static_ids(String[] subject_static_ids) {
		this.subject_static_ids = subject_static_ids;
	}
	@Override
	public String toString() {
		return "Advice [advice_Code=" + advice_code + ", subjectIds=" + Arrays.toString(subject_ids)
				+ ", advice_Message=" + advice_message + ", reference_Ids=" + Arrays.toString(reference_ids)
				+ ", reference_static_ids=" + Arrays.toString(reference_static_ids) + ", subject_static_ids="
				+ Arrays.toString(subject_static_ids) + "]";
	}	
    
}
