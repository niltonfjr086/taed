package taed_portfolio.model;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public final class FactoryDAO {

	private FactoryDAO() {
		
	}
	
    private static Configuration cfg;
    private static SessionFactory sessionFactory;
    private static Session session;
    
    public static Session sessionInstance() {
    	if(session == null) {
    	    cfg = new Configuration();
    	    cfg.configure("hibernate.cfg.xml");
    	    sessionFactory = cfg.buildSessionFactory();
    	    session = sessionFactory.openSession();
    	}
    	
    	return session;
    }

}
