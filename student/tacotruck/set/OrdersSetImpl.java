package com.olympic.cis143.m04.student.tacotruck.set;

import com.olympic.cis143.m04.student.tacotruck.Orders;
import com.olympic.cis143.m04.student.tacotruck.TacoImpl;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class OrdersSetImpl  implements Orders {
	
	private Set<TacoImpl> tacoQueue = new LinkedHashSet<>();
	
    @Override
    public void addOrder(TacoImpl tacoOrder) {
    	this.tacoQueue.add(tacoOrder);
    }

    @Override
    public boolean hasNext() {
        return !this.tacoQueue.isEmpty();
    }

    @Override
    public TacoImpl closeNextOrder() {
        TacoImpl taco = (TacoImpl)(this.tacoQueue.toArray())[0];
        this.tacoQueue.remove(taco);
        return taco;
    }

    @Override
    public int howManyOrders() {
        return this.tacoQueue.size();
    }
}
