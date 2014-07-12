package cn.com.leadfar.oa.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import cn.com.leadfar.oa.SystemContext;
import cn.com.leadfar.oa.dao.BaseService;
import cn.com.leadfar.oa.vo.PagerVO;

public class BaseServiceImp implements BaseService {

	@Resource
	private SessionFactory sessionFactory;

	@Override
	public void del(Object entity) {
		this.getSession().delete(entity);
	}

	@Override
	public List find(Object entity) {
		// TODO Auto-generated method stub
		return this.getSession().createCriteria(entity.getClass()).add(Example.create(entity)).list();
	}

	@Override
	public <T> List<T> findAll(Class<T> entityClass) {
		// TODO Auto-generated method stub
		return this.getSession().createCriteria(entityClass).list();
	}

	@Override
	public <T> T findById(Class<T> entityClass, int id) {
		// TODO Auto-generated method stub
		return (T) this.getSession().load(entityClass, id);
	}

	@Override
	public PagerVO findPaginated(String query) {
		// TODO Auto-generated method stub
		return findPaginated(query,null);
	}

	@Override
	public PagerVO findPaginated(String query, Object param) {
		// TODO Auto-generated method stub
		return findPaginated(query,new Object[]{param});
		
	}

	@Override
	public PagerVO findPaginated(String query, Object[] params) {
		// TODO Auto-generated method stub
		return findPaginated(query,params,SystemContext.getOffset(),SystemContext.getPagesize());
	}

	@Override
	public PagerVO findPaginated(String query, int offset, int pagesize) {
		// TODO Auto-generated method stub
		return findPaginated(query, null,offset,pagesize);
	}

	@Override
	public PagerVO findPaginated(String query, Object param, int offset,
			int pagesize) {
		// TODO Auto-generated method stub
		return findPaginated(query, new Object[]{param}, offset, pagesize);
	}

	@Override
	public PagerVO findPaginated(String query, Object[] params, int offset,
			int pagesize) {
		//查询总的记录数
		String countHql=countHql(query);
		Query q1=this.getSession().createQuery(countHql);
		for(int i=0;i<params.length;i++){
			q1.setParameter(i, params[i]);
		}
		int totalCount=Integer.parseInt(q1.uniqueResult().toString());
		
		Query q2=this.getSession().createQuery(query);
		for(int i=0;i<params.length;i++){
			q2.setParameter(i, params[i]);
		}
		q2.setFirstResult(offset);
		q2.setMaxResults(pagesize);
		List datas=q2.list();
		PagerVO pv=new PagerVO();
		pv.setDatas(datas);
		pv.setTotal(totalCount);
		return pv;
	}

	@Override
	public void save(Object entity) {
	  this.getSession().save(entity);
	}

	@Override
	public void update(Object entity) {
		this.getSession().update(entity);
	}

	protected Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}
	
	public  String countHql(String hql){
		String resultSQL="";
		if(hql==null||"".equals(hql.trim())){
			throw new RuntimeException("hql不能为空");
		}
		int index=hql.indexOf(" from ");
		System.out.println(index);
		resultSQL="select count(*)"+hql.substring(index);
		return resultSQL;
	}
	
	public static void main(String[] args){
		String hql="select * from user";
		
	}

}
