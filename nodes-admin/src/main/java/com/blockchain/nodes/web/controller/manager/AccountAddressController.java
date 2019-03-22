package com.blockchain.nodes.web.controller.manager;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.blockchain.nodes.common.annotation.Log;
import com.blockchain.nodes.common.enums.BusinessType;
import com.blockchain.nodes.manager.domain.AccountAddress;
import com.blockchain.nodes.manager.service.IAccountAddressService;
import com.blockchain.nodes.framework.web.base.BaseController;
import com.blockchain.nodes.common.page.TableDataInfo;
import com.blockchain.nodes.common.base.AjaxResult;
import com.blockchain.nodes.common.utils.poi.ExcelUtil;

/**
 * 账户地址 信息操作处理
 * 
 * @author Gene Max
 * @date 2019-03-08
 */
@Controller
@RequestMapping("/manager/accountAddress")
public class AccountAddressController extends BaseController
{
    private String prefix = "manager/accountAddress";
	
	@Autowired
	private IAccountAddressService accountAddressService;
	
	@RequiresPermissions("manager:accountAddress:view")
	@GetMapping()
	public String accountAddress()
	{
	    return prefix + "/accountAddress";
	}
	
	/**
	 * 查询账户地址列表
	 */
	@RequiresPermissions("manager:accountAddress:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(AccountAddress accountAddress)
	{
		startPage();
        List<AccountAddress> list = accountAddressService.selectAccountAddressList(accountAddress);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出账户地址列表
	 */
	@RequiresPermissions("manager:accountAddress:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(AccountAddress accountAddress)
    {
    	List<AccountAddress> list = accountAddressService.selectAccountAddressList(accountAddress);
        ExcelUtil<AccountAddress> util = new ExcelUtil<AccountAddress>(AccountAddress.class);
        return util.exportExcel(list, "accountAddress");
    }
	
	/**
	 * 查询底层节点账号余额
	 */
	@RequiresPermissions("manager:accountAddress:list")
	@GetMapping("/getAddressBalance/{walletAddress}")
    @ResponseBody
    public AjaxResult getAddressBalance(@PathVariable("walletAddress") String walletAddress)
    {
		String walletBalance = accountAddressService.getAddressBalance(walletAddress);
        return AjaxResult.success(walletBalance);
    }
	
	/**
	 * 更新账号余额
	 */
	@RequiresPermissions("manager:accountAddress:edit")
	@GetMapping("/updateAddressBalance/{walletAddress}/{nodeWalletBalance}")
    @ResponseBody
    public AjaxResult updateAddressBalance(@PathVariable("walletAddress") String walletAddress,@PathVariable("nodeWalletBalance") String nodeWalletBalance)
    {
		int rs   = accountAddressService.updateAddressBalance(walletAddress,nodeWalletBalance);
		if(rs==1) {
			return success();
		}
		if(rs==0) {
			return error();
		}
		if(rs==-1) {
			return error("地址不存在");
		}
		return error();
    }
	
	/**
	 * 更新账号余额
	 */
	@RequiresPermissions("manager:accountAddress:edit")
	@GetMapping("/turnAddressBalance/{turnOutWalletAddress}/{turnInWalletAddress}/{walletBalance}")
    @ResponseBody
    public AjaxResult turnAddressBalance(@PathVariable("turnOutWalletAddress") String turnOutWalletAddress,@PathVariable("turnInWalletAddress") String turnInWalletAddress,@PathVariable("walletBalance") String walletBalance)
    {
		return  accountAddressService.turnAddressBalance(turnOutWalletAddress,turnInWalletAddress,walletBalance);
		
    }
	
	/**
	 * 新增账户地址
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存账户地址
	 */
	@RequiresPermissions("manager:accountAddress:add")
	@Log(title = "账户地址", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(AccountAddress accountAddress)
	{		
		int rs = accountAddressService.insertAccountAddress(accountAddress);
		if(rs==1) {
			return success();
		}
		if(rs==0) {
			return error();
		}
		if(rs==-1) {
			return error("手机号不存在");
		}
		if(rs==-2) {
			return error("快积分账号不能手动创建");
		}
		if(rs==-3) {
			return error("区块链积分地址创建异常");
		}
		return error();
	}

	/**
	 * 修改账户地址
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, ModelMap mmap)
	{
		AccountAddress accountAddress = accountAddressService.selectAccountAddressById(id);
		mmap.put("accountAddress", accountAddress);
	    return prefix + "/edit";
	}
	
	/**
	 * 跳转至同步节点余额页面
	 */
	@GetMapping("/goWalletBalance/{id}")
	public String goWalletBalance(@PathVariable("id") Long id, ModelMap mmap)
	{
		AccountAddress accountAddress = accountAddressService.selectAccountAddressById(id);
		mmap.put("accountAddress", accountAddress);
	    return prefix + "/walletBalance";
	}
	
	/**
	 * 跳转至转账页面
	 */
	@GetMapping("/goTurnWalletBalance/{id}")
	public String goTurnWalletBalance(@PathVariable("id") Long id, ModelMap mmap)
	{
		AccountAddress accountAddress = accountAddressService.selectAccountAddressById(id);
		mmap.put("accountAddress", accountAddress);
	    return prefix + "/transWallet";
	}
	
	/**
	 * 修改保存账户地址
	 */
	@RequiresPermissions("manager:accountAddress:edit")
	@Log(title = "账户地址", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(AccountAddress accountAddress)
	{		
		return toAjax(accountAddressService.updateAccountAddress(accountAddress));
	}
	
	/**
	 * 删除账户地址
	 */
	@RequiresPermissions("manager:accountAddress:remove")
	@Log(title = "账户地址", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(accountAddressService.deleteAccountAddressByIds(ids));
	}
	
}
