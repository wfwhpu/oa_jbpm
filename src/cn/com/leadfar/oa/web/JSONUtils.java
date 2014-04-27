package cn.com.leadfar.oa.web;

import org.apache.struts2.ServletActionContext;

import com.sdicons.json.mapper.JSONMapper;

public class JSONUtils {
	/**
	 * ��ĳ������ת��ΪJSON��ʽ���ַ�����������ֱ��д��HttpResponse����
	 * @param obj
	 */
	public static void toJSON(Object obj){
		try {
			ServletActionContext.getResponse().setCharacterEncoding("UTF-8");
			ServletActionContext.getResponse().getWriter().println(
				JSONMapper.toJSON(obj).render(false)
			);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("�ڽ�����"+obj+"ת��ΪJSON��ʽ�ַ�����ʱ�����쳣��");
		}
	}
}
