package review.ex04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class PhoneRepository {

	private List<Person> pList;

	// 생성자
	public PhoneRepository() {
		pList = new ArrayList<Person>();
		loadList();
	}

	// 메소드 g/s
	public List<Person> getList() {
		return pList;
	}

	// 기능: 파일 읽음, 파일 저장, 리스트 추가/삭제
	private void loadList() {
		try {

			Reader fr = new FileReader("C:\\javaStudy\\minipro\\PhoneDB.txt");
			BufferedReader br = new BufferedReader(fr);

			while (true) {
				Person phoneVO = new Person();
				String line;

				line = br.readLine();
				if (line != null) {
					String[] dataArray = new String[3];
					dataArray = line.split(",");

					phoneVO.setName(dataArray[0]);
					phoneVO.setHp(dataArray[1]);
					phoneVO.setCompany(dataArray[2]);

					pList.add(phoneVO);
				} else {
					break;
				}

			}
			br.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void saveList() {

		try {

			Writer fw = new FileWriter("C:\\javaStudy\\minipro\\PhoneDB.txt");
			BufferedWriter bw = new BufferedWriter(fw);

			for (int i = 0; i < pList.size(); i++) {
				String str = pList.get(i).getName() + "," + pList.get(i).getHp() + "," + pList.get(i).getCompany();
				bw.write(str);
				bw.newLine();
			}
			bw.flush();
			bw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void addInfo(Person phoneVO) {
		pList.add(phoneVO);
		saveList();
	}

	public void delInfo(int num) {
		pList.remove(num - 1);
		saveList();
	}

}
