package com.nagarro;

import java.util.*;
import java.util.stream.Collectors;

public class JavaPOC {
    private static List<Order> orderList = new ArrayList<>(Arrays.asList(
            new Order("1", "AMAZON","22-04-24"),
            new Order("2", "FLIPKART","22-04-24"),
            new Order("2", "FLIPKART","23-04-24"),
            new Order("1", "PAYTM","22-04-24"),
            new Order("1", "MYNTRA","22-04-24")
            ));

    public static void main(String args[]) {
//        Map<String, List<String >> map = orderList.stream().collect(Collectors.groupingBy(x-> x.getDate()));
        Map<String, List<Order>> dateMap = new HashMap<>();
        for (Order order : orderList) {
            if (dateMap.containsKey(order.date)) {
                List<Order> value = dateMap.get(order.date);
                value.add(order);
                dateMap.put(order.date, value);
            } else {
                List<Order> list = new ArrayList<>();
                list.add(order);
                dateMap.put(order.date, list);
            }
        }

        Map<String, List<Order>> productMap = new HashMap<>();
        for (Map.Entry map : dateMap.entrySet()) {
            List<Order> dateList = (List<Order>) map.getValue();
            for (Order order : dateList) {
                if (productMap.containsKey(order.productId)) {
                    List<Order> value = productMap.get(order.productId);
                    value.add(order);
                    productMap.put(order.productId, value);
                } else {
                    List<Order> list = new ArrayList<>();
                    list.add(order);
                    productMap.put(order.productId, list);
                }
            }
        }

        Map<String, List<Order >> channelMap = new HashMap<>();
        for(Map.Entry map : productMap.entrySet()) {
            List<Order>  = (List<Order>) map.getValue();
            for(Order order : channelList) {
                if(productMap.containsKey(order.channel)){
                    List<Order> value = productMap.get(order.channel);
                    value.add(order);
                    productMap.put(order.channel, value);
                }
                else {
                    List<Order> list = new ArrayList<>();
                    list.add(order);
                    productMap.put(order.channel,list);
                }
            }

    }
}

class  Order{
    String productId;
    String channel;
    String date;

    public Order(String productId, String channel, String date) {
        this.channel = channel;
        this.productId = productId;
        this.date = date;
    }
}
