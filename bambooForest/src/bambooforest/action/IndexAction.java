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
		// DB���� �Խñ� ����� �о��
		// request.setAttribute �� ����
		PostDBBean bean = PostDBBean.getInstance();//�̱��� ������ �����Ҷ� ��� 
		//������ ���Ը� �Ź� �������� �ʰ� ���� ȣ��ÿ� jvm�� static �ϰ� �����ϰ��� �ϴ� Ŭ������ 
		//�ν��Ͻ��� �����ؼ� ����ϰ��� �Ҷ� ��� 

		request.setAttribute("postList", bean.getList());//�Խù� ��ü select
		
		return "/list.jsp"; // �Խù� ��ü ���� list.jsp�� �����ش�.
	}

}