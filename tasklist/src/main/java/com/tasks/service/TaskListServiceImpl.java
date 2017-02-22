package com.tasks.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.Response;

import com.tasks.beans.Task;

public class TaskListServiceImpl implements TaskListService {

	private long currentId = 100;
	private final int not_found_status = 404;
	Map<Long, Task> tasklist = new HashMap<Long, Task>();

	public TaskListServiceImpl() {
		intit();
	}

	private void intit() {
		Task task = new Task();
		task.setId(currentId);
		task.setName("Morning works");
		tasklist.put(task.getId(), task);
	}

	@Override
	public Response getTask(String id) {
		// TODO Auto-generated method stub
		Long task_id = Long.parseLong(id);
		Task task = tasklist.get(task_id);
		Response response = null;
		if (task != null)
			response = Response.ok(task).build();
		else
			response = Response.status(not_found_status).build();
		// return task;
		return response;
	}

	@Override
	public Response addTask(Task task) {
		// TODO Auto-generated method stub
		task.setId(++currentId);
		tasklist.put(task.getId(), task);
		return Response.ok(task).build();
	}

	@Override
	public Response deleteTasks() {
		// TODO Auto-generated method stub
		tasklist.clear();
		return Response.ok().build();
	}

	@Override
	public List<Task> getAllTask() {
		// TODO Auto-generated method stub
		return new ArrayList<Task>(tasklist.values());
	}

	@Override
	public Response deleteTask(String id) {
		// TODO Auto-generated method stub
		Long taskId = Long.parseLong(id);
		Task task_for_delete = tasklist.get(taskId);
		Response response = null;
		if (task_for_delete != null) {
			tasklist.remove(taskId);
			response = Response.ok(task_for_delete).build();
		} else
			response = Response.status(not_found_status).build();
		return response;
	}

}
