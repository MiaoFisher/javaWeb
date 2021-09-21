package com.servletTest;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

//文件下载的具体步骤
public class DownloadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.先获取文件名（在这里先写死）
        System.out.println("hello");
        String fileName = "1.jpg";
        //2.读取要下载的内容，通过servletContext可以获得,并且获取文件类型
        String mimeType = getServletContext().getMimeType("/" + fileName);
        System.out.println("文件的类型:" + mimeType);
        //3.在回传之前，通过响应头告诉客户端返回的数据类型
        response.setContentType(mimeType);
        //4.根据文件路径，获得文件的输入流
        InputStream resourceAsStream = getServletContext().getResourceAsStream("/" + fileName);
        //5.获取响应的输出流
        ServletOutputStream outputStream = response.getOutputStream();
        //6.通过IOUtils可以将输出流和输出流关联起来，将输入流的内容直接通过输出流输出
        IOUtils.copy(resourceAsStream,outputStream);
        //7.还要告诉客户端，收到的数据用于下载 attachment：是附件的意思,后面是下载的文件的名称(可以和原来的文件名不一样),这里是下载后用户获得的名称
        //URLEncoder是将文件名的编码进行utf-8编码，防止乱码
        response.setHeader("Content-Disposition","attachment;filename=" + URLEncoder.encode("花flower.jpg","utf-8"));

    }
}
