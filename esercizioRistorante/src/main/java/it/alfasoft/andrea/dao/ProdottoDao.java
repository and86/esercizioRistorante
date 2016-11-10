package it.alfasoft.andrea.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import it.alfasoft.andrea.bean.Prodotto;
import hibernateUtil.HibernateUtil;


public class ProdottoDao {
	
	public boolean aggiungiProdotto(Prodotto p)
	{
		boolean b=false;
		
		Session session =HibernateUtil.openSession();
		Transaction tx=null;

		try{
		tx=session.getTransaction();
		tx.begin();
		
		session.persist(p);
		
		 b=true;
		 tx.commit();
		}catch(Exception ex){
			tx.rollback();
		}finally{
			session.close();
		}
		
		return b;

	}
	
	public Prodotto trovaProdotto(String nome)
	{
		Prodotto f=null;
		Session session =HibernateUtil.openSession();
		Transaction tx=null;

		try{
		tx=session.getTransaction();
		tx.begin();

		Query query=session.createQuery("from Prodotto where nome=:nomeInserito");
		query.setString("nomeInserito", nome);
		
		f=(Prodotto) query.uniqueResult();
		 
		 tx.commit();
		}catch(Exception ex){
			tx.rollback();
		}finally{
			session.close();
		}
		
		return f;
	}
	
	public Prodotto trovaProdottoConId(long id)
	{
		Prodotto f=null;
		Session session =HibernateUtil.openSession();
		Transaction tx=null;

		try{
		tx=session.getTransaction();
		tx.begin();

		Query query=session.createQuery("from Prodotto where id_Prodotto=:idInserito");
		query.setLong("idInserito", id);
		
		f=(Prodotto) query.uniqueResult();
		 
		 tx.commit();
		}catch(Exception ex){
			tx.rollback();
		}finally{
			session.close();
		}
		
		return f;
	}
	
	@SuppressWarnings("unchecked")
	public List<Prodotto> getProdotto()
	{
		List<Prodotto> lista= new ArrayList<Prodotto>();
		Session session =HibernateUtil.openSession();
		Transaction tx=null;

		try{
		tx=session.getTransaction();
		tx.begin();

		Query query= session.createQuery("from Prodotto");
		 lista=query.list();
		
		 tx.commit();
		}catch(Exception ex){
			tx.rollback();
		}finally{
			session.close();
		}
		return lista;
	}
	
	public boolean aggiornaProdotto(Prodotto p)
	{
		boolean result=false;
		Session session =HibernateUtil.openSession();
		Transaction tx=null;

		try{
		tx=session.getTransaction();
		tx.begin();
		
		session.update(p);
		result=true;
		 
		 tx.commit();
		}catch(Exception ex){
			tx.rollback();
		}finally{
			session.close();
		}
		
		return result;
	}
	

	public boolean eliminaProdotto(Prodotto p)
	{
		boolean result=false;
		Session session =HibernateUtil.openSession();
		Transaction tx=null;

		try{
		tx=session.getTransaction();
		tx.begin();
		
		session.delete(p);
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
