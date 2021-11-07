package crud.dao;

import crud.model.Person;

public interface PersonDAO {

	public Person getPerson(Integer id);

	public Person[] getAllPersons();

	public void updatePerson(Person personBean);

	public void insertPerson(Person personBean);

	public void deletePerson(Integer id);
}
