package com.jda.utility;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Utility class for Algorithm Program which contains methods for checking
 * Anagram , Getting Prime series.
 * 
 * @author bridgelabz
 *
 */
public class AlgorithmUtility {
	static Scanner sc = new Scanner(System.in);

	public static int getInteger() {
		String getval = sc.next();
		int value = Integer.valueOf(getval);
		return value;
	}

	public static float getFloat() {
		String getval = sc.next();
		float value = Float.valueOf(getval);
		return value;
	}

	public static String getNext() {
		String getval = sc.next();
		return getval;
	}

	public static String getString() {
		String stringval = sc.nextLine();
		return stringval;
	}

	/**
	 * Make hash table for both the string. String have character from a to z.
	 * And finally check that the count at every position is same, if yes return
	 * Strings are anagram else return Strings are not anagram.
	 */
	public static boolean checkAnagram(String first, String second) {
		int len1 = first.length(), len2 = second.length();
		boolean digit = false;
		int[] cnt1 = new int[26];
		int[] cnt2 = new int[26];
		int[] cnt3 = new int[10];
		int[] cnt4 = new int[10];
		for (int i = 0; i < len1; i++) {
			if (first.charAt(i) - 'a' >= 0)
				cnt1[first.charAt(i) - 'a']++;
			else {
				cnt3[first.charAt(i) - '0']++;
				digit = true;
			}
		}
		for (int i = 0; i < len2; i++) {
			if ((second.charAt(i) - 'a') >= 0)
				cnt2[second.charAt(i) - 'a']++;
			else
				cnt4[second.charAt(i) - '0']++;
		}
		if (!digit) {
			for (int i = 0; i < 26; i++) {
				if (cnt1[i] != cnt2[i])
					return false;
			}
		} else {
			for (int i = 0; i < 10; i++) {
				if (cnt3[i] != cnt4[i])
					return false;
			}
		}
		return true;
	}
	/**
	 * Binary search is applicable on sorted set of data. We have a key
	 * which will be checked by algorithm that is it exist or not? Firstly
	 * take the middle element and check is it greater than the key element
	 * if yes make our search from low to middle-1 if not then make our
	 * search from middle+1 to high. If it is equal to the element then
	 * return yes otherwise return not exist.
	 */
	public static boolean binarySearchForInteger(List<Integer> arr, int key, int len) {
		int low = 0, high = len - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (arr.get(mid) > key)
				high = mid - 1;
			else if (arr.get(mid) < key)
				low = mid + 1;
			else
				return true;
		}
		return false;
	}
	/**
	 * Binary search is applicable on sorted set of data. We have a key
	 * which will be checked by algorithm that is it exist or not? Firstly
	 * take the middle string and check is it greater than the key string if
	 * yes make our search from low to middle-1 if not then make our search
	 * from middle+1 to high. If it is equal to the string then return yes
	 * otherwise return not exist.
	 */
	public static boolean binarySearchForString(List<String> arr, String key, int len) {
		int low = 0, high = len - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			String tmpstr = arr.get(mid);
			if (tmpstr.compareToIgnoreCase(key) > 0)
				high = mid - 1;
			else if (tmpstr.compareToIgnoreCase(key) < 0)
				low = mid + 1;
			else
				return true;
		}
		return false;
	}
	/**
	 * Consider array have single element which is always sorted then with
	 * the help of this element place the rest element to it's correct
	 * position. Get second element and compare it with the first element if
	 * it is smaller than first then copy the previous value to second and
	 * at last at first position copy the second. And do the same thing till
	 * the last element fit it's exact location.
	 */
	public static List<Integer> insertionSortForInterger(List<Integer> arr, int len) {
	
		for (int i = 1; i < len; i++) {
			int key = arr.get(i), j;
			for (j = i - 1; j >= 0 && arr.get(j) > key; j--)
				arr.set(j + 1, arr.get(j));
			arr.set(j + 1, key);
		}
		return arr;
	}
	/**
	 * Consider array have single string which is always sorted then with
	 * the help of this string place the rest element to it's correct
	 * position. Get second string and compare it with the first string if
	 * it is smaller than first then copy the previous value to second and
	 * at last at first position copy the second. And do the same thing till
	 * the last string fit it's exact location.
	 */
	public static List<String> insertionSortForString(List<String> arr, int len) {
	
		for (int i = 1; i < len; i++) {
			String key = arr.get(i);
			int j;
			for (j = i - 1; j >= 0 && arr.get(j).compareToIgnoreCase(key) > 0; j--)
				arr.set(j + 1, arr.get(j));
			arr.set(j + 1, key);
		}
		return arr;
	}
	/**
	 * Firstly take the largest string of the array list and place to last
	 * element and take second largest string of the array and place to the
	 * second last string and keep doing until minimum element get it exact
	 * position.
	 */
	public static List<String> bubbleSortForString(List<String> arr, int len) {
		
		for (int i = 0; i < len - 1; i++) {
			for (int j = 0; j < len - i - 1; j++) {
				if (arr.get(j).compareToIgnoreCase(arr.get(j + 1)) > 0) {
					String tmp = arr.get(j);
					arr.set(j, arr.get(j + 1));
					arr.set(j + 1, tmp);
				}
			}
		}
		return arr;
	}
	/**
	 * Firstly take the largest element of the array list and place to last
	 * element and take second largest element of the array and place to the
	 * second last element and keep doing until minimum element get it exact
	 * position.
	 */
	public static List<Integer> bubbleSortForInteger(List<Integer> arr, int len) {
	
		for (int i = 0; i < len - 1; i++) {
			for (int j = 0; j < len - i - 1; j++) {
				if (arr.get(j) > arr.get(j + 1)) {
					int tmp = arr.get(j);
					arr.set(j, arr.get(j + 1));
					arr.set(j + 1, tmp);
				}
			}
		}
		return arr;
	}

	public static boolean primeChecker(int val) {
		if (val == 0 || val == 1)
			return false;
		for (int i = 2; i * i <= val; i++) {
			if (val % i == 0)
				return false;
		}
		return true;
	}

	public static List<Integer> primeSeries(int strt, int end) {
		List<Integer> series = new ArrayList<>();
		for (int i = strt; i <= end; i++) {
			if (primeChecker(i))
				series.add(i);
		}
		return series;
	}
	/**
	 * if first element is equal to last element and second is equal to
	 * second last and doing same till middle of the string if any mismatch
	 * occur then return Not palindrom otherwise return palindrom.
	 */
	public static boolean palindrom(String ch) {
		int len = ch.length(), i, j;
		for (i = 0, j = len - 1; i <= j; i++, j--)
			if (ch.charAt(i) != ch.charAt(j))
				return false;
		return true;
	}
	public static int dayOfWeek(int month,int day,int year)
	{
		int y=(year - (14-month)/12);
		int x=y + y/4 - y/100 + y/400;
		int m0 = month +  12*((14-month)/12) -2;;
		int d0 = (day + x + (31*m0)/ 12) % 7;
		return d0;
	}
	public static float tempratureConversion(float tmp,int opt)
	{
		if(opt ==1)
			return ((tmp*9)/5+32);
		
		return ((tmp-32)*5)/9;
	}
	public static float montlyPayment(float principalAmnt , float year, float intrst)
	{
		float r=intrst/(12*100);
		float n=12*year;
		return (principalAmnt*r)/(float)(1.0-(float)1/Math.pow(1+r,n)) ;
	}
	public static String toBinary(int num)
	{
		char[] ch= new char[32];
		for(int i=0;i<32;i++)
			ch[i]='0';
		int index=31;
		while(num>0)
		{
			ch[index--]=(char)(num%2+'0');
			num=num/2;
		}
		return String.valueOf(ch);
	}
}