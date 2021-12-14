package miniproject;

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

public class PhoneApp_ex {

	public static void main(String[] args) throws IOException { // 연습장 (1차 시도 ~ )

		System.out.println("***********************************");
		System.out.println("*         전화번호 관리 프로그램         *");
		System.out.println("***********************************");

		Scanner sc = new Scanner(System.in);
		List<Person> pList = new ArrayList<Person>();

		Reader fr = new FileReader("C:\\javaStudy\\minipro\\PhoneDB.txt");
		BufferedReader br = new BufferedReader(fr);		

		Writer fw = new FileWriter("C:\\javaStudy\\minipro\\PhoneDB.txt");
		BufferedWriter bw = new BufferedWriter(fw);

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
		// System.out.println(pList.toString());
		
		boolean action = true;
		while (action) {

			System.out.println("1.리스트  2.등록  3.삭제  4.검색  5.종료");
			System.out.println("------------------------------------");
			System.out.print(">메뉴번호: ");
			int select = sc.nextInt();

			switch (select) {
			case 1:
				System.out.println("<1.리스트>");
				printList(pList);
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

				// 리스트 변경
				Person enter = new Person(enterName, enterHp, enterCompany);
				pList.add(enter);

				// PhoneDB.txt 변경
				for (Person write : pList) {
					bw.write(write.enter());
					bw.newLine();
				}

				System.out.println("[등록되었습니다.]");
				System.out.println("");
				break;

			case 3:
				System.out.println("<3.삭제>");
				System.out.print(">번호: ");
				int delete = sc.nextInt();

				// 리스트 변경
				pList.remove(delete - 1);

				// PhoneDB.txt 변경
				for (Person write : pList) {
					bw.write(write.enter());
					bw.newLine();
				}

				System.out.println("[삭제되었습니다.]");
				System.out.println("");
				break;

			case 4:
				System.out.println("<4.검색>");
				System.out.print(">이름: ");
				String search = sc.next();

				// 별도 리스트
				List<Person> searchList = new ArrayList<Person>();
				for (int i = 0; i < pList.size(); i++) { 
					String s = pList.get(i).getName();
					if (s.contains(search)) {
						searchList.add(pList.get(i));
					}
				}
				
				// 확인
				printList(searchList);
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
		bw.close();
	}

	public static void printList(List<Person> list) { 
		for (int i = 0; i < list.size(); i++) {
			System.out.println((i + 1) + ".   " + list.get(i).getName() + "   " + list.get(i).getHp() + "   "
					+ list.get(i).getCompany());
		}
	} // <4.검색>시 본래 리스트의 번호(=순서)를 불러올 수 없음

}
