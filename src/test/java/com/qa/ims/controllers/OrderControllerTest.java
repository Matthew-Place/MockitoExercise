package com.qa.ims.controllers;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.controller.OrderController;
import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.Utils;

@RunWith(MockitoJUnitRunner.class)
public class OrderControllerTest {
	
	@Mock
	private OrderDAO dao;
	
	@Mock
	private Utils utils;
	
	@InjectMocks
	private OrderController controller;
	
	@Test
	public void orderCreateTest() {
		//Given
//		Order toCreate = new Order(1L, 1L, 5);
		Order created = new Order(1L, 1L, 5);
		//When(and then)
		Mockito.when(utils.getLong()).thenReturn(created.getOrderId());
		Mockito.when(utils.getLong()).thenReturn(created.getItemId());
		Mockito.when(utils.getInteger()).thenReturn(created.getQty());
		Mockito.when(dao.create(created)).thenReturn(created);
		
		assertEquals(created, controller.create());
		
		Mockito.verify(dao, Mockito.times(1)).create(created);
		Mockito.verify(utils, Mockito.times(2)).getLong();
		Mockito.verify(utils, Mockito.times(1)).getInteger();

	}
	
	@Test
	public void orderUpdateTest() {
		//Given
		Order toUpdate = new Order(1L, 2L, 3L, 10);
		Order updated = new Order(1L, 2L, 3L, 10);
		//when
		Mockito.when(utils.getLong()).thenReturn(updated.getOrderId(), updated.getItemId(), updated.getCustomerId());
		Mockito.when(utils.getInteger()).thenReturn(updated.getQty());
		Mockito.when(dao.update(toUpdate)).thenReturn(updated);
		
		assertEquals(updated, controller.update());
	
		Mockito.verify(dao, Mockito.times(1)).update(updated);
		Mockito.verify(utils, Mockito.times(3)).getLong();
		Mockito.verify(utils, Mockito.times(1)).getInteger();
	}

}
