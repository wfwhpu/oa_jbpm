package cn.com.leadfar.oa.web.actions;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.jbpm.api.ProcessDefinition;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import cn.com.leadfar.oa.service.LeaveService;
import cn.com.leadfar.oa.vo.ProcessVO;
import cn.com.leadfar.oa.web.JSONUtils;

@Controller("processAction")
public class ProcessAction {

	@Resource
	private LeaveService leaveService;
	
	public void processList(){
		List<ProcessDefinition> pds = this.leaveService.getAllProcess();
		List<String> names = new ArrayList<String>();
		for(ProcessDefinition pd : pds){
			String [] name = {pd.getId(),pd.getKey()};
			
			names.add(pd.getId());
		}
		ProcessVO pvo = new ProcessVO();
		pvo.setDatas(names);
		//ActionContext.getContext().put("names", names);
		JSONUtils.toJSON(pvo);
		//return "list";
	}
}
