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
		String memberId = request.getParameter("memberId");//ajax에서 data로 넘어온 id password값을 파라미터값으로 저장한다. 
		String password = request.getParameter("password");

		MemberDBBean db = MemberDBBean.getInstance();
		
		int result = db.memberCheck(memberId, password);//valid , invalidid, invalidpassword 을 result값으로 전달한다 . 
		
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
		JsonObject obj = new JsonObject();//JSONObject는 JSON형태의 데이터를 관리해 주는 메서드이다. 
		//주의점은 맵의 특성으로 인해 순서를 보장하지 않는다는것. 즉 똑같이 뽑아내도 내용물의 순서가 섞일 수 있다.




		JSONArray array = new JSONArray();//JSONArray 는 JSONObject가 들어가는 배열


		// 나중에 수정
		return resultString;
	}

}
