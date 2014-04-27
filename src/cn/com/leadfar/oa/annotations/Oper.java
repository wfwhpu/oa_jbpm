package cn.com.leadfar.oa.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * �������������ע��
 * @author Lee
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD) //ֻ�ܶ����ڷ�����ǰ��
public @interface Oper {
	
	/**
	 * ���������ƣ����������������ԣ����Զ����ݷ����������Զ�����һ��ֵ���������£�
	 * add��ͷ�ķ������Զ�����һ�����ƣ����
	 * update��ͷ�ķ������Զ�����һ�����ƣ�����
	 * del��ͷ�ķ������Զ�����һ�����ƣ�ɾ��
	 * �����������Զ�����һ�����ƣ���ѯ
	 */
	String name() default "";
	
	/**
	 * ������Ψһ��ʶ�����������������ԣ����Զ����ݷ����������Զ�����һ��ֵ���������£�
	 * add��ͷ�ķ������Զ�����һ��Ψһ��ʶ��CREATE
	 * update��ͷ�ķ������Զ�����һ��Ψһ��ʶ��UPDATE
	 * del��ͷ�ķ������Զ�����һ��Ψһ��ʶ��DELETE
	 * �����������Զ�����һ��Ψһ��ʶ��READ
	 */
	String sn() default "";
	
	/**
	 * ������Ӧ������ֵ�����������������ԣ����Զ����ݷ����������Զ�����һ��ֵ���������£�
	 * add��ͷ�ķ������Զ�����һ������ֵ��0
	 * update��ͷ�ķ������Զ�����һ������ֵ��1
	 * del��ͷ�ķ������Զ�����һ������ֵ��2
	 * ���������Զ�����һ������ֵ��3
	 */
	int index() default -1;
}
