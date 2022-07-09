package com.bridgelab.addressbook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class AddressBookMain {
	static Scanner sc;

	public static void main(String[] args) throws IllegalAccessError {

		System.out.println("***--Welcome to the addressBook--***");

		sc = new Scanner(System.in);

		HashMap<String, IAddressBook> addressBook = new HashMap<>();
		IAddressBook familyaddressBook = new AddressBook();
		IAddressBook businessaddressBook = new AddressBook();
		IAddressBook friendsaddressBook = new AddressBook();

		addressBook.put("Family", familyaddressBook);
		addressBook.put("Business", businessaddressBook);
		addressBook.put("Friends", friendsaddressBook);

		int userInput = 0;

		while (userInput != 5) {

			userInput = getOption(sc);
			sc = new Scanner(System.in);
			String inputValue;
			switch (userInput) {
			case 1:
				try {
					System.out.println("Enter which addressBook you want to add contact");
					System.out.println("1. Family \n2. Business \n3. Friends");
					inputValue = sc.nextLine();

					sc = new Scanner(System.in);
					addressBook.get(inputValue).addContact(sc);
				} catch (NullPointerException ne) {
					// System.out.println(ne.getMessage());
					System.out.println("Enter the options in proper formate...!!");
				}

				break;
			case 2:

				addressBook.forEach((key, addressbook) -> {
					System.out.println("--------" + key + "--------");

					addressbook.showaddress();
				});

				break;

			case 3:
				try {
					System.out.println("Enter which addressBook you want to edit the contact");
					System.out.println("1. Family \n2. Business \n3. Friends");
					inputValue = sc.nextLine();

					sc = new Scanner(System.in);
					addressBook.get(inputValue).updateContact(sc);
				} catch (NullPointerException ne) {
					System.out.println("Enter the options in proper formate...!!");
				}

				break;

			case 4:
				try {
					System.out.println("Enter which addressBook you want to delete the contact");
					System.out.println("1. Family \n2. Business \n3. Friends");
					inputValue = sc.nextLine();

					sc = new Scanner(System.in);
					addressBook.get(inputValue).deleteContact();
				} catch (NullPointerException ne) {
					System.out.println("Enter the options in proper formate...!!");
				} catch (Exception ec) {
				}
				break;

			case 5:

				userInput = 5;
				System.out.println("Exit from addressBook bye...! ");
				break;

			default:
				throw new IllegalArgumentException("check your option again ...!");
			}

		}
		sc.close();
	}

	public static int getOption(Scanner sc) {

		System.out.println("1. Add Contacts\n2. Show Contact \n3. Edit \n4. Delete Contacts \n5. Exit");
		System.out.println("Enter your choice...!");
		int option = sc.nextInt();

		return option;
	}

}
