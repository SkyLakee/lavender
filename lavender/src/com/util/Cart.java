package com.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.model.TGoods;
import com.model.TMingxi;

public class Cart
{

	protected Map<Integer, TMingxi> items;

	public Cart()
	{

		if (items == null)
		{
			items = new HashMap<Integer, TMingxi>();
		}
	}

	public void addGoods(Integer goodsId, TMingxi orderItem)
	{

		if (items.containsKey(goodsId))
		{

			TMingxi _orderitem = items.get(goodsId);
			_orderitem.setGoodsShuliang(_orderitem.getGoodsShuliang()+ orderItem.getGoodsShuliang());
			items.put(goodsId, _orderitem);
		} else
		{

			items.put(goodsId, orderItem);
		}
	}
	
	public void delGoods(Integer goodsId)
	{
		items.remove(goodsId);
	}
	

	public void updateCart(Integer goodsId, int quantity)
	{

		TMingxi orderItem = items.get(goodsId);
		orderItem.setGoodsShuliang(quantity);
		items.put(goodsId, orderItem);
	}

	public int getTotalPrice()
	{

		int totalPrice = 0;
		for (Iterator it = items.values().iterator(); it.hasNext();)
		{

			TMingxi orderItem = (TMingxi) it.next();
			TGoods goods = orderItem.getGoods();
			int quantity = orderItem.getGoodsShuliang();
			totalPrice += goods.getTejia() * quantity;
		}
		return totalPrice;
	}

	public Map<Integer, TMingxi> getItems()
	{
		return items;
	}

}
