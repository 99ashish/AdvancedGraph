package com.jda.advanced_utility;
class Property {
	private String brandName;
	private float pricePerKg;
	private float weight;
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public float getPricePerKg() {
		return pricePerKg;
	}
	public void setPricePerKg(float pricePerKg) {
		this.pricePerKg = pricePerKg;
	}
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
}
public class Commodity 
{
String commodityName;
Property property;
public String getCommodityName() {
	return commodityName;
}
public void setCommodityName(String commodityName) {
	this.commodityName = commodityName;
}
public Property getProperty() {
	return property;
}
public void setProperty(Property property) {
	this.property = property;
}
}
