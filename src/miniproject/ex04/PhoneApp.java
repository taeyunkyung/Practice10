package miniproject.ex04;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import miniproject.ex01.Person;

public class PhoneApp {

	public static void main(String[] args) throws IOException {

		PersonRepository pr = new PersonRepository();
		PersonView pv = new PersonView();

		pv.titlePage();

		Scanner sc = new Scanner(System.in);
		List<Person> pList = new ArrayList<Person>();

		pr.readList(pList);

		boolean action = true;
		while (action) {

			pr.countNum(pList);

			pv.optionSelect();
			int select = sc.nextInt();

			switch (select) {
			case 1:
				pv.selected(1);

				pr.printList(pList);

				break;

			case 2:
				pv.selected(2);

				System.out.print(">이름: ");
				String enterName = sc.next();

				System.out.print(">휴대전화: ");
				String enterHp = sc.next();

				System.out.print(">회사전화: ");
				String enterCompany = sc.next();

				pr.optionSecond(pList, enterName, enterHp, enterCompany);
				pv.end(2);

				break;

			case 3:
				pv.selected(3);

				System.out.print(">번호: ");
				int delete = sc.nextInt();

				pr.optionThird(pList, delete);
				pv.end(3);

				break;

			case 4:
				pv.selected(4);

				System.out.print(">이름: ");
				String search = sc.next();

				pr.optionFourth(pList, search);

				break;

			case 5:
				action = false;
				pv.selected(5);
				break;

			default:
				pv.end(select);
				break;
			}
		}

		sc.close();
	}

}
