package service;

import java.util.List;

import Pojo.Customer;
import Pojo.User;

public interface CustomerService {
	List<Customer> selectAllBuyer();
	List<Customer> selectAllSeller();
	Customer findtelephone(String telephone);
	void insertbuyer(Customer customer);
	void insertseller(Customer customer);
	List<Customer> selectAllNoValidBuyer();
	List<Customer> selectAllNoValidSeller();
	void validbuyer(Customer customer);
	void novalidbuyer(Customer customer);
	void validseller(Customer customer);
	void novalidseller(Customer customer);
	void addcustomer(User user);
	List<Customer> findseller(Customer customer);
	List<Customer> findbuyer(Customer customer);
	void deletecustomer(String id);
	Customer findcustomer(String customerid);
	void updatecustomer(Customer customer);
}
