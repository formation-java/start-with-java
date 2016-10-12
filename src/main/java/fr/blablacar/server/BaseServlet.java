package fr.blablacar.server;

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

	// Shell call for demo is :
	//for i in 1 2 3 4 5 ; do curl 'http://localhost:8080/' -H "X-Id-Blabla: $i" ; done

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/plain");
		String xIdBlabla = req.getHeader("X-Id-Blabla");
		incrementCalls();
		String message = "I am [" + this + "] executing in thread " + Thread.currentThread().getId()
				+ " and I've been called [" + numberOfCall + "] time from " + xIdBlabla + "\n";
		logger.info(message);
		resp.getWriter().write(message);
	}

	private synchronized void incrementCalls() {
			numberOfCall++;	
	}

}
