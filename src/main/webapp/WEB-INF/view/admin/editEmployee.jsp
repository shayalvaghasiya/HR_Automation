<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <title>Rushmile Admin</title>
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
    <!-- partial:../../partials/_navbar.html -->
    
    <jsp:include page="header.jsp"></jsp:include>
    
    <!-- partial -->
    <div class="container-fluid page-body-wrapper">
      <div class="row row-offcanvas row-offcanvas-right">
        <!-- partial:../../partials/_settings-panel.html -->
        <div class="theme-setting-wrapper">
          <div id="settings-trigger"><i class="mdi mdi-settings"></i></div>
          <div id="theme-settings" class="settings-panel">
            <i class="settings-close mdi mdi-close"></i>
            <p class="settings-heading">SIDEBAR SKINS</p>
            <div class="sidebar-bg-options selected" id="sidebar-light-theme"><div class="img-ss rounded-circle bg-light border mr-3"></div>Light</div>
            <div class="sidebar-bg-options" id="sidebar-dark-theme"><div class="img-ss rounded-circle bg-dark border mr-3"></div>Dark</div>
            <p class="settings-heading mt-2">HEADER SKINS</p>
            <div class="color-tiles mx-0 px-4">
              <div class="tiles primary"></div>
              <div class="tiles success"></div>
              <div class="tiles warning"></div>
              <div class="tiles danger"></div>
              <div class="tiles pink"></div>
              <div class="tiles info"></div>
              <div class="tiles dark"></div>
              <div class="tiles default"></div>
            </div>
          </div>
        </div>
        <div id="right-sidebar" class="settings-panel">
          <i class="settings-close mdi mdi-close"></i>
          <ul class="nav nav-tabs" id="setting-panel" role="tablist">
            <li class="nav-item">
              <a class="nav-link active" id="todo-tab" data-toggle="tab" href="#todo-section" role="tab" aria-controls="todo-section" aria-expanded="true">TO DO LIST</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" id="chats-tab" data-toggle="tab" href="#chats-section" role="tab" aria-controls="chats-section">CHATS</a>
            </li>
          </ul>
          <div class="tab-content" id="setting-content">
            <div class="tab-pane fade show active scroll-wrapper" id="todo-section" role="tabpanel" aria-labelledby="todo-section">
              <div class="add-items d-flex px-3 mb-0">
                <form class="form w-100">
                  <div class="form-group d-flex">
                    <input type="text" class="form-control todo-list-input" placeholder="Add To-do">
                    <button type="submit" class="add btn btn-primary todo-list-add-btn" id="add-task">Add</button>
                  </div>
                </form>
              </div>
              <div class="list-wrapper px-3">
                <ul class="d-flex flex-column-reverse todo-list">
                  <li>
                    <div class="form-check">
                      <label class="form-check-label">
                        <input class="checkbox" type="checkbox">
                        Team review meeting at 3.00 PM
                      </label>
                    </div>
                    <i class="remove mdi mdi-close-circle-outline"></i>
                  </li>
                  <li>
                    <div class="form-check">
                      <label class="form-check-label">
                        <input class="checkbox" type="checkbox">
                        Prepare for presentation
                      </label>
                    </div>
                    <i class="remove mdi mdi-close-circle-outline"></i>
                  </li>
                  <li>
                    <div class="form-check">
                      <label class="form-check-label">
                        <input class="checkbox" type="checkbox">
                        Resolve all the low priority tickets due today
                      </label>
                    </div>
                    <i class="remove mdi mdi-close-circle-outline"></i>
                  </li>
                  <li class="completed">
                    <div class="form-check">
                      <label class="form-check-label">
                        <input class="checkbox" type="checkbox" checked>
                        Schedule meeting for next week
                      </label>
                    </div>
                    <i class="remove mdi mdi-close-circle-outline"></i>
                  </li>
                  <li class="completed">
                    <div class="form-check">
                      <label class="form-check-label">
                        <input class="checkbox" type="checkbox" checked>
                        Project review
                      </label>
                    </div>
                    <i class="remove mdi mdi-close-circle-outline"></i>
                  </li>
                </ul>
              </div>
              <div class="events py-4 border-bottom px-3">
                <div class="wrapper d-flex mb-2">
                  <i class="mdi mdi-circle-outline text-primary mr-2"></i>
                  <span>Feb 11 2018</span>
                </div>
                <p class="mb-0 font-weight-thin text-gray">Creating component page</p>
                <p class="text-gray mb-0">build a js based app</p>
              </div>
              <div class="events pt-4 px-3">
                <div class="wrapper d-flex mb-2">
                  <i class="mdi mdi-circle-outline text-primary mr-2"></i>
                  <span>Feb 7 2018</span>
                </div>
                <p class="mb-0 font-weight-thin text-gray">Meeting with Alisa</p>
                <p class="text-gray mb-0 ">Call Sarah Graves</p>
              </div>
            </div>
            <!-- To do section tab ends -->
            <div class="tab-pane fade" id="chats-section" role="tabpanel" aria-labelledby="chats-section">
              <div class="d-flex align-items-center justify-content-between border-bottom">
                <p class="settings-heading border-top-0 mb-3 pl-3 pt-0 border-bottom-0 pb-0">Friends</p>
                <small class="settings-heading border-top-0 mb-3 pt-0 border-bottom-0 pb-0 pr-3 font-weight-normal">See All</small>
              </div>
              <ul class="chat-list">
                <li class="list active">
                  <div class="profile"><img src="<%=request.getContextPath()%>/adminResource/images/face1.jpg" alt="image"><span class="online"></span></div>
                  <div class="info">
                    <p>Thomas Douglas</p>
                    <p>Available</p>
                  </div>
                  <small class="text-muted my-auto">19 min</small>
                </li>
                <li class="list">
                  <div class="profile"><img src="<%=request.getContextPath()%>/adminResource/images/face2.jpg" alt="image"><span class="offline"></span></div>
                  <div class="info">
                    <div class="wrapper d-flex">
                      <p>Catherine</p>
                    </div>
                    <p>Away</p>
                  </div>
                  <div class="badge badge-success badge-pill my-auto mx-2">4</div>
                  <small class="text-muted my-auto">23 min</small>
                </li>
                <li class="list">
                  <div class="profile"><img src="<%=request.getContextPath()%>/adminResource/images/face3.jpg" alt="image"><span class="online"></span></div>
                  <div class="info">
                    <p>Daniel Russell</p>
                    <p>Available</p>
                  </div>
                  <small class="text-muted my-auto">14 min</small>
                </li>
                <li class="list">
                  <div class="profile"><img src="<%=request.getContextPath()%>/adminResource/images/face4.jpg" alt="image"><span class="offline"></span></div>
                  <div class="info">
                    <p>James Richardson</p>
                    <p>Away</p>
                  </div>
                  <small class="text-muted my-auto">2 min</small>
                </li>
                <li class="list">
                  <div class="profile"><img src="<%=request.getContextPath()%>/adminResource/images/face5.jpg" alt="image"><span class="online"></span></div>
                  <div class="info">
                    <p>Madeline Kennedy</p>
                    <p>Available</p>
                  </div>
                  <small class="text-muted my-auto">5 min</small>
                </li>
                <li class="list">
                  <div class="profile"><img src="<%=request.getContextPath()%>/adminResource/images/face6.jpg" alt="image"><span class="online"></span></div>
                  <div class="info">
                    <p>Sarah Graves</p>
                    <p>Available</p>
                  </div>
                  <small class="text-muted my-auto">47 min</small>
                </li>
              </ul>
            </div>
            <!-- chat tab ends -->
          </div>
        </div>
        <!-- partial -->
        <!-- partial:../../partials/_sidebar.html -->
        <jsp:include page="menu.jsp"></jsp:include>
        
                <!-- partial -->
        <div class="content-wrapper">
          <div class="row grid-margin">
            <div class="col-12">
              <div class="card">
                
              </div>
            </div>
          </div>
          <div class="row grid-margin">
            <div class="col-lg-12">
              <div class="card">
                <div class="card-body">
                  <h4 class="card-title">Edit Employee</h4>
                  
                  <%@taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
                  <%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
                  
                  <f:form class="cmxform" id="commentForm" method="post" action="updateEmployee.html" modelAttribute="EmployeeVO">
                    
                    <f:hidden path="id"/>
                    <f:hidden path="loginVO.id" />
                    
                    <fieldset>
                      <div class="form-group">
                        <label for="fname"><i style="color: #fb9678 !important">* </i>First Name </label>
                        <f:input id="fname" class="form-control" path="employeeFirstName" minlength="2" type="text" />
                      </div> 
                      
                         <div class="form-group">
                        <label for="lname"><i style="color: #fb9678 !important">* </i>Last Name </label>
                        <f:input id="lname" class="form-control" path="employeeLastName" minlength="2" type="text" />
                      </div>
                      
                      <div class="form-group">
                        <label for="eid"><i style="color: #fb9678 !important">* </i>Employee-id </label>
                        <f:input id="eid" class="form-control" type="text" path="employeeIDno" />
                      </div>
                      
                      <div class="form-group">
                        <label for="dept"><i style="color: #fb9678 !important">* </i>Department </label>
                        <f:select id="dept" class="form-control"  path="departmentVO.id">
                        	 <c:forEach items="${departmentList}" var="i" >
                      		<option value="${i.id}">${i.departmentName}</option>
                      	</c:forEach>
                     
                        </f:select>
                      </div>
                      
                      <div class="form-group">
                        <label for="desg"><i style="color: #fb9678 !important">* </i>Designation </label>
                        <f:select id="desg" class="form-control"  path="designationVO.id">
                       <c:forEach items="${designationList}" var="i" >
                      		<option value="${i.id}">${i.designationName}</option>
                      	</c:forEach>
                     
                      </f:select>
                      </div>
                                            
                      <div class="form-group">
                        <label for="cemail"><i style="color: #fb9678 !important">* </i>E-Mail </label>
                        <f:input id="cemail" class="form-control" type="email" path="loginVO.userName" />
                      </div>
                      
                       <div class="form-group">
                        <label for="pass"><i style="color: #fb9678 !important">* </i>Password </label>
                        <f:input id="pass" class="form-control" type="text" path="loginVO.password" />
                      </div>
                     
                      
                      <div class="form-group">
                        <label for="cnum"><i style="color: #fb9678 !important">* </i>Contact Number</label>
                        <f:input id="cnum" class="form-control" type="number" maxlength="10" path="employeeContact" />
                      </div>
                      
                      <div class="form-group">
                        <label for="add"><i style="color: #fb9678 !important">* </i>Address </label>
                        <f:textarea rows="5" cols="60" class="form-control" path="employeeAddress" ></f:textarea>
                      </div>
                      <div class="form-group">
                        <label for="dob"><i style="color: #fb9678 !important">* </i>Date of Birth </label>
                        <f:input id="dob" class="form-control" type="date" path="employeeDateofBirth" />
                      </div>
                      
                      <div class="form-group">
                        <label for="bg"><i style="color: #fb9678 !important">* </i>Blood Group</label>
                        <select id="bg" class="form-control" name="employeeBloodGroup" required>
                        <option>select</option>
                        <option>A+</option>
                        <option>A-</option>
                        <option>B+</option>
                        <option>B-</option>
                        <option>AB+</option>
                        <option>AB-</option>
                        <option>O+</option>
                        <option>O-</option>
                        
                        </select>
                      </div>
                      
                      <div class="form-group">
                        <label for="status"><i style="color: #fb9678 !important">* </i>Marital Status </label>
                        <f:radiobutton path="employeeMaritalStatus" value="single" />Single
                        <f:radiobutton path="employeeMaritalStatus" value="married" />Married
                      </div>
                      
                      
                      <input class="btn btn-primary" type="submit" value="Submit">
                    </fieldset>
                  </f:form>
                </div>
              </div>
            </div>
          </div>
          <div class="row">
            <div class="col-lg-12">
              
            </div>
          </div>
        </div>
        <!-- content-wrapper ends -->
        <!-- partial:../../partials/_footer.html -->
        
        <jsp:include page="footer.jsp"></jsp:include>
        
        <!-- partial -->
      </div>
      <!-- row-offcanvas ends -->
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
  <!-- Plugin js for this page-->
  <script src="<%=request.getContextPath()%>/adminResource/js/jquery.validate.min.js"></script>
  <script src="<%=request.getContextPath()%>/adminResource/js/bootstrap-maxlength.min.js"></script>
  <!-- End plugin js for this page-->
  <!-- inject:js -->
  <script src="<%=request.getContextPath()%>/adminResource/js/off-canvas.js"></script>
  <script src="<%=request.getContextPath()%>/adminResource/js/hoverable-collapse.js"></script>
  <script src="<%=request.getContextPath()%>/adminResource/js/misc.js"></script>
  <script src="<%=request.getContextPath()%>/adminResource/js/settings.js"></script>
  <script src="<%=request.getContextPath()%>/adminResource/js/todolist.js"></script>
  <!-- endinject -->
  <!-- Custom js for this page-->
  <script src="<%=request.getContextPath()%>/adminResource/js/form-validation.js"></script>
  <script src="<%=request.getContextPath()%>/adminResource/js/bt-maxLength.js"></script>
  <!-- End custom js for this page-->
</body>

</html>
    