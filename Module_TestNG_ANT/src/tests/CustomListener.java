package tests;
import java.util.Date;
import java.sql.*;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;




public class CustomListener extends TestListenerAdapter {
	
	
		public final String ver = "3.0" ;
		public final String rev = "4563";
		public String msg;
		private Connection con;
	 	
		public void insert(String t_name,String	 s_time,String e_time,String status,ITestResult timer){
	 		
			try{
	 			
	 	        if (timer.getEndMillis() - timer.getStartMillis() >= timer.getMethod().getTimeOut() && timer.getMethod().getTimeOut()!=0) {
	 	            msg = "the method "+t_name+" has been timeOut";
	 	            Reporter.log("<p style='background-color:#ffff42'>"+msg+"</p>");
	 	          
	 	        }
	 	        else{
	 	        	msg = null;
	 	        }
	 			
	 	        Class.forName("com.mysql.jdbc.Driver");
	 			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
	 			String query = "INSERT INTO selenium (test_name,result_type,start_time,end_time,message,version,revision_no)"
	 					+ " VALUES(?,?,?,?,?,?,?)";
		 		PreparedStatement preparedStmt = con.prepareStatement(query);
		 	      
		 		  preparedStmt.setString (1, t_name);
		 	      preparedStmt.setString (2, status);
		 	      preparedStmt.setString (3, s_time);
		 	      preparedStmt.setString (4, e_time);
		 	      preparedStmt.setString (5, msg   );
		 	      preparedStmt.setString (6, ver   );
		 	      preparedStmt.setString (7, rev   );
		 	      preparedStmt.execute();
	 			
	 		} catch(Exception ex){
	 			System.out.println("error:"+ex);
	 		}
	 	}

	 	@Override
	    public void onTestFailure(ITestResult tr) {
	 	  	insert(tr.getName(),new Date(tr.getStartMillis()).toString(),new Date(tr.getEndMillis()).toString(),"FAIL",tr);
	 		log(tr.getName()+"FAILED\n");
			    
	    }
		 
	
		@Override
	    public void onTestSkipped(ITestResult tr) {
	    	insert(tr.getName(),new Date(tr.getStartMillis()).toString(),new Date(tr.getEndMillis()).toString(),"SKIP",tr);
	        log(tr.getName()+"SKIPPED\n");
	    }
		 
	    @Override
	    public void onTestSuccess(ITestResult tr) {
	    	insert(tr.getName(),new Date(tr.getStartMillis()).toString(),new Date(tr.getEndMillis()).toString(),"PASS",tr);
	    	log(tr.getName()+"PASSED TEST\n");
	    }
		 
	    private void log(String string) {
	        System.out.print(string+"after clearing work space");
	      
	     
	    }


}
