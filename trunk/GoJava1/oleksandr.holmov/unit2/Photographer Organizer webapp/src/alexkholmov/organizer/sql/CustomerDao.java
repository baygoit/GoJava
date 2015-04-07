/**
 * 
 */
package alexkholmov.organizer.sql;

import alexkholmov.organizer.logic.Customer;

/**
 * @author SASH
 *
 */
public class CustomerDao extends GenericDaoImpl<Customer, Integer> {
    
    public CustomerDao() {
        super(Customer.class);
    }
}
