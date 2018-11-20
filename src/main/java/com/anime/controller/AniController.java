package com.anime.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.anime.bean.Ani;
import com.anime.constant.ResultCode;
import com.anime.exception.ServiceException;
import com.anime.msg.common.ResultBean;
import com.anime.msg.req.AniPageReq;
import com.anime.msg.rsp.AniPageRsp;
import com.anime.service.AniService;

@Controller
@ResponseBody
@RequestMapping("ani")
public class AniController {

	private Logger logger = LoggerFactory.getLogger(AniController.class);

	@Autowired
	private AniService aniService;

	@RequestMapping("queryAniById")
	public Ani queryAniById(int id) {
		Ani ani = null;
		try {
			ani = aniService.queryAniById(id);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		return ani;
	}

	@RequestMapping("addAni")
	public ResultBean addAni(Ani ani) {
		ResultBean result = new ResultBean();
		try {
			aniService.addAni(ani);
			result.setResultCode(ResultCode.SUCCESS);
			result.setResultMessage("success");
		} catch (ServiceException e) {
			result.setResultCode(ResultCode.ERROR);
			result.setResultMessage("Failed to add Ani.");
		}
		return result;
	}

	@RequestMapping("deleteAni")
	public ResultBean dropAni(Integer[] ids) {
		ResultBean result = new ResultBean();
		try {
			aniService.dropAni(ids);
			result.setResultCode(ResultCode.SUCCESS);
			result.setResultMessage("success");
		} catch (ServiceException e) {
			result.setResultCode(ResultCode.ERROR);
			result.setResultMessage("Failed to delete Ani.");
			e.printStackTrace();
		}
		return result;
	}

	@RequestMapping("modifyAni")
	public ResultBean modifyAni(@RequestBody Ani ani) {
		ResultBean result = new ResultBean();
		try {
			aniService.modifyAni(ani);
			result.setResultCode(ResultCode.SUCCESS);
			result.setResultMessage("success");
		} catch (ServiceException e) {
			result.setResultCode(ResultCode.ERROR);
			result.setResultMessage("Failed to modify Ani.");
			e.printStackTrace();
		}
		return result;
	}

	@RequestMapping("queryAniByPage")
	public AniPageRsp queryAniByPage(@RequestBody AniPageReq aniPageReq) {
		logger.info("queryAniByPage, request:{}", aniPageReq);
		AniPageRsp rsp = new AniPageRsp();
		try {
			rsp = aniService.queryAniByPage(aniPageReq);
			rsp.setResultCode(ResultCode.SUCCESS);
			rsp.setResultMessage("success");
		} catch (ServiceException e) {
			rsp.setResultCode(ResultCode.ERROR);
			rsp.setResultMessage("Failed to query Ani by page.");
			logger.error("{}", e);
		}
		logger.info("queryAniByPage, response:", rsp);
		return rsp;
	}

	@RequestMapping("plusOne")
	public ResultBean plusOne(@RequestBody Ani ani) {
		logger.info("plusOne, request:{}", ani.getId());
		ResultBean resultBean = new ResultBean();
		try {
			int result = aniService.plusOne(ani.getId());
			if (1 != result) {
				resultBean.setResultCode(ResultCode.ERROR);
				return resultBean;
			}
		} catch (ServiceException e) {
			resultBean.setResultCode(ResultCode.ERROR);
			return resultBean;
		}
		resultBean.setResultCode(ResultCode.SUCCESS);
		return resultBean;
	}

	@RequestMapping("total")
	public int total() throws ServiceException {
		return aniService.total();
	}

}
