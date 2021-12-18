package miniproject.ex01;

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

	public static void main(String[] args) throws IOException {

		System.out.println("***********************************");
		System.out.println("*         전화번호 관리 프로그램         *");
		System.out.println("***********************************");

		Scanner sc = new Scanner(System.in);
		List<Person> pList = new ArrayList<Person>();

		// txt파일을 읽어 리스트에 넣어준다
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
			pList.add(data);
		}

		br.close();

		boolean action = true;
		while (action) {

			countNum(pList); // 리스트에 변화가 생길 때마다 Person의 count값을 새로 정렬해준다

			System.out.println("1.리스트  2.등록  3.삭제  4.검색  5.종료");
			System.out.println("------------------------------------");
			System.out.print(">메뉴번호: ");
			int select = sc.nextInt();

			switch (select) {
			case 1:
				System.out.println("<1.리스트>");
				for (Person p : pList) {
					p.printList(); // Person의 메소드 사용
				}
				System.out.println("");
				break;

			case 2:
				System.out.println("<2.등록>");
				System.out.print(">이름: ");
				String enterName = sc.next();

				System.out.print(">휴대전화: ");
				String enterHp = sc.next();

				System.out.print(">회사전화: ");
				String enterCompany = sc.next();

				Person enter = new Person(enterName, enterHp, enterCompany);
				pList.add(enter); // 리스트에 추가

				writeList(pList); // 메소드 사용: PhoneDB.txt 새로 작성

				System.out.println("[등록되었습니다.]");
				System.out.println("");
				break;

			case 3:
				System.out.println("<3.삭제>");
				System.out.print(">번호: ");
				int delete = sc.nextInt();

				pList.remove(delete - 1); // 리스트에서 삭제

				writeList(pList); // 메소드 사용: PhoneDB.txt 새로 작성

				System.out.println("[삭제되었습니다.]");
				System.out.println("");
				break;

			case 4:
				System.out.println("<4.검색>");
				System.out.print(">이름: ");
				String search = sc.next();

				List<Person> searchList = new ArrayList<Person>(); // 새로운 리스트
				for (int i = 0; i < pList.size(); i++) {
					String s = pList.get(i).getName();
					if (s.contains(search)) {
						searchList.add(pList.get(i));
					}
				}

				for (Person p : searchList) {
					p.printList();
				}

				System.out.println("");
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

	public static void countNum(List<Person> list) {
		for (int i = 0; i < list.size(); i++) {
			list.get(i).setCount(i + 1);
		}
	}

	public static void writeList(List<Person> list) throws IOException {

		Writer fw = new FileWriter("C:\\javaStudy\\minipro\\PhoneDB.txt");
		BufferedWriter bw = new BufferedWriter(fw);

		for (Person write : list) {
			bw.write(write.enter());
			bw.newLine();
		}

		bw.close();
	}
}
