package cn.com.leadfar.oa.web.actions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.com.leadfar.oa.annotations.Res;
import cn.com.leadfar.oa.model.Person;
import cn.com.leadfar.oa.vo.PagerVO;
import cn.com.leadfar.oa.web.JSONUtils;

@Controller("personAction")
@Scope("prototype")
@Res(name="人员操作",sn="person",orderNumber=50,parentSn="party")
public class PersonAction extends PartyAction {
	
	private String sSearch;
	
	public Object getModel() {
		
		if(model == null){
			model = new Person();
		}
		
		return model;
	}

	@Override
	public String execute() {
		return "person_list";
	}

	//构造人员信息列表的JSON串
	public void list(){
		
		Map map = new HashMap();
		
		PagerVO pv = partyService.findPersons(model.getId(),sSearch);
		
		map.put("iTotalRecords", pv.getTotal());
		map.put("iTotalDisplayRecords", pv.getTotal());
		map.put("aaData", pv.getDatas());
		
		JSONUtils.toJSON(map);
	}

	public String getSSearch() {
		return sSearch;
	}

	public void setSSearch(String search) {
		sSearch = search;
	}
}
