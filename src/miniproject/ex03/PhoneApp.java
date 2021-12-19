package miniproject.ex03;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import miniproject.ex01.Person;

public class PhoneApp {

	public static void main(String[] args) throws IOException {

		PersonManager pm = new PersonManager();

		System.out.println("***********************************");
		System.out.println("*         전화번호 관리 프로그램         *");
		System.out.println("***********************************");

		Scanner sc = new Scanner(System.in);
		List<Person> pList = new ArrayList<Person>();

		pm.readList(pList);

		boolean action = true;
		while (action) {

			pm.countNum(pList);

			System.out.println("1.리스트  2.등록  3.삭제  4.검색  5.종료");
			System.out.println("------------------------------------");
			System.out.print(">메뉴번호: ");
			int select = sc.nextInt();

			switch (select) {
			case 1:
				System.out.println("<1.리스트>");

				pm.printList(pList);

				break;

			case 2:
				System.out.println("<2.등록>");

				System.out.print(">이름: ");
				String enterName = sc.next();

				System.out.print(">휴대전화: ");
				String enterHp = sc.next();

				System.out.print(">회사전화: ");
				String enterCompany = sc.next();

				pm.optionSecond(pList, enterName, enterHp, enterCompany);

				break;

			case 3:
				System.out.println("<3.삭제>");

				System.out.print(">번호: ");
				int delete = sc.nextInt();

				pm.optionThird(pList, delete);

				break;

			case 4:
				System.out.println("<4.검색>");

				System.out.print(">이름: ");
				String search = sc.next();

				pm.optionFourth(pList, search);

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

}
