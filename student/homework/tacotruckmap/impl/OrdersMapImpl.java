package com.olympic.cis143.m04.student.homework.tacotruckmap.impl;

import com.olympic.cis143.m04.student.homework.tacotruckmap.OrderDoesNotExistException;
import com.olympic.cis143.m04.student.homework.tacotruckmap.Orders;
import com.olympic.cis143.m04.student.homework.tacotruckmap.TacoImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrdersMapImpl implements Orders {

	private Map<String, List<TacoImpl>> tacoQueue = new HashMap<>();
	
    @Override
    public void createOrder(final String orderid) {
    	this.tacoQueue.put(orderid, new ArrayList<TacoImpl>());
    }

    @Override
    public void addTacoToOrder(final String orderid, final TacoImpl taco) throws OrderDoesNotExistException {
    	this.orderExists(orderid);
    	this.tacoQueue.get(orderid).add(taco);
    }

    @Override
    public boolean hasNext() {
        return !this.tacoQueue.isEmpty();
    }

    @Override
    public List<TacoImpl> closeOrder(final String orderid) throws OrderDoesNotExistException {
    	this.orderExists(orderid);
    	return this.tacoQueue.remove(orderid);
    }

    @Override
    public int howManyOrders() {
        return this.tacoQueue.size();
    }

    @Override
    public List<TacoImpl> getListOfOrders(final String orderid) throws OrderDoesNotExistException {
    	this.orderExists(orderid);
    	return this.tacoQueue.get(orderid);
    }
    
    private void orderExists(final String orderid) throws OrderDoesNotExistException {
        if (this.tacoQueue.get(orderid) == null) {
            throw new OrderDoesNotExistException(orderid);
        }
    }
}
