/**
 * 
 */
package alexkholmov.organizer.sql;

import alexkholmov.organizer.logic.PackageFotos;
import alexkholmov.organizer.sql.GenericDaoImpl;

/**
 * @author SASH
 *
 */
public class PackageFotosDao extends GenericDaoImpl<PackageFotos, Integer> {

    public PackageFotosDao() {
        super(PackageFotos.class);
    }
}
