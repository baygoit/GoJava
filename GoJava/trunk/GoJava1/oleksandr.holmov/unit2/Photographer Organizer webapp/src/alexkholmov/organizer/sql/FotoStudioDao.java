/**
 * 
 */
package alexkholmov.organizer.sql;

import alexkholmov.organizer.logic.FotoStudio;
import alexkholmov.organizer.sql.GenericDaoImpl;

/**
 * @author SASH
 *
 */
public class FotoStudioDao extends GenericDaoImpl<FotoStudio, Integer> {

    public FotoStudioDao() {
        super(FotoStudio.class);
    }
}
