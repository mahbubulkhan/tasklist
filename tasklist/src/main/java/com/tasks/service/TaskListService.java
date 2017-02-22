package com.tasks.service;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.tasks.beans.Task;
//"application/xml",
@Produces({ "application/json" })
public interface TaskListService {
	
	@GET
	@Path("/tasks/")
	List<Task> getAllTask();
	
	@GET
	@Path("/tasks/{id}")
	Response getTask(@PathParam("id") String id);
	
	@PUT
	@Path("/tasks/")
	Response addTask(Task task);
	
	@DELETE
	@Path("/tasks/{id}")
	Response deleteTask(@PathParam("id")String id);
	
	@DELETE
	@Path("/tasks/")
	Response deleteTasks();

}
