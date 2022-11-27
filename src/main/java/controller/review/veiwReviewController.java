package controller.review;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.ReviewDAOImpl;
import model.ReviewDTO;

public class veiwReviewController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ReviewDAOImpl reviewDao = new ReviewDAOImpl();
		int ReviewNum = Integer.parseInt(request.getParameter("ReviewNum"));
		
		ReviewDTO review = reviewDao.getReview(ReviewNum);
		request.setAttribute("review", review);
		return "review.jsp";
	}

}
