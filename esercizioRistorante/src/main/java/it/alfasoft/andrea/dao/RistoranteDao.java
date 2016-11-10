package it.alfasoft.andrea.dao;

import hibernateUtil.HibernateUtil;

import it.alfasoft.andrea.bean.Ristorante;



import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class RistoranteDao {

	public boolean aggiungiRistorante(Ristorante r)
	{
		boolean b=false;
		
		Session session =HibernateUtil.openSession();
		Transaction tx=null;

		try{
		tx=session.getTransaction();
		tx.begin();
		
		session.persist(r);
		
		 b=true;
		 tx.commit();
		}catch(Exception ex){
			tx.rollback();
		}finally{
			session.close();
		}
		
		return b;

	}
	
	public Ristorante trovaRistorante(String nome)
	{
		Ristorante r=null;
		Session session =HibernateUtil.openSession();
		Transaction tx=null;

		try{
		tx=session.getTransaction();
		tx.begin();

		Query query=session.createQuery("from Ristorante where nome=:nomeInserito");
		query.setString("nomeInserito", nome);
		
		r=(Ristorante) query.uniqueResult();
		 
		 tx.commit();
		}catch(Exception ex){
			tx.rollback();
		}finally{
			session.close();
		}
		
		return r;
	}
	
	public Ristorante trovaRistoranteConId(long id)
	{
		Ristorante r=null;
		Session session =HibernateUtil.openSession();
		Transaction tx=null;

		try{
		tx=session.getTransaction();
		tx.begin();

		Query query=session.createQuery("from Ristorante where id_ristorante=:idInserito");
		query.setLong("idInserito", id);
		
		r=(Ristorante) query.uniqueResult();
		 
		 tx.commit();
		}catch(Exception ex){
			tx.rollback();
		}finally{
			session.close();
		}
		
		return r;
	}
	
	
	public boolean aggiornaRistorante(Ristorante r)
	{
		boolean result=false;
		Session session =HibernateUtil.openSession();
		Transaction tx=null;

		try{
		tx=session.getTransaction();
		tx.begin();
		
		session.update(r);
		result=true;
		 
		 tx.commit();
		}catch(Exception ex){
			tx.rollback();
		}finally{
			session.close();
		}
		
		return result;
	}
	

	public boolean eliminaRistorante(Ristorante r)
	{
		boolean result=false;
		Session session =HibernateUtil.openSession();
		Transaction tx=null;

		try{
		tx=session.getTransaction();
		tx.begin();
		
		session.delete(r);
		result=true;
		 
		 tx.commit();
		}catch(Exception ex){
			tx.rollback();
		}finally{
			session.close();
		}
		return result;
}



	
}
