package com.giahr.management.customer.service

import com.giahr.management.customer.exception.CustomerExistException
import com.giahr.management.customer.model.Customer
import com.giahr.management.customer.repository.CustomerRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class DefaultCustomerService(private val customerRepository: CustomerRepository) : CustomerService {

    override fun getCustomer(id:Int) = customerRepository.findById(id)

    override fun createCustomer(customer:Mono<Customer>) =
            customerRepository.create(customer)

    override fun deleteCustomer(id:Int): Mono<Boolean> =
            customerRepository.deleteById(id).map {it.deletedCount > 0}

    override fun searchCustomers(nameFilter: String) =
            customerRepository.findCustomer(nameFilter)

}