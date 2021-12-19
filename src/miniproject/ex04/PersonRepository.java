package miniproject.ex04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import miniproject.ex01.Person;

public class PersonRepository {

	public void readList(List<Person> list) throws IOException {

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
			list.add(data);
		}

		br.close();
	}
	
	public void writeList(List<Person> list) throws IOException {

		Writer fw = new FileWriter("C:\\javaStudy\\minipro\\PhoneDB.txt");
		BufferedWriter bw = new BufferedWriter(fw);

		for (Person write : list) {
			bw.write(write.getName() + "," + write.getHp() + "," + write.getCompany());
			bw.newLine();
		}

		bw.close();
	}

	public void printList(List<Person> list) {

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getCount() + ".   " + list.get(i).getName() + "   " + list.get(i).getHp()
					+ "   " + list.get(i).getCompany());
		}

		System.out.println("");
	}

	public void countNum(List<Person> list) {

		for (int i = 0; i < list.size(); i++) {
			list.get(i).setCount(i + 1);
		}
	}

	public void optionSecond(List<Person> list, String name, String hp, String company) throws IOException {

		Person data = new Person(name, hp, company);
		list.add(data);
		writeList(list);

	}

	public void optionThird(List<Person> list, int delete) throws IOException {

		list.remove(delete - 1);
		writeList(list);

	}

	public void optionFourth(List<Person> list, String search) throws IOException {

		List<Person> searchList = new ArrayList<Person>();

		for (int i = 0; i < list.size(); i++) {
			String s = list.get(i).getName();
			if (s.contains(search)) {
				searchList.add(list.get(i));
			}
		}

		printList(searchList);

	}
}
