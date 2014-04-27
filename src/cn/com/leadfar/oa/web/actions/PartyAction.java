package cn.com.leadfar.oa.web.actions;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.com.leadfar.oa.annotations.Oper;
import cn.com.leadfar.oa.annotations.Res;
import cn.com.leadfar.oa.model.Company;
import cn.com.leadfar.oa.model.Party;
import cn.com.leadfar.oa.service.PartyService;
import cn.com.leadfar.oa.vo.PartyTreeVO;
import cn.com.leadfar.oa.web.JSONUtils;

import com.opensymphony.xwork2.ModelDriven;

@Controller("partyAction")
@Scope("prototype")
@Res(name="��֯��������",sn="party",orderNumber=10)
public class PartyAction extends BaseAction implements ModelDriven{
	
	@Resource
	protected PartyService partyService;

	protected Party model;
	
	@Override
	public Object getModel() {
		
		if(model == null){
			model = new Party();
		}
		
		return model;
	}

	//�򿪻�������������
	@Oper
	public String execute(){
		Company current = partyService.currentCompany();
		if(current == null){
			throw new RuntimeException("��ά����֯����֮ǰ���������ñ���˾�Ļ�����Ϣ��");
		}		
		return "index";
	}
	
	//���ص�ǰ��֯�ܹ�����JSON��
	public void tree(){
		Company current = partyService.currentCompany();
		PartyTreeVO ptv = new PartyTreeVO(current);
		JSONUtils.toJSON(ptv);
	}
	
	//�����ҳ��
	@Oper
	public String addInput(){
		
		//ҳ���ϱ��봫����parent.id�������Ա����������һ��party���洴����party
		int parentId = model.getParent().getId();
		if(parentId == 0){
			throw new RuntimeException("δ֪���ڵ㣬�޷������ӽڵ㣡");
		}
		
		return "add_input";
	}
	
	//ִ����Ӳ���
	@Oper
	public String add(){
		
		//��party��Ϣ�洢�����ݿ���
		partyService.addParty(model);
		
		return "add_success";
	}
	
	//�򿪸���ҳ��
	@Oper
	public String updateInput(){
		
		model = partyService.findPartyById(model.getId());

		return "update_input";
	}
	
	//ִ�и��²���
	@Oper
	public String update(){
		
		partyService.updateParty(model);
		
		return "update_success";
	}
	
	//ִ��ɾ������
	@Oper
	public String del(){
		partyService.delParty(model.getId());
		return "del_success";
	}
}
