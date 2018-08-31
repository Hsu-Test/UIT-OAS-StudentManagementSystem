/*
 * $Header$
 * $Revision$
 * $Date$
 */
package Model.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;
import javax.sql.DataSource;

import Model.dbo.DatabaseException;

/**
 * 概略
 * <p>概要・説明</p>
 *
 * @author oasm-shweyamininzali
 * @version $Revision$ $Date$
 */
public enum DaoUtil {

    INSTANCE;

    private static final String JNDI_NAME = "jdbc/students";
    private static final String DATA_SOURCE_NAME = "java:comp/env/" + JNDI_NAME;

    private DataSource ds;
    public Connection getDBConnection() throws DatabaseException {
        Connection conn = null;

        if (ds == null) {
            Object obj = lookup(DATA_SOURCE_NAME);
            ds = (DataSource) narrow(obj, DataSource.class);
        }

        try {
            conn = ds.getConnection();
        } catch (SQLException ex) {
            throw new DatabaseException(String.format(" Connection acquisition failed. : %s", ex.getMessage()));
        }

        return conn;
    }

    private DataSource lookup(final String name) throws DatabaseException {
        DataSource result = null;

        try {
            InitialContext ctx = new InitialContext();
            result = (DataSource) ctx.lookup(name);
        } catch (NamingException ex) {
            throw new DatabaseException(String.format(" Lookup failed.[JNDI:%s] : %s", name, ex.getMessage()));
        }

        return result;
    }

    private Object narrow(final Object obj, final Class<?> clazz) {
        return PortableRemoteObject.narrow(obj, clazz);
    }
}
