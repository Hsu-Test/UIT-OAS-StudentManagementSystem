/*
 * $Header$
 * $Revision$
 * $Date$
 */
package Model.dbo;

import java.io.IOException;

public class DatabaseException extends IOException {
    public DatabaseException(String message) {
        super(message);
    }
}
