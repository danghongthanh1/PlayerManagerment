package com.nab.test;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;

import com.nab.dao.FinanceDAO;
import com.nab.dao.PersonDAO;
//import com.nab.dao.UserInfoDAO;
//import com.nab.dao.UserRoleDAO;
import com.nab.entities.Finance;
import com.nab.entities.Person;
import com.nab.service.PersonService;

public class Driver {
	private static PersonDAO personDAO=new PersonDAO();
	//private static FinanceDAO financeDAO=new FinanceDAO();
//	private static UserInfoDAO userInfoDAO=new UserInfoDAO();
//	private static UserRoleDAO userRoleDAO=new UserRoleDAO();
	//@Autowired static private SessionFactory sessionFactory;
	public static void main(String args[]) {
		List<Person> list1= personDAO.getAll();
		for(Person person: list1) {
			System.out.println(person.getId());
		}
//		System.out.println(personDAO.countTotalRecords());
//		List<Finance> list=financeDAO.getFinances("pw");
//		for(Finance finance:list) {
//			System.out.println(finance.getId_finance());
//		}
//		List<String> list=userRoleDAO.getUserRoles("danghongthanh");
//		for(String s: list) {
//			System.out.println(s);
//		}
		//jdbcTemplate.execute("Delete from person where id=3");
//		Session session=sessionFactory.openSession();
//		Query query=session.createQuery("delete from Person p where p.id=4");
	//	XmlBeanFactory xmlBeanFactory=new XmlBeanFactory(new ClassPathResource("spring-mvc-servlet.xml"));
//		ApplicationContext context=new FileSystemXmlApplicationContext
//				("C:/Users/thanh.dh166716/eclipse-workspace/PlayerManagement/src/main/webapp/WEB-INF/spring-mvc-servlet.xml");
//		JdbcTemplate jdbcTemplate=(JdbcTemplate) context.getBean("jdbcTemplate");
//		jdbcTemplate.execute("Delete from person where id=4");
//		FinanceDAO financeDao=new FinanceDAO();
//		List<Finance> list=financeDao.getAll();
//		for(Finance f: list) {
//			System.out.println(f.getDescription());
//		}
	}
}
