package com.tasks.beans;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "Task")
public class Task {
	
	private long id;
	private String name;
	
	public Task()
	{
		
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
