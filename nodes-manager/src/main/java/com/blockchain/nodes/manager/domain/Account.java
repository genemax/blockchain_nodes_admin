package com.blockchain.nodes.manager.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.blockchain.nodes.common.base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * 账户表 t_account
 * 
 * @author Gene Max
 * @date 2019-03-08
 */
public class Account extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 主键 */
	private Long id;
	/** 账号 */
	private String userName;
	/** 注册手机号 */
	private String mobile;
	/** 注册邮箱 */
	private String email;
	/** 性别1 男 2 女 3 保密 */
	private String sex;
	/** 登录密码 */
	private String loginPasswd;
	/** 支付密码 */
	private String payPasswd;
	/** 1 正常 2 活动用户 3 停用 4 禁用 */
	private String status;
	/** 盐值 */
	private String saltVal;
	/** 加密码 */
	private String userUniqueCode;
	/**  */
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date createTime;
	
	/** 实名信息 */
	private String realName;
	/** 证件编码 身份证 驾驶证 护照 */
	private String certificateCode;
	/** 证件类型 1 身份证 2 香港身份证 3、澳门身份证 4、台湾身份证 5 护照 6 National identity card */
	private String certificateType;
	/**  */
	private String facePhoto;
	/**  */
	private String backPhoto;
	/** 手持 */
	private String handPhoto;
	/** 照片审核状态 1草稿 2 待审核  4未通过 5 审核通过  */
	private String checkStatus;
	/** 提交日期 */
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date submitDate;
	/** 审核时间 */
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date examineDate;
	/** 审核驳回内容 */
	private String checkContent;
	/** 最后登录时间 */
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date lastLoginDate;
	/** 禁用理由 */
	private String unuseReason;
	/** 备注 */
	private String remarks;
	
	private String orderType;
	
	private String passcode;

	
	public void setRealName(String realName) 
	{
		this.realName = realName;
	}

	public String getRealName() 
	{
		return realName;
	}
	public void setCertificateCode(String certificateCode) 
	{
		this.certificateCode = certificateCode;
	}

	public String getCertificateCode() 
	{
		return certificateCode;
	}
	public void setCertificateType(String certificateType) 
	{
		this.certificateType = certificateType;
	}

	public String getCertificateType() 
	{
		return certificateType;
	}
	public void setFacePhoto(String facePhoto) 
	{
		this.facePhoto = facePhoto;
	}

	public String getFacePhoto() 
	{
		return facePhoto;
	}
	public void setBackPhoto(String backPhoto) 
	{
		this.backPhoto = backPhoto;
	}

	public String getBackPhoto() 
	{
		return backPhoto;
	}
	public void setHandPhoto(String handPhoto) 
	{
		this.handPhoto = handPhoto;
	}

	public String getHandPhoto() 
	{
		return handPhoto;
	}
	public void setCheckStatus(String checkStatus) 
	{
		this.checkStatus = checkStatus;
	}

	public String getCheckStatus() 
	{
		return checkStatus;
	}
	public void setSubmitDate(Date submitDate) 
	{
		this.submitDate = submitDate;
	}

	public Date getSubmitDate() 
	{
		return submitDate;
	}
	public void setExamineDate(Date examineDate) 
	{
		this.examineDate = examineDate;
	}

	public Date getExamineDate() 
	{
		return examineDate;
	}
	public void setCheckContent(String checkContent) 
	{
		this.checkContent = checkContent;
	}

	public String getCheckContent() 
	{
		return checkContent;
	}
	public void setLastLoginDate(Date lastLoginDate) 
	{
		this.lastLoginDate = lastLoginDate;
	}

	public Date getLastLoginDate() 
	{
		return lastLoginDate;
	}
	public void setUnuseReason(String unuseReason) 
	{
		this.unuseReason = unuseReason;
	}

	public String getUnuseReason() 
	{
		return unuseReason;
	}
	public void setRemarks(String remarks) 
	{
		this.remarks = remarks;
	}

	public String getRemarks() 
	{
		return remarks;
	}

	public void setId(Long id) 
	{
		this.id = id;
	}

	public Long getId() 
	{
		return id;
	}
	public void setUserName(String userName) 
	{
		this.userName = userName;
	}

	public String getUserName() 
	{
		return userName;
	}
	public void setMobile(String mobile) 
	{
		this.mobile = mobile;
	}

	public String getMobile() 
	{
		return mobile;
	}
	public void setEmail(String email) 
	{
		this.email = email;
	}

	public String getEmail() 
	{
		return email;
	}
	public void setSex(String sex) 
	{
		this.sex = sex;
	}

	public String getSex() 
	{
		return sex;
	}
	public void setLoginPasswd(String loginPasswd) 
	{
		this.loginPasswd = loginPasswd;
	}

	public String getLoginPasswd() 
	{
		return loginPasswd;
	}
	public void setPayPasswd(String payPasswd) 
	{
		this.payPasswd = payPasswd;
	}

	public String getPayPasswd() 
	{
		return payPasswd;
	}
	public void setStatus(String status) 
	{
		this.status = status;
	}

	public String getStatus() 
	{
		return status;
	}
	public void setSaltVal(String saltVal) 
	{
		this.saltVal = saltVal;
	}

	public String getSaltVal() 
	{
		return saltVal;
	}
	public void setUserUniqueCode(String userUniqueCode) 
	{
		this.userUniqueCode = userUniqueCode;
	}

	public String getUserUniqueCode() 
	{
		return userUniqueCode;
	}
	public void setCreateTime(Date createTime) 
	{
		this.createTime = createTime;
	}

	public Date getCreateTime() 
	{
		return createTime;
	}

    public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	
	

	public String getPasscode() {
		return passcode;
	}

	public void setPasscode(String passcode) {
		this.passcode = passcode;
	}

	public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userName", getUserName())
            .append("mobile", getMobile())
            .append("email", getEmail())
            .append("sex", getSex())
            .append("loginPasswd", getLoginPasswd())
            .append("payPasswd", getPayPasswd())
            .append("status", getStatus())
            .append("saltVal", getSaltVal())
            .append("userUniqueCode", getUserUniqueCode())
            .append("createTime", getCreateTime())
            .toString();
    }
}
