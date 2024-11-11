package service;

import java.util.List;

import Pojo.Contract;

public interface ContractService {
	List<Contract> selectAllContract();
	void addcontract(Contract contract);
	List<Contract> selectAllContractByStatus(String status);
	void updatecontractstatus(Contract contract);
	Contract seecontract(String id);
	void deletecontract(String id);
	List<Contract> selectBuyerContractById(String buyerid);
	List<Contract> selectSellerContractById(String sellerid);
}
