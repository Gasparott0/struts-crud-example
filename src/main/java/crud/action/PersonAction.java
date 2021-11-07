package crud.action;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

import crud.model.Person;
import crud.service.PersonService;
import crud.service.impl.PersonServiceImpl;

@SuppressWarnings("serial")
public class PersonAction extends ActionSupport implements Preparable {

	private static final Logger LOG = LogManager.getLogger(PersonAction.class.getName());

	private PersonService personService = new PersonServiceImpl();
	private Person person;
	private Person[] persons;
	private String[] genders;

	public void prepare() throws Exception {
		genders = personService.getGenders();
		LOG.info("Prepared support data for Person entity.");

		if (person != null && person.getPersonId() != null) {
			person = personService.getPerson(person.getPersonId());
			LOG.info("Preparing actual data for Person: " + person);
		}
	}

	/**
	 * Get all persons for display in the view.
	 */
	public String list() {
		persons = personService.getAllPersons();
		LOG.info("Listing persons");
		return SUCCESS;
	}

	/**
	 * Save the state of the Person object instance field.
	 */
	public String save() {
		if (person.getPersonId() == null) {
			personService.insertPerson(person);
			LOG.info("Created new Person: " + person);
		} else {
			personService.updatePerson(person);
			LOG.info("Updated Person: " + person);
		}
		return SUCCESS;
	}

	/**
	 * Delete from Person identified by the person instance field's personId value.
	 */
	public String delete() {
		personService.deletePerson(person.getPersonId());
		LOG.info("Deleted Person: " + person);
		return SUCCESS;
	}

	public Person[] getPersons() {
		return persons;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public String[] getGenders() {
		return genders;
	}

}
