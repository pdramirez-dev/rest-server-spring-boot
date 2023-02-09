package com.pdramirez.restservice;

import com.pdramirez.restservice.employee.Employee;
import com.pdramirez.restservice.employee.EmployeeRepository;
import com.pdramirez.restservice.order.Order;
import com.pdramirez.restservice.order.OrderRepository;
import com.pdramirez.restservice.order.Status;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(EmployeeRepository employeerepository, OrderRepository orderRepository) {

        return args -> {
            employeerepository.save(new Employee("Pepe", "Cabeza", "Hero"));
            employeerepository.save(new Employee("Pipo", "Perez", "rno"));

            employeerepository.findAll().forEach(employee -> {
                log.info("Preoloaded "+employee);
            });
            orderRepository.save(new Order("MacBook Pro", Status.COMPLETED));
            orderRepository.save(new Order("iPhone", Status.IN_PROGRESS));

            orderRepository.findAll().forEach(order -> {
                log.info("Preloaded " + order);
            });
        };
    }
}
