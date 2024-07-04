package com.model;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class HbproductCriteria {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory=hibernateUtil.getSessionFactory();
    	Session session=sessionFactory.getCurrentSession();
    	Transaction tx=session.beginTransaction();
    	
    	Criteria criteria=session.createCriteria(product.class);
    	List<product> proList=criteria.list();
    	for(product pro:proList)
    	{
    		System.out.println("ID="+" "+pro.getSlno()+" "+pro.getProductname()+" "+pro.getQuantity()+" "+pro.getPrice());
    	}
    	System.out.println("====================================================================");
    	proList=session.createCriteria(product.class) .add(Restrictions.gt("price",20000)).list();
    	for(product pro1:proList)  
    	{
    		System.out.println("Product whose price is greater than 500 = "+pro1.getProductname());
    	}
    	System.out.println("====================================================================");
    	proList=session.createCriteria(product.class).add(Restrictions.gt("quantity", 10)).list();
    	for(product pro2:proList)
    	{
    		System.out.println("Product whose quantity is greater than 10 = "+pro2.getProductname());
    	}
    	System.out.println("====================================================================");
    	Criteria d=session.createCriteria(product.class);
    	proList=d.setProjection(Projections.max("price")).list();
    	System.out.println("Maximum of Price = "+proList.getFirst());
    	System.out.println("====================================================================");
    	Criteria c=session.createCriteria(product.class);
    	proList=c.setProjection(Projections.min("price")).list();
    	System.out.println("Minimum of Price = "+proList.getFirst());
    	System.out.println("====================================================================");
    	Criteria f=session.createCriteria(product.class);
    	proList=f.setProjection(Projections.sum("price")).list();
    	System.out.println("Sum of Price = "+proList.getFirst());
    	System.out.println("====================================================================");
    	Criteria g=session.createCriteria(product.class);
    	proList=g.setProjection(Projections.count("productname")).list();
    	System.out.println("Count of the product = "+proList.getFirst());
    	System.out.println("====================================================================");
    	tx.commit();
    	sessionFactory.close();    	

	}

}