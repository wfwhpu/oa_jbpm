package cn.com.leadfar.oa.web.actions;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.com.leadfar.oa.annotations.Oper;
import cn.com.leadfar.oa.annotations.Res;
import cn.com.leadfar.oa.model.Company;

@Controller("companyAction")
@Scope("prototype")
@Res(name="��˾����",sn="company",orderNumber=20,parentSn="party")
public class CompanyAction extends PartyAction {

	@Override
	public Object getModel() {
		if(model == null){
			model = new Company();
		}
		
		return model;
	}
	
	/**
	 * �򿪹�˾��Ϣ���ý���
	 * @return
	 */
	@Oper(name="��˾��Ϣά��",index=4,sn="saveCompany")
	public String saveInput() {
		
		//��ѯ��ǰ��˾����Ϣ
		model = partyService.currentCompany();
		
		return "company_input";
	}

	/**
	 * ���湫˾��Ϣ����ӻ����
	 * @return
	 */
	@Oper(name="��˾��Ϣά��",index=4,sn="saveCompany")
	public String save(){
		partyService.saveCompany((Company)model);
		return "add_success";
	}
}
