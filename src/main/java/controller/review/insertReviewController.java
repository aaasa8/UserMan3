package controller.review;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.ReviewDAOImpl;
import model.ReviewDTO;

public class insertReviewController implements Controller {
	private static final Logger log = LoggerFactory.getLogger(insertReviewController.class);
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ReviewDAOImpl reviewDao = new ReviewDAOImpl();
		int ReviewNum = Integer.parseInt(request.getParameter("ReviewNum"));
		int postNum = Integer.parseInt(request.getParameter("postNum"));
		String date = request.getParameter("reviewWriteDate");
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH시 mm분");
		Date reviewWriteDate = formatter.parse(date);
		ReviewDTO review = new ReviewDTO(
				ReviewNum, 
				request.getParameter("revivewContent"),
				reviewWriteDate,
				postNum, 
				request.getParameter("reviewWriterId"));
		int result = 0;
		result = reviewDao.insertReview(review);
		if(result != 0) {
			return "redirect:reviewInsert.jsp";
		}else {
			return "review.jsp";
		}
	}

}
