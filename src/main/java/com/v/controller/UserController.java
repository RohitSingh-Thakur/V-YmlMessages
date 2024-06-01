package com.v.controller;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping; 
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.v.payloads.UserEntityDTO;



@RestController
@RequestMapping(path = "/v")
public class UserController {

	@PostMapping(path = "/saveUser")
	public UserEntityDTO saveUser(@Valid @RequestBody UserEntityDTO dto) {
		return dto;
	}
}
