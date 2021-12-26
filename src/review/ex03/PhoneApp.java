package review.ex03;

public class PhoneApp {

	public static void main(String[] args) {

		PhoneManager pManager = new PhoneManager();

		pManager.showTitle();

		boolean run = true;
		while (run) {
			int menuNum = pManager.showMenu();

			switch (menuNum) {

			case 1:
				pManager.showList();
				break;

			case 2:
				pManager.showAdd();
				break;

			case 3:
				pManager.showRemove();
				break;

			case 4:
				pManager.showSearch();
				break;

			case 5:
				run = false;
				break;

			default:
				pManager.showEtc();
				break;
				
			} // switch 종료
		} // while 종료
		
		pManager.showEnd();
		
	}
}
