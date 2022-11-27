package controller.review;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.ReviewDAOImpl;
import model.ReviewDTO;

public class deleteReviewController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ReviewDAOImpl reviewDao = new ReviewDAOImpl();
		int ReviewNum = Integer.parseInt(request.getParameter("ReviewNum"));
		int result = 0;
		result = reviewDao.deleteReview(ReviewNum);
		if(result != 0) {
			return "redirect:/review.jsp";
		}else {
			return "review.jsp";
		}
		
	}

}
