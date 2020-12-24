package model.main;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

import db.accidentInfoOutDao;
import db.consultationDao;
import db.contractConditionDao;
import db.customerDao;
import db.handlingDao;
import db.insuranceDao;
import db.insuranceRegistrationDao;
import db.propertyDao;
import view.main.mainFrame;

public class insuranceSystemMain {
	public static mainFrame mainFrame;
	public static accidentInfoOutDao accidentInfoOutDao;
	public static consultationDao consultationDao;
	public static contractConditionDao contractConditionDao;
	public static customerDao customerDao;
	public static handlingDao handlingDao;
	public static insuranceDao insuranceDao;
	public static insuranceRegistrationDao insuranceRegistrationDao;
	public static propertyDao propertyDao;
	
	public static void main(String[] args) {	
		@SuppressWarnings("resource")
		//ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
		XmlBeanFactory context=new XmlBeanFactory(new FileSystemResource("context.xml"));
		accidentInfoOutDao = context.getBean("accidentInfoOutDao", accidentInfoOutDao.class);
		consultationDao = context.getBean("consultationDao", consultationDao.class);
		contractConditionDao = context.getBean("contractConditionDao", contractConditionDao.class);
		customerDao = context.getBean("customerDao", customerDao.class);
		handlingDao = context.getBean("handlingDao", handlingDao.class);
		insuranceDao = context.getBean("insuranceDao", insuranceDao.class);
		insuranceRegistrationDao = context.getBean("insuranceRegistrationDao", insuranceRegistrationDao.class);
		propertyDao = context.getBean("propertyDao", propertyDao.class);
				
		mainFrame = new mainFrame();
	}
}
