package cn.com.leadfar.oa.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.leadfar.oa.dao.PartyDao;
import cn.com.leadfar.oa.model.Company;
import cn.com.leadfar.oa.model.Party;
import cn.com.leadfar.oa.service.PartyService;
import cn.com.leadfar.oa.vo.PagerVO;

@Service("partyService")
public class PartyServiceImpl implements PartyService {

	@Resource
	private PartyDao partyDao;
	
	@Override
	public void addParty(Party party) {
		partyDao.save(party);
	}

	@Override
	public void saveCompany(Company current) {
		partyDao.saveOrUpdate(current);
	}

	@Override
	public Company currentCompany() {
		return partyDao.findCompany();
	}

	@Override
	public void delParty(int partyId) {
		
		//�жϱ�party�����Ƿ�����party
		Party p = findPartyById(partyId);
		if(p.getChildren().size() > 0){
			throw new RuntimeException("��Party��ID="+partyId+"�����滹����Party��Ϣ��������ɾ����");
		}
		
		partyDao.del(p);
	}

	@Override
	public Party findPartyById(int partyId) {
		return partyDao.findById( partyId);
	}

	@Override
	public PagerVO findPersons(int parentId,String search) {

		//���ݸ�ID��ѯPerson�����б�
		String hql = "select p.id,p.name,p.sex,p.phone from Person p where p.parent.id = "+parentId;
		
		if(parentId == 0){
			hql = "select p.id,p.name,p.sex,p.phone from Person p where 1=1 ";
		}
		
		if(search != null && !search.trim().equals("")){
			hql = hql + " and (p.name like '%"+search+"%' or p.sex like '%"+search+"%')";
		}
		
		return partyDao.findPaginated(hql);
	}

	@Override
	public void updateParty(Party party) {
		partyDao.update(party);
	}

}
