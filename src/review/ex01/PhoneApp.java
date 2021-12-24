package review.ex01;

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

public class PhoneApp { // main 함수만 이용

	public static void main(String[] args) throws IOException {

		// 준비영역
		Writer fw;
		BufferedWriter bw;
		boolean run = true;

		// 스캐너
		Scanner sc = new Scanner(System.in);

		// 파일을 읽기 위한 스트림 준비
		Reader fr = new FileReader("C:\\javaStudy\\minipro\\PhoneDB.txt");
		BufferedReader br = new BufferedReader(fr);

		// 리스트 생성
		List<Person> pList = new ArrayList<Person>();

		// 파일을 읽어 리스트에 추가하기
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

		// 시작화면
		System.out.println("***********************************");
		System.out.println("*         전화번호 관리 프로그램         *");
		System.out.println("***********************************");

		// while 시작
		while (run) {

			// 메뉴화면
			System.out.println("1.리스트  2.등록  3.삭제  4.검색  5.종료");
			System.out.println("------------------------------------");
			System.out.print(">메뉴번호: ");

			// 메뉴입력
			int menuNum = sc.nextInt();
			sc.nextLine();

			// switch 시작

			switch (menuNum) {

			case 1: // 리스트
				System.out.println("<1.리스트>");
				for (int i = 0; i < pList.size(); i++) {
					System.out.print(i + 1 + ". ");
					System.out.print(pList.get(i).getName() + "\t");
					System.out.print(pList.get(i).getHp() + "\t");
					System.out.print(pList.get(i).getCompany() + "\t");
					System.out.println("");
				}
				break;

			case 2: // 등록
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

				// 파일에 저장
				fw = new FileWriter("C:\\javaStudy\\minipro\\PhoneDB.txt");
				bw = new BufferedWriter(fw);

				for (int i = 0; i < pList.size(); i++) {
					String str = pList.get(i).getName() + "," + pList.get(i).getHp() + "," + pList.get(i).getCompany();
					bw.write(str);
					bw.newLine();
				}
				bw.flush();
				bw.close();

				System.out.println("[등록되었습니다.]");
				System.out.println("");
				break;

			case 3: // 삭제
				System.out.println("<3.삭제>");

				System.out.print(">번호: ");
				int no = sc.nextInt();
				pList.remove(no - 1);

				// 파일에 저장
				fw = new FileWriter("C:\\javaStudy\\minipro\\PhoneDB.txt");
				bw = new BufferedWriter(fw);

				for (int i = 0; i < pList.size(); i++) {
					String str = pList.get(i).getName() + "," + pList.get(i).getHp() + "," + pList.get(i).getCompany();
					bw.write(str);
					bw.newLine();
				}
				bw.flush();
				bw.close();

				System.out.println("[삭제되었습니다.]");
				System.out.println("");
				break;

			case 4: // 검색
				System.out.println("<4.검색>");

				System.out.print(">이름: ");
				String keyword = sc.nextLine();

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
				break;

			case 5: // 종료
				run = false;
				break;

			default:
				System.out.println("[다시 입력해 주세요.]");
				System.out.println("");
				break;

			} // switch 종료
		} // while 종료

		br.close();
		sc.close();

		// 종료화면
		System.out.println("");
		System.out.println("***********************************");
		System.out.println("*             감사합니다             *");
		System.out.println("***********************************");
	}

}
