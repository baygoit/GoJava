/**
 * 
 */
package alexkholmov.organizer.exceptions;

/**
 * @author SASH
 *
 */
public class DaoException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = -4471336133510006434L;
    
    private String errorMessage;
    
    public DaoException() {
        super();
    }
    
    public DaoException(String arg0) {
        super(arg0);
    }
    
    public DaoException(String arg0, Exception e) {
        super(arg0, e);
    }

    /**
     * @return the errorMessage
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * @param errorMessage the errorMessage to set
     */
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
   
}
