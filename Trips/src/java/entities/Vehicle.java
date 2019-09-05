/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Meghan
 */
@Entity
@Table(name = "vehicle")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "Vehicle.findAll", query = "SELECT v FROM Vehicle v")
    , @NamedQuery(name = "Vehicle.findByVehicleVin", query = "SELECT v FROM Vehicle v WHERE v.vehicleVin = :vehicleVin")
    , @NamedQuery(name = "Vehicle.findByVehicleId", query = "SELECT v FROM Vehicle v WHERE v.vehicleId = :vehicleId")
    , @NamedQuery(name = "Vehicle.findByOdometer", query = "SELECT v FROM Vehicle v WHERE v.odometer = :odometer")
})
public class Vehicle implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "vehicle_vin")
    private String vehicleVin;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "vehicle_id")
    private String vehicleId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "odometer")
    private int odometer;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vehicle")
    private Collection<Trip> tripCollection;

    public Vehicle()
    {
    }

    public Vehicle(String vehicleVin)
    {
        this.vehicleVin = vehicleVin;
    }

    public Vehicle(String vehicleVin, String vehicleId, int odometer)
    {
        this.vehicleVin = vehicleVin;
        this.vehicleId = vehicleId;
        this.odometer = odometer;
    }

    public String getVehicleVin()
    {
        return vehicleVin;
    }

    public void setVehicleVin(String vehicleVin)
    {
        this.vehicleVin = vehicleVin;
    }

    public String getVehicleId()
    {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId)
    {
        this.vehicleId = vehicleId;
    }

    public int getOdometer()
    {
        return odometer;
    }

    public void setOdometer(int odometer)
    {
        this.odometer = odometer;
    }

    @XmlTransient
    public Collection<Trip> getTripCollection()
    {
        return tripCollection;
    }

    public void setTripCollection(Collection<Trip> tripCollection)
    {
        this.tripCollection = tripCollection;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (vehicleVin != null ? vehicleVin.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vehicle))
        {
            return false;
        }
        Vehicle other = (Vehicle) object;
        if ((this.vehicleVin == null && other.vehicleVin != null) || (this.vehicleVin != null && !this.vehicleVin.equals(other.vehicleVin)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "entities.Vehicle[ vehicleVin=" + vehicleVin + " ]";
    }
    
}
