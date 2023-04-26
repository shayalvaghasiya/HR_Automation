<nav class="sidebar sidebar-offcanvas" id="sidebar">
          <ul class="nav">
            <li class="nav-item nav-profile">
              <div class="nav-link">
                <div class="profile-image">
                  <img src="<%=request.getContextPath()%>/adminResource/images/rushmileU.jpg" alt="image"/>
                  <span class="online-status online"></span> <!--change class online to offline or busy as needed-->
                </div>
                <div class="profile-name">
                  <p class="name">
                   
                  </p>
                  <p class="designation">
                  
                  </p>
                </div>
              </div>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="index.html">
                <i class="icon-rocket menu-icon"></i>
                <span class="menu-title">Dashboard</span>
                <span class="badge badge-success">New</span>
              </a>
            </li>
                        
            
            <li class="nav-item d-none d-lg-block">
              <a class="nav-link" data-toggle="collapse" href="#sidebar-layoutss" aria-expanded="false" aria-controls="sidebar-layouts">
                <i class="icon-info  menu-icon"></i>
                <span class="menu-title">Complaint</span>
                <span class="badge badge-warning"></span>
              </a>
              <div class="collapse" id="sidebar-layoutss">
                <ul class="nav flex-column sub-menu">
                  <li class="nav-item"> <a class="nav-link" href="loadComplaint.html">Add Complaint</a></li>
                  <li class="nav-item"> <a class="nav-link" href="viewEmployeeComplaint.html">View Complaint</a></li>
                 
                </ul>
              </div>
            </li>
            
            <li class="nav-item d-none d-lg-block">
              <a class="nav-link" data-toggle="collapse" href="#sidebar-layoutss1" aria-expanded="false" aria-controls="sidebar-layouts">
                <i class="icon-bubbles menu-icon"></i>
                <span class="menu-title">Feedback</span>
                <span class="badge badge-warning"></span>
              </a>
              <div class="collapse" id="sidebar-layoutss1">
                <ul class="nav flex-column sub-menu">
                  <li class="nav-item"> <a class="nav-link" href="loadFeedback.html">Add Feedback</a></li>
                  <li class="nav-item"> <a class="nav-link" href="viewDepartment.html">View Feedback</a></li>
                 
                </ul>
              </div>
            </li>
            
            
            
            <li class="nav-item d-none d-lg-block">
              <a class="nav-link" data-toggle="collapse" href="#sidebar-layouts2" aria-expanded="false" aria-controls="sidebar-layouts">
                <i class="icon-calendar menu-icon"></i>
                <span class="menu-title"> Attendance</span>
                <span class="badge badge-warning"></span>
              </a>
              <div class="collapse" id="sidebar-layouts2">
                <ul class="nav flex-column sub-menu">
                   
                  <li class="nav-item"> <a class="nav-link" href="viewEmployeeAttendance.html">View Attendance</a></li>
                 
                </ul>
              </div>
            </li>
            
            <li class="nav-item d-none d-lg-block">
              <a class="nav-link" data-toggle="collapse" href="#sidebar-layouts3" aria-expanded="false" aria-controls="sidebar-layouts">
                <i class="icon-envelope-open menu-icon"></i>
                <span class="menu-title">Letter Type</span>
                <span class="badge badge-warning"></span>
              </a>
              <div class="collapse" id="sidebar-layouts3">
                <ul class="nav flex-column sub-menu">
                  
                  <li class="nav-item"> <a class="nav-link" href="viewEmployeeLetterType.html">View Letters</a></li>
                 
                </ul>
              </div>
            </li>
            
            <li class="nav-item d-none d-lg-block">
              <a class="nav-link" data-toggle="collapse" href="#sidebar-layoutss8" aria-expanded="false" aria-controls="sidebar-layouts">
                <i class="icon-bubbles menu-icon"></i>
                <span class="menu-title">Leave Application</span>
                <span class="badge badge-warning"></span>
              </a>
              <div class="collapse" id="sidebar-layoutss8">
                <ul class="nav flex-column sub-menu">
                  <li class="nav-item"> <a class="nav-link" href="addLeaveapplication">Request Leave</a></li>
                  <li class="nav-item"> <a class="nav-link" href="viewLeaveapplication">View Status</a></li>
                 
                </ul>
              </div>
            </li>
                        
            <li class="nav-item d-none d-lg-block">
              <a class="nav-link" data-toggle="collapse" href="#sidebar-layouts4" aria-expanded="false" aria-controls="sidebar-layouts">
               <i class="icon-wallet menu-icon"></i>
                <span class="menu-title">Payroll</span>
                <span class="badge badge-warning"></span>
              </a>
              <div class="collapse" id="sidebar-layouts4">
                <ul class="nav flex-column sub-menu">
                  
                  <li class="nav-item"> <a class="nav-link" href="viewEmployeePaySlip.html">View Salary</a></li>
                 
                </ul>
              </div>
            </li>
            
            
            <li class="nav-item d-none d-lg-block">
              <a class="nav-link" data-toggle="collapse" href="#sidebar-layouts6" aria-expanded="false" aria-controls="sidebar-layouts">
                <i class="icon-briefcase menu-icon"></i>
                <span class="menu-title">Personal Loan Details</span>
                <span class="badge badge-warning"></span>
              </a>
              <div class="collapse" id="sidebar-layouts6">
                <ul class="nav flex-column sub-menu">
                 
                  <li class="nav-item"> <a class="nav-link" href="viewEmployeeLoan.html">View Loan</a></li>
                 
                </ul>
              </div>
            </li>
            
            
            <li class="nav-item d-none d-lg-block">
              <a class="nav-link" data-toggle="collapse" href="#sidebar-layouts7" aria-expanded="false" aria-controls="sidebar-layouts">
                <i class="icon-bag menu-icon"></i>
                <span class="menu-title">Medical Cover</span>
                <span class="badge badge-warning"></span>
              </a>
              
              <div class="collapse" id="sidebar-layouts7">
                <ul class="nav flex-column sub-menu">
                  
                  <li class="nav-item"> <a class="nav-link" href="viewEmployeeMedicalCover.html">View Medical cover</a></li>
                 
                </ul>
              </div>
            </li>
            
                           
            
          </ul>
        </nav>