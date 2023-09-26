package vn.edu.iuh.fit.week2.services;

import vn.edu.iuh.fit.week2.models.Order;
import vn.edu.iuh.fit.week2.repositories.OrderRepository;

import java.util.List;

public class OrderService {
    private OrderRepository orderRepository;

    public OrderService() {
        orderRepository = new OrderRepository();
    }

    public Order create(Order o){
        orderRepository.add(o);
        return o;
    }

    public void delete(long id){
        orderRepository.delete(id);
    }

    public Order update(Order o){
        orderRepository.update(o);
        return o;
    }

    public List<Order> getAll(){
        return orderRepository.getAll();
    }
}
