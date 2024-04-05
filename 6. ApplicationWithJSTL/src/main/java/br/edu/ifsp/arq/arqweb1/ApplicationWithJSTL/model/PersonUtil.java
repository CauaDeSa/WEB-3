package br.edu.ifsp.arq.arqweb1.ApplicationWithJSTL.model;

import java.util.ArrayList;
import java.util.List;

public class PersonUtil {

	public List<Person> pessoas;

	public List<Person> getPersons(String persons) {
		List<Person> list = new ArrayList<>();

		if (persons.length() > 0) {
			String[] lines = persons.split("\n");

			for (String line : lines) {

				String[] personData = line.split("\\s*;\\s*");

				if (personData.length == 3) {
					list.add(new Person(personData[0], personData[1], personData[2]));
				}
			}
		}

		return list;
	}
}