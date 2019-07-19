package com.anime.constant;

public interface StateConstant {

	/*
	 * 完结
	 */
	public final int FIN_FLAG_FIN = 1;
	
	/*
	 * 连载
	 */
	public final int FIN_FLAG_UN_FIN = 0;
	/*
	 * 未上映
	 */
	public final int FIN_FLAG_COMING = 2;
	
	/*
	 * 未看
	 */
	public final int WATCH_FLAG_BEFORE = 0;
	
	/*
	 * 追番
	 */
	public final int WATCH_FLAG_CHASING = 1;
	
	/*
	 * 看完
	 */
	public final int WATCH_FLAG_FINISH = 2;

	/*
	 * 弃
	 */
	public final int WATCH_FLAG_ABANDONED = 3;
	
}
