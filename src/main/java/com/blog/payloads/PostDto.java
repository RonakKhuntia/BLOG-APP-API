package com.blog.payloads;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.blog.entities.Comment;


public class PostDto {
	private Integer postId;
	
	private Set<CommentDto> comments = new HashSet<>();
	
	public Set<CommentDto> getComments() {
		return comments;
	}

	public void setComments(Set<CommentDto> comments) {
		this.comments = comments;
	}

	public Integer getPostId() {
		return postId;
	}

	public void setPostId(Integer postId) {
		this.postId = postId;
	}
	private String title;
	private String content;
	private String imageName;
	private Date addedDate;
	private CategoryDto category;
	private UserDto user;
	
	public CategoryDto getCategory() {
		return category;
	}

	public void setCategory(CategoryDto categoryDto) {
		this.category = categoryDto;
	}

	public UserDto getUser() {
		return user;
	}

	public void setUser(UserDto userDto) {
		this.user = userDto;
	}

	public PostDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PostDto(Integer postId, String title, String content, String imageName, Date addedDate, CategoryDto category,
			UserDto user) {
		super();
		this.postId = postId;
		this.title = title;
		this.content = content;
		this.imageName = imageName;
		this.addedDate = addedDate;
		this.category = category;
		this.user = user;
	}

	public String getTitle() {
		return title;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public Date getAddedDate() {
		return addedDate;
	}
	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
