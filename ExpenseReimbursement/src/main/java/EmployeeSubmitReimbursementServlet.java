import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EmployeeSubmitReimbursementServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
         request.getRequestDispatcher("test.html").include(request, response);
        //request.getRequestDispatcher("navbar.html").include(request, response);

        // get employee object from the session
        HttpSession session = request.getSession(false); // true to create a new session for this request if necessary; false to return null if there's no current session https://docs.oracle.com/javaee/6/api/javax/servlet/http/HttpServletRequest.html#getSession(boolean)
        Employee employee = (Employee) session.getAttribute("employee");

        // submit request to add in the reimbursement table in the database.

        out.println(
                    "<style>body{background-color: #666699}</style>" +
                    "<section class='vh-100 gradient-custom'>" +
                "<form action=\"EmployeeSubmitReimbursementServlet\" method=\"post\" > " +
                "<div class='container py-5 h-100'>" +
                "<div class='row d-flex justify-content-center align-items-center h-100'>" +
                "<div class='col-12 col-md-9 col-lg-5 col-xl-5'>" +
                "<div class='card bg-dark text-white style ='border-radius: 8rem;'>" +
                "<div class='card-body p-5 text-center'>" +

                "<div class='mb-md-5 mt-md-4 pb-5'>" +

                "<h2 class='fw-bold mb-2 text'>Employee Reimbursement</h2>" +
                "<p class='text-white-50 mb-5'></p>" +

                "<div class='form-outline form-white mb-4'>" +
                "<label class='form-label' for='detail' >Details</label>" +
                "<input type='text' id='detail' class='form-control form-control-lg' name='detail' />" +
                "</div>" +

                "<div class='form-outline form-white mb-4'>" +
                "<label class='form-label' for='amount'>Amount</label>" +
                "<input type='number' id='amount' class='form-control form-control-lg' name='amount' />" +
                "</div>" +

                "<div class='form-outline form-white mb-4'>" +
                "<label class='form-label' for='start' >Start Date:</label>" +
                "<input type='date' id='start' class='form-control form-control-lg' name='start' />" +
                "</div>" +

                "<div class='form-outline form-white mb-4'>" +
                "<label class='form-label' for='end' >End Date:</label>" +
                "<input type='date' id='end' class='form-control form-control-lg' name='end' />" +
                "</div>" +

                "<button class='btn btn-outline-primary btn-lg px-10' type='submit'>Submit</button>" +

                "</div>" +

                "</div> </div> </div> </div> </div> </form> </section> ");

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        request.getRequestDispatcher("test.html").include(request, response);

        ReimbursementDao reimbursementDao = ReimbursementDaoFactory.getReimbursementDao();

        String expenseDetail = request.getParameter("detail");
        double amount = Double.parseDouble(request.getParameter("amount"));
        String dateStart = request.getParameter("start");
        String dateEnd = request.getParameter("end");

        HttpSession httpSession = request.getSession();
        Employee employee = (Employee) httpSession.getAttribute("employee");
        //out.println("EmployeeId =" + employee.getEmployeeId() + ", Name =" + employee.getName() + ", Username =" + employee.getUsername() + ", Password =" + employee.getPassword());

        Integer ticketStatus = Reimbursement.hmap.get("PENDING");
        Reimbursement reimbursement = new Reimbursement();
        reimbursement.setExpenseDetail(expenseDetail);
        reimbursement.setAmount(amount);
        reimbursement.setDateStart(dateStart);
        reimbursement.setDateEnd(dateEnd);
        reimbursement.setTicketStatus(ticketStatus);
        reimbursement.setEmployeeId(employee.getEmployeeId());

        reimbursementDao.insert(reimbursement);

        // out.println("<h1>You have submitted a new reimbursement request!</h1>");

        response.sendRedirect("EmployeeViewPendingRequestsServlet");

    }
}

