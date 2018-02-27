package web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/*
 * 15.Filter(������)
	����:��һ������ȥ����ĳ����Դ��ʱ��,filter���������������ʵ������Դ֮ǰ,����������,
	Ȼ������һϵ�еĴ�������ж�(��������ת��,��Ϣ�Ĺ��ˡ�Ȩ�޵��жϡ��Ƿ��Ѿ���¼����֤�ȵ�),
	���filter�پ����Ƿ�Ҫ���������ȥ�����Ǹ���Դ.
	���дһ��filter:
	дһ��java��,Ȼ��ʵ��javax.Servlet.Filter�ӿ�
	����ӿ�������������:
	init  destroy  doFilter
	init:����������౻���������������ʱ�����õ����������
	destroy:�������������ٵ�ʱ���������������
	doFilter:�����������ص������ʱ��,��������doFilter.
 * */
public class EncodingFilter implements Filter {

	public EncodingFilter() {
		System.out.println("filter����");
	}
	@Override
	public void destroy() {
		System.out.println("filter����");
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("filter����ǰ");
		//���������
		chain.doFilter(req, resp);
		System.out.println("filter���к�");
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("filter��ʼ��");
	}

}
