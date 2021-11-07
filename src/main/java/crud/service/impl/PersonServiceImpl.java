package crud.service.impl;

import crud.dao.PersonDAO;
import crud.dao.impl.MemoryPersonDAO;
import crud.model.Person;
import crud.service.PersonService;

public class PersonServiceImpl implements PersonService {

	PersonDAO personDao;

	public PersonServiceImpl() {
		personDao = new MemoryPersonDAO();
	}

	public Person getPerson(Integer id) {
		return personDao.getPerson(id);
	}

	public Person[] getAllPersons() {
		return personDao.getAllPersons();
	}

	public void updatePerson(Person personBean) {
		personDao.updatePerson(personBean);
	}

	public void insertPerson(Person personBean) {
		personDao.insertPerson(personBean);

	}

	public void deletePerson(Integer id) {
		personDao.deletePerson(id);
	}

	public String[] getGenders() {
		return new String[] { "Masculino", "Feminino" };
	}

}
