package controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import service.CustomerService;
import Pojo.Customer;
import Pojo.User;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Controller

public class CustomerController {
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("/buyerlist")
	public String buyerlist(Model model ,@RequestParam(required=false,defaultValue="1") Integer page,
            @RequestParam(required=false,defaultValue="100") Integer pageSize){
		
		PageHelper.startPage(page, pageSize);
		List<Customer> buyerlist=customerService.selectAllBuyer();
		PageInfo<Customer> p=new PageInfo<Customer>(buyerlist);
		model.addAttribute("p", p);
		model.addAttribute("buyerlist",buyerlist);
		model.addAttribute("mainPage","buyerlist.jsp");
		return "admin/admin";
	}
	@RequestMapping("/sellerlist")
	public String sellerlist(Model model ,@RequestParam(required=false,defaultValue="1") Integer page,
            @RequestParam(required=false,defaultValue="100") Integer pageSize){
		
		PageHelper.startPage(page, pageSize);
		List<Customer> sellerlist=customerService.selectAllSeller();
		PageInfo<Customer> p=new PageInfo<Customer>(sellerlist);
		model.addAttribute("p", p);
		model.addAttribute("sellerlist",sellerlist);
		model.addAttribute("mainPage","sellerlist.jsp");
		return "admin/admin";
	}
	@RequestMapping("/toaddbuyer")
	public String toaddbuyer(Model model){
		model.addAttribute("mainPage","addbuyer.jsp");
		return "customer/customer";
//		return "admin/admin";
	}
	@RequestMapping("/addbuyer")
	public String addbuyer(Model model ,Customer customer){
		
		String telephone=customer.getTelephone().toString();
		Customer customerlist1=customerService.findtelephone(telephone);
		if(customerlist1!=null){
			model.addAttribute("error","该手机号已经注册!");
			model.addAttribute("buyerlist",customerlist1);
			model.addAttribute("mainPage","addbuyer.jsp");
			return "admin/admin";
		}else{
			//下面的方式不需要自己添加字段
			model.addAttribute("error","addsuccess");
			customerService.insertbuyer(customer);
			//根据手机号，在用户表中生成新的账号
			User user = new User();
			user.setUsername(customer.getTelephone());
			//默认初始密码是123456
			user.setPassword("123456");
			user.setType("buyer");
			customerService.addcustomer(user);
			return "redirect:/buyerlistforcustomer.action";
		}
	}
	@RequestMapping("/toaddseller")
	public String toaddseller(Model model){
		model.addAttribute("mainPage","addseller.jsp");
		return "customer/customer";
//		return "admin/admin";
	}
	@RequestMapping("/addseller")
	public String addseller(Model model ,Customer customer){
		
		String telephone=customer.getTelephone().toString();
		Customer customerlist1=customerService.findtelephone(telephone);
		if(customerlist1!=null){
			model.addAttribute("error","该手机号已经注册!");
			model.addAttribute("sellerlist",customerlist1);
			model.addAttribute("mainPage","addseller.jsp");
			return "admin/admin";
		}else{
			model.addAttribute("error","addsuccess");
			customerService.insertseller(customer);
			//根据手机号，在用户表中生成新的账号
			User user = new User();
			user.setUsername(customer.getTelephone());
			//默认初始密码是123456
			user.setPassword("123456");
			user.setType("seller");
			customerService.addcustomer(user);
			return "redirect:/sellerlistforcustomer.action";
		}
	}
	
	@RequestMapping("/verifybuyer")
	public String verifybuyer(Model model ,@RequestParam(required=false,defaultValue="1") Integer page,
            @RequestParam(required=false,defaultValue="10") Integer pageSize){
		
		PageHelper.startPage(page, pageSize);
		List<Customer> novalidbuyerlist=customerService.selectAllNoValidBuyer();
		PageInfo<Customer> p=new PageInfo<Customer>(novalidbuyerlist);
		model.addAttribute("p", p);
		model.addAttribute("novalidbuyerlist",novalidbuyerlist);
		model.addAttribute("mainPage","verifybuyerlist.jsp");
		return "admin/admin";
	}
	
	@RequestMapping("/verifyseller")
	public String verifyseller(Model model ,@RequestParam(required=false,defaultValue="1") Integer page,
            @RequestParam(required=false,defaultValue="10") Integer pageSize){
		
		PageHelper.startPage(page, pageSize);
		List<Customer> novalidsellerlist=customerService.selectAllNoValidSeller();
		PageInfo<Customer> p=new PageInfo<Customer>(novalidsellerlist);
		model.addAttribute("p", p);
		model.addAttribute("novalidsellerlist",novalidsellerlist);
		model.addAttribute("mainPage","verifysellerlist.jsp");
		return "admin/admin";
	}
	
	@RequestMapping("/validbuyer")
	public String validbuyer(Customer customer,Model model){
		customerService.validbuyer(customer);
		List<Customer> novalidbuyerlist=customerService.selectAllNoValidBuyer();
		PageInfo<Customer> p=new PageInfo<Customer>(novalidbuyerlist);
		model.addAttribute("p", p);
		model.addAttribute("novalidbuyerlist",novalidbuyerlist);
		model.addAttribute("mainPage", "verifybuyerlist.jsp");
		model.addAttribute("error","审核完成");
		return "admin/admin";
	}
	
	@RequestMapping("/novalidbuyer")
	public String novalidbuyer(Customer customer,Model model){
		
		customerService.novalidbuyer(customer);
		List<Customer> novalidbuyerlist=customerService.selectAllNoValidBuyer();
		PageInfo<Customer> p=new PageInfo<Customer>(novalidbuyerlist);
		model.addAttribute("p", p);
		model.addAttribute("novalidbuyerlist",novalidbuyerlist);
		model.addAttribute("mainPage", "verifybuyerlist.jsp");
		model.addAttribute("error","审核完成");
		return "admin/admin";
	}
	
	@RequestMapping("/validseller")
	public String validseller(Customer customer,Model model){
		customerService.validbuyer(customer);
		List<Customer> novalidsellerlist=customerService.selectAllNoValidSeller();
		PageInfo<Customer> p=new PageInfo<Customer>(novalidsellerlist);
		model.addAttribute("p", p);
		model.addAttribute("novalidsellerlist",novalidsellerlist);
		model.addAttribute("mainPage", "verifysellerlist.jsp");
		model.addAttribute("error","审核完成");
		return "admin/admin";
	}
	
	@RequestMapping("/novalidseller")
	public String novalidseller(Customer customer,Model model){
		
		customerService.novalidbuyer(customer);
		List<Customer> novalidsellerlist=customerService.selectAllNoValidSeller();
		PageInfo<Customer> p=new PageInfo<Customer>(novalidsellerlist);
		model.addAttribute("p", p);
		model.addAttribute("novalidsellerlist",novalidsellerlist);
		model.addAttribute("mainPage", "verifysellerlist.jsp");
		model.addAttribute("error","审核完成");
		return "admin/admin";
	}
	
	@RequestMapping("/buyerlistforbuyer")
	public String buyerlistforbuyer(Model model ,@RequestParam(required=false,defaultValue="1") Integer page,
            @RequestParam(required=false,defaultValue="100") Integer pageSize){
		PageHelper.startPage(page, pageSize);
		List<Customer> buyerlist=customerService.selectAllBuyer();
		PageInfo<Customer> p=new PageInfo<Customer>(buyerlist);
		model.addAttribute("p", p);
		model.addAttribute("buyerlist",buyerlist);
		model.addAttribute("mainPage","buyerlist.jsp");
		return "buyer/buyer";
	}
	@RequestMapping("/buyerlistforcustomer")
	public String buyerlistforcustomer(Model model ,@RequestParam(required=false,defaultValue="1") Integer page,
            @RequestParam(required=false,defaultValue="100") Integer pageSize){
		PageHelper.startPage(page, pageSize);
		List<Customer> buyerlist=customerService.selectAllBuyer();
		PageInfo<Customer> p=new PageInfo<Customer>(buyerlist);
		model.addAttribute("p", p);
		model.addAttribute("buyerlist",buyerlist);
		model.addAttribute("mainPage","buyerlist.jsp");
		return "customer/customer";
	}

	@RequestMapping("/sellerlistforbuyer")
	public String sellerlistforbuyer(Model model ,@RequestParam(required=false,defaultValue="1") Integer page,
            @RequestParam(required=false,defaultValue="100") Integer pageSize){
		
		PageHelper.startPage(page, pageSize);
		List<Customer> sellerlist=customerService.selectAllSeller();
		PageInfo<Customer> p=new PageInfo<Customer>(sellerlist);
		model.addAttribute("p", p);
		model.addAttribute("sellerlist",sellerlist);
		model.addAttribute("mainPage","sellerlist.jsp");
		return "buyer/buyer";
	}
	@RequestMapping("/sellerlistforcustomer")
	public String sellerlistforcustomer(Model model ,@RequestParam(required=false,defaultValue="1") Integer page,
            @RequestParam(required=false,defaultValue="100") Integer pageSize){
		
		PageHelper.startPage(page, pageSize);
		List<Customer> sellerlist=customerService.selectAllSeller();
		PageInfo<Customer> p=new PageInfo<Customer>(sellerlist);
		model.addAttribute("p", p);
		model.addAttribute("sellerlist",sellerlist);
		model.addAttribute("mainPage","sellerlist.jsp");
		return "customer/customer";
	}
	@RequestMapping("/buyerlistforseller")
	public String buyerlistforseller(Model model ,@RequestParam(required=false,defaultValue="1") Integer page,
            @RequestParam(required=false,defaultValue="100") Integer pageSize){
		PageHelper.startPage(page, pageSize);
		List<Customer> buyerlist=customerService.selectAllBuyer();
		PageInfo<Customer> p=new PageInfo<Customer>(buyerlist);
		model.addAttribute("p", p);
		model.addAttribute("buyerlist",buyerlist);
		model.addAttribute("mainPage","buyerlist.jsp");
		return "seller/seller";
	}

	@RequestMapping("/sellerlistforseller")
	public String sellerlistforseller(Model model ,@RequestParam(required=false,defaultValue="1") Integer page,
            @RequestParam(required=false,defaultValue="100") Integer pageSize){
		
		PageHelper.startPage(page, pageSize);
		List<Customer> sellerlist=customerService.selectAllSeller();
		PageInfo<Customer> p=new PageInfo<Customer>(sellerlist);
		model.addAttribute("p", p);
		model.addAttribute("sellerlist",sellerlist);
		model.addAttribute("mainPage","sellerlist.jsp");
		return "seller/seller";
	}
	@RequestMapping("/tofindseller")
	public String tofindseller(Model model){
		model.addAttribute("mainPage","findseller.jsp");
		return "buyer/buyer";
	}
	/**
	 * 签订合同
	 * @param model
	 * @param customer
	 * @return
	 */
	@RequestMapping("/findseller")
	public String findseller(Model model ,Customer customer,@RequestParam(required=false,defaultValue="1") Integer page,
            @RequestParam(required=false,defaultValue="100") Integer pageSize){
		
		List<Customer> customerlist = customerService.findseller(customer);
		if (customerlist != null && customerlist.size() > 0) {
			model.addAttribute("error","匹配成功！");
		}else {
			model.addAttribute("error","没有符合条件的数据！");
		}
		PageHelper.startPage(page, pageSize);
		PageInfo<Customer> p=new PageInfo<Customer>(customerlist);
		model.addAttribute("p", p);
		model.addAttribute("sellerlist",customerlist);
		model.addAttribute("mainPage","findsellerlist.jsp");
		return "buyer/buyer";
	}
	@RequestMapping("/tofindbuyer")
	public String tofindbuyer(Model model){
		model.addAttribute("mainPage","findbuyer.jsp");
		return "seller/seller";
	}
	/**
	 * 签订合同
	 * @param model
	 * @param customer
	 * @return
	 */
	@RequestMapping("/findbuyer")
	public String findbuyer(Model model ,Customer customer,@RequestParam(required=false,defaultValue="1") Integer page,
            @RequestParam(required=false,defaultValue="100") Integer pageSize){
		
		List<Customer> customerlist = customerService.findbuyer(customer);
		if (customerlist != null && customerlist.size() > 0) {
			model.addAttribute("error","匹配成功！");
		}else {
			model.addAttribute("error","没有符合条件的数据！");
		}
		PageHelper.startPage(page, pageSize);
		PageInfo<Customer> p=new PageInfo<Customer>(customerlist);
		model.addAttribute("p", p);
		model.addAttribute("buyerlist",customerlist);
		model.addAttribute("mainPage","findbuyerlist.jsp");
		return "seller/seller";
	}
	//删除买方和卖方信息
	@RequestMapping("/deletebuyer")
	public String deletebuyer(String id,Model model){
		customerService.deletecustomer(id);
		model.addAttribute("error", "deletesuccess");
		return "redirect:/buyerlist.action";
	}
	//删除买方和卖方信息
	@RequestMapping("/deleteseller")
	public String deleteseller(String id,Model model){
		customerService.deletecustomer(id);
		model.addAttribute("error", "deletesuccess");
		return "redirect:/sellerlist.action";
	}
	@RequestMapping("/updatebuyer")
	public String updatebuyer(String id,Model model){
		Customer buyer=customerService.findcustomer(id);
		model.addAttribute("buyerlist", buyer);
		model.addAttribute("mainPage", "updatebuyer.jsp");
		return "admin/admin";
	}
	@RequestMapping("/changebuyer")
	public String changebuyer(Customer customer){
		customerService.updatecustomer(customer);
		return "redirect:/buyerlist.action";
	}
	@RequestMapping("/updateseller")
	public String updateseller(String id,Model model){
		Customer seller=customerService.findcustomer(id);
		model.addAttribute("sellerlist", seller);
		model.addAttribute("mainPage", "updateseller.jsp");
		return "admin/admin";
	}
	@RequestMapping("/changeseller")
	public String changeseller(Customer customer){
		customerService.updatecustomer(customer);
		return "redirect:/sellerlist.action";
	}
}
