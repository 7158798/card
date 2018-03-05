package com.rw.finance.common.pass.yeepay2.agent;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Servlet implementation class DownloadFileServle
 */
public class DownloadFileServlet {
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	/*protected void doPost(){
		String method = request.getParameter("method");
		String date = request.getParameter("date");
		String dataType = request.getParameter("dataType");

		System.out.println(method);
		System.out.println(date);
		System.out.println(dataType);

		Map<String, String> params = new HashMap<>();
		params.put("method", method);
		params.put("date", date);
		params.put("dataType", dataType);
		// 获得项目绝对路径
		String realPath = this.getServletConfig().getServletContext().getRealPath("/");
		// 对账文件的存储路径
		String path = realPath + "File";

		System.out.println("path====" + path);
		// 获取对账文件
		String filePath = YeepayService.yosFile(params, path);

		System.out.println(filePath);
	}*/

}
