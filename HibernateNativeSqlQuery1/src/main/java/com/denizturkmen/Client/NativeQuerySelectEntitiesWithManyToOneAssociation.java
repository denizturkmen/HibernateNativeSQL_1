package com.denizturkmen.Client;

import java.util.List;

import org.hibernate.Session;

import com.denizturkmen.Entity.Person;
import com.denizturkmen.Entity.Phone;
import com.denizturkmen.Util.HibernateUtil;

public class NativeQuerySelectEntitiesWithManyToOneAssociation {

	public static void main(String[] args) {
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			@SuppressWarnings("unchecked")
			List<Phone> phones = session.createNativeQuery(
				    "SELECT id, phone_number, phone_type, person_id " +
				    "FROM Phone" )
				.addEntity( Phone.class )
				.list();
			for (Phone phone : phones) {
				System.out.println("Phones Details::::::::::::::::::::::");
				System.out.println("Phone Id:"+phone.getId());
				System.out.println("Phone No:"+phone.getNumber());
				System.out.println("Phone Type:"+phone.getType().toString());
				Person person = phone.getPerson();
				if(person !=null){
					System.out.println("Person details:::::::::::::::::::::");
					System.out.println("Person Id:"+person.getId());
					System.out.println("Person Name:"+person.getName());
					System.out.println("Person NickName:"+person.getNickName());
					System.out.println("Address:"+person.getAddress());
					System.out.println("CreatedOn:"+person.getCreatedOn());
					System.out.println("Version:"+person.getVersion());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
