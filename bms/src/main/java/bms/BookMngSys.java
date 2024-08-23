package bms;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class BookMngSys {
	static Scanner sc=new Scanner(System.in);
	static EntityManagerFactory emf=Persistence.createEntityManagerFactory("bks");
	static EntityManager em=emf.createEntityManager();
	static EntityTransaction et=em.getTransaction();
	public static void main(String[] args) {
		while(true) {
			System.out.println();
			System.out.println("************************");
			System.out.println("Enter Choice:\n 1. Save new Record..\n 2. Update Record..\n 3. Find Record..\n 4. Delete Record..");
			switch (sc.nextInt()) {
			case 1: saveRecord();
				break;
			case 2: updateRecord();
				break;
			case 3:	findRecord();
				break;
			case 4:	deleteRecord();
				break;
			default:
				System.out.println("Invalid Choice");
			}
		}
	}
	private static void deleteRecord() {
		System.out.println("Enter Book id");
		Books book=em.find(Books.class, sc.nextInt());
		System.out.println(book);
		et.begin();
		em.remove(book);
		et.commit();
	}
	private static void findRecord() {
		System.out.println("Enter Book id");
		Books book=em.find(Books.class, sc.nextInt());
		System.out.println(book);
	}
	private static void updateRecord() {
		System.out.println("Enter Book id");
		Books book=em.find(Books.class, sc.nextInt());
		
		System.out.println("Which column you want to update\n date\n price\n title\n");
		switch (sc.next()) {
		case "date":	System.out.println("Enter Date to Update");
						book.setDate(sc.next());
			break;
		case "price":	System.out.println("Enter Price to Update");
						book.setPrice(sc.nextDouble());
			break;
		case "title":	System.out.println("Enter Title to Update");
						book.setTitle(sc.next());
			break;
		default:		System.out.println("Invalid Choice or Check Spells");
			break;
		}
		System.out.println(book);
		et.begin();
		em.merge(book);
		et.commit();
	}
	private static void saveRecord() {
		Books b=new Books();
		System.out.println("Enter Book Id");
		b.setId(sc.nextInt());
		System.out.println("Enter Book Title");
		b.setTitle(sc.next());
		System.out.println("Enter Book Date");
		b.setDate(sc.next());
		System.out.println("Enter Book Price");
		b.setPrice(sc.nextDouble());
		et.begin();
		em.persist(b);
		et.commit();
	}

}
