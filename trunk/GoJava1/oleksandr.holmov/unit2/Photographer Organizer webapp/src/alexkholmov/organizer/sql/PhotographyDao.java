/**
 * 
 */
package alexkholmov.organizer.sql;

import alexkholmov.organizer.logic.Photography;
import alexkholmov.organizer.sql.GenericDaoImpl;

/**
 * @author SASH
 *
 */
public class PhotographyDao extends GenericDaoImpl<Photography, Integer> {

    public PhotographyDao() {
        super(Photography.class);
    }
}
