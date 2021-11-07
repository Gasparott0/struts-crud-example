package crud.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import crud.dao.PersonDAO;
import crud.model.Person;

public class MemoryPersonDAO implements PersonDAO {

	private static final Logger LOG = LogManager.getLogger(MemoryPersonDAO.class.getName());

	private static final List<Person> persons;

	static {
		persons = new ArrayList<Person>();
		persons.add(new Person(1, "Mateus", "Gasparotto", "20", "Masculino", "mateusg@gmail.com", "9999999999"));
		persons.add(new Person(2, "Mariana", "Malora", "20", "Feminino", "marianag@gmail.com", "8888888888"));
	}

	public Person getPerson(Integer id) {
		for (Person p : persons) {
			if (p.getPersonId().equals(id)) {
				try {
					return (Person) p.clone();
				} catch (CloneNotSupportedException ex) {
					LOG.error("Unexpected exception cloning Person");
				}
			}
		}
		return null;
	}

	public Person[] getAllPersons() {
		return persons.toArray(new Person[persons.size()]);
	}

	public void updatePerson(Person personBean) {
		Integer id = personBean.getPersonId();
		for (int i = 0; i < persons.size(); i++) {
			Person p = persons.get(i);
			if (p.getPersonId().equals(id)) {
				persons.set(i, personBean);
				break;
			}
		}
	}

	public void insertPerson(Person personBean) {
		int lastId = 0;
		for (Person p : persons) {
			if (p.getPersonId() > lastId) {
				lastId = p.getPersonId();
			}
		}
		personBean.setPersonId(lastId + 1);
		persons.add(personBean);
	}

	public void deletePerson(Integer id) {
		for (int i = 0; i < persons.size(); i++) {
			Person person = persons.get(i);
			if (person.getPersonId().equals(id)) {
				persons.remove(i);
				break;
			}
		}
	}

}
