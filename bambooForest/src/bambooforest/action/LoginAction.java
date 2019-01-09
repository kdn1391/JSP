package bambooforest.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;

import com.google.gson.JsonObject;

import bambooforest.model.MemberBean;
import bambooforest.model.MemberDBBean;

public class LoginAction implements Action {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String memberId = request.getParameter("memberId");//ajax���� data�� �Ѿ�� id password���� �Ķ���Ͱ����� �����Ѵ�. 
		String password = request.getParameter("password");

		MemberDBBean db = MemberDBBean.getInstance();
		
		int result = db.memberCheck(memberId, password);//valid , invalidid, invalidpassword �� result������ �����Ѵ� . 
		
		String resultString;
		switch (result) {
		case MemberDBBean.VALID:
			resultString = "valid";
			MemberBean member = new MemberBean();
			member.setPassword(password);
			member.setMemberId(memberId);
			request.getSession().setAttribute("member", db.getMember(memberId));
			break;
		case MemberDBBean.INVALID_PASSWORD:
			resultString = "invalid pasword";
			break;
		case MemberDBBean.INVALID_USER:
			resultString = "invalid user";
			break;
		default:
			resultString = "error";
			break;
		}
		JsonObject obj = new JsonObject();//JSONObject�� JSON������ �����͸� ������ �ִ� �޼����̴�. 
		//�������� ���� Ư������ ���� ������ �������� �ʴ´ٴ°�. �� �Ȱ��� �̾Ƴ��� ���빰�� ������ ���� �� �ִ�.




		JSONArray array = new JSONArray();//JSONArray �� JSONObject�� ���� �迭


		// ���߿� ����
		return resultString;
	}

}
