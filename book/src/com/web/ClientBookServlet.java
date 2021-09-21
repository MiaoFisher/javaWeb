package com.web;

import com.pojo.Book;
import com.pojo.Page;
import com.service.BookService;
import com.service.impl.BookServiceImpl;
import com.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ClientBookServlet extends BaseServlet{
    //创建bookService对象
    private BookService bookService = new BookServiceImpl();
    public void page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取pageNo和pageSize参数
        int pageNo = WebUtils.parseInt(request.getParameter("pageNo"), 1);
        //设置pageSize参数
        int pageSize = WebUtils.parseInt(request.getParameter("pageSize"), Page.PAGE_SIZE);
        //2.根据pageNo 和 pageSize 获取page对象
        Page<Book> page = bookService.page(pageNo, pageSize);
        //3.保存page对象
        request.setAttribute("page",page);
        //4.设置当前页面地址
        page.setUrl("client/bookClientServlet?action=page");
        //5.请求转发到client/index.jsp页面中
        request.getRequestDispatcher("/pages/client/shop.jsp").forward(request,response);
    }
    public void pageByPrice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取pageNo和pageSize参数
        int pageNo = WebUtils.parseInt(request.getParameter("pageNo"), 1);
        //获取max和min参数(默认为0 和 Integer.MAX_VALUE)
        int min = WebUtils.parseInt(request.getParameter("min"), 0);
        int max = WebUtils.parseInt(request.getParameter("max"), Integer.MAX_VALUE);
        //设置pageSize参数
        int pageSize = WebUtils.parseInt(request.getParameter("pageSize"), Page.PAGE_SIZE);
        //2.根据pageNo 和 pageSize 获取page对象
        Page<Book> page = bookService.pageByPrice(pageNo, pageSize,min,max);
        //3.保存page对象
        request.setAttribute("page",page);
        //4.设置当前页面地址
        StringBuffer sb = new StringBuffer("client/bookClientServlet?action=pageByPrice");
        if (request.getParameter("min")!=null){
            sb.append("&min=").append(request.getParameter("min"));
        }
        if (request.getParameter("max")!=null){
            sb.append("&max=").append(request.getParameter("max"));
        }
        page.setUrl(sb.toString());
        //5.请求转发到client/index.jsp页面中
        request.getRequestDispatcher("/pages/client/shop.jsp").forward(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
