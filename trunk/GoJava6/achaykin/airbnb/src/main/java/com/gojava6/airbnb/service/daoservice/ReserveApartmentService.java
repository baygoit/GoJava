package com.gojava6.airbnb.service.daoservice;

import com.gojava6.airbnb.Exception.daoexception.MySqlReservedApartmentDAOException;
import com.gojava6.airbnb.dao.reservedapartment.MySqlReservedApartmentDAO;
import com.gojava6.airbnb.model.apartment.ReserveApartment;
import com.gojava6.airbnb.service.IReserveService;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;


import java.util.Date;
import java.util.List;


/**
 * @Autor Andrey Chaykin
 * @Since 25.11.2015
 */
public class ReserveApartmentService implements IReserveService {

    private static final Logger LOGGER = LogManager.getLogger(ReserveApartmentService.class);
    private MySqlReservedApartmentDAO apartmentDao = new MySqlReservedApartmentDAO();
    private List<ReserveApartment> resultList;
    private boolean boolResult;


    public void create(int apartmentID, int hostID, int renterID, Date checkIN, Date checkOUT) {
        try {
            if (checkArguments(apartmentID, hostID, renterID, checkIN, checkOUT)) {
                if (!isReserved(apartmentID, checkIN, checkOUT)) {
                    boolResult = apartmentDao.create(apartmentID, hostID, renterID, checkIN, checkOUT);
                    if (boolResult) {
                        LOGGER.debug("Reserve apartment successful complete! ApartmentID: " + apartmentID +
                                ", hostID: " + hostID + ", renterID: " + renterID + ", checkIN: " + checkIN +
                                ", checkOUT: " + checkOUT);
                    } else {
                        LOGGER.debug("Cannot reserve apartment: " + apartmentID +
                                ", hostID: " + hostID + ", renterID: " + renterID + ", checkIN: " + checkIN +
                                ", checkOUT: " + checkOUT);
                    }
                }
            }
        } catch (MySqlReservedApartmentDAOException e) {
            e.printStackTrace();
        }
    }

    public List<ReserveApartment> retrieveApartmentByID(int apartmentID) {
        try {
            if (apartmentID != 0) {
                resultList = apartmentDao.retrieveApartmentByID(apartmentID);
                if (!resultList.isEmpty()) {
                    LOGGER.debug("Retrieve apartment by id successful complete!");
                } else {
                    LOGGER.debug("Apartment (id:" + apartmentID + ") haven`t any reserve dates.");
                }
            } else {
                LOGGER.debug("Incorrect value for retrieve apartment by id! ApartmentID: " + apartmentID);
            }
        } catch (MySqlReservedApartmentDAOException e) {
            LOGGER.error("Cannot retrieve apartment by id: " + apartmentID);
            e.printStackTrace();
        }
        return resultList;
    }

    public List<ReserveApartment> retrieveApartmentsByHostID(int hostID) {
        try {
            if (hostID != 0) {
                resultList = apartmentDao.retrieveAoartmentsByHostID(hostID);
                if (!resultList.isEmpty()) {
                    LOGGER.debug("Retrieve apartments by hostId successful complete!");
                } else {
                    LOGGER.debug("Host (id:" + hostID + ") haven`t any apartments on reserve.");
                }
            } else {
                LOGGER.debug("Incorrect value for retrieve apartments by hostIid! Host id: " + hostID);
            }
        } catch (MySqlReservedApartmentDAOException e) {
            LOGGER.error("Cannot retrieve apartments by host id: " + hostID);
            e.printStackTrace();
        }
        return resultList;
    }

    public void update(int apartmentID, int hostID, int renterID, Date oldCheckIN, Date oldCheckOUT, Date newCheckIN, Date newCheckOut) {
        try {
            if (checkArguments(apartmentID, hostID, renterID, oldCheckIN, oldCheckOUT) && checkOrderDays(newCheckIN, newCheckOut)) {
                if (isReserveExist(apartmentID, hostID, renterID, oldCheckIN, oldCheckOUT)) {
                    boolResult = apartmentDao.update(apartmentID, hostID, renterID, oldCheckIN, oldCheckOUT, newCheckIN, newCheckOut);
                    if (boolResult) {
                        LOGGER.debug("Update reserve complete!");
                    } else {
                        LOGGER.debug("Cannot update reserve on this dates!");
                    }
                }
            }
        } catch (MySqlReservedApartmentDAOException e) {
            LOGGER.error("Cannot update apartment! ApartmentID: " + apartmentID + ", hostID: " + hostID + ", renterID" +
                    renterID + ", old");
            e.printStackTrace();
        }
    }

    public void delete(int apartmentID, int hostID, int renterID, Date checkIN, Date checkOUT) {
        try {
            if (checkArguments(apartmentID, hostID, renterID, checkIN, checkOUT)) {
                if (isReserveExist(apartmentID, hostID, renterID, checkIN, checkOUT)) {
                    boolResult = apartmentDao.delete(apartmentID, hostID, renterID, checkIN, checkOUT);
                    if (boolResult) {
                        LOGGER.debug("Delete reserve completed!");
                    } else {
                        LOGGER.debug("Cannot delete reserve in database! ApartmentID: " + apartmentID +
                                ", hostID: " + hostID + ", renterID: " + renterID +
                                ", checkIN: " + checkIN + ", checkOUT: " + checkOUT);
                    }
                }
            }
        } catch (MySqlReservedApartmentDAOException e) {
            LOGGER.error("Cannot delete apartment! ApartmentID: " + apartmentID + ", hostID: " + hostID + ", renterID: " +
                    renterID + ", checkIN: " + checkIN + ", checkOUT: " + checkOUT);
            e.printStackTrace();
        }

    }

    public boolean isReserved(int apartmentID, Date checkIN, Date checkOUT) throws MySqlReservedApartmentDAOException {
        try {
            if (apartmentID != 0 && checkOrderDays(checkIN, checkOUT)) {
                boolResult = apartmentDao.isReserved(apartmentID, checkIN, checkOUT);
                if (boolResult) {
                    LOGGER.debug("Apartment (apartmentID: " + apartmentID + ") is reserved on dates: " +
                            "checkIN: " + checkIN + ", checkOUT: " + checkOUT);
                    return true;
                } else {
                    LOGGER.debug("Apartment (apartmentID: " + apartmentID + ") is not reserved on dates: " +
                            "checkIN: " + checkIN + ", checkOUT: " + checkOUT);
                }
            } else {
                LOGGER.debug("Incorrect values! ApartmentID: " + apartmentID + ", checkIN: " + checkIN +
                        ", checkOUT: " + checkOUT);
            }
        } catch (MySqlReservedApartmentDAOException e) {
            LOGGER.error("Cannot check if apartment is reserved! " + e);
            e.printStackTrace();
        }
        return false;
    }

    private boolean isReserveExist(int apartmentID, int hostID, int renterID, Date checkIN, Date checkOUT) {
        try {
            if (checkArguments(apartmentID, hostID, renterID, checkIN, checkOUT)) {
                boolResult = apartmentDao.isReserveExist(apartmentID, hostID, renterID, checkIN, checkOUT);
                if (boolResult) {
                    LOGGER.debug("Apartment (apartmentID: " + apartmentID + ") on dates: checkIN: " + checkIN +
                            ", checkOUT: " + checkOUT + " is reserved!");
                    return true;
                } else {
                    LOGGER.debug("Reserve doesn`t exist! ApartmentID: " + apartmentID +
                            ", hostID: " + hostID + ", renterID: " + renterID +
                            ", checkIN: " + checkIN + ", checkOUT: " + checkOUT);
                }
            }
        } catch (MySqlReservedApartmentDAOException e) {
            e.printStackTrace();
        }
        return false;
    }

    private boolean checkArguments(int apartmentID, int hostID, int renterID, Date checkIN, Date checkOUT) {
        if (apartmentID != 0 && hostID != 0 && renterID != 0 && checkIN != null && checkOUT != null) {
            if (checkOrderDays(checkIN, checkOUT)) {
                return true;
            }
        } else {
            LOGGER.debug("Incorrect values! ApartmentID: " + apartmentID + ", hostID: " + hostID + ", renterID: " +
                    renterID + ", checkIN: " + checkIN + ", checkOUT: " + checkOUT);
        }
        return false;
    }

    private boolean checkOrderDays(Date checkIN, Date checkOUT) {
        if (checkIN != null && checkOUT != null) {
            if (checkIN.before(checkOUT)) {
                return true;
            } else {
                LOGGER.debug("Dates are in wrong order! CheckIN: " + checkIN + ", checkOUT: " + checkOUT + ".");
            }
        } else {
            LOGGER.debug("Incorrect values! CheckIN: " + checkIN + ", checkOUT: " + checkOUT);
        }
        return false;
    }
}
