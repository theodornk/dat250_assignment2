package no.hvl.dat250.jpa.basicexample;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Main {
    private static final String PERSISTENCE_UNIT_NAME = "bankaccount";
    private static EntityManagerFactory factory;

    public static void main(String[] args) {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();
        // read the existing entries and write to console
        //Query q = em.createQuery("select t from Todo t");
        //List<Todo> todoList = q.getResultList();
        //for (Todo todo : todoList) {
        //    System.out.println(todo);
        //}
        //System.out.println("Size: " + todoList.size());

        // create new todo
        em.getTransaction().begin();
        //Todo todo = new Todo();
        //todo.setSummary("This is a test");
        //todo.setDescription("This is a test");
        Person person0 = new Person();
        Creditcard creditcard0 = new Creditcard();
        Creditcard creditcard1 = new Creditcard();
        Address address0 = new Address();
        Pin pin0 = new Pin();
        Bank bank0 = new Bank();
        person0.setName("Max Musterman");
        creditcard0.setBalance(5000);
        creditcard0.setLimit(10000);
        creditcard0.setCreditcardpersons(person0);
        creditcard0.setNumber(12345);
        creditcard0.setCreditcardbanks(bank0);
        creditcard0.setCreditcardpin(pin0);
        creditcard1.setBalance(1);
        creditcard1.setLimit(2000);
        creditcard1.setCreditcardpersons(person0);
        creditcard1.setNumber(123);
        creditcard1.setCreditcardbanks(bank0);
        creditcard1.setCreditcardpin(pin0);
        address0.setStreet("Inndalsveien");
        address0.setNumber(28);
        pin0.setPincode("123");
        pin0.setCount(1);
        bank0.setName("Pengebank");
        person0.getPersoncreditcards().add(creditcard0);
        person0.getPersoncreditcards().add(creditcard1);
        person0.getPersonaddresses().add(address0);
        address0.getAddressPerson().add(person0);
        bank0.getBankcreditcards().add(creditcard0);
        bank0.getBankcreditcards().add(creditcard1);




        //em.persist(todo);
        em.persist(person0);
        em.persist(creditcard0);
        em.persist(creditcard1);
        em.persist(address0);
        em.persist(pin0);
        em.persist(bank0);
        em.getTransaction().commit();
        em.close();


    }
}
