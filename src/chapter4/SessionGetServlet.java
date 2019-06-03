package chapter4;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionCreateServlet
 */
@WebServlet("/SessionGetServlet")
public class SessionGetServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String memberName = "";
		String memberData = "";

		HttpSession session = request.getSession();
		memberName = (String) session.getAttribute("MemberName");
		memberData = (String) session.getAttribute("MemberData");

		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\">");
		out.println("<title>セッション情報の見本2</title>");
		out.println("</head>");
		out.println("<body>");

		out.println("<hr>");
		out.println("<h2>その2 セッションの値の取得</h2>");
		out.println("ようこそ、" + memberName + "さん");
		out.println("<br>");
		out.println("その1から取得した内容");
		out.println("<br>");
		out.println("<hr>");
		out.println("会員名" + memberName);
		out.println("<br>");
		out.println("会員入会日" + memberData + "<br><br>");
		out.println("<br>");
		out.println("<br>");
		out.println("現在のセッションID : 「" + session.getId() + "」");
		out.println("<br>");
		out.println("<form action = \"SessionGetServlet\" " + " method = \"post\">");
		out.println("<input type=\"submit\" " + "value=\"次のサーブレット「その3」	の値の削除を呼び出し\">");
		out.println("</form>");
		out.println("<a href = \" startsessionsample.html\">" + "入力へ戻す</a>");
		out.println("</body>");
		out.println("</html>");
	}
}