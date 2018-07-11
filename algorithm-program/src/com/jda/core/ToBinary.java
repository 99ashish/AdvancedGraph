package com.jda.core;

import com.jda.utility.AlgorithmUtility;
/**
 * 
 * @author bridgelabz
 *
 */
public class ToBinary {
	public static boolean powerOfTwo(String str) {
		char[] ch = str.toCharArray();
		int cnt = 0;
		for (int i = 0; i < 32; i++) {
			if (ch[i] == '1')
				cnt++;
		}
		if (cnt == 1)
			return true;
		return false;
	}

	public static String swapNibble(String str, int nibbleNum, int toSwapNibble) {
		char[] ch = str.toCharArray();
		for (int i = 0; i < 4; i++) {
			char tmp = ch[4 * nibbleNum + i];
			ch[4 * nibbleNum + i] = ch[4 * toSwapNibble + i];
			ch[4 * toSwapNibble + i] = tmp;
		}
		return String.valueOf(ch);
	}

	public static void main(String[] args) {
		System.out.println("Enter a integer number:");
		int num = AlgorithmUtility.getInteger();
		String binary = AlgorithmUtility.toBinary(num);
		System.out.println("Binay conversion of " + num + " is " + binary);

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (i != j) {
					String str = swapNibble(binary, i, j);
					if (powerOfTwo(str))
						System.out.println(str);
				}
			}
		}

	}

}
