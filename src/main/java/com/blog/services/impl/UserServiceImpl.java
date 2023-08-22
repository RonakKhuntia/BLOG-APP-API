package com.blog.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.entities.User;
import com.blog.exceptions.ResourceNotFoundException;
import com.blog.payloads.UserDto;
import com.blog.repositories.UserRepo;
import com.blog.services.UserService;

import org.modelmapper.ModelMapper;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public UserDto createUser(UserDto userDto) {
		// TODO Auto-generated method stub
		User user = this.dtoToUser(userDto);
		User savedUser = this.userRepo.save(user);
		return this.userToDto(savedUser);
	}

	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {
		// TODO Auto-generated method stub
		User user = this.userRepo.findById(userId).orElseThrow(() ->new ResourceNotFoundException("User","Id",userId));
		user.setName(userDto.getName());
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setAbout(userDto.getAbout());
		user.setPassword(userDto.getPassword());
		User updatedUser = this.userRepo.save(user);
		UserDto updatedUserDto = this.userToDto(updatedUser);
		return updatedUserDto;
	}

	@Override
	public UserDto getUserById(Integer userId) {
		// TODO Auto-generated method stub
		User user = this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","Id",userId));
		return this.userToDto(user);
	}

	@Override
	public List<UserDto> getAllUsers() {
		// TODO Auto-generated method stub
		List<User> users = this.userRepo.findAll();
		List<UserDto> dtoUsers = users.stream().map(user->this.userToDto(user)).collect(Collectors.toList());
		return dtoUsers;
	}

	@Override
	public void deleteUser(Integer userId) {
		// TODO Auto-generated method stub
		User user = this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","Id",userId));
		this.userRepo.delete(user);
	}
	
	public User dtoToUser(UserDto userDto) {
		return this.modelMapper.map(userDto, User.class);
	}
	
	public UserDto userToDto(User user) {
		return this.modelMapper.map(user, UserDto.class);
	}

}
