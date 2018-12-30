package com.java.GenericUtility;

public interface GenericInterface<T extends Comparable<T>> {
T min();
T max();
}
