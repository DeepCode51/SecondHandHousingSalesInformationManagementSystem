package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Pojo.Customer;
import Pojo.User;
import dao.CustomerMapper;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerMapper customerMapper;
	

	@Override
	public List<Customer> selectAllBuyer() {
		List<Customer> buyerlist=customerMapper.selectAllBuyer();
		return buyerlist;
	}

	@Override
	public List<Customer> selectAllSeller() {
		List<Customer> sellerlist=customerMapper.selectAllSeller();
		return sellerlist;
	}

	@Override
	public Customer findtelephone(String telephone) {
		Customer customer = customerMapper.findtelephone(telephone);
		return customer;
	}

	@Override
	public void insertbuyer(Customer customer) {
		customerMapper.insertbuyer(customer);
	}
	@Override
	public void insertseller(Customer customer) {
		customerMapper.insertseller(customer);
	}

	@Override
	public List<Customer> selectAllNoValidBuyer() {
		List<Customer> buyerlist=customerMapper.selectAllNoValidBuyer();
		return buyerlist;
	}
	
	@Override
	public List<Customer> selectAllNoValidSeller() {
		List<Customer> buyerlist=customerMapper.selectAllNoValidSeller();
		return buyerlist;
	}

	@Override
	public void validbuyer(Customer customer) {
		customerMapper.validbuyer(customer);
		
	}

	@Override
	public void novalidbuyer(Customer customer) {
		customerMapper.novalidbuyer(customer);
		
	}

	@Override
	public void validseller(Customer customer) {
		customerMapper.validbuyer(customer);
		
	}

	@Override
	public void novalidseller(Customer customer) {
		customerMapper.novalidbuyer(customer);
		
	}

	@Override
	public void addcustomer(User user) {
		customerMapper.addcustomer(user);		
	}

	@Override
	public List<Customer> findseller(Customer customer) {
		List<Customer> customerlist = customerMapper.findseller(customer);
		return customerlist;
	}

	@Override
	public List<Customer> findbuyer(Customer customer) {
		List<Customer> customerlist = customerMapper.findbuyer(customer);
		return customerlist;
	}

	@Override
	public void deletecustomer(String id) {
		customerMapper.deletecustomer(id);
	}

	@Override
	public Customer findcustomer(String customerid) {
		Customer customer = customerMapper.findcustomer(customerid);
		return customer;
	}

	@Override
	public void updatecustomer(Customer customer) {
		customerMapper.updatecustomer(customer);
	}

}
