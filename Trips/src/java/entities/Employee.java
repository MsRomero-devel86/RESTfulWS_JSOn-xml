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
@Table(name = "employee")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "Employee.findAll", query = "SELECT e FROM Employee e")
    , @NamedQuery(name = "Employee.findByEmployeeId", query = "SELECT e FROM Employee e WHERE e.employeeId = :employeeId")
    , @NamedQuery(name = "Employee.findByEmployeeName", query = "SELECT e FROM Employee e WHERE e.employeeName = :employeeName")
    , @NamedQuery(name = "Employee.findByEmployeeStatus", query = "SELECT e FROM Employee e WHERE e.employeeStatus = :employeeStatus")
})
public class Employee implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "employee_id")
    private String employeeId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "employee_name")
    private String employeeName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "employee_status")
    private String employeeStatus;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employee")
    private Collection<Trip> tripCollection;

    public Employee()
    {
    }

    public Employee(String employeeId)
    {
        this.employeeId = employeeId;
    }

    public Employee(String employeeId, String employeeName, String employeeStatus)
    {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeStatus = employeeStatus;
    }

    public String getEmployeeId()
    {
        return employeeId;
    }

    public void setEmployeeId(String employeeId)
    {
        this.employeeId = employeeId;
    }

    public String getEmployeeName()
    {
        return employeeName;
    }

    public void setEmployeeName(String employeeName)
    {
        this.employeeName = employeeName;
    }

    public String getEmployeeStatus()
    {
        return employeeStatus;
    }

    public void setEmployeeStatus(String employeeStatus)
    {
        this.employeeStatus = employeeStatus;
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
        hash += (employeeId != null ? employeeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Employee))
        {
            return false;
        }
        Employee other = (Employee) object;
        if ((this.employeeId == null && other.employeeId != null) || (this.employeeId != null && !this.employeeId.equals(other.employeeId)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "entities.Employee[ employeeId=" + employeeId + " ]";
    }
    
}
