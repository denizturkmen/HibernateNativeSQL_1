package com.denizturkmen.Client;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

import com.denizturkmen.Entity.Person;
import com.denizturkmen.Entity.Phone;
import com.denizturkmen.Util.HibernateUtil;

public class NativeQuerySelectEntitiesWithManyToOneAssociationUsingResultTransformer {

	public static void main(String[] args) {

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			@SuppressWarnings("unchecked")
			List<Person> persons = session
					.createNativeQuery("SELECT * " + "FROM Phone ph " + "LEFT JOIN Person pr ON ph.person_id = pr.id")
					.addEntity("phone", Phone.class).addJoin("pr", "phone.person")
					.setResultTransformer(Criteria.ROOT_ENTITY).list();

			for (Person person : persons) {
				List<Phone> phones = person.getPhones();
				System.out.println("Phone details::::::::::::::::::");
				for (Phone phone : phones) {
					System.out.println("Phone Id:" + phone.getId());
					System.out.println("Phone No:" + phone.getNumber());
					System.out.println("Phone Type:" + phone.getType().toString());
					Person person2 = phone.getPerson();
					if (person2 != null) {
						System.out.println("Person details:::::::::::::::::::::");
						System.out.println("Person Id:" + person.getId());
						System.out.println("Person Name:" + person.getName());
						System.out.println("Person NickName:" + person.getNickName());
						System.out.println("Address:" + person.getAddress());
						System.out.println("CreatedOn:" + person.getCreatedOn());
						System.out.println("Version:" + person.getVersion());
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
