package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.Utils;

public class OrderController implements CrudController<Order> {
	
	public static final Logger LOGGER = LogManager.getLogger();
	
	private OrderDAO orderDAO;
	private Utils utils;
	
	public OrderController(OrderDAO orderDAO, Utils utils) {
		super();
		this.orderDAO = orderDAO;
		this.utils = utils;
	}

	@Override
	public List<Order> readAll() {
		List<Order> orders = orderDAO.readAll();
		for (Order order : orders) {
			LOGGER.info(order);
		}
		return orders;
	}

	@Override
	public Order create() {
		LOGGER.info("Please enter the customer id");
		Long customerId = utils.getLong();
		LOGGER.info("Please enter the item id");
		Long itemId = utils.getLong();
		LOGGER.info("Please enter the qty");
		Integer qty = utils.getInteger();
		Order order = orderDAO.create(new Order(customerId, itemId, qty));
		LOGGER.info("order created");
		return order;
	}

	@Override
	public Order update() {
		LOGGER.info("Please enter the id of the order you would like to update: ");
		Long orderId = utils.getLong();
		LOGGER.info("Enter the new item id: ");
		Long itemId = utils.getLong();
		LOGGER.info("enter a quantity: ");
		Integer qty = utils.getInteger();
		LOGGER.info("And finally, enter the customer id");
		Long custId = utils.getLong();
		Order order = orderDAO.update(new Order(orderId, custId, itemId, qty));
		return order;
	}

	@Override
	public int delete() {
		LOGGER.info("Please enter the id of the order you would like to delete");
		Long orderId = utils.getLong();
		LOGGER.info("order deleted");
		return orderDAO.delete(orderId);
	}

}
