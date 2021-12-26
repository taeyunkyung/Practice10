package review.ex04;

import java.util.List;
import java.util.Scanner;

public class PhoneView {

	private Scanner sc;

	// 생성자
	public PhoneView() {
		this.sc = new Scanner(System.in);
	}

	// 기본화면
	public void showStart() {
		System.out.println("***********************************");
		System.out.println("*         전화번호 관리 프로그램         *");
		System.out.println("***********************************");
	}

	public int showMenu() {
		System.out.println("");
		System.out.println("1.리스트  2.등록  3.삭제  4.검색  5.종료");
		System.out.println("------------------------------------");
		System.out.print(">메뉴번호: ");

		int menuNum = sc.nextInt();
		sc.nextLine();

		return menuNum;
	}

	// 메뉴
	public void showList(List<Person> phoneList) {
		System.out.println("<1.리스트>");
		showSearchResult(phoneList, "");
	}

	public Person showAdd() {

		Person person = new Person();
		System.out.println("<2.등록>");

		System.out.print(">이름: ");
		String name = sc.nextLine();

		System.out.print(">휴대전화: ");
		String hp = sc.nextLine();

		System.out.print(">회사전화: ");
		String company = sc.nextLine();

		person.setName(name);
		person.setHp(hp);
		person.setCompany(company);

		return person;

	}

	public void showAddResult() {
		System.out.println("[등록되었습니다.]");
	}

	public int showDel() {
		System.out.println("<3.삭제>");

		System.out.print(">번호: ");
		int delNo = sc.nextInt();
		sc.nextLine();

		return delNo;
	}

	public void showDelResult() {
		System.out.println("[삭제되었습니다.]");
	}

	public String showSearch() {
		System.out.println("<4.검색>");

		System.out.print(">이름: ");
		String keyword = sc.nextLine();
		System.out.println("");

		return keyword;
	}

	// 기능
	public void showSearchResult(List<Person> phoneList, String keyword) {
		for (int i = 0; i < phoneList.size(); i++) {
			String searchName = phoneList.get(i).getName();
			if (searchName.contains(keyword)) {
				System.out.print(i + 1 + ". ");
				System.out.print(phoneList.get(i).getName() + "\t");
				System.out.print(phoneList.get(i).getHp() + "\t");
				System.out.print(phoneList.get(i).getCompany() + "\t");
				System.out.println("");
			}
		}
	}
	
	// default, 종료
	public void showEtc() {
		System.out.println("[다시 입력해 주세요.]");
	}

	public void showEnd() {
		System.out.println("");
		System.out.println("***********************************");
		System.out.println("*             감사합니다             *");
		System.out.println("***********************************");

		sc.close();
	}

}
