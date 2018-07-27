package com.jda.advanced_utility;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
class Transaction{
	String transactionType;
	String date;
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public String getDate() {
		return date;
	}
	public void setDate() {
		DateTimeFormatter date=DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
	    LocalDateTime now=LocalDateTime.now();
	    this.date=date.format(now);
	}
}
public class Stock {
private String nameOfStack;
private double pricePerShare;
private double totalShare;
Transaction transAction;
public String getNameOfStack() {
	return nameOfStack;
}
public void setNameOfStack(String nameOfStack) {
	this.nameOfStack = nameOfStack;
}
public double getPricePerShare() {
	return pricePerShare;
}
public void setPricePerShare(double pricePerShare) {
	this.pricePerShare = pricePerShare;
}
public double getTotalShare() {
	return totalShare;
}
public Transaction getTransAction() {
	return transAction;
}
public void setTransAction(Transaction transAction) {
	this.transAction = transAction;
}
public void setTotalShare(double totalShare) {
	this.totalShare = totalShare;
}
}
