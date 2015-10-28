/**
 * 
 */
package alexkholmov.organizer.sql;

import alexkholmov.organizer.logic.Order;
import alexkholmov.organizer.sql.GenericDaoImpl;

/**
 * @author SASH
 *
 */
public class OrderDao extends GenericDaoImpl<Order, Integer> {

    public OrderDao() {
        super(Order.class);
    }
}
