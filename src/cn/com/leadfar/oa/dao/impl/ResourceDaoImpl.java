package cn.com.leadfar.oa.dao.impl;

import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Repository;

import cn.com.leadfar.oa.dao.ResourceDao;
import cn.com.leadfar.oa.model.ActionResource;

@Repository("resourceDao")
public class ResourceDaoImpl extends BaseDaoImpl implements
		ResourceDao {

	@Override
	public void delAllActionResources() {
		//����������������ɾ������Ϊt_resource_opers�������ڱ����Ӧ�ı�
//		getSession().createQuery("delete ActionResource")
//			.executeUpdate();
		
		Iterator it= getSession().createQuery("from ActionResource").iterate();
		while(it.hasNext()){
			//��ActionResource��������صĲ�������һ��ɾ����
			getSession().delete(it.next());
		}
		getSession().flush();
	}

	@Override
	public ActionResource findActionResourceBySn(String sn) {
		String hql = "select ar from ActionResource ar where ar.sn = ?";
		return (ActionResource)getSession().createQuery(hql)
			.setParameter(0, sn)
			.uniqueResult();
	}

	@Override
	public List<ActionResource> findAll() {
		String hql = "select ar from ActionResource ar order by ar.orderNumber";
		return getSession().createQuery(hql).list();
	}

	@Override
	public List<ActionResource> findAllTopActionResource() {
		String hql = "select ar from ActionResource ar where ar.parent is null order by ar.orderNumber";
		return getSession().createQuery(hql).list();
	}

	@Override
	public void update(ActionResource ar) {
		ActionResource oldAr = (ActionResource)getSession().load(ActionResource.class, ar.getId());
		ar.setOpers(oldAr.getOpers());
		
		//��������ע�⣬������ʹ��merge������������
		getSession().merge(ar);
	}

	@Override
	public ActionResource findByClassName(String className) {
		String hql = "select ar from ActionResource ar where ar.className like ?";
		return (ActionResource)getSession().createQuery(hql)
			.setParameter(0, "%"+className+"%")
			.uniqueResult();
	}

}
