<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">
<!-- <script type="text/javascript">

function f1(z) {
	
	var a=document.getElementById("1st");
	var b=document.getElementById("2nd");
	var c=document.getElementById("3rd");
	var d=document.getElementById("4th");
	var e=document.getElementById("5th");
	

	if(z.value=="1") {
			
			a.style.color="red";
			b.style.color="black";
			c.style.color="black";
			d.style.color="black";
			e.style.color="black";
					
	}
	if(z.value=="2") {
		
			a.style.color="orange";
			b.style.color="orange";
			c.style.color="black";
			d.style.color="black";
			e.style.color="black";

	}
	if(z.value=="3") {
			a.style.color="yellow";
			b.style.color="yellow";
			c.style.color="yellow";
			d.style.color="black";
			e.style.color="black";
	}
	if(z.value=="4") {
		a.style.color="blue";
		b.style.color="blue";
		c.style.color="blue";
		d.style.color="blue";
		e.style.color="black";
	}
	if(z.value=="5") {
		a.style.color="green";
		b.style.color="green";
		c.style.color="green";
		d.style.color="green";
		e.style.color="green";
	}
	
}

</script> -->
<style>
    .form-group {
	margin: 0;
	padding: 0;
	position:relative;
	padding-bottom: 35px;
}

.rating {
	position: absolute;
	
	left: 11%;
	bottom:-69px;
	transform: translate(-50%,-50%) rotateY(180deg);
	display: flex;
}

.rating input {
	display: none;
}

.rating label {
    display: block;
    cursor: pointer;
    width: 50px;
}

.rating label:before {
	content: '\f005';
	font-family: fontAwesome;
	position: relative;
	display: block;
	font-size: 50px;
	color: #101010;
}

.rating label:after {
	content: '\f005';
	font-family: fontAwesome;
    position: absolute;
	display: block;
	font-size: 50px;
	color: #eec100;
	top: 0;
	opacity: 0;
    transition: .5s;
    text-shadow: 0 2px 5px rgba(80, 50, 0, 8.5);
}

.rating label:hover:after,
.rating label:hover ~ label:after,
.rating input:checked ~ label:after {
	opacity: 1;
}

    td.details-control {
    background: url('staffResources/images/details_open.png') no-repeat center center;
    cursor: pointer;
}
    tr.shown td.details-control {
        background: url('staffResources/images/details_close.png') no-repeat center center;
    }
</style>

<head>
<title>:: Bank AI System ::</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
<meta name="description" content="Lucid Bootstrap 4.1.1 Admin Template">
<meta name="author" content="WrapTheme, design by: ThemeMakker.com">

<link rel="icon" href="favicon.ico" type="image/x-icon">
<!-- VENDOR CSS -->
<link rel="stylesheet" href="staffResources/css/bootstrap.min.css">
<link rel="stylesheet" href="staffResources/css/font-awesome.min.css">
<link rel="stylesheet" href="staffResources/css/bootstrap-multiselect.css">
<link rel="stylesheet" href="staffResources/css/parsley.css">

<!-- MAIN CSS -->
<link rel="stylesheet" href="staffResources/css/main.css">
<link rel="stylesheet" href="staffResources/css/color_skins.css">
</head>
<body class="theme-cyan">

<!-- Page Loader
<div class="page-loader-wrapper">
    <div class="loader">
        <div class="m-t-30"><img src="staffResources/images/logo-icon.svg" width="48" height="48" alt="Lucid"></div>
        <p>Please wait...</p>        
    </div>
</div>
Overlay For Sidebars -->

<div id="wrapper">

    <div id="main-content">
        <div class="container-fluid">
            <div class="block-header">
                <div class="row">
                    <div class="col-lg-6 col-md-8 col-sm-12">
                        <h2><a href="javascript:void(0);" class="btn btn-xs btn-link btn-toggle-fullwidth">
                        <i class="fa fa-arrow-left"></i></a>Manage Feedback</h2>
                        <ul class="breadcrumb">
                            <li class="breadcrumb-item"><a href="index.jsp"><i class="icon-home"></i></a></li>                            
                            <li class="breadcrumb-item">Manage Feedback</li>
                            <li class="breadcrumb-item active">Add Feedback</li>
                        </ul>
                    </div>            
                                    </div>
            </div>

            <div class="row clearfix">
                <div class="col-md-12">
                    <div class="card">
                        <div class="header">
                            <h2>Add Feedback</h2>
                        </div>
                        <div class="body">
                            <form id="basic-form" method="post" action="<%=request.getContextPath()%>/FeedbackController" novalidate>
                                
                                
                                <div class="form-group">
                                    <label>Feedback Description</label>
                                    <textarea class="form-control" name="feedbackDescription" rows="5" cols="30" required="required"></textarea>
                               		<input type="hidden" value="insert" name="flag">
                                </div>  
                                
                                 <div class="form-group">     
                                      <label>Feedback Rating</label>
                                            <br><br>	
                                             <div class="rating">
   	  											<input type="radio" name="feedbackRating" id="star5" value="5"> 
   	  <label for="star5" data-toggle="tooltip" data-original-title="EXCELENT"></label>

   	   <input type="radio" name="feedbackRating" id="star4" value="4"> 
   	  <label for="star4" data-toggle="tooltip" data-original-title="GREAT"></label>

   	   <input type="radio" name="feedbackRating" id="star3" value="3"> 
   	  <label for="star3" data-toggle="tooltip" data-original-title="VERY GOOD"></label>

   	   <input type="radio" name="feedbackRating" id="star2" value="2"> 
   	  <label for="star2" data-toggle="tooltip" data-original-title="GOOD"></label>

   	   <input type="radio" name="feedbackRating" id="star1" value="1"> 
   	  <label for="star1" data-toggle="tooltip" data-original-title="BAD"></label>
   </div>
   </div>
    <button type="submit" class="btn btn-primary">Submit</button>
                                    <button type="reset" class="btn btn-primary">Reset</button>                         
                            </form>
                        </div>
                    </div>
                </div>
              </div>
            
        </div>
    </div>
    
</div>

<!-- Javascript -->
<script src="staffResources/js/libscripts.bundle.js"></script>    
<script src="staffResources/js/vendorscripts.bundle.js"></script>

<script src="staffResources/js/bootstrap-multiselect.js"></script>
<script src="staffResources/js/parsley.min.js"></script>
    
<script src="staffResources/js/mainscripts.bundle.js"></script>
<script>
    $(function() {
        
    	// validation needs name of the element
        $('#food').multiselect();

        // initialize after multiselect
        $('#basic-form').parsley();
    });
    </script>
</body>
</html>

