package Ch08;

import java.io.*;
import java.net.*;

public class Q08_02 {

	public static void main(String[] args) {
		try {
			methodA();
		} catch (ArithmeticException e) {
		}
		System.out.println("Program ends");
	}

	static void methodA() {
		int i = 3 / 0;
		try {
			URL urlA = new URL("http://www.seed.net.tw");
		} catch (MalformedURLException e) {

			e.printStackTrace();
		}
		try {
			FileInputStream fis = new FileInputStream("D:\\Test.txt");
		} catch (FileNotFoundException e) {
		}

	}
}