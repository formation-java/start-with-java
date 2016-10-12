package fr.glouglouwine.server;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private Long numberOfCall = 0L;

	private Logger logger = Logger.getLogger(BaseServlet.class.getCanonicalName());

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/plain");
		String xIdGlouGlou = req.getHeader("X-Id-GlouGlou");
		incrementCalls();
		String message = "I am [" + this + "] executing in thread " + Thread.currentThread().getId()
				+ " and I've been called [" + numberOfCall + "] time from " + xIdGlouGlou + "\n";
		logger.info(message);
		resp.getWriter().write(message);
	}

	private synchronized void incrementCalls() {
			numberOfCall++;	
	}

}
