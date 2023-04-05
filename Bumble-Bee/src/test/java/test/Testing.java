package test;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import org.junit.Test;
import org.mockito.Mockito;

import com.apassingment.bumblebee.service.BrandService;
import com.apassingment.bumblebee.service.LoginService;

public class Testing extends Mockito{
	
	protected LoginService loginService =LoginService.getLoginService();
	
	protected BrandService brandService = BrandService.getBrandServiceService();
	
    @Test
    public void testServlet() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);       
        HttpServletResponse response = mock(HttpServletResponse.class);    

        when(request.getParameter("username")).thenReturn("admin");
        when(request.getParameter("password")).thenReturn("123");

        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);

        new Testing().doPost(request, response);

        verify(request, atLeast(1)).getParameter("username"); // only if you want to verify username was called...
        writer.flush(); // it may not have been flushed yet...
        //assertTrue(stringWriter.toString().contains("My expected string"));
    }

	private void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
}