package com.dzbs.controller.order;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dzbs.bean.common.CommentVO;
import com.dzbs.bean.security.Member;
import com.dzbs.bean.security.Role;
import com.dzbs.dao.UserDao;
import com.dzbs.service.UserDetailServiceImpl;
import com.dzbs.service.order.OrderImpl;
import com.dzbs.util.common.DataTableUtil;

@Controller
@RequestMapping(value = "/order")
public class OrderController {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private UserDetailServiceImpl userDetailServiceImpl;
	
	@Autowired
	private OrderImpl orderDao;
	
	/**
	 * 评论主页
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/index", method = { RequestMethod.GET })
	public ModelAndView indexPage(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView();
		UserDetails userDetails = (UserDetails) SecurityContextHolder
				.getContext().getAuthentication().getPrincipal();
		String username = userDetails.getUsername();
		Member member = userDetailServiceImpl.findUserByUsername(username);
		modelAndView.addObject("member", member);
		modelAndView.setViewName("comment/index");
		return modelAndView;
	}
	
	/**
	 * 获取数据
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/data", method = { RequestMethod.POST }, produces = "application/json; charset=utf-8")
	@ResponseBody
	public String data(HttpServletRequest request, HttpServletResponse response) {
		/**
		 * 获取查询参数
		 */
		DataTableUtil dataTableUtil = new DataTableUtil(request);
		System.out.println("===================================");
		System.out.println("起始偏移=" + dataTableUtil.getStart());
		System.out.println("页长=" + dataTableUtil.getLength());
		System.out.println("页码=" + dataTableUtil.getPage());
		System.out.println("排序字段=" + dataTableUtil.getOrderColumn());
		System.out.println("排序顺序=" + dataTableUtil.getOrderDirection());
		System.out.println("搜索关键字=" + dataTableUtil.getSearchValue());
		System.out.println("===================================");
	
//		UserDetails userDetails = (UserDetails) SecurityContextHolder
//				.getContext().getAuthentication().getPrincipal();
//		String username = userDetails.getUsername();
//		Member member = userDetailServiceImpl.findUserByUsername(username);
//		Set<Role> mRoles = member.getRoles();
//		Iterator<Role> it = mRoles.iterator();
//		String roleCode = "";
//		while(it.hasNext()){
//			Role role = it.next();
//			roleCode = role.getCode();
//		}
//		List<CommentVO> comment = null;
//		if(roleCode.equals("ROLE_ADMIN")){
//			comment = commentDao.findAllCommentVOs();
//			// 总记录数
//			Integer recordsTotal =  comment.size();
//			// 关键字过滤后总记录数
//			Integer recordsFiltered = recordsTotal;
//			dataTableUtil.setResult(recordsTotal, recordsFiltered,commentDao.findAllCommentVOs(dataTableUtil.getPage(), dataTableUtil.getLength()));
//		}else{
//			comment = commentDao.findByMemberIdVO(member.getId());
//			// 总记录数
//			Integer recordsTotal =  comment.size();
//			// 关键字过滤后总记录数
//			Integer recordsFiltered = recordsTotal;
//			dataTableUtil.setResult(recordsTotal, recordsFiltered,commentDao.findByMemberIdVO(dataTableUtil.getPage(), dataTableUtil.getLength(),member.getId()));
//		}
//		
//		return dataTableUtil.result();
		return null;
	}	
}
