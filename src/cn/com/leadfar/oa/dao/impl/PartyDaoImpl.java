package cn.com.leadfar.oa.dao.impl;

import org.springframework.stereotype.Repository;

import cn.com.leadfar.oa.dao.PartyDao;
import cn.com.leadfar.oa.model.Company;
import cn.com.leadfar.oa.model.Party;

@Repository("partyDao")
public class PartyDaoImpl extends BaseDaoImpl implements PartyDao {

	@Override
	public Company findCompany() {
		
		getSession().enableFilter("no_contain_person");
		
		String hql = "select c from Company c where c.parent is null";
		
		return (Company)getSession().createQuery(hql).uniqueResult();
	}

	@Override
	public Party findById(int id) {
		
		//�ܹ�����ʵ�ʵ�Party���ͣ�����Company/Department�ȵ�
		//return (Party)getSession().get(Party.class, id);
		
		//�ܹ�����ʵ�ʵ�Party���ͣ�����Company/Department�ȵ�
		return (Party)getSession().createQuery("select p from Party p where p.id = ?")
			.setParameter(0, id).uniqueResult();
	}

	/**
	 * ��ӻ����Party����
	 */
	@Override
	public void saveOrUpdate(Party party) {
		
		/**
		 * ���party�������ݿ��ʶ�����Զ�����������䣻�����Զ������������
		 * ����idΪint���͵�ʵ��������id������0���൱�ھ������ݿ��ʶ��
		 */
		getSession().saveOrUpdate(party);
	}

}
