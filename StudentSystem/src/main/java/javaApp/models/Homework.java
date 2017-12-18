package javaApp.models;

import java.util.Date;

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
@Table(name = "homeworks")
public class Homework {
	//id, content, content-type (e.g. application/pdf or application/zip), submission date
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long id;
	@Basic
	private String content;
	@Column(name = "content_type")
	private ContentType contentType;
	@Column(name = "submission_date")	
	private Date submissionDate;
	@ManyToOne()
	@JoinColumn(name = "student_id")
	private Student student;
	@ManyToOne()
	@JoinColumn(name = "course_id")
	private Course course;
	
	public Homework() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public ContentType getContentType() {
		return contentType;
	}

	public void setContentType(ContentType contentType) {
		this.contentType = contentType;
	}

	public Date getSubmissionDate() {
		return submissionDate;
	}

	public void setSubmissionDate(Date submissionDate) {
		this.submissionDate = submissionDate;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
	
	
}
