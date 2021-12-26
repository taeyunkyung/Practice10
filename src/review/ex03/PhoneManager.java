package review.ex03;

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

public class PhoneManager {

	private List<Person> pList;
	private Scanner sc;

	// 생성자
	public PhoneManager() {
		sc = new Scanner(System.in);
		pList = new ArrayList<Person>();

		loadList();
	}

	public void showTitle() {
		System.out.println("***********************************");
		System.out.println("*         전화번호 관리 프로그램         *");
		System.out.println("***********************************");
	}

	public int showMenu() {
		int menuNum;
		System.out.println("");
		System.out.println("1.리스트  2.등록  3.삭제  4.검색  5.종료");
		System.out.println("------------------------------------");
		System.out.print(">메뉴번호: ");
		menuNum = sc.nextInt();
		sc.nextLine();
		return menuNum;
	}

	// 메뉴
	public void showList() {
		System.out.println("<1.리스트>");
		printList();
	}

	public void showAdd() {
		System.out.println("<2.등록>");

		System.out.print(">이름: ");
		String name = sc.nextLine();

		System.out.print(">휴대전화: ");
		String hp = sc.nextLine();

		System.out.print(">회사전화: ");
		String company = sc.nextLine();

		Person person = new Person();
		person.setName(name);
		person.setHp(hp);
		person.setCompany(company);

		pList.add(person);

		saveList();

	}
	
	public void showRemove() {
		System.out.println("<3.삭제>");

		System.out.print(">번호: ");
		int no = sc.nextInt();
		pList.remove(no - 1);

		saveList();

		System.out.println("[삭제되었습니다.]");		
	}

	public void showSearch() {
		System.out.println("<4.검색>");

		System.out.print(">이름: ");
		String keyword = sc.nextLine();

		printList(keyword);
	}
	
	public void showEnd() {
		System.out.println("");
		System.out.println("***********************************");
		System.out.println("*             감사합니다             *");
		System.out.println("***********************************");
		
		sc.close();
	}
	
	public void showEtc() {
		System.out.println("[다시 입력해 주세요.]");
	}
	
	// 기능
	private void loadList() {
		try {

			Reader fr = new FileReader("C:\\javaStudy\\minipro\\PhoneDB.txt");
			BufferedReader br = new BufferedReader(fr);

			while (true) {
				String line = br.readLine();
				if (line == null) {
					break;
				}

				String[] data = line.split(",");
				String name = data[0];
				String hp = data[1];
				String company = data[2];

				Person phone = new Person(name, hp, company);

				pList.add(phone);
			}
			br.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void saveList() {

		try {

			Writer fw = new FileWriter("C:\\javaStudy\\minipro\\PhoneDB.txt");
			BufferedWriter bw = new BufferedWriter(fw);

			for (int i = 0; i < pList.size(); i++) {
				String str = pList.get(i).getName() + "," + pList.get(i).getHp() + "," + pList.get(i).getCompany();
				bw.write(str);
				bw.newLine();
			}
			bw.flush();
			bw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void printList() {
		printList("");
	}

	private void printList(String keyword) {
		for (int i = 0; i < pList.size(); i++) {
			String searchName = pList.get(i).getName();
			if (searchName.contains(keyword)) {
				System.out.print(i + 1 + ". ");
				System.out.print(pList.get(i).getName() + "\t");
				System.out.print(pList.get(i).getHp() + "\t");
				System.out.print(pList.get(i).getCompany() + "\t");
				System.out.println("");
			}
		}
	}
}
