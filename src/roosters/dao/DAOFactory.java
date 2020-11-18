package roosters.dao;

import roosters.query.MySQLDAOFactory;

public abstract class DAOFactory {
	

	  public static final int MYSQL = 1;

	  public static DAOFactory getDAOFactory(int Motor_Base) {
	    switch (Motor_Base) {
	      case MYSQL:
	        return new MySQLDAOFactory();
	      default:
	        return null;
	    }
	  }

	public abstract AuthDAO getAuthDAO();

}
