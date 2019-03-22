package com.blockchain.nodes.manager.service.impl;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blockchain.nodes.common.crypto.AESUtils;
import com.blockchain.nodes.common.crypto.RC4;
import com.blockchain.nodes.common.crypto.SecurityUtil;
import com.blockchain.nodes.common.enums.UserStatus;
import com.blockchain.nodes.common.enums.WalletType;
import com.blockchain.nodes.common.support.Convert;
import com.blockchain.nodes.manager.domain.Account;
import com.blockchain.nodes.manager.domain.AccountAddress;
import com.blockchain.nodes.manager.domain.AccountInfo;
import com.blockchain.nodes.manager.mapper.AccountAddressMapper;
import com.blockchain.nodes.manager.mapper.AccountInfoMapper;
import com.blockchain.nodes.manager.mapper.AccountMapper;
import com.blockchain.nodes.manager.service.IAccountService;

/**
 * 账户 服务层实现
 * 
 * @author Gene Max
 * @date 2019-03-08
 */
@Service
public class AccountServiceImpl implements IAccountService 
{
	@Autowired
	private AccountMapper accountMapper;
	
	@Autowired
	private AccountInfoMapper accountInfoMapper;
	
	@Autowired
	private AccountAddressMapper accountAddressMapper;

	/**
     * 查询账户信息
     * 
     * @param id 账户ID
     * @return 账户信息
     */
    @Override
	public Account selectAccountById(Long id)
	{
	    return accountMapper.selectAccountById(id);
	}
	
	/**
     * 查询账户列表
     * 
     * @param account 账户信息
     * @return 账户集合
     */
	@Override
	public List<Account> selectAccountList(Account account)
	{
	    return accountMapper.selectAccountList(account);
	}
	
    /**
     * 新增账户
     * 
     * @param account 账户信息
     * @return 结果
     */
	@Override
	public int insertAccount(Account account)
	{
		
		String saltVal = SecurityUtil.getNewPsw();
		account.setSaltVal(saltVal);
		account.setCreateTime(new Date());
		Random rand = new Random();
		String usercode = String.valueOf(rand.nextInt(1000000000) + 1);
		account.setUserUniqueCode(usercode);
		String pwd = SecurityUtil.getStoreLogpwd(usercode, account.getLoginPasswd(), saltVal);
		// 生成加密后的登陆密码
		account.setLoginPasswd(pwd);
		accountMapper.insertAccount(account);
		
		AccountInfo accountInfo = new AccountInfo();
		BeanUtils.copyProperties(account, accountInfo);
		accountInfo.setAccountId(account.getId());
		accountInfoMapper.insertAccountInfo(accountInfo);
		//给用户创建快积分钱包
		AccountAddress  accountAddress = new AccountAddress();
		Long init=0L;
		accountAddress.setWalletAddress(account.getMobile());//用户换手机号这里需要更新
		accountAddress.setAccountId(account.getId());
		accountAddress.setWalletAlias(account.getMobile()+String.valueOf(account.getId()));
		accountAddress.setCreateTime(new Date());
		accountAddress.setStatus(UserStatus.OK.getCode());
		accountAddress.setUpdateTime(new Date());
		accountAddress.setWalletBalance(init);
		accountAddress.setWalletType(WalletType.QSCORE.getCode());
		accountAddress.setNodeId(1);
		accountAddress.setSign(SecurityUtil.getSHA256Str(String.valueOf(init)));
		
	    return accountAddressMapper.insertAccountAddress(accountAddress);
	}
	
	/**
     * 修改账户
     * 
     * @param account 账户信息
     * @return 结果
     */
	@Override
	public int updateAccount(Account account)
	{
		AccountInfo accountInfo = new AccountInfo();
		BeanUtils.copyProperties(account, accountInfo);
		accountInfo.setAccountId(account.getId());
		accountInfoMapper.updateAccountInfo(accountInfo);
		
		String saltVal = SecurityUtil.getNewPsw();
		account.setSaltVal(saltVal);
		Random rand = new Random();
		String usercode = String.valueOf(rand.nextInt(1000000000) + 1);
		account.setUserUniqueCode(usercode);
		String pwd = SecurityUtil.getStoreLogpwd(usercode, account.getLoginPasswd(), saltVal);
		// 生成加密后的登陆密码
		account.setLoginPasswd(pwd);
		accountMapper.updateAccount(account);
		AccountAddress  accountAddress = new AccountAddress();
		accountAddress.setAccountId(account.getId());
		accountAddress.setWalletAddress(account.getMobile());
		accountAddress.setUpdateTime(new Date());
	    return accountAddressMapper.updateAccountQScoreAddress(accountAddress);
	}

	/**
     * 删除账户对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteAccountByIds(String ids)
	{
		return accountMapper.deleteAccountByIds(Convert.toStrArray(ids));
	}
	
}
