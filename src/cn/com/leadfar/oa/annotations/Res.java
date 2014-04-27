package cn.com.leadfar.oa.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ����������Դ��ע��
 * @author Lee
 *
 */
@Retention(RetentionPolicy.RUNTIME) //�����е�ʱ�򣬿���ͨ��������ƻ�����ע����й���Ϣ
@Target(ElementType.TYPE) //ֻ�ܶ�������/�ӿڵ�ǰ��
public @interface Res {
	
	/**
	 * ��Դ�����ƣ����붨��
	 * �磺��֯��������
	 */
	String name();
	
	/**
	 * ��Դ��Ψһ��ʶ�����붨��
	 * �磺party
	 */
	String sn();
	
	/**
	 * ��Դ������ţ���ҪĿ����Ϊ���ڽ����϶���Դ���й����Լ�
	 * ����Դ�г�������Ȩ��ʱ����������;
	 */
	int orderNumber() default 0;
	
	/**
	 * ����Դ��Ψһ��ʶ
	 */
	String parentSn() default "";
}
