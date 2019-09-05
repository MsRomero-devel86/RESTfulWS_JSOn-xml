package entities.service;

import entities.Trip;
import entities.TripPK;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.PathSegment;

/**
 * @author Meghan
 */
@Stateless
@Path("entities.trip")
public class TripFacadeREST extends AbstractFacade<Trip>
{

    @PersistenceContext(unitName = "TripsPU")
    private EntityManager em;

    private TripPK getPrimaryKey(PathSegment pathSegment)
    {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;tripId=tripIdValue;employeeId=employeeIdValue;vehicleVin=vehicleVinValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        entities.TripPK key = new entities.TripPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> tripId = map.get("tripId");
        if (tripId != null && !tripId.isEmpty())
        {
            key.setTripId(tripId.get(0));
        }
        java.util.List<String> employeeId = map.get("employeeId");
        if (employeeId != null && !employeeId.isEmpty())
        {
            key.setEmployeeId(employeeId.get(0));
        }
        java.util.List<String> vehicleVin = map.get("vehicleVin");
        if (vehicleVin != null && !vehicleVin.isEmpty())
        {
            key.setVehicleVin(vehicleVin.get(0));
        }
        return key;
    }

    public TripFacadeREST()
    {
        super(Trip.class);
    }

    @POST
    @Override
    @Consumes(
    {
        MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON
    })
    public void create(Trip entity)
    {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes(
    {
        MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON
    })
    public void edit(@PathParam("id") PathSegment id, Trip entity)
    {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") PathSegment id)
    {
        entities.TripPK key = getPrimaryKey(id);
        super.remove(super.find(key));
    }

    @GET
    @Path("{id}")
    @Produces(
    {
        MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON
    })
    public Trip find(@PathParam("id") PathSegment id)
    {
        System.out.println("PathSegment id: " + id);
        System.out.println("Matrix Parameters: " + id.getMatrixParameters());
        System.out.println("ID Path: " + id.getPath());
        entities.TripPK key = getPrimaryKey(id);
        return super.find(key);
    }

    @GET
    @Override
    @Produces(
    {
        MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON
    })
    public List<Trip> findAll()
    {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces(
    {
        MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON
    })
    public List<Trip> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to)
    {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST()
    {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager()
    {
        return em;
    }
    
}
