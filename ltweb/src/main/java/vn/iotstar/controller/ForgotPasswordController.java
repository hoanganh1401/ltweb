package vn.iotstar.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.iotstar.services.impl.UserService;

@WebServlet(urlPatterns = "/forgotpassword")
public class ForgotPasswordController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.getRequestDispatcher("/views/forgotpassword.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    resp.setContentType("text/html");
	    resp.setCharacterEncoding("UTF-8");
	    req.setCharacterEncoding("UTF-8");

	    // Lấy email từ form
	    String email = req.getParameter("email");

	    // Tạo đối tượng UserService để gọi các phương thức
	    UserService service = new UserService();

	    String alertMsg = "";
	    
	    // Kiểm tra xem email có tồn tại trong hệ thống không
	    if (!service.checkExistEmail(email)) {
	        alertMsg = "Email không tồn tại!";
	    } else {
	        // Tạo mật khẩu mới và cập nhật mật khẩu vào cơ sở dữ liệu
	        String newPassword = service.RandomPassword();
	        System.out.println("Mật khẩu mới: " + newPassword); // Debug mật khẩu mới
	        service.updatePassword(newPassword, email);
	        System.out.println("Cập nhật mật khẩu thành công cho email: " + email); // Debug cập nhật mật khẩu

	        alertMsg = "Mật khẩu mới của bạn là " + newPassword;
	    }
	    
	    // Đặt thông báo vào request và chuyển hướng lại trang forgotpassword.jsp
	    req.setAttribute("alert", alertMsg);
	    req.getRequestDispatcher("/views/forgotpassword.jsp").forward(req, resp);
	}


}