package review.ex04;

public class PhoneApp {

	public static void main(String[] args) {

		PhoneView phoneView = new PhoneView();
		PhoneRepository phoneRepo = new PhoneRepository();

		phoneView.showStart();

		boolean run = true;
		while (run) {

			int menuNum = phoneView.showMenu();

			switch (menuNum) {

			case 1:
				phoneView.showList(phoneRepo.getList());
				break;

			case 2:
				Person phoneVO = phoneView.showAdd();
				phoneRepo.addInfo(phoneVO);
				phoneView.showAddResult();
				break;

			case 3:
				int delNo = phoneView.showDel();
				phoneRepo.delInfo(delNo);
				phoneView.showDelResult();
				break;

			case 4:
				String keyword = phoneView.showSearch();
				phoneView.showSearchResult(phoneRepo.getList(), keyword);
				break;

			case 5:
				run = false;
				break;

			default:
				phoneView.showEtc();
				break;
			} // switch 종료
		} // while 종료

		phoneView.showEnd();

	}
}
