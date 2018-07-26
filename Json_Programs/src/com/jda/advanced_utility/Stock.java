package com.jda.advanced_utility;
public class Stock {
private String nameOfStack;
private double pricePerShare;
private double totalShare;
private double totValue;
public double getTotValue() {
	return totValue;
}
public void setTotValue() {
	this.totValue = totalShare*pricePerShare;
}
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
public void setTotalShare(double totalShare) {
	this.totalShare = totalShare;
}
}
