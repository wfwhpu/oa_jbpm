package cn.com.leadfar.oa.web.actions;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.com.leadfar.oa.model.Leave;

import com.opensymphony.xwork2.ModelDriven;


@Controller("leaveAction")
@Scope("prototype")
public class LeaveAction implements ModelDriven<Leave>{
	
	private Leave leave;
	
	public String myLeave(){
		
		
		return "my_leave";
	}
	
	public void leaveList(){
		//将属于自己的请假单查询出来
	}
	
	public String addInput(){
		
		return "add_input";
	}
	
	public String aadd(){
		
		return "add_success";
	}

	@Override
	public Leave getModel() {
		if(leave == null){
			leave = new Leave();
		}
		return leave;
	}

}
