package com.bear.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.bear.pojo.User;

public class LoginInterceptor implements HandlerInterceptor{
    
	
	
	// ���������֮ǰִ��
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		//���·��
		String uri=request.getRequestURI();
		//��������Դ·��
		StringBuffer url=request.getRequestURL();
		 System.out.println(uri+" -- "+url);
		Object obj=request.getSession().getAttribute("user");
		// ����������¼�Ļ��ͷ���
		if(uri.equals("/easyui/login")||uri.equals("/easyui/validcode")||uri.equals("/easyui/#")){
			return true;
		}else{
			if(obj==null){
				System.out.println(request.getContextPath());
				response.sendRedirect(request.getContextPath()+"/login.jsp");
				return false;
			}else{
				return true;
			}
			
		}
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

}
