package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Pojo.Contract;
import dao.ContractMapper;

@Service
public class ContractServiceImpl implements ContractService {
	
	@Autowired
	private ContractMapper contractMapper;
	



	@Override
	public List<Contract> selectAllContract() {
		List<Contract> contractlist=contractMapper.selectAllContract();
		return contractlist;
	}




	@Override
	public void addcontract(Contract contract) {
		contractMapper.addcontract(contract);		
	}




	@Override
	public List<Contract> selectAllContractByStatus(String status) {
		List<Contract> contractlist = contractMapper.selectAllContractByStatus(status);
		return contractlist;
	}




	@Override
	public void updatecontractstatus(Contract contract) {
		contractMapper.updatecontractstatus(contract);
	}




	@Override
	public Contract seecontract(String id) {
		Contract contract = contractMapper.seecontract(id);
		return contract;
	}




	@Override
	public void deletecontract(String id) {
		contractMapper.deletecontract(id);
	}




	@Override
	public List<Contract> selectBuyerContractById(String buyerid) {
		List<Contract> contractlist = contractMapper.selectBuyerContractById(buyerid);
		return contractlist;
	}




	@Override
	public List<Contract> selectSellerContractById(String sellerid) {
		List<Contract> contractlist = contractMapper.selectSellerContractById(sellerid);
		return contractlist;
	}

	
}
