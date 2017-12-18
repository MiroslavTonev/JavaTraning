package javaApp.models;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "resources")
public class Resource {
	//•	Resources: id, name, type of resource (video / presentation / document / other), URL
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Basic
	private String name;
	@Column(name = "resource_type")
	private ResourceType resourceType;
	@Basic
	private String URL;
	@ManyToOne()
	@JoinColumn(name = "course_id")
	private Course course;
	
	public Resource() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ResourceType getResourceType() {
		return resourceType;
	}

	public void setResourceType(ResourceType resourceType) {
		this.resourceType = resourceType;
	}

	public String getURL() {
		return URL;
	}

	public void setURL(String URL) {
		this.URL = URL;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
	
	
	
}
