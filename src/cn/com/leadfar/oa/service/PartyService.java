package cn.com.leadfar.oa.service;

import cn.com.leadfar.oa.model.Company;
import cn.com.leadfar.oa.model.Party;
import cn.com.leadfar.oa.vo.PagerVO;

public interface PartyService {
	
	/**
	 * ���Party����
	 * @param party
	 */
	public void addParty(Party party);
	
	/**
	 * ��ѯ��ǰϵͳ�е��ܹ�˾����
	 * @return
	 */
	public Company currentCompany();
	
	/**
	 * ����Party����
	 * @param party
	 */
	public void updateParty(Party party);
	
	/**
	 * ɾ��party����
	 * ���party������������party��Ϣ����������ɾ�����׳�RuntimeException�쳣
	 * @param partyId
	 */
	public void delParty(int partyId);
	
	/**
	 * ����ID��ѯparty����
	 * @param partyId
	 * @return
	 */
	public Party findPartyById(int partyId);
	
	/**
	 * ���ݲ�ѯ������ѯ��Ա�б������ѯ������ƥ����Ա�������Ա�
	 * @param parentId ���ĸ���˾�����Ż��λ�����ѯ��Ա�������ֵΪ0��
	 *  ����ѯ���е���Ա��Ϣ
	 * @param search ��ѯ����
	 * @return �����б��е�Ԫ�������飺��ԱID���������Ա𣬵绰
	 */
	public PagerVO findPersons(int parentId,String search);
	
	/**
	 * ���湫˾����
	 * �����˾���󲻴��ڣ���IDΪ0���������
	 * �����˾�����Ѵ��ڣ���ID��Ϊ0���������
	 * @param current ��˾����
	 */
	public void saveCompany(Company current);
}
