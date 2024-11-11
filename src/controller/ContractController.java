package controller;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import service.ContractService;
import Pojo.Contract;
import Pojo.User;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Controller
@RequestMapping("/contract")
public class ContractController {
	@Autowired
	private ContractService contractService;
	
	/**
	 * 合同信息列表
	 * @param model
	 * @param page
	 * @param pageSize
	 * @return
	 */
	@RequestMapping("/contractlist")
	public String contractlist(Model model ,@RequestParam(required=false,defaultValue="1") Integer page,
            @RequestParam(required=false,defaultValue="100") Integer pageSize){
		
		PageHelper.startPage(page, pageSize);
		List<Contract> contractlist=contractService.selectAllContract();
		PageInfo<Contract> p=new PageInfo<Contract>(contractlist);
		model.addAttribute("p", p);
		model.addAttribute("contractlist",contractlist);
		model.addAttribute("mainPage","contractlist.jsp");
		return "admin/admin";
	}
	@RequestMapping("/toaddcontract")
	public String toaddcontract(Model model){
		model.addAttribute("mainPage","addcontract.jsp");
		return "admin/admin";
	}
	/**
	 * 签订合同
	 * @param model
	 * @param customer
	 * @return
	 */
	@RequestMapping("/addcontract")
	public String addcontract(Model model ,Contract contract){
		
		model.addAttribute("error","添加成功");
		contractService.addcontract(contract);
		model.addAttribute("contractlist",null);
		model.addAttribute("mainPage","addcontract.jsp");
		return "admin/admin";
	}
	/**
	 * 过户申请
	 * @param model
	 * @param page
	 * @param pageSize
	 * @return
	 */
	@RequestMapping("/totransferapply")
	public String totransferapply(Model model ,@RequestParam(required=false,defaultValue="1") Integer page,
            @RequestParam(required=false,defaultValue="10") Integer pageSize){
		
		PageHelper.startPage(page, pageSize);
		List<Contract> contractlist=contractService.selectAllContractByStatus("0");
		PageInfo<Contract> p=new PageInfo<Contract>(contractlist);
		model.addAttribute("p", p);
		model.addAttribute("contractlist",contractlist);
		model.addAttribute("mainPage","transferapply.jsp");
		return "admin/admin";
	}
	/**
	 * 过户申请
	 * @param model
	 * @param customer
	 * @return
	 */
	@RequestMapping("/transferapply")
	public String transferapply(Model model ,Contract contract){
		
		model.addAttribute("error","过户申请成功");
		contract.setStatus("2");
		contractService.updatecontractstatus(contract);
		model.addAttribute("contractlist",null);
		model.addAttribute("mainPage","transferapply.jsp");
		return "redirect:/contract/totransferapply.action";
		
	}
	/**
	 * 立契
	 * @param model
	 * @param page
	 * @param pageSize
	 * @return
	 */
	@RequestMapping("/tomakecontract")
	public String tomakecontract(Model model ,@RequestParam(required=false,defaultValue="1") Integer page,
            @RequestParam(required=false,defaultValue="10") Integer pageSize){
		
		PageHelper.startPage(page, pageSize);
		List<Contract> contractlist=contractService.selectAllContractByStatus("2");
		PageInfo<Contract> p=new PageInfo<Contract>(contractlist);
		model.addAttribute("p", p);
		model.addAttribute("contractlist",contractlist);
		model.addAttribute("mainPage","makecontract.jsp");
		return "admin/admin";
	}
	/**
	 * 立契
	 * @param model
	 * @param customer
	 * @return
	 */
	@RequestMapping("/makecontract")
	public String makecontract(Model model ,Contract contract){
		
		model.addAttribute("error","立契成功");
		contract.setStatus("4");
		contractService.updatecontractstatus(contract);
		model.addAttribute("contractlist",null);
		model.addAttribute("mainPage","makecontract.jsp");
		return "redirect:/contract/tomakecontract.action";
	}
	/**
	 * 缴纳税费
	 * @param model
	 * @param page
	 * @param pageSize
	 * @return
	 */
	@RequestMapping("/topaytaxes")
	public String topaytaxes(Model model ,@RequestParam(required=false,defaultValue="1") Integer page,
            @RequestParam(required=false,defaultValue="10") Integer pageSize){
		
		PageHelper.startPage(page, pageSize);
		List<Contract> contractlist=contractService.selectAllContractByStatus("4");
		PageInfo<Contract> p=new PageInfo<Contract>(contractlist);
		model.addAttribute("p", p);
		model.addAttribute("contractlist",contractlist);
		model.addAttribute("mainPage","paytaxes.jsp");
		return "admin/admin";
	}
	/**
	 * 缴纳税费
	 * @param model
	 * @param customer
	 * @return
	 */
	@RequestMapping("/paytaxes")
	public String paytaxes(Model model ,Contract contract){
		
		model.addAttribute("error","缴纳税费成功");
		contract.setStatus("6");
		contractService.updatecontractstatus(contract);
		model.addAttribute("contractlist",null);
		model.addAttribute("mainPage","paytaxes.jsp");
		return "redirect:/contract/topaytaxes.action";
	}
	/**
	 * 产权转移
	 * @param model
	 * @param page
	 * @param pageSize
	 * @return
	 */
	@RequestMapping("/tofinishcontract")
	public String tofinishcontract(Model model ,@RequestParam(required=false,defaultValue="1") Integer page,
            @RequestParam(required=false,defaultValue="10") Integer pageSize){
		
		PageHelper.startPage(page, pageSize);
		List<Contract> contractlist=contractService.selectAllContractByStatus("6");
		PageInfo<Contract> p=new PageInfo<Contract>(contractlist);
		model.addAttribute("p", p);
		model.addAttribute("contractlist",contractlist);
		model.addAttribute("mainPage","finishcontract.jsp");
		return "admin/admin";
	}
	/**
	 * 产权转移
	 * @param model
	 * @param customer
	 * @return
	 */
	@RequestMapping("/finishcontract")
	public String finishcontract(Model model ,Contract contract){
		
		model.addAttribute("error","产权转移完成");
		contract.setStatus("9");
		contractService.updatecontractstatus(contract);
		model.addAttribute("contractlist",null);
		model.addAttribute("mainPage","finishcontract.jsp");
		return "redirect:/contract/tofinishcontract.action";
	}
	/**
	 * 查看合同
	 * @param house_id
	 * @param model
	 * @return
	 */
	@RequestMapping("/seecontract")
	public String seecontract(String id,Model model){
		Contract contract = contractService.seecontract(id);
		model.addAttribute("contract", contract);
		model.addAttribute("mainPage", "contract.jsp");
		return "admin/admin";
	}
	/**
	 * 查看合同
	 * @param house_id
	 * @param model
	 * @return
	 */
	@RequestMapping("/seecontractforbuyer")
	public String seecontractforbuyer(String id,Model model){
		Contract contract = contractService.seecontract(id);
		model.addAttribute("contract", contract);
		model.addAttribute("mainPage", "contract.jsp");
		return "buyer/buyer";
	}
	/**
	 * 查看合同
	 * @param house_id
	 * @param model
	 * @return
	 */
	@RequestMapping("/seecontractforseller")
	public String seecontractforseller(String id,Model model){
		Contract contract = contractService.seecontract(id);
		model.addAttribute("contract", contract);
		model.addAttribute("mainPage", "contract.jsp");
		return "seller/seller";
	}
	/**
	 * 删除合同
	 * @param house_id
	 * @param model
	 * @return
	 */
	@RequestMapping("/deletecontract")
	public String deletecontract(String id,Model model){
		contractService.deletecontract(id);
		model.addAttribute("error", "deletesuccess");
		return "redirect:/contract/contractlist.action";
	}
	
	
	
	/**
	 * 合同信息列表
	 * @param model
	 * @param page
	 * @param pageSize
	 * @return
	 */
	@RequestMapping("/contractlistforcustomer")
	public String contractlistforbuyer(Model model ,@RequestParam(required=false,defaultValue="1") Integer page,
            @RequestParam(required=false,defaultValue="100") Integer pageSize,HttpSession httpSession){
		User user1= (User) httpSession.getAttribute("user");
		if ("buyer".equals(user1.getType())) {
			PageHelper.startPage(page, pageSize);
			List<Contract> contractlist=contractService.selectBuyerContractById(user1.getUsername());
			PageInfo<Contract> p=new PageInfo<Contract>(contractlist);
			model.addAttribute("p", p);
			model.addAttribute("contractlist",contractlist);
			model.addAttribute("mainPage","contractlist.jsp");
			return "buyer/buyer";
		}else if ("seller".equals(user1.getType())) {
			PageHelper.startPage(page, pageSize);
			List<Contract> contractlist=contractService.selectSellerContractById(user1.getUsername());
			PageInfo<Contract> p=new PageInfo<Contract>(contractlist);
			model.addAttribute("p", p);
			model.addAttribute("contractlist",contractlist);
			model.addAttribute("mainPage","contractlist.jsp");
			return "seller/seller";
		}else {
			PageHelper.startPage(page, pageSize);
			List<Contract> contractlist=contractService.selectAllContract();
			PageInfo<Contract> p=new PageInfo<Contract>(contractlist);
			model.addAttribute("p", p);
			model.addAttribute("contractlist",contractlist);
			model.addAttribute("mainPage","contractlist.jsp");
			return "admin/admin";
		}
	}
}
