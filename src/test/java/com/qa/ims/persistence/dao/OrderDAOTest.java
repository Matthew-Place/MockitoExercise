package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.DBUtils;

public class OrderDAOTest {
	
	private final OrderDAO orderDAO = new OrderDAO();
	
	@Before
	public void setup() {
		DBUtils.connect();
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
	}
	
	@Ignore
	@Test
	public void testCreate() {
		final Order created = new Order(1L, 1L, 1);
		assertEquals(created, orderDAO.create(created));
	}
	
	
	@Test
	public void testReadAll() {
		List<Order> expected = new ArrayList<>();
		expected.add(new Order(1L, 1L, 1, 0.2, "jordan", "Pen"));
		assertEquals(expected, orderDAO.readAll());
	}

	@Ignore
	@Test
	public void testReadLatest() {
		assertEquals(new Order(1L, 1L, 1, 0.2, "jordan", "Pen"), orderDAO.readLatest());
	}
	
	@Ignore
	@Test
	public void testRead() {
		final Long orderId = 1L;
		assertEquals(new Order(orderId, 1L, 1, 0.2, "jordan", "Pen"), orderDAO.read(orderId));
	}
	
	@Ignore
	@Test
	public void testUpdate() {
		final Order updatedItem = new Order(1L, 1L, 1L, 2);
		assertEquals(updatedItem, orderDAO.update(updatedItem));
	}
	
	@Test
	public void testDelete() {
		assertEquals(1, orderDAO.delete(1));
	}
	

}
