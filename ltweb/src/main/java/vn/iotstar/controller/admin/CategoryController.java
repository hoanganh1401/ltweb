package vn.iotstar.controller.admin;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.List;

import org.apache.commons.fileupload2.core.DiskFileItemFactory;
import org.apache.commons.fileupload2.core.FileItem;
import org.apache.commons.fileupload2.jakarta.servlet6.JakartaServletFileUpload;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import vn.iotstar.models.CategoryModel;
import vn.iotstar.services.ICategoryService;
import vn.iotstar.services.impl.CategoryServiceImpl;
import vn.iotstar.utils.Constant;

@WebServlet(urlPatterns = {"/admin/categories", "/admin/category/add", "/admin/category/insert",
		"/admin/category/edit", "/admin/category/update",
		"/admin/category/delete", "/admin/category/search"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
maxFileSize = 1024 * 1024 * 10, // 10MB
maxRequestSize = 1024 * 1024 * 50) // 50MB
public class CategoryController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ICategoryService cateService = new CategoryServiceImpl();
	private String getFileName(Part part) {
		return part.getSubmittedFileName();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI();
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		if(url.contains("categories")) {
			List<CategoryModel> list = cateService.findAll();
			req.setAttribute("listcate", list);
			req.getRequestDispatcher("/views/admin/category-list.jsp").forward(req, resp);
		}else if(url.contains("add")) {
			req.getRequestDispatcher("/views/admin/category-add.jsp").forward(req, resp);
		}else if(url.contains("edit")) {
			int id = Integer.parseInt(req.getParameter("categoryid"));
			CategoryModel category = cateService.findById(id);
			req.setAttribute("cate", category);
			req.getRequestDispatcher("/views/admin/category-edit.jsp").forward(req, resp);
		}else if(url.contains("delete")) {
			int id = Integer.parseInt(req.getParameter("categoryid"));
			cateService.delete(id);
			resp.sendRedirect(req.getContextPath()+ "/admin/categories");
		}else if(url.contains("search")) {
			String key = req.getParameter("keyword");
			List<CategoryModel> list = cateService.findName(key);
			req.setAttribute("listcate", list);
			req.getRequestDispatcher("/views/admin/category-list.jsp").forward(req, resp);
		}
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI();
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		String images = "";
		String categoryname = req.getParameter("categoryname");
		int status = Integer.parseInt(req.getParameter("status"));
		
		
		//String uploadPath = UPLOAD_DIRECTORY // lưu vào thư mục trong máy
		String uploadPath = getServletContext().getRealPath("") + File.separator + "upload"; // luu vào thư mục trong prj
	    File uploadDir = new File(uploadPath);
	    if (!uploadDir.exists()) uploadDir.mkdir();

	    try {
	        String fileName = "";
	        // Duyệt qua các part trong request
	        for (Part part : req.getParts()) {
	            // Kiểm tra nếu part là file (có content-disposition)
	            if (part.getSubmittedFileName() != null && !part.getSubmittedFileName().isEmpty()) {
	                fileName = getFileName(part);
	                part.write(uploadPath + File.separator + fileName);
	                if(fileName == "" && req.getParameter("imageslink") != null ) {
	        	    	images = req.getParameter("imageslink");
	        	    }else {
	        	    	images = fileName;
	        	    }	        	    	
	            }
	        }
	    } catch (FileNotFoundException fne) {
	        req.setAttribute("message", "Có lỗi xảy ra: " + fne.getMessage());
	    }
	    

	
		if(url.contains("insert")) {
		
			CategoryModel category = new CategoryModel();
			category.setCategoryname(categoryname);
			category.setStatus(status);
			category.setImages(images);
			cateService.insert(category);
			resp.sendRedirect(req.getContextPath() + "/admin/categories");
		}else if(url.contains("update")) {
			
			int categoryid = Integer.parseInt(req.getParameter("categoryid"));
			if(images == "") {
				
				CategoryModel a = cateService.findById(categoryid);
				images = a.getImages();
			}
			
			CategoryModel category = new CategoryModel();
			category.setCategoryid(categoryid);
			category.setCategoryname(categoryname);
			category.setStatus(status);
			category.setImages(images);
			cateService.update(category);
			resp.sendRedirect(req.getContextPath() + "/admin/categories");
		}
	}

}