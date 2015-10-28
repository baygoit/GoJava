/**
 * 
 */
package alexkholmov.organizer.sql;

import alexkholmov.organizer.logic.Reserve;
import alexkholmov.organizer.sql.GenericDaoImpl;

/**
 * @author SASH
 *
 */
public class ReserveDao extends GenericDaoImpl<Reserve, Integer> {

    public ReserveDao() {
        super(Reserve.class);
    }
}
