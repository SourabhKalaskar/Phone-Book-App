package in.ashokit.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.bindings.ContactForm;
import in.ashokit.entities.Contact;
import in.ashokit.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	ContactRepository contactRepo;

	@Override
	public String saveContact(ContactForm form) {

		Contact entity = new Contact();
		BeanUtils.copyProperties(form, entity);
		
		entity.setActiveSw("Y");

		entity = contactRepo.save(entity);

		if (entity.getContactId() != null) {
			return "SUCCESS";
		}

		return "FAILURE";
	}

	@Override
	public List<ContactForm> viewContacts() {

		List<ContactForm> contactformlist = new ArrayList<>();

		List<Contact> list = contactRepo.findAll();

		for (Contact contact : list) {

			ContactForm form = new ContactForm();
			BeanUtils.copyProperties(contact, form);
			contactformlist.add(form);
		}

		return contactformlist;
	}

	@Override
	public ContactForm editContact(Integer contactId) {

		Optional<Contact> findById = contactRepo.findById(contactId);

		if (findById.isPresent()) {
			Contact entity = findById.get();
			ContactForm contactForm = new ContactForm();
			BeanUtils.copyProperties(entity, contactForm);
			return contactForm;
		}
		return null;
	}

	@Override
	public List<ContactForm> deleteContact(Integer contactId) {

		contactRepo.deleteById(contactId);

		List<ContactForm> contactformlist = new ArrayList<>();

		List<Contact> list = contactRepo.findAll();

		for (Contact contact : list) {

			ContactForm form = new ContactForm();
			BeanUtils.copyProperties(contact, form);
			contactformlist.add(form);
		}

		return contactformlist;
	}

}
