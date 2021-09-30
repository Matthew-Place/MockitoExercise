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

import com.qa.ims.controller.ItemController;
import com.qa.ims.persistence.dao.ItemDAO;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.Utils;

@RunWith(MockitoJUnitRunner.class)
public class ItemControllerTest {

	@Mock
	private ItemDAO dao;

	@Mock
	private Utils utils;

	@InjectMocks
	private ItemController controller;

	@Test
	public void itemReadAllTest() {
		// Given
		Item toRead = new Item(1L, "test", 2D);
		List<Item> list = new ArrayList<>(Arrays.asList(toRead));
		// When
		Mockito.when(dao.readAll()).thenReturn(list);

		assertEquals(list, controller.readAll());

		Mockito.verify(dao, Mockito.times(1)).readAll();
	}

	@Test
	public void itemCreateTest() {
		// Given
		Item created = new Item("test", 1D);
		// When(and then)
		Mockito.when(utils.getString()).thenReturn(created.getItemName());
		Mockito.when(utils.getDouble()).thenReturn(created.getItemPrice());
		Mockito.when(dao.create(created)).thenReturn(created);

		assertEquals(created, controller.create());

		Mockito.verify(dao, Mockito.times(1)).create(created);
		Mockito.verify(utils, Mockito.times(1)).getString();
		Mockito.verify(utils, Mockito.times(1)).getDouble();
	}

	@Test
	public void itemUpdateTest() {
		// Given
		Item toUpdate = new Item(1L, "test", 2D);
		Item updated = new Item(1L, "test", 2D);
		// when
		Mockito.when(utils.getString()).thenReturn(updated.getItemName());
		Mockito.when(utils.getLong()).thenReturn(updated.getItemId());
		Mockito.when(utils.getDouble()).thenReturn(updated.getItemPrice());
		Mockito.when(dao.update(toUpdate)).thenReturn(updated);

		assertEquals(updated, controller.update());

		Mockito.verify(dao, Mockito.times(1)).update(updated);
		Mockito.verify(utils, Mockito.times(1)).getLong();
		Mockito.verify(utils, Mockito.times(1)).getDouble();
		Mockito.verify(utils, Mockito.times(1)).getString();
	}

	@Test
	public void itemDeleteTest() {
		// Given
		Item toDelete = new Item(1L, "test", 2D);
		// when
		Mockito.when(utils.getLong()).thenReturn(toDelete.getItemId());
		Mockito.when(dao.delete(toDelete.getItemId())).thenReturn(1);

		assertEquals(1, controller.delete());

		Mockito.verify(dao, Mockito.times(1)).delete(toDelete.getItemId());
		Mockito.verify(utils, Mockito.times(1)).getLong();
	}
}
