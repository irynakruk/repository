package com.reflection.reader;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		try{
			System.out.print("Enter class name: ");
			String inputText = scanner.nextLine();
			
			while(!"end".equals(inputText)){
				ClassReader.readClass(inputText);
				System.out.print("Enter class name: ");
				inputText = scanner.nextLine();
			}			
		} finally{
			scanner.close();
		}
	}

}
