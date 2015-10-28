/**
 * 
 */
package alexkholmov.organizer.services;

import java.io.Serializable;

import alexkholmov.organizer.exceptions.DaoException;
import alexkholmov.organizer.logic.Customer;
import alexkholmov.organizer.sql.CustomerDao;

/**
 * @author SASH
 *
 */
public class CustomerService implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 942270937721638316L;
    private CustomerDao customerDao = AppContext.getContext().getBean(CustomerDao.class);

    public CustomerService() {
        
    } 
    
    public void saveCustomer(Customer customer) throws DaoException {
        customerDao.save(customer);
    }
    
    public int createCustomer(Customer customer) throws DaoException {
        return customerDao.create(customer);
    }
    
    public Customer getCustomerById(int id) throws DaoException {
        return customerDao.getObjectById(id);
    }
}
