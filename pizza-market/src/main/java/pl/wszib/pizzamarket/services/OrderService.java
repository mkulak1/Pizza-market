package pl.wszib.pizzamarket.services;

import jakarta.persistence.EntityExistsException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.wszib.pizzamarket.data.entities.OrderAddressEntity;
import pl.wszib.pizzamarket.data.entities.OrderEntity;
import pl.wszib.pizzamarket.data.entities.PizzaEntity;
import pl.wszib.pizzamarket.data.repositories.OrderRepository;
import pl.wszib.pizzamarket.data.repositories.PizzaRepository;
import pl.wszib.pizzamarket.web.mappers.OrderAddressMapper;
import pl.wszib.pizzamarket.web.models.OrdrAddressModel;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final PizzaRepository pizzaRepository;

    public OrderService(OrderRepository orderRepository, PizzaRepository pizzaRepository) {
        this.orderRepository = orderRepository;
        this.pizzaRepository = pizzaRepository;
    }
    @Transactional
    public void saveOrder(Long pizzaId, OrdrAddressModel ordrAddressModel) {
        PizzaEntity pizzaEntity = pizzaRepository.findById(pizzaId)
                .orElseThrow(EntityExistsException::new);

        OrderAddressEntity orderAddressEntity = OrderAddressMapper.toEntity(ordrAddressModel);

        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setPizzaName(pizzaEntity.getName());
        orderEntity.setPrice(pizzaEntity.getPrice());
        orderEntity.setOrderAddress(orderAddressEntity);

        orderRepository.save(orderEntity);

    }
}
