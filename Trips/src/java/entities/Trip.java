package entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Meghan
 */
@Entity
@Table(name = "trip")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "Trip.findAll", query = "SELECT t FROM Trip t")
    , @NamedQuery(name = "Trip.findByTripId", query = "SELECT t FROM Trip t WHERE t.tripPK.tripId = :tripId")
    , @NamedQuery(name = "Trip.findByEmployeeId", query = "SELECT t FROM Trip t WHERE t.tripPK.employeeId = :employeeId")
    , @NamedQuery(name = "Trip.findByVehicleVin", query = "SELECT t FROM Trip t WHERE t.tripPK.vehicleVin = :vehicleVin")
    , @NamedQuery(name = "Trip.findByPassengernameAMroute", query = "SELECT t FROM Trip t WHERE t.passengernameAMroute = :passengernameAMroute")
    , @NamedQuery(name = "Trip.findByAm", query = "SELECT t FROM Trip t WHERE t.am = :am")
    , @NamedQuery(name = "Trip.findByOrigination", query = "SELECT t FROM Trip t WHERE t.origination = :origination")
    , @NamedQuery(name = "Trip.findByDestination", query = "SELECT t FROM Trip t WHERE t.destination = :destination")
    , @NamedQuery(name = "Trip.findByOdometerStart", query = "SELECT t FROM Trip t WHERE t.odometerStart = :odometerStart")
    , @NamedQuery(name = "Trip.findByOdometerEnd", query = "SELECT t FROM Trip t WHERE t.odometerEnd = :odometerEnd")
    , @NamedQuery(name = "Trip.findByTripTimeStart", query = "SELECT t FROM Trip t WHERE t.tripTimeStart = :tripTimeStart")
    , @NamedQuery(name = "Trip.findByTripTimeEnd", query = "SELECT t FROM Trip t WHERE t.tripTimeEnd = :tripTimeEnd")
    , @NamedQuery(name = "Trip.findByTypeOfOuting", query = "SELECT t FROM Trip t WHERE t.typeOfOuting = :typeOfOuting")
    , @NamedQuery(name = "Trip.findByFareAmount", query = "SELECT t FROM Trip t WHERE t.fareAmount = :fareAmount")
    , @NamedQuery(name = "Trip.findByFareAmountCollected", query = "SELECT t FROM Trip t WHERE t.fareAmountCollected = :fareAmountCollected")
    , @NamedQuery(name = "Trip.findByTripComplete", query = "SELECT t FROM Trip t WHERE t.tripComplete = :tripComplete")
})
public class Trip implements Serializable
{

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TripPK tripPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "passenger_name_AM_route")
    private String passengernameAMroute;
    @Basic(optional = false)
    @NotNull
    @Column(name = "AM")
    private boolean am;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "origination")
    private String origination;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "destination")
    private String destination;
    @Basic(optional = false)
    @NotNull
    @Column(name = "odometer_start")
    private int odometerStart;
    @Basic(optional = false)
    @NotNull
    @Column(name = "odometer_end")
    private int odometerEnd;
    @Basic(optional = false)
    @NotNull
    @Column(name = "trip_time_start")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tripTimeStart;
    @Basic(optional = false)
    @NotNull
    @Column(name = "trip_time_end")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tripTimeEnd;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "type_of_outing")
    private String typeOfOuting;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "fare_amount")
    private BigDecimal fareAmount;
    @Column(name = "fare_amount_collected")
    private BigDecimal fareAmountCollected;
    @Basic(optional = false)
    @NotNull
    @Column(name = "trip_complete")
    private boolean tripComplete;
    @JoinColumn(name = "employee_id", referencedColumnName = "employee_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Employee employee;
    @JoinColumn(name = "vehicle_vin", referencedColumnName = "vehicle_vin", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Vehicle vehicle;

    public Trip()
    {
    }

    public Trip(TripPK tripPK)
    {
        this.tripPK = tripPK;
    }

    public Trip(TripPK tripPK, String passengernameAMroute, boolean am, 
        String origination, String destination, int odometerStart, int odometerEnd, 
        Date tripTimeStart, Date tripTimeEnd, String typeOfOuting, boolean tripComplete)
    {
        this.tripPK = tripPK;
        this.passengernameAMroute = passengernameAMroute;
        this.am = am;
        this.origination = origination;
        this.destination = destination;
        this.odometerStart = odometerStart;
        this.odometerEnd = odometerEnd;
        this.tripTimeStart = tripTimeStart;
        this.tripTimeEnd = tripTimeEnd;
        this.typeOfOuting = typeOfOuting;
        this.tripComplete = tripComplete;
    }

    public Trip(String tripId, String employeeId, String vehicleVin)
    {
        this.tripPK = new TripPK(tripId, employeeId, vehicleVin);
    }

    public TripPK getTripPK()
    {
        return tripPK;
    }

    public void setTripPK(TripPK tripPK)
    {
        this.tripPK = tripPK;
    }

    public String getPassengernameAMroute()
    {
        return passengernameAMroute;
    }

    public void setPassengernameAMroute(String passengernameAMroute)
    {
        this.passengernameAMroute = passengernameAMroute;
    }

    public boolean getAm()
    {
        return am;
    }

    public void setAm(boolean am)
    {
        this.am = am;
    }

    public String getOrigination()
    {
        return origination;
    }

    public void setOrigination(String origination)
    {
        this.origination = origination;
    }

    public String getDestination()
    {
        return destination;
    }

    public void setDestination(String destination)
    {
        this.destination = destination;
    }

    public int getOdometerStart()
    {
        return odometerStart;
    }

    public void setOdometerStart(int odometerStart)
    {
        this.odometerStart = odometerStart;
    }

    public int getOdometerEnd()
    {
        return odometerEnd;
    }

    public void setOdometerEnd(int odometerEnd)
    {
        this.odometerEnd = odometerEnd;
    }

    public Date getTripTimeStart()
    {
        return tripTimeStart;
    }

    public void setTripTimeStart(Date tripTimeStart)
    {
        this.tripTimeStart = tripTimeStart;
    }

    public Date getTripTimeEnd()
    {
        return tripTimeEnd;
    }

    public void setTripTimeEnd(Date tripTimeEnd)
    {
        this.tripTimeEnd = tripTimeEnd;
    }

    public String getTypeOfOuting()
    {
        return typeOfOuting;
    }

    public void setTypeOfOuting(String typeOfOuting)
    {
        this.typeOfOuting = typeOfOuting;
    }

    public BigDecimal getFareAmount()
    {
        return fareAmount;
    }

    public void setFareAmount(BigDecimal fareAmount)
    {
        this.fareAmount = fareAmount;
    }

    public BigDecimal getFareAmountCollected()
    {
        return fareAmountCollected;
    }

    public void setFareAmountCollected(BigDecimal fareAmountCollected)
    {
        this.fareAmountCollected = fareAmountCollected;
    }

    public boolean getTripComplete()
    {
        return tripComplete;
    }

    public void setTripComplete(boolean tripComplete)
    {
        this.tripComplete = tripComplete;
    }

    public Employee getEmployee()
    {
        return employee;
    }

    public void setEmployee(Employee employee)
    {
        this.employee = employee;
    }

    public Vehicle getVehicle()
    {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle)
    {
        this.vehicle = vehicle;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (tripPK != null ? tripPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Trip))
        {
            return false;
        }
        Trip other = (Trip) object;
        if ((this.tripPK == null && other.tripPK != null) || (this.tripPK != null && !this.tripPK.equals(other.tripPK)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "entities.Trip[ tripPK=" + tripPK + " ]";
    }
    
}
