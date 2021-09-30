package com.qa.ims.controllers;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.controller.CustomerController;
import com.qa.ims.persistence.dao.CustomerDAO;
import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.utils.Utils;

@RunWith(MockitoJUnitRunner.class)
public class CustomerControllerTest {

	@Mock
	private CustomerDAO dao;

	@Mock
	private Utils utils;

	@InjectMocks
	private CustomerController controller;

	@Test
	public void customerReadAllTest() {
		// Given
		Customer toRead = new Customer(1L, "test", "ing");
		List<Customer> list = new ArrayList<>(Arrays.asList(toRead));
		// When
		Mockito.when(dao.readAll()).thenReturn(list);

		assertEquals(list, controller.readAll());

		Mockito.verify(dao, Mockito.times(1)).readAll();
	}

	@Test
	public void customerCreateTest() {
		// Given
		Customer created = new Customer("test", "ing");
		// When(and then)
		Mockito.when(utils.getString()).thenReturn(created.getFirstName(), created.getSurname());
		Mockito.when(dao.create(created)).thenReturn(created);

		assertEquals(created, controller.create());

		Mockito.verify(dao, Mockito.times(1)).create(created);
		Mockito.verify(utils, Mockito.times(2)).getString();
	}

	@Test
	public void customerUpdateTest() {
		// Given
		Customer toUpdate = new Customer(1L, "test", "ing");
		Customer updated = new Customer(1L, "test", "ing");
		// when
		Mockito.when(utils.getString()).thenReturn(updated.getFirstName(), updated.getSurname());
		Mockito.when(utils.getLong()).thenReturn(updated.getId());
		Mockito.when(dao.update(toUpdate)).thenReturn(updated);

		assertEquals(updated, controller.update());

		Mockito.verify(dao, Mockito.times(1)).update(updated);
		Mockito.verify(utils, Mockito.times(1)).getLong();
		Mockito.verify(utils, Mockito.times(2)).getString();
	}

	@Test
	public void customerDeleteTest() {
		// Given
		Customer toDelete = new Customer(1L, "test", "ing");
		// when
		Mockito.when(utils.getLong()).thenReturn(toDelete.getId());
		Mockito.when(dao.delete(toDelete.getId())).thenReturn(0);

		assertEquals(0, controller.delete());

		Mockito.verify(dao, Mockito.times(1)).delete(toDelete.getId());
		Mockito.verify(utils, Mockito.times(1)).getLong();
	}
}
