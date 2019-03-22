package com.blockchain.nodes.manager.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.blockchain.nodes.common.base.BaseEntity;
import java.util.Date;

/**
 * 账户地址表 t_account_address
 * 
 * @author Gene Max
 * @date 2019-03-08
 */
public class AccountAddress extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private Long id;
	/** 账户主键 */
	private Long accountId;
	/** 钱包地址 */
	private String walletAddress;
	/** 钱包别名 */
	private String walletAlias;
	/** 1快积分 2 BTC 3 ETH  */
	private String walletType;
	/** 余额实际值X10的8次方 */
	private Long walletBalance;
	/** 状态 1正常 2 冻解 3 禁用(删除） */
	private String status;
	/** 钱包所在节点 */
	private Integer nodeId;
	/** 余额验证 */
	private String sign;
	/** 创建时间 */
	private Date createTime;
	/** 更新时间 */
	private Date updateTime;
	
	 private String mobile;
	 
	 private String amount;//余额

	public void setId(Long id) 
	{
		this.id = id;
	}

	public Long getId() 
	{
		return id;
	}
	public void setAccountId(Long accountId) 
	{
		this.accountId = accountId;
	}

	public Long getAccountId() 
	{
		return accountId;
	}
	public void setWalletAddress(String walletAddress) 
	{
		this.walletAddress = walletAddress;
	}

	public String getWalletAddress() 
	{
		return walletAddress;
	}
	public void setWalletAlias(String walletAlias) 
	{
		this.walletAlias = walletAlias;
	}

	public String getWalletAlias() 
	{
		return walletAlias;
	}
	public void setWalletType(String walletType) 
	{
		this.walletType = walletType;
	}

	public String getWalletType() 
	{
		return walletType;
	}
	public void setWalletBalance(Long walletBalance) 
	{
		this.walletBalance = walletBalance;
	}

	public Long getWalletBalance() 
	{
		return walletBalance;
	}
	public void setStatus(String status) 
	{
		this.status = status;
	}

	public String getStatus() 
	{
		return status;
	}
	public void setNodeId(Integer nodeId) 
	{
		this.nodeId = nodeId;
	}

	public Integer getNodeId() 
	{
		return nodeId;
	}
	public void setSign(String sign) 
	{
		this.sign = sign;
	}

	public String getSign() 
	{
		return sign;
	}
	public void setCreateTime(Date createTime) 
	{
		this.createTime = createTime;
	}

	public Date getCreateTime() 
	{
		return createTime;
	}
	public void setUpdateTime(Date updateTime) 
	{
		this.updateTime = updateTime;
	}

	public Date getUpdateTime() 
	{
		return updateTime;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("accountId", getAccountId())
            .append("walletAddress", getWalletAddress())
            .append("walletAlias", getWalletAlias())
            .append("walletType", getWalletType())
            .append("walletBalance", getWalletBalance())
            .append("status", getStatus())
            .append("nodeId", getNodeId())
            .append("sign", getSign())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}
    
    
}
