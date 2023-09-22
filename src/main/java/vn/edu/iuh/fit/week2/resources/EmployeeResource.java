package vn.edu.iuh.fit.week2.resources;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import vn.edu.iuh.fit.week2.models.Employee;
import vn.edu.iuh.fit.week2.services.EmployeeService;

import java.util.List;

@Path("/employees")
public class EmployeeResource {
    private EmployeeService employeeService;

    public EmployeeResource(){
        employeeService = new EmployeeService();
    }

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Response getAllEmployee(@PathParam("id") long id){
        List<Employee> le = employeeService.getAllEmployee();
        return Response.ok(le).build();
    }

    @POST
    @Path("/createEmployee")
    @Produces("application/json")
    public Response createEmployee(Employee e){
        employeeService.add(e);
        return Response.ok(e).build();
    }
}
