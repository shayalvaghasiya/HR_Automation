<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <title>Rushmile</title>
  <!-- plugins:css -->
  <link rel="stylesheet" href="<%=request.getContextPath()%>/adminResource/css/materialdesignicons.min.css">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/adminResource/css/simple-line-icons.css">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/adminResource/css/flag-icon.min.css">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/adminResource/css/perfect-scrollbar.min.css">
  <!-- endinject -->
  <!-- plugin css for this page -->
  <!-- End plugin css for this page -->
  <!-- inject:css -->
  <link rel="stylesheet" href="<%=request.getContextPath()%>/adminResource/css/style.css">
  <!-- endinject -->
  <link rel="shortcut icon" href="<%=request.getContextPath()%>/adminResource/images/imageHR.jpg" />
</head>

<body>
  <div class="container-scroller">
    <div class="container-fluid page-body-wrapper">
      <div class="row">
        <div class="content-wrapper full-page-wrapper d-flex align-items-center auth login-full-bg">
          <div class="row w-100">
            <div class="col-lg-4 mx-auto">
              <div class="auth-form-dark text-left p-5">
                <h2>Login</h2>
                <h4 class="font-weight-light">Hello! let's get started</h4>
               
                <form class="pt-5" action="step2" method="post">
               
                  <div class="form-group">
                    <label for="exampleInputEmail1">OTP</label>
                    <input type="text" class="form-control" id="otp" placeholder="OTP" name="otp">
                    <i class="mdi mdi-account"></i>
                  </div><span id="otpSpn"></span>
               
                  <div class="form-group">
                    <label for="exampleInputPassword1">Password</label>
                    <input type="password" class="form-control" id="password" placeholder="Password" name="password">
                    <i class="mdi mdi-eye"></i>
                  </div><span id="pwdSpn"></span>
                  
                  <div class="form-group">
                    <label for="exampleInputPassword1">Confirm Password</label>
                    <input type="password" class="form-control" id="confirmpassword" placeholder="confirmpassword" name="confirmpassword">
                    <i class="mdi mdi-eye"></i>
                  </div><span id="con_pwdSpn"></span>
                  
                  <div class="mt-5">   
                   <button class="btn btn-block btn-warning btn-lg font-weight-medium">Submit</button>
                  </div>
                  
                  
                </form>
              </div>
            </div>
          </div>
        </div>
        <!-- content-wrapper ends -->
      </div>
      <!-- row ends -->
    </div>
    <!-- page-body-wrapper ends -->
  </div>
  <!-- container-scroller -->
  <!-- plugins:js -->
  <script src="<%=request.getContextPath()%>/adminResource/js/jquery.min.js"></script>
  <script src="<%=request.getContextPath()%>/adminResource/js/popper.min.js"></script>
  <script src="<%=request.getContextPath()%>/adminResource/js/bootstrap.min.js"></script>
  <script src="<%=request.getContextPath()%>/adminResource/js/perfect-scrollbar.jquery.min.js"></script>
  <!-- endinject -->
  <!-- inject:js -->
  <script src="<%=request.getContextPath()%>/adminResource/js/off-canvas.js"></script>
  <script src="<%=request.getContextPath()%>/adminResource/js/hoverable-collapse.js"></script>
  <script src="<%=request.getContextPath()%>/adminResource/js/misc.js"></script>
  <script src="<%=request.getContextPath()%>/adminResource/js/settings.js"></script>
  <script src="<%=request.getContextPath()%>/adminResource/js/todolist.js"></script>
  
  
  <script type="text/javascript">
		
		var generatedOTP = <%=session.getAttribute("generatedOTP")%>;
		
		$("#otp").keyup(function(){
			
			
			
			if(generatedOTP == $("#otp").val()){
				$("#otpSpn").html("OTP Matched.");
				$("#otpSpn").css("color" , "green");
				$("#otpSpn").css("font-weight" , "bold");
				$("#calculate").attr("disabled" , false);
			}
			else{
				$("#otpSpn").html("Wrong OTP.");
				$("#otpSpn").css("color" , "red");
				$("#otpSpn").css("font-weight" , "bold");
				$("#calculate").attr("disabled" , true);
			}
			
		});
		
		
		$("#confirmpassword").keyup(function()
				{
					if($("#password").val() == $("#confirmpassword").val()){
						$("#con_pwdSpn").html("Password Matched.");
						$("#con_pwdSpn").css("color" , "green");
						$("#con_pwdSpn").css("font-weight" , "bold");
						$("#calculate").attr("disabled" , false);
					}
					else{
						$("#con_pwdSpn").html("Wrong Password.");
						$("#con_pwdSpn").css("color" , "red");
						$("#con_pwdSpn").css("color" , "red");
						$("#con_pwdSpn").css("font-weight" , "bold");
						$("#calculate").attr("disabled" , true);
						}
				});
		  
		</script>
  
  <!-- endinject -->
</body>

</html>
    