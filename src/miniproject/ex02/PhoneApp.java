package miniproject.ex02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import miniproject.ex01.Person;

public class PhoneApp {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		System.out.println("***********************************");
		System.out.println("*         전화번호 관리 프로그램         *");
		System.out.println("***********************************");

		List<Person> pList = new ArrayList<Person>();
		readList(pList);

		boolean action = true;
		while (action) {

			countNum(pList);

			System.out.println("1.리스트  2.등록  3.삭제  4.검색  5.종료");
			System.out.println("------------------------------------");
			System.out.print(">메뉴번호: ");
			int select = sc.nextInt();

			switch (select) {
			case 1:
				System.out.println("<1.리스트>");

				printList(pList);

				break;

			case 2:
				System.out.println("<2.등록>");
				System.out.print(">이름: ");
				String enterName = sc.next();

				System.out.print(">휴대전화: ");
				String enterHp = sc.next();

				System.out.print(">회사전화: ");
				String enterCompany = sc.next();

				optionSecond(pList, enterName, enterHp, enterCompany);

				break;

			case 3:
				System.out.println("<3.삭제>");
				System.out.print(">번호: ");
				int delete = sc.nextInt();

				optionThird(pList, delete);

				break;

			case 4:
				System.out.println("<4.검색>");
				System.out.print(">이름: ");
				String search = sc.next();

				optionFourth(pList, search);

				break;

			case 5:
				action = false;
				System.out.println("");
				System.out.println("***********************************");
				System.out.println("*             감사합니다             *");
				System.out.println("***********************************");
				break;

			default:
				System.out.println("[다시 입력해 주세요.]");
				System.out.println("");
				break;

			}
		}

		sc.close();
	}

	// 메소드 모음
	public static void readList(List<Person> list) throws IOException {

		Reader fr = new FileReader("C:\\javaStudy\\minipro\\PhoneDB.txt");
		BufferedReader br = new BufferedReader(fr);

		while (true) {
			String str = br.readLine();

			if (str == null) {
				break;
			}

			String dataArray[] = str.split(",");
			String name = dataArray[0];
			String hp = dataArray[1];
			String company = dataArray[2];

			Person data = new Person(name, hp, company);
			list.add(data);
		}

		br.close();
	}

	public static void printList(List<Person> list) {

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getCount() + ".   " + list.get(i).getName() + "   " + list.get(i).getHp()
					+ "   " + list.get(i).getCompany());
		}

		System.out.println("");
	}

	public static void countNum(List<Person> list) {

		for (int i = 0; i < list.size(); i++) {
			list.get(i).setCount(i + 1);
		}
	}

	public static void optionSecond(List<Person> list, String name, String hp, String company) throws IOException {

		Person data = new Person(name, hp, company);
		list.add(data);

		writeList(list);

		System.out.println("[등록되었습니다.]");
		System.out.println("");

	}

	public static void optionThird(List<Person> list, int delete) throws IOException {

		list.remove(delete - 1);

		writeList(list);

		System.out.println("[삭제되었습니다.]");
		System.out.println("");

	}

	public static void optionFourth(List<Person> list, String search) throws IOException {

		List<Person> searchList = new ArrayList<Person>();

		for (int i = 0; i < list.size(); i++) {
			String s = list.get(i).getName();
			if (s.contains(search)) {
				searchList.add(list.get(i));
			}
		}

		printList(searchList);

	}

	public static void writeList(List<Person> list) throws IOException {

		Writer fw = new FileWriter("C:\\javaStudy\\minipro\\PhoneDB.txt");
		BufferedWriter bw = new BufferedWriter(fw);

		for (Person write : list) {
			bw.write(write.getName() + "," + write.getHp() + "," + write.getCompany());
			bw.newLine();
		}

		bw.close();
	}
}
