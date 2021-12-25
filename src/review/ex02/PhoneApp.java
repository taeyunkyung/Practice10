package review.ex02;

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

public class PhoneApp {
	 /*
	  main 함수 이용, 메소드로 기능분리 
	 - 시작시 파일을 읽어 리스트에 추가하는 기능 
	 - 리스트를 화면에 출력하는 기능 (1.리스트 4.검색)
	 - 리스트의 모든 값을 파일에 저장하는 기능 (2.등록 3.삭제)
	 */

	private static List<Person> pList;

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);

		loadList();

		System.out.println("***********************************");
		System.out.println("*         전화번호 관리 프로그램         *");
		System.out.println("***********************************");

		boolean run = true;
		while (run) {

			System.out.println("1.리스트  2.등록  3.삭제  4.검색  5.종료");
			System.out.println("------------------------------------");
			System.out.print(">메뉴번호: ");

			int menuNum = sc.nextInt();
			sc.nextLine();

			switch (menuNum) {

			case 1: 
				System.out.println("<1.리스트>");

				showList();

				break;

			case 2: 
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

				System.out.println("[등록되었습니다.]");
				System.out.println("");
				break;

			case 3:
				System.out.println("<3.삭제>");

				System.out.print(">번호: ");
				int no = sc.nextInt();
				pList.remove(no - 1);

				saveList();

				System.out.println("[삭제되었습니다.]");
				System.out.println("");
				break;

			case 4: 
				System.out.println("<4.검색>");

				System.out.print(">이름: ");
				String keyword = sc.nextLine();

				showList(keyword);

				break;

			case 5: 
				run = false;
				break;

			default:
				System.out.println("[다시 입력해 주세요.]");
				System.out.println("");
				break;

			} // switch 종료
		} // while 종료

		sc.close();

		System.out.println("");
		System.out.println("***********************************");
		System.out.println("*             감사합니다             *");
		System.out.println("***********************************");
	}

	public static void loadList() throws IOException {
		Reader fr = new FileReader("C:\\javaStudy\\minipro\\PhoneDB.txt");
		BufferedReader br = new BufferedReader(fr);

		pList = new ArrayList<Person>();

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
	}

	public static void showList() { // 메소드 오버로딩
		showList(""); 				// 키워드가 없는 값으로 전달
	}

	public static void showList(String keyword) {
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
		System.out.println("");
	}

	public static void saveList() throws IOException {
		Writer fw = new FileWriter("C:\\javaStudy\\minipro\\PhoneDB.txt");
		BufferedWriter bw = new BufferedWriter(fw);

		for (int i = 0; i < pList.size(); i++) {
			String str = pList.get(i).getName() + "," + pList.get(i).getHp() + "," + pList.get(i).getCompany();
			bw.write(str);
			bw.newLine();
		}
		bw.flush();
		bw.close();
	}

}
