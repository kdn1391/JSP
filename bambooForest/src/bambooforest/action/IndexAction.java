package bambooforest.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bambooforest.model.PostDBBean;

public class IndexAction implements Action {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// DB에서 게시글 목록을 읽어와
		// request.setAttribute 할 예정
		PostDBBean bean = PostDBBean.getInstance();//싱글톤 패턴을 적용할때 사용 
		//동일한 개게를 매번 생성하지 않고 최초 호출시에 jvm에 static 하게 생성하고자 하는 클래스의 
		//인스턴스를 생성해서 사용하고자 할때 사용 

		request.setAttribute("postList", bean.getList());//게시물 전체 select
		
		return "/list.jsp"; // 게시물 전체 값을 list.jsp에 던져준다.
	}

}
