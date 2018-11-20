package com.anime.bean;

import java.io.Serializable;
import java.util.Date;

import com.anime.util.DateUtil;

public class Ani implements Serializable{

	private static final long serialVersionUID = -143293185117591800L;

	private Integer id;
	
	private Date createTime;
	
	private Date updateTime;
	
	private Integer episodeNum;
	
	private String info;
	
	private String name;
	
	//时期
	private String period;
	
	private Integer finState;
	
	private Integer watchState;
	
	private Integer day;
	
	private String url;
	
	private Integer flag;
	
	public String getCreateTimeStr() {
		return DateUtil.dateToSmartString(getCreateTime());
	}

	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getEpisodeNum() {
		return episodeNum;
	}

	public void setEpisodeNum(Integer episodeNum) {
		this.episodeNum = episodeNum;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public Integer getFinState() {
		return finState;
	}

	public void setFinState(Integer finState) {
		this.finState = finState;
	}

	public Integer getWatchState() {
		return watchState;
	}

	public void setWatchState(Integer watchState) {
		this.watchState = watchState;
	}

	public Integer getDay() {
		return day;
	}

	public void setDay(Integer day) {
		this.day = day;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Ani [id=");
		builder.append(id);
		builder.append(", createTime=");
		builder.append(createTime);
		builder.append(", updateTime=");
		builder.append(updateTime);
		builder.append(", episodeNum=");
		builder.append(episodeNum);
		builder.append(", info=");
		builder.append(info);
		builder.append(", name=");
		builder.append(name);
		builder.append(", period=");
		builder.append(period);
		builder.append(", finState=");
		builder.append(finState);
		builder.append(", watchState=");
		builder.append(watchState);
		builder.append(", day=");
		builder.append(day);
		builder.append(", url=");
		builder.append(url);
		builder.append(", flag=");
		builder.append(flag);
		builder.append("]");
		return builder.toString();
	}
	
	
}
