package cn.com.leadfar.oa.web.actions;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.com.leadfar.oa.model.Menu;
import cn.com.leadfar.oa.service.AclService;
import cn.com.leadfar.oa.vo.AuthMenuTreeVO;
import cn.com.leadfar.oa.vo.LoginInfoVO;
import cn.com.leadfar.oa.web.JSONUtils;

/**
 * ���������¼֮���������ϵĸ�������
 * @author Lee
 *
 */
@Controller("indexAction")
@Scope("prototype")
public class IndexAction extends BaseAction{
	
	@Resource
	private AclService aclService;
	
	//���ݵ�ǰ��¼�û�����ѯ��ӵ�з���Ȩ�޵Ĳ˵�
	public void menu(){
		LoginInfoVO user = currentUser();
		List<Menu> authMenus = aclService.findPermitMenus(user.getId());
		List<AuthMenuTreeVO> vos = new ArrayList<AuthMenuTreeVO>();
		for(Menu m:authMenus){
			AuthMenuTreeVO vo = new AuthMenuTreeVO(m);
			vos.add(vo);
		}
		JSONUtils.toJSON(vos);
	}
	
}
