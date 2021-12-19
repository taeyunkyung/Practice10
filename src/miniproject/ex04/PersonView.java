package miniproject.ex04;

public class PersonView {

	public void titlePage() {
		System.out.println("***********************************");
		System.out.println("*         전화번호 관리 프로그램         *");
		System.out.println("***********************************");
	}

	public void optionSelect() {
		System.out.println("1.리스트  2.등록  3.삭제  4.검색  5.종료");
		System.out.println("------------------------------------");
		System.out.print(">메뉴번호: ");
	}

	public void selected(int select) {

		switch (select) {
		case 1:
			System.out.println("<1.리스트>");
			break;

		case 2:
			System.out.println("<2.등록>");
			break;

		case 3:
			System.out.println("<3.삭제>");
			break;

		case 4:
			System.out.println("<4.검색>");
			break;

		case 5:
			System.out.println("");
			System.out.println("***********************************");
			System.out.println("*             감사합니다             *");
			System.out.println("***********************************");
			break;

		default:			
			break;
		}
	}

	public void end(int select) {

		if (select == 2) {
			System.out.println("[등록되었습니다.]");
			System.out.println("");
		} else if (select == 3) {
			System.out.println("[삭제되었습니다.]");
			System.out.println("");
		} else {
			System.out.println("[다시 입력해 주세요.]");
			System.out.println("");
		}
	}
}
