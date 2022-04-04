package com.codingdojo.exam_prep;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.codingdojo.exam_prep.mvc.controllers.LoginController;
import com.codingdojo.exam_prep.mvc.controllers.ProjectManagerController;
import com.codingdojo.exam_prep.mvc.models.User;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ExamPrepApplicationTests {

	@Autowired
	private LoginController loginController;

	@Autowired
	private ProjectManagerController siteController;

	private static Validator validator;

	@BeforeAll
	static void setup() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}
	
	@Test
	void contextLoads() {
	}

	@Test
	void testControllers() {
		assertThat(loginController).isNotNull();
		assertThat(siteController).isNotNull();
	}

	@Test
	void testUser() {
		User user = new User();
		Set<ConstraintViolation<User>> violations = validator.validate(user);
		for (ConstraintViolation<User> violation : violations) {
			System.out.println(violation.getMessage()); 
		}
		assertTrue(violations.isEmpty());
	}
}
