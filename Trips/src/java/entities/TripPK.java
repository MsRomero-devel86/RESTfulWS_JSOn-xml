package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author Meghan
 */
@Embeddable
public class TripPK implements Serializable
{

    @Basic(optional = false)
    @Column(name = "trip_id", length=50)
    private String tripId;
    @Basic(optional = false)
    @Column(name = "employee_id", length=50)
    private String employeeId;
    @Basic(optional = false)
    @Column(name = "vehicle_vin", length=50)
    private String vehicleVin;
    

    public TripPK()
    {
    }

    public TripPK(String tripId, String employeeId, String vehicleVin)
    {
        this.tripId = tripId;
        this.employeeId = employeeId;
        this.vehicleVin = vehicleVin;
    }

    public String getTripId()
    {
        return tripId;
    }

    public void setTripId(String tripId)
    {
        this.tripId = tripId;
    }

    public String getEmployeeId()
    {
        return employeeId;
    }

    public void setEmployeeId(String employeeId)
    {
        this.employeeId = employeeId;
    }

    public String getVehicleVin()
    {
        return vehicleVin;
    }

    public void setVehicleVin(String vehicleVin)
    {
        this.vehicleVin = vehicleVin;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (tripId != null ? tripId.hashCode() : 0);
        hash += (employeeId != null ? employeeId.hashCode() : 0);
        hash += (vehicleVin != null ? vehicleVin.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TripPK))
        {
            return false;
        }
        TripPK other = (TripPK) object;
        if ((this.tripId == null && other.tripId != null) || (this.tripId != null && !this.tripId.equals(other.tripId)))
        {
            return false;
        }
        if ((this.employeeId == null && other.employeeId != null) || (this.employeeId != null && !this.employeeId.equals(other.employeeId)))
        {
            return false;
        }
        if ((this.vehicleVin == null && other.vehicleVin != null) || (this.vehicleVin != null && !this.vehicleVin.equals(other.vehicleVin)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "entities.TripPK[ tripId=" + tripId + ", employeeId=" + employeeId + ", vehicleVin=" + vehicleVin + " ]";
    }
    
}
