package ae2.util;

import java.util.*;
import javax.ejb.*;
import javax.jms.*;
import javax.naming.*;
import javax.sql.*;

public class UbicadorServicios   implements java.io.Serializable {

  private InitialContext ic = null;
  private Map cache = null;
  private static UbicadorServicios instance;
  
  private UbicadorServicios() throws NamingException {
    try {
      ic = new InitialContext();
      cache = Collections.synchronizedMap(new HashMap());
    }
    catch (NamingException ne) {

      throw ne;
    }
  }
  
  private UbicadorServicios(InitialContext iCtx) {
    ic = iCtx;
  }

  public static UbicadorServicios getInstance() throws NamingException {
    if (instance == null) {
      instance = new UbicadorServicios();
    }
    return instance;
  }

   public static InitialContext getInitialContext() throws NamingException {
    return new InitialContext();
  }

  public DataSource getDataSource(String dataSourceName) throws NamingException {

    DataSource dataSource = null;
    try {
      if (cache.containsKey(dataSourceName)) {
        dataSource = (DataSource) cache.get(dataSourceName);

      }
      else {
        dataSource = (DataSource) ic.lookup(dataSourceName);
        cache.put(dataSourceName, dataSource);

      }
    }
    catch (NamingException nex) {
      throw new NamingException();

    }
    catch (Exception ex) {
      throw new NamingException();
    }
    return dataSource;
  }
}
