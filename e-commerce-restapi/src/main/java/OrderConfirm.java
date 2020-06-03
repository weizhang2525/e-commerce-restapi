/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.console;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.JSONArray;
import org.json.JSONObject;
import java.sql.*;

/**
 *
 * @author jonathanlun
 */
public class OrderConfirm extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet OrderConfirm</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet OrderConfirm at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        JSONArray orderJson = new JSONArray();
        try {
            // 0. Check for driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 1. Get a connectiong to database
            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Nuance9?useSSL=false&serverTimezone=PST", "user", "test123");

            // 2. Create a statement3
            Statement myStmt = myConn.createStatement();

            // 3. Get last customer id
//            ResultSet c = myStmt.executeQuery("SELECT MAX('cid') AS lastCustomer FROM orders");
//            c.next();

            HttpSession session = request.getSession();
           
            int customer = (Integer)(session.getAttribute("cid"));
//            out.println(customer);
            
            ResultSet order = myStmt.executeQuery("SELECT * from orders WHERE cid='" + customer + "'");
            order.next();
             
            // 4. Get essential info first
//            out.println("Test 4");
            JSONObject orderdate = new JSONObject();
            orderdate.put("date", order.getString("order_date"));
            orderJson.put(orderdate);

            ResultSet cus = myStmt.executeQuery("SELECT * from customers WHERE cid='" + customer + "'");
            cus.next();
            JSONObject customerinfo= new JSONObject();
//            out.println("1");
            customerinfo.put("name",cus.getString("fname") + " " + cus.getString("lname"));
            customerinfo.put("email", cus.getString("email"));
            customerinfo.put("phone", cus.getString("phone"));
            customerinfo.put("address", cus.getString("street_address"));
            customerinfo.put("csz", cus.getString("city") + ", " + cus.getString("us_state") + " " + cus.getString("zip"));
            orderJson.put(customerinfo);

            ResultSet cc = myStmt.executeQuery("SELECT * from creditcards WHERE cid='" + customer + "'");
//            out.println("2");
            cc.next();
            JSONObject creditcard = new JSONObject();
            creditcard.put("ccnum", cc.getString("ccnum"));
            creditcard.put("exp", cc.getString("expiration"));
            orderJson.put(creditcard);
            
            // 5. Get product set
            double customerTotal = (Double)session.getAttribute("cartTotal");
//            while(order.next())
//            {
//                JSONObject item = new JSONObject();
//                customerTotal += order.getInt("total");
//                String pid = order.getString("pid");
////                ResultSet product = myStmt.executeQuery("SELECT * from products WHERE pid='" + pid + "'");
//                out.println("3");
////                product.next();
////                item.put("name", product.getString("pname"));
//                item.put("pid", pid);
//                item.put("quantity", order.getInt("quantity"));
//                orderJson.put(item);
//            }
            
            //6. Get total
            JSONObject total = new JSONObject();
            total.put("t", customerTotal);
            orderJson.put(total);
            
            out.println(orderJson);
        }
        catch (Exception e) {
            out.println("[ERROR - S]: " + e.toString());
            // out.println("TEST S - 2");
            e.printStackTrace();
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
