package com.vote.bean;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


/**
 * @Title: Entity
 * @Description: 学生
 * @author zhangdaihao
 * @date 2016-04-19 10:37:29
 * @version V1.0
 *
 */
public class TblStudentEntity implements java.io.Serializable {
	/**学生表编号*/
	private java.lang.String id;
	/**创建时间*/
	private java.util.Date createDate;
	/**最近更新日期*/
	private java.util.Date updateDate;
	/**删除标志*/
	private java.lang.String deleted;
	/**学号*/
	private java.lang.String xh;
	/**姓名*/
	private java.lang.String xm;
	/**英文姓名*/
	private java.lang.String ywxm;
	/**是否生僻字*/
	private java.lang.String sfspz;
	/**姓名拼音*/
	private java.lang.String xmpy;
	/**曾用名*/
	private java.lang.String cym;
	/**性别码*/
	private java.lang.String xbm;
	/**出生日期*/
	private java.util.Date csrq;
	/**出生地码*/
	private java.lang.String csdm;
	/**学生来源码*/
	private java.lang.String xslym;
	/**出生地省份码*/
	private java.lang.String csdsf;
	/**来源地省份码*/
	private java.lang.String lydsf;
	/**来源地区码码*/
	private java.lang.String lydqm;
	/**籍贯*/
	private java.lang.String jg;
	/**民族码*/
	private java.lang.String mzm;
	/**国籍/地区码*/
	private java.lang.String gjdqm;
	/**身份证件类型码*/
	private java.lang.String sfzjlxm;
	/**身份证件号*/
	private java.lang.String sfzjh;
	/**身份证件有效期*/
	private java.lang.String sfzjyxq;
	/**上海居住证类型，参照T_BZ_JZZLX A 国内引进人才居住证，B 国 外引进人才居住证，C 临时居住证*/
	private java.lang.String jzzlxm;
	/**上海居住证号码*/
	private java.lang.String jzzhm;
	/**上海居住证有效期*/
	private java.lang.String jzzyxq;
	/**1.上海市居住证积分是否达到标准分值*/
	private java.lang.String jzzjfsfddmz;
	/**2.上海市临时居住证是否持有灵活就业登记证明
	 */
	private java.lang.String lsjzzsfcylhjydj;
	/**3.上海市居住证（海外证）编号*/
	private java.lang.String jzzhwhm;
	/**婚姻状况码*/
	private java.lang.String hyzkm;
	/**港澳台侨外码*/
	private java.lang.String gatqwm;
	/**政治面貌码*/
	private java.lang.String zzmmm;
	/**健康状况码*/
	private java.lang.String jkzkm;
	/**信仰宗教码*/
	private java.lang.String zjxym;
	/**血型码*/
	private java.lang.String xxm;
	/**照片*/
	private java.lang.String zp;
	/**特长*/
	private java.lang.String tc;
	/**户籍街道*/
	private java.lang.String hjjd;
	/**户口性质，参照T_BZ_HKXZ，0未落常住户口(袋袋户口)，1非农业家庭户口，2农业家庭户口，3非农业集体户口，4农业集体户口，8其他户口*/
	private java.lang.String hkxz;
	/**户口所属省份*/
	private java.lang.String hksf;
	/**户口所属区县ID，参照数据标准 T_BZ_XZQ
	 */
	private java.lang.String hkqx;
	/**户口详细地址，学生户籍地址。外籍？*/
	private java.lang.String hkdz;
	/**残疾人类型码*/
	private java.lang.String cjlxm;
	/**是否独生子女*/
	private java.lang.String sfdszn;
	/**是否父母一方为上海户口*/
	private java.lang.String fmsfshhk;
	/**是否受过学前教育*/
	private java.lang.String xqjy;
	/**是否留守儿童*/
	private java.lang.String sflset;
	/**是否流动人口*/
	private java.lang.String ldrk;
	/**是否进城务工人员随迁子女*/
	private java.lang.String sqzn;
	/**是否外来务工人员子女*/
	private java.lang.String sfwlwgryzn;
	/**是否孤儿*/
	private java.lang.String sfge;
	/**是否烈士或优抚子女*/
	private java.lang.String sflshyfzn;
	/**是否提交真实材料*/
	private java.lang.String sftjzscl;
	/**是否需要乘坐校车*/
	private java.lang.String sfxyczxc;
	/**是否购买学位，民办学校学生，由政府出资接受教育。0-否，1-是*/
	private java.lang.String gmxw;
	/**是否需要申请资助,1是0否*/
	private java.lang.String sfsqzz;
	/**是否享受一补,1是0否*/
	private java.lang.String sfxsyb;
	/**是否寄宿生,1是0否 学生来源码,来自T_BZ_XSLY*/
	private java.lang.String sfjss;
	/**现住地区县代码，参照数据标准 T_BZ_XZQ*/
	private java.lang.String xzdqx;
	/**现住址，学生现在居住的地址*/
	private java.lang.String xzz;
	/**现住址邮政编码*/
	private java.lang.String xzzyzbm;
	/**联系电话，学生的联系固定电话或者手机号码*/
	private java.lang.String lxdh;
	/**电子信箱*/
	private java.lang.String dzxx;
	/**通信地址*/
	private java.lang.String txdz;
	/**通信地址邮政编码*/
	private java.lang.String yzbm;
	/**主页地址*/
	private java.lang.String zydz;
	/**备注*/
	private java.lang.String bz;
	/**所属区县代码*/
	private java.lang.String ssqxdm;
	/**入学年月*/
	private java.lang.String rxny;
	/**入学方式*/
	private java.lang.String rxfsm;
	/**学生类别码*/
	private java.lang.String xslbm;
	/**学制*/
	private java.lang.String xz;
	/**专业码*/
	private java.lang.String zym;
	/**学生当前状态码*/
	private java.lang.String xsdqztm;
	/**班级代码*/
	private java.lang.String bjdm;
	/**年级代码*/
	private java.lang.String njdm;
	/**全国学籍号*/
	private java.lang.String qgxjh;
	/**学籍副号*/
	private java.lang.String xjh;
	/**学段*/
	private java.lang.String xdm;
	/**学校名称*/
	private java.lang.String xxmc;
	/**学校代码*/
	private java.lang.String xxdm;
	/**学籍校区*/
	private java.lang.String xqdm;
	/**就读方式，参照T_BZ_JDFS，1 走读，2 住校，9 其他*/
	private java.lang.String jdfsm;

	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  学生表编号
	 */

	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@Column(name ="ID",nullable=false,length=36)
	public java.lang.String getId(){
		return this.id;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  学生表编号
	 */
	public void setId(java.lang.String id){
		this.id = id;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  创建时间
	 */
	@Column(name ="CREATE_DATE",nullable=true)
	public java.util.Date getCreateDate(){
		return this.createDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  创建时间
	 */
	public void setCreateDate(java.util.Date createDate){
		this.createDate = createDate;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  最近更新日期
	 */
	@Column(name ="UPDATE_DATE",nullable=true)
	public java.util.Date getUpdateDate(){
		return this.updateDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  最近更新日期
	 */
	public void setUpdateDate(java.util.Date updateDate){
		this.updateDate = updateDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  删除标志
	 */
	@Column(name ="DELETED",nullable=true,length=5)
	public java.lang.String getDeleted(){
		return this.deleted;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  删除标志
	 */
	public void setDeleted(java.lang.String deleted){
		this.deleted = deleted;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  学号
	 */
	@Column(name ="XH",nullable=true,length=20)
	public java.lang.String getXh(){
		return this.xh;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  学号
	 */
	public void setXh(java.lang.String xh){
		this.xh = xh;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  姓名
	 */
	@Column(name ="XM",nullable=true,length=50)
	public java.lang.String getXm(){
		return this.xm;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  姓名
	 */
	public void setXm(java.lang.String xm){
		this.xm = xm;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  英文姓名
	 */
	@Column(name ="YWXM",nullable=true,length=30)
	public java.lang.String getYwxm(){
		return this.ywxm;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  英文姓名
	 */
	public void setYwxm(java.lang.String ywxm){
		this.ywxm = ywxm;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  是否生僻字
	 */
	@Column(name ="SFSPZ",nullable=true,length=5)
	public java.lang.String getSfspz(){
		return this.sfspz;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  是否生僻字
	 */
	public void setSfspz(java.lang.String sfspz){
		this.sfspz = sfspz;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  姓名拼音
	 */
	@Column(name ="XMPY",nullable=true,length=50)
	public java.lang.String getXmpy(){
		return this.xmpy;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  姓名拼音
	 */
	public void setXmpy(java.lang.String xmpy){
		this.xmpy = xmpy;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  曾用名
	 */
	@Column(name ="CYM",nullable=true,length=30)
	public java.lang.String getCym(){
		return this.cym;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  曾用名
	 */
	public void setCym(java.lang.String cym){
		this.cym = cym;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  性别码
	 */
	@Column(name ="XBM",nullable=true,length=20)
	public java.lang.String getXbm(){
		return this.xbm;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  性别码
	 */
	public void setXbm(java.lang.String xbm){
		this.xbm = xbm;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  出生日期
	 */
	@Column(name ="CSRQ",nullable=true)
	public java.util.Date getCsrq(){
		return this.csrq;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  出生日期
	 */
	public void setCsrq(java.util.Date csrq){
		this.csrq = csrq;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  出生地码
	 */
	@Column(name ="CSDM",nullable=true,length=20)
	public java.lang.String getCsdm(){
		return this.csdm;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  出生地码
	 */
	public void setCsdm(java.lang.String csdm){
		this.csdm = csdm;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  学生来源码
	 */
	@Column(name ="XSLYM",nullable=true,length=20)
	public java.lang.String getXslym(){
		return this.xslym;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  学生来源码
	 */
	public void setXslym(java.lang.String xslym){
		this.xslym = xslym;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  出生地省份码
	 */
	@Column(name ="CSDSF",nullable=true,length=20)
	public java.lang.String getCsdsf(){
		return this.csdsf;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  出生地省份码
	 */
	public void setCsdsf(java.lang.String csdsf){
		this.csdsf = csdsf;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  来源地省份码
	 */
	@Column(name ="LYDSF",nullable=true,length=20)
	public java.lang.String getLydsf(){
		return this.lydsf;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  来源地省份码
	 */
	public void setLydsf(java.lang.String lydsf){
		this.lydsf = lydsf;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  来源地区码码
	 */
	@Column(name ="LYDQM",nullable=true,length=20)
	public java.lang.String getLydqm(){
		return this.lydqm;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  来源地区码码
	 */
	public void setLydqm(java.lang.String lydqm){
		this.lydqm = lydqm;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  籍贯
	 */
	@Column(name ="JG",nullable=true,length=20)
	public java.lang.String getJg(){
		return this.jg;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  籍贯
	 */
	public void setJg(java.lang.String jg){
		this.jg = jg;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  民族码
	 */
	@Column(name ="MZM",nullable=true,length=20)
	public java.lang.String getMzm(){
		return this.mzm;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  民族码
	 */
	public void setMzm(java.lang.String mzm){
		this.mzm = mzm;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  国籍/地区码
	 */
	@Column(name ="GJDQM",nullable=true,length=20)
	public java.lang.String getGjdqm(){
		return this.gjdqm;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  国籍/地区码
	 */
	public void setGjdqm(java.lang.String gjdqm){
		this.gjdqm = gjdqm;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  身份证件类型码
	 */
	@Column(name ="SFZJLXM",nullable=true,length=20)
	public java.lang.String getSfzjlxm(){
		return this.sfzjlxm;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  身份证件类型码
	 */
	public void setSfzjlxm(java.lang.String sfzjlxm){
		this.sfzjlxm = sfzjlxm;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  身份证件号
	 */
	@Column(name ="SFZJH",nullable=true,length=30)
	public java.lang.String getSfzjh(){
		return this.sfzjh;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  身份证件号
	 */
	public void setSfzjh(java.lang.String sfzjh){
		this.sfzjh = sfzjh;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  身份证件有效期
	 */
	@Column(name ="SFZJYXQ",nullable=true,length=7)
	public java.lang.String getSfzjyxq(){
		return this.sfzjyxq;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  身份证件有效期
	 */
	public void setSfzjyxq(java.lang.String sfzjyxq){
		this.sfzjyxq = sfzjyxq;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  上海居住证类型，参照T_BZ_JZZLX A 国内引进人才居住证，B 国 外引进人才居住证，C 临时居住证
	 */
	@Column(name ="JZZLXM",nullable=true,length=20)
	public java.lang.String getJzzlxm(){
		return this.jzzlxm;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  上海居住证类型，参照T_BZ_JZZLX A 国内引进人才居住证，B 国 外引进人才居住证，C 临时居住证
	 */
	public void setJzzlxm(java.lang.String jzzlxm){
		this.jzzlxm = jzzlxm;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  上海居住证号码
	 */
	@Column(name ="JZZHM",nullable=true,length=50)
	public java.lang.String getJzzhm(){
		return this.jzzhm;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  上海居住证号码
	 */
	public void setJzzhm(java.lang.String jzzhm){
		this.jzzhm = jzzhm;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  上海居住证有效期
	 */
	@Column(name ="JZZYXQ",nullable=true,length=7)
	public java.lang.String getJzzyxq(){
		return this.jzzyxq;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  上海居住证有效期
	 */
	public void setJzzyxq(java.lang.String jzzyxq){
		this.jzzyxq = jzzyxq;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  1.上海市居住证积分是否达到标准分值
	 */
	@Column(name ="JZZJFSFDDMZ",nullable=true,length=20)
	public java.lang.String getJzzjfsfddmz(){
		return this.jzzjfsfddmz;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  1.上海市居住证积分是否达到标准分值
	 */
	public void setJzzjfsfddmz(java.lang.String jzzjfsfddmz){
		this.jzzjfsfddmz = jzzjfsfddmz;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  2.上海市临时居住证是否持有灵活就业登记证明

	 */
	@Column(name ="LSJZZSFCYLHJYDJ",nullable=true,length=20)
	public java.lang.String getLsjzzsfcylhjydj(){
		return this.lsjzzsfcylhjydj;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  2.上海市临时居住证是否持有灵活就业登记证明

	 */
	public void setLsjzzsfcylhjydj(java.lang.String lsjzzsfcylhjydj){
		this.lsjzzsfcylhjydj = lsjzzsfcylhjydj;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  3.上海市居住证（海外证）编号
	 */
	@Column(name ="JZZHWHM",nullable=true,length=20)
	public java.lang.String getJzzhwhm(){
		return this.jzzhwhm;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  3.上海市居住证（海外证）编号
	 */
	public void setJzzhwhm(java.lang.String jzzhwhm){
		this.jzzhwhm = jzzhwhm;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  婚姻状况码
	 */
	@Column(name ="HYZKM",nullable=true,length=20)
	public java.lang.String getHyzkm(){
		return this.hyzkm;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  婚姻状况码
	 */
	public void setHyzkm(java.lang.String hyzkm){
		this.hyzkm = hyzkm;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  港澳台侨外码
	 */
	@Column(name ="GATQWM",nullable=true,length=20)
	public java.lang.String getGatqwm(){
		return this.gatqwm;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  港澳台侨外码
	 */
	public void setGatqwm(java.lang.String gatqwm){
		this.gatqwm = gatqwm;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  政治面貌码
	 */
	@Column(name ="ZZMMM",nullable=true,length=20)
	public java.lang.String getZzmmm(){
		return this.zzmmm;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  政治面貌码
	 */
	public void setZzmmm(java.lang.String zzmmm){
		this.zzmmm = zzmmm;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  健康状况码
	 */
	@Column(name ="JKZKM",nullable=true,length=20)
	public java.lang.String getJkzkm(){
		return this.jkzkm;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  健康状况码
	 */
	public void setJkzkm(java.lang.String jkzkm){
		this.jkzkm = jkzkm;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  信仰宗教码
	 */
	@Column(name ="ZJXYM",nullable=true,length=20)
	public java.lang.String getZjxym(){
		return this.zjxym;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  信仰宗教码
	 */
	public void setZjxym(java.lang.String zjxym){
		this.zjxym = zjxym;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  血型码
	 */
	@Column(name ="XXM",nullable=true,length=20)
	public java.lang.String getXxm(){
		return this.xxm;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  血型码
	 */
	public void setXxm(java.lang.String xxm){
		this.xxm = xxm;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  照片
	 */
	@Column(name ="ZP",nullable=true,length=300)
	public java.lang.String getZp(){
		return this.zp;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  照片
	 */
	public void setZp(java.lang.String zp){
		this.zp = zp;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  特长
	 */
	@Column(name ="TC",nullable=true,length=1000)
	public java.lang.String getTc(){
		return this.tc;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  特长
	 */
	public void setTc(java.lang.String tc){
		this.tc = tc;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  户籍街道
	 */
	@Column(name ="HJJD",nullable=true,length=100)
	public java.lang.String getHjjd(){
		return this.hjjd;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  户籍街道
	 */
	public void setHjjd(java.lang.String hjjd){
		this.hjjd = hjjd;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  户口性质，参照T_BZ_HKXZ，0未落常住户口(袋袋户口)，1非农业家庭户口，2农业家庭户口，3非农业集体户口，4农业集体户口，8其他户口
	 */
	@Column(name ="HKXZ",nullable=true,length=50)
	public java.lang.String getHkxz(){
		return this.hkxz;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  户口性质，参照T_BZ_HKXZ，0未落常住户口(袋袋户口)，1非农业家庭户口，2农业家庭户口，3非农业集体户口，4农业集体户口，8其他户口
	 */
	public void setHkxz(java.lang.String hkxz){
		this.hkxz = hkxz;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  户口所属省份
	 */
	@Column(name ="HKSF",nullable=true,length=50)
	public java.lang.String getHksf(){
		return this.hksf;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  户口所属省份
	 */
	public void setHksf(java.lang.String hksf){
		this.hksf = hksf;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  户口所属区县ID，参照数据标准 T_BZ_XZQ

	 */
	@Column(name ="HKQX",nullable=true,length=50)
	public java.lang.String getHkqx(){
		return this.hkqx;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  户口所属区县ID，参照数据标准 T_BZ_XZQ

	 */
	public void setHkqx(java.lang.String hkqx){
		this.hkqx = hkqx;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  户口详细地址，学生户籍地址。外籍？
	 */
	@Column(name ="HKDZ",nullable=true,length=200)
	public java.lang.String getHkdz(){
		return this.hkdz;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  户口详细地址，学生户籍地址。外籍？
	 */
	public void setHkdz(java.lang.String hkdz){
		this.hkdz = hkdz;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  残疾人类型码
	 */
	@Column(name ="CJLXM",nullable=true,length=20)
	public java.lang.String getCjlxm(){
		return this.cjlxm;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  残疾人类型码
	 */
	public void setCjlxm(java.lang.String cjlxm){
		this.cjlxm = cjlxm;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  是否独生子女
	 */
	@Column(name ="SFDSZN",nullable=true,length=5)
	public java.lang.String getSfdszn(){
		return this.sfdszn;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  是否独生子女
	 */
	public void setSfdszn(java.lang.String sfdszn){
		this.sfdszn = sfdszn;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  是否父母一方为上海户口
	 */
	@Column(name ="FMSFSHHK",nullable=true,length=5)
	public java.lang.String getFmsfshhk(){
		return this.fmsfshhk;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  是否父母一方为上海户口
	 */
	public void setFmsfshhk(java.lang.String fmsfshhk){
		this.fmsfshhk = fmsfshhk;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  是否受过学前教育
	 */
	@Column(name ="XQJY",nullable=true,length=5)
	public java.lang.String getXqjy(){
		return this.xqjy;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  是否受过学前教育
	 */
	public void setXqjy(java.lang.String xqjy){
		this.xqjy = xqjy;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  是否留守儿童
	 */
	@Column(name ="SFLSET",nullable=true,length=5)
	public java.lang.String getSflset(){
		return this.sflset;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  是否留守儿童
	 */
	public void setSflset(java.lang.String sflset){
		this.sflset = sflset;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  是否流动人口
	 */
	@Column(name ="LDRK",nullable=true,length=5)
	public java.lang.String getLdrk(){
		return this.ldrk;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  是否流动人口
	 */
	public void setLdrk(java.lang.String ldrk){
		this.ldrk = ldrk;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  是否进城务工人员随迁子女
	 */
	@Column(name ="SQZN",nullable=true,length=5)
	public java.lang.String getSqzn(){
		return this.sqzn;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  是否进城务工人员随迁子女
	 */
	public void setSqzn(java.lang.String sqzn){
		this.sqzn = sqzn;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  是否外来务工人员子女
	 */
	@Column(name ="SFWLWGRYZN",nullable=true,length=5)
	public java.lang.String getSfwlwgryzn(){
		return this.sfwlwgryzn;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  是否外来务工人员子女
	 */
	public void setSfwlwgryzn(java.lang.String sfwlwgryzn){
		this.sfwlwgryzn = sfwlwgryzn;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  是否孤儿
	 */
	@Column(name ="SFGE",nullable=true,length=5)
	public java.lang.String getSfge(){
		return this.sfge;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  是否孤儿
	 */
	public void setSfge(java.lang.String sfge){
		this.sfge = sfge;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  是否烈士或优抚子女
	 */
	@Column(name ="SFLSHYFZN",nullable=true,length=5)
	public java.lang.String getSflshyfzn(){
		return this.sflshyfzn;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  是否烈士或优抚子女
	 */
	public void setSflshyfzn(java.lang.String sflshyfzn){
		this.sflshyfzn = sflshyfzn;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  是否提交真实材料
	 */
	@Column(name ="SFTJZSCL",nullable=true,length=5)
	public java.lang.String getSftjzscl(){
		return this.sftjzscl;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  是否提交真实材料
	 */
	public void setSftjzscl(java.lang.String sftjzscl){
		this.sftjzscl = sftjzscl;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  是否需要乘坐校车
	 */
	@Column(name ="SFXYCZXC",nullable=true,length=5)
	public java.lang.String getSfxyczxc(){
		return this.sfxyczxc;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  是否需要乘坐校车
	 */
	public void setSfxyczxc(java.lang.String sfxyczxc){
		this.sfxyczxc = sfxyczxc;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  是否购买学位，民办学校学生，由政府出资接受教育。0-否，1-是
	 */
	@Column(name ="GMXW",nullable=true,length=50)
	public java.lang.String getGmxw(){
		return this.gmxw;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  是否购买学位，民办学校学生，由政府出资接受教育。0-否，1-是
	 */
	public void setGmxw(java.lang.String gmxw){
		this.gmxw = gmxw;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  是否需要申请资助,1是0否
	 */
	@Column(name ="SFSQZZ",nullable=true,length=50)
	public java.lang.String getSfsqzz(){
		return this.sfsqzz;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  是否需要申请资助,1是0否
	 */
	public void setSfsqzz(java.lang.String sfsqzz){
		this.sfsqzz = sfsqzz;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  是否享受一补,1是0否
	 */
	@Column(name ="SFXSYB",nullable=true,length=50)
	public java.lang.String getSfxsyb(){
		return this.sfxsyb;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  是否享受一补,1是0否
	 */
	public void setSfxsyb(java.lang.String sfxsyb){
		this.sfxsyb = sfxsyb;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  是否寄宿生,1是0否 学生来源码,来自T_BZ_XSLY
	 */
	@Column(name ="SFJSS",nullable=true,length=50)
	public java.lang.String getSfjss(){
		return this.sfjss;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  是否寄宿生,1是0否 学生来源码,来自T_BZ_XSLY
	 */
	public void setSfjss(java.lang.String sfjss){
		this.sfjss = sfjss;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  现住地区县代码，参照数据标准 T_BZ_XZQ
	 */
	@Column(name ="XZDQX",nullable=true,length=50)
	public java.lang.String getXzdqx(){
		return this.xzdqx;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  现住地区县代码，参照数据标准 T_BZ_XZQ
	 */
	public void setXzdqx(java.lang.String xzdqx){
		this.xzdqx = xzdqx;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  现住址，学生现在居住的地址
	 */
	@Column(name ="XZZ",nullable=true,length=200)
	public java.lang.String getXzz(){
		return this.xzz;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  现住址，学生现在居住的地址
	 */
	public void setXzz(java.lang.String xzz){
		this.xzz = xzz;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  现住址邮政编码
	 */
	@Column(name ="XZZYZBM",nullable=true,length=50)
	public java.lang.String getXzzyzbm(){
		return this.xzzyzbm;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  现住址邮政编码
	 */
	public void setXzzyzbm(java.lang.String xzzyzbm){
		this.xzzyzbm = xzzyzbm;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  联系电话，学生的联系固定电话或者手机号码
	 */
	@Column(name ="LXDH",nullable=true,length=50)
	public java.lang.String getLxdh(){
		return this.lxdh;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  联系电话，学生的联系固定电话或者手机号码
	 */
	public void setLxdh(java.lang.String lxdh){
		this.lxdh = lxdh;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  电子信箱
	 */
	@Column(name ="DZXX",nullable=true,length=50)
	public java.lang.String getDzxx(){
		return this.dzxx;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  电子信箱
	 */
	public void setDzxx(java.lang.String dzxx){
		this.dzxx = dzxx;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  通信地址
	 */
	@Column(name ="TXDZ",nullable=true,length=200)
	public java.lang.String getTxdz(){
		return this.txdz;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  通信地址
	 */
	public void setTxdz(java.lang.String txdz){
		this.txdz = txdz;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  通信地址邮政编码
	 */
	@Column(name ="YZBM",nullable=true,length=50)
	public java.lang.String getYzbm(){
		return this.yzbm;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  通信地址邮政编码
	 */
	public void setYzbm(java.lang.String yzbm){
		this.yzbm = yzbm;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  主页地址
	 */
	@Column(name ="ZYDZ",nullable=true,length=200)
	public java.lang.String getZydz(){
		return this.zydz;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  主页地址
	 */
	public void setZydz(java.lang.String zydz){
		this.zydz = zydz;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */
	@Column(name ="BZ",nullable=true,length=4000)
	public java.lang.String getBz(){
		return this.bz;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备注
	 */
	public void setBz(java.lang.String bz){
		this.bz = bz;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  所属区县代码
	 */
	@Column(name ="SSQXDM",nullable=true,length=20)
	public java.lang.String getSsqxdm(){
		return this.ssqxdm;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  所属区县代码
	 */
	public void setSsqxdm(java.lang.String ssqxdm){
		this.ssqxdm = ssqxdm;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  入学年月
	 */
	@Column(name ="RXNY",nullable=true,length=20)
	public java.lang.String getRxny(){
		return this.rxny;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  入学年月
	 */
	public void setRxny(java.lang.String rxny){
		this.rxny = rxny;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  入学方式
	 */
	@Column(name ="RXFSM",nullable=true,length=20)
	public java.lang.String getRxfsm(){
		return this.rxfsm;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  入学方式
	 */
	public void setRxfsm(java.lang.String rxfsm){
		this.rxfsm = rxfsm;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  学生类别码
	 */
	@Column(name ="XSLBM",nullable=true,length=20)
	public java.lang.String getXslbm(){
		return this.xslbm;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  学生类别码
	 */
	public void setXslbm(java.lang.String xslbm){
		this.xslbm = xslbm;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  学制
	 */
	@Column(name ="XZ",nullable=true,length=20)
	public java.lang.String getXz(){
		return this.xz;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  学制
	 */
	public void setXz(java.lang.String xz){
		this.xz = xz;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  专业码
	 */
	@Column(name ="ZYM",nullable=true,length=20)
	public java.lang.String getZym(){
		return this.zym;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  专业码
	 */
	public void setZym(java.lang.String zym){
		this.zym = zym;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  学生当前状态码
	 */
	@Column(name ="XSDQZTM",nullable=true,length=20)
	public java.lang.String getXsdqztm(){
		return this.xsdqztm;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  学生当前状态码
	 */
	public void setXsdqztm(java.lang.String xsdqztm){
		this.xsdqztm = xsdqztm;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  班级代码
	 */
	@Column(name ="BJDM",nullable=true,length=20)
	public java.lang.String getBjdm(){
		return this.bjdm;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  班级代码
	 */
	public void setBjdm(java.lang.String bjdm){
		this.bjdm = bjdm;
	}


	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  年级代码
	 */
	@Column(name ="NJDM",nullable=true,length=20)
	public java.lang.String getNjdm(){
		return this.njdm;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  年级代码
	 */
	public void setNjdm(java.lang.String njdm){
		this.njdm = njdm;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  全国学籍号
	 */
	@Column(name ="QGXJH",nullable=true,length=20)
	public java.lang.String getQgxjh(){
		return this.qgxjh;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  全国学籍号
	 */
	public void setQgxjh(java.lang.String qgxjh){
		this.qgxjh = qgxjh;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  学籍副号
	 */
	@Column(name ="XJH",nullable=true,length=20)
	public java.lang.String getXjh(){
		return this.xjh;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  学籍副号
	 */
	public void setXjh(java.lang.String xjh){
		this.xjh = xjh;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  学段
	 */
	@Column(name ="XDM",nullable=true,length=20)
	public java.lang.String getXdm(){
		return this.xdm;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  学段
	 */
	public void setXdm(java.lang.String xdm){
		this.xdm = xdm;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  学校名称
	 */
	@Column(name ="XXMC",nullable=true,length=255)
	public java.lang.String getXxmc() {
		return xxmc;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  学校名称
	 */
	public void setXxmc(java.lang.String xxmc) {
		this.xxmc = xxmc;
	}

	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  学校代码
	 */
	@Column(name ="XXDM",nullable=true,length=20)
	public java.lang.String getXxdm(){
		return this.xxdm;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  学校代码
	 */
	public void setXxdm(java.lang.String xxdm){
		this.xxdm = xxdm;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  学籍校区
	 */
	@Column(name ="XQDM",nullable=true,length=20)
	public java.lang.String getXqdm(){
		return this.xqdm;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  学籍校区
	 */
	public void setXqdm(java.lang.String xqdm){
		this.xqdm = xqdm;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  就读方式，参照T_BZ_JDFS，1 走读，2 住校，9 其他
	 */
	@Column(name ="JDFSM",nullable=true,length=20)
	public java.lang.String getJdfsm(){
		return this.jdfsm;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  就读方式，参照T_BZ_JDFS，1 走读，2 住校，9 其他
	 */
	public void setJdfsm(java.lang.String jdfsm){
		this.jdfsm = jdfsm;
	}
}
