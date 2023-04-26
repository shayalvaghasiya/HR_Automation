<nav class="sidebar sidebar-offcanvas" id="sidebar">
          <ul class="nav">
            <li class="nav-item nav-profile">
              <div class="nav-link">
                <div class="profile-image">
                  <img src="<%=request.getContextPath()%>/adminResource/images/images.jpeg" alt="image"/>
                  <span class="online-status online"></span> <!--change class online to offline or busy as needed-->
                </div>
                <div class="profile-name">
                  <p class="name">
                  
                  </p>
                  <p class="designation">
                 <br>
                 <br>
                  <br>
                  <br>
                     Admin
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
              <a class="nav-link" data-toggle="collapse" href="#sidebar-layouts" aria-expanded="false" aria-controls="sidebar-layouts">
                <i class="icon-people menu-icon"></i>
                <span class="menu-title">Manage Employee</span>
                <span class="badge badge-warning"></span>
              </a>
              <div class="collapse" id="sidebar-layouts">
                <ul class="nav flex-column sub-menu">
                  <li class="nav-item"> <a class="nav-link" href="loadEmployee.html">Add Employee</a></li>
                  <li class="nav-item"> <a class="nav-link" href="viewEmployee.html">View Employee</a></li>
                 
                </ul>
              </div>
            </li>
            
            
            
            
            <li class="nav-item d-none d-lg-block">
              <a class="nav-link" data-toggle="collapse" href="#sidebar-layoutss" aria-expanded="false" aria-controls="sidebar-layouts">
                 <i class="icon-folder-alt menu-icon"></i>
                <span class="menu-title">Manage Department</span>
                <span class="badge badge-warning"></span>
              </a>
              <div class="collapse" id="sidebar-layoutss">
                <ul class="nav flex-column sub-menu">
                  <li class="nav-item"> <a class="nav-link" href="loadDepartment.html">Add Department</a></li>
                  <li class="nav-item"> <a class="nav-link" href="viewDepartment.html">View Department</a></li>
                 
                </ul>
              </div>
            </li>
            <li class="nav-item d-none d-lg-block">
              <a class="nav-link" data-toggle="collapse" href="#sidebar-layouts1" aria-expanded="false" aria-controls="sidebar-layouts">
                <i class="icon-graduation menu-icon"></i>
                <span class="menu-title">Manage Designation</span>
                <span class="badge badge-warning"></span>
              </a>
              <div class="collapse" id="sidebar-layouts1">
                <ul class="nav flex-column sub-menu">
                  <li class="nav-item"> <a class="nav-link" href="loadDesignation.html">Add Designation</a></li>
                  <li class="nav-item"> <a class="nav-link" href="viewDesignation.html">View Designation</a></li>
                 
                </ul>
              </div>
            </li>
            <li class="nav-item d-none d-lg-block">
              <a class="nav-link" data-toggle="collapse" href="#sidebar-layouts2" aria-expanded="false" aria-controls="sidebar-layouts">
               <i class="icon-calendar menu-icon"></i>
                <span class="menu-title">Manage Attendance</span>
                <span class="badge badge-warning"></span>
              </a>
              <div class="collapse" id="sidebar-layouts2">
                <ul class="nav flex-column sub-menu">
                   <li class="nav-item"> <a class="nav-link" href="loadAttendance.html">Add Attendance</a></li>
                  <li class="nav-item"> <a class="nav-link" href="viewAttendance.html">View Attendance</a></li>
                 
                </ul>
              </div>
            </li>
            
            <li class="nav-item d-none d-lg-block">
              <a class="nav-link" data-toggle="collapse" href="#sidebar-layouts3" aria-expanded="false" aria-controls="sidebar-layouts">
                <i class="icon-list menu-icon"></i>
                <span class="menu-title">Leave Criterion</span>
                <span class="badge badge-warning"></span>
              </a>
              <div class="collapse" id="sidebar-layouts3">
                <ul class="nav flex-column sub-menu">
                  <li class="nav-item"> <a class="nav-link" href="loadLeave.html">Add leaves</a></li>
                  <li class="nav-item"> <a class="nav-link" href="viewLeave.html">View leaves</a></li>
                 
                </ul>
              </div>
            </li>
            
            <li class="nav-item d-none d-lg-block">
              <a class="nav-link" data-toggle="collapse" href="#sidebar-layouts14" aria-expanded="false" aria-controls="sidebar-layouts">
                <i class="icon-credit-card menu-icon"></i> 
                <span class="menu-title">Allowances/Deductions</span>
                <span class="badge badge-warning"></span>
              </a>
              <div class="collapse" id="sidebar-layouts14">
                <ul class="nav flex-column sub-menu">
                  <li class="nav-item"> <a class="nav-link" href="loadAllowance.html">Add Allowances/Deductions</a></li>
                  <li class="nav-item"> <a class="nav-link" href="viewAllowances.html">View Allowances/Deductions</a></li>
                 
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
                  <li class="nav-item"> <a class="nav-link" href="loadSalary.html">Add Salary</a></li>
                  <li class="nav-item"> <a class="nav-link" href="viewSalary.html">View Salary</a></li>
                  <li class="nav-item"> <a class="nav-link" href="viewPaySlip.html">Generate Pay-Slip</a></li>
                 
                </ul>
              </div>
            </li>
            
            <li class="nav-item d-none d-lg-block">
              <a class="nav-link" data-toggle="collapse" href="#sidebar-layouts10" aria-expanded="false" aria-controls="sidebar-layouts">
                <i class="icon-bubbles menu-icon"></i>
                <span class="menu-title">Manage Leave Request</span>
                <span class="badge badge-warning"></span>
              </a>
              <div class="collapse" id="sidebar-layouts10">
                <ul class="nav flex-column sub-menu">
                  
                  <li class="nav-item"> <a class="nav-link" href="replyLeaveRequest.html">Reply Leave Request</a></li>
                  <li class="nav-item"> <a class="nav-link" href="viewLeaveRequest.html">View Leave Request</a></li>
                </ul>
              </div>
            </li>
            
            <li class="nav-item d-none d-lg-block">
              <a class="nav-link" data-toggle="collapse" href="#sidebar-layouts5" aria-expanded="false" aria-controls="sidebar-layouts">
                <i class="icon-envelope-open menu-icon"></i>  
                <span class="menu-title">Manage Letter type</span>
                <span class="badge badge-warning"></span>
              </a>
              <div class="collapse" id="sidebar-layouts5">
                <ul class="nav flex-column sub-menu">
                  <li class="nav-item"> <a class="nav-link" href="loadLetterType.html">Add Letter</a></li>
                  <li class="nav-item"> <a class="nav-link" href="viewLetterType.html">View Letter</a></li>
                 
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
                  <li class="nav-item"> <a class="nav-link" href="loadLoan.html">Add Loan</a></li>
                  <li class="nav-item"> <a class="nav-link" href="viewLoan.html">View Loan</a></li>
                 
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
                  <li class="nav-item"> <a class="nav-link" href="loadMedicalCover.html">Add Medical cover</a></li>
                  <li class="nav-item"> <a class="nav-link" href="viewMedicalCover.html">View Medical cover</a></li>
                 
                </ul>
              </div>
            </li>
            
            <li class="nav-item d-none d-lg-block">
              <a class="nav-link" data-toggle="collapse" href="#sidebar-layouts8" aria-expanded="false" aria-controls="sidebar-layouts">
                <i class="icon-info  menu-icon"></i>
                <span class="menu-title"> Manage Complaint</span>
                <span class="badge badge-warning"></span>
              </a>
              <div class="collapse" id="sidebar-layouts8">
                <ul class="nav flex-column sub-menu">
                 
                  <li class="nav-item"> <a class="nav-link" href="viewComplaint.html">View Complaint</a></li>
                 
                </ul>
              </div>
            </li>
            
            <li class="nav-item d-none d-lg-block">
              <a class="nav-link" data-toggle="collapse" href="#sidebar-layouts9" aria-expanded="false" aria-controls="sidebar-layouts">
                <i class="icon-bubbles menu-icon"></i>
                <span class="menu-title">Manage Feedback</span>
                <span class="badge badge-warning"></span>
              </a>
              <div class="collapse" id="sidebar-layouts9">
                <ul class="nav flex-column sub-menu">
                  
                  <li class="nav-item"> <a class="nav-link" href="viewFeedback.html">View Feedback</a></li>
                 
                </ul>
              </div>
            </li>
            
            
            
                        
            
          </ul>
        </nav>