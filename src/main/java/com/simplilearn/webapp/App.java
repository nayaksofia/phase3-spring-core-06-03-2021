package com.simplilearn.webapp;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.simplilearn.webapp.bean.Employee;

public class App 
{
    public static void main( String[] args )
    {
   
//*****************************************************************************************
// Example:  Tightly coupled class
//        
//       Employee employee = new Employee();
//       employee.setEmpId(101);
//       employee.setName("Lucina Litt");
//       employee.setDept("Finance");
//       employee.setSalary(8000000.97);
//       
//       System.out.println(employee);
//**********************************************************************************************     
      
//*********************************************************************************************************    	
//Example: Loosely Coupled Class
  //IOC:: Inversion Of Control => Dependency Injection is a pattern we can use to implement IOC 
    	
//First Way: Application Context Container Type => load all bean object at startup (eager load)
    	
//    	ApplicationContext context = new ClassPathXmlApplicationContext("appContext.xml");
//    	Employee emp1 = (Employee) context.getBean("emp1");
//    	Employee emp2 = (Employee) context.getBean("emp2");
//    	
//    	System.out.println(emp1);
//    	System.out.println(emp2);
    	
    	
//Second Way: Bean Factory Container Type=> Load object on demand (lazy load)
    	
    Resource resource  = new ClassPathResource("appContext.xml");
    BeanFactory factory = new XmlBeanFactory(resource);
    
    Employee emp1 = (Employee) factory.getBean("emp1"); //TypeCasting Done
    System.out.println(emp1);
    
    Employee emp2 = factory.getBean("emp2" ,Employee.class); //TypeCasting Done
    System.out.println(emp2);
    
    }
}
