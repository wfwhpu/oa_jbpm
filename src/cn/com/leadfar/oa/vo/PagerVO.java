package cn.com.leadfar.oa.vo;

import java.util.List;

/**
 * ��ҳ��ѯʱ����װ��ѯ�Ľ��
 * @author Lee
 *
 */
public class PagerVO {
	private int total;
	private List datas;
	
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public List getDatas() {
		return datas;
	}
	public void setDatas(List datas) {
		this.datas = datas;
	}
}
