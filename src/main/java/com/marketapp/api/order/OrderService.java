package com.marketapp.api.order;


import com.marketapp.api.item.Item;
import com.marketapp.api.item.ItemRepository;
import com.marketapp.api.orderitem.OrderItem;
import com.marketapp.api.orderitem.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    private final ItemRepository itemRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository, OrderItemRepository orderItemRepository, ItemRepository itemRepository) {
        this.orderRepository = orderRepository;
        this.orderItemRepository = orderItemRepository;
        this.itemRepository = itemRepository;
    }

    public List<Order> getBranchOrdersByStatus(String status, Long branchId){
        return orderRepository.findBranchOrdersByStatus(status, branchId);

    }

    public Order createOrder(Long storeId, Long branchId) {
        Order order = new Order("pending", 0f, 0f, LocalDate.now(), storeId, branchId);
        orderRepository.save(order);
        return order;
    }

    public Optional<Order> addItemToOrder(Long itemId, Long orderId, Integer orderItemQuantity, Long storeId, Long branchId){

        //Get the required item to add to the order
        Optional<Item> item = itemRepository.findById(itemId);

        //Check if the item exists
        if (item.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Item does not exist");
        }


        String orderStatus = "pending";

        //Get the latest items total price
        Float totalPrice = item.get().getPrice() * orderItemQuantity;

        //Get the latest items total cost


        //Add item to the order


        return orderRepository.findById(orderId);

    }

    public void checkout(Long orderId){
        //Get the latest price of items in the order
        //Update orderItem table price and cost
        //Update items table quantity
        //Apply coupon code on the total price
        //Update order set total price and total cost
        //Update order status to "completed"

    }

}
