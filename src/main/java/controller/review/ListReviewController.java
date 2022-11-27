package controller.review;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.ReviewDAOImpl;
import model.ReviewDTO;

public class ListReviewController implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ReviewDAOImpl reviewDao = new ReviewDAOImpl();
		
		List<ReviewDTO> reviewList = reviewDao.getReviewList(request.getParameter("reviewWriterId"));
		
		request.setAttribute("revireList", reviewList);
		
		return "review.jsp";
	}

}
