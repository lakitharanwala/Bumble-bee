<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
    <%@taglib prefix="tag" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
  <meta charset="utf-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <link rel="apple-touch-icon" sizes="76x76" href="img/apple-icon.png">
  <link rel="icon" type="image/png" href="img/favicon.png">
  <title>
    Bumble-bee
  </title>
  <!--     Fonts and icons     -->
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700" rel="stylesheet" />
  <!-- Nucleo Icons -->
  <link href="css/nucleo-icons.css" rel="stylesheet" />
  <link href="css/nucleo-svg.css" rel="stylesheet" />
  <!-- Font Awesome Icons -->
  <script src="https://kit.fontawesome.com/42d5adcbca.js" crossorigin="anonymous"></script>
  <link href="css/nucleo-svg.css" rel="stylesheet" />
  <!-- CSS Files -->
  <link id="pagestyle" href="css/argon-dashboard.css?v=2.0.4" rel="stylesheet" />
</head>

<body class="g-sidenav-show   bg-gray-100">
  <div class="min-height-300 bg-primary position-absolute w-100"></div>
  
  <main class="main-content position-relative border-radius-lg ">
    <!-- Navbar -->
    <nav class="navbar navbar-main navbar-expand-lg px-0 mx-4 shadow-none border-radius-xl " id="navbarBlur" data-scroll="false">
      <div class="container-fluid py-1 px-3">
        <nav aria-label="breadcrumb">
          <ol class="breadcrumb bg-transparent mb-0 pb-0 pt-1 px-0 me-sm-6 me-5">
            <li class="breadcrumb-item text-sm"><a href="<%=request.getContextPath()%>/dashBoard" class="opacity-9 text-white" ">Dashboard</a></li>
            <li class="breadcrumb-item text-sm text-white active" aria-current="page">Products List</li>
          </ol>
          <h6 class="font-weight-bolder text-white mb-0">Active Products</h6>
        </nav>
        
      <form id="formS" role="form" action="search-product" method="Get">
        <div class="collapse navbar-collapse mt-sm-1 mt-3 me-md-15 me-sm-6" id="navbar">
          <div class="ms-md-auto pe-md-3 d-flex align-items-center">
            <div class="input-group">
               <span class="input-group-text text-body"><i class="fas fa-search" aria-hidden="true"></i></span>
                <input id="SInput" type="text" class="form-control" placeholder="Brand name" aria-label="User Name"  name="name">
            </div>
          	</div>
        </div>
      </form>
        
          
    <button type="button" class="btn btn-success" data-toggle="modal" data-target="#exampleModal">
  		Add  <i class="fa fa-plus-square" aria-hidden="true"></i>
	</button>

<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
      <form role="form" action="save-product" method="POST">
  		<div class="form-group">
    	<label for="exampleInputPassword1">Add new product</label>
    		<input type="text" class="form-control" id="exampleInputPassword1" placeholder="new product" name="name">
  		</div>
  		
  		<div class="form-group">
    	<label for="exampleInputPassword1">Add price</label>
    		<input type="text" class="form-control" id="exampleInputPassword1" placeholder="price" name="price">
  		</div>
  		
  		<label for="exampleInputPassword1">Add category</label>
  		 <select class="form-control" id="exampleFormControlSelect1" name="category">
  		  <tag:forEach var="cate" items="${cate}">
  		    <option>${cate.category}</option>
  		  </tag:forEach>
    	</select>
    	
    	&nbsp;
    	
    	<label for="exampleInputPassword1">Add Brand</label>
    	 <select class="form-control" id="exampleFormControlSelect1" name="brand">
		     <tag:forEach var="brand" items="${brand}">
  		    <option>${brand.name}</option>
  		  </tag:forEach>
    	</select>
  		
	
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="submit" class="btn btn-primary">Save changes</button>
      </div>
      </form>
    </div>
  </div>
</div>
         
      </div>
    </nav>
    
   
    <!-- End Navbar -->
    <div class="container-fluid py-4">
      <div class="row">
        <div class="col-12">
          <div class="card mb-4">
            <div class="card-header pb-0">
              <h6>Active Products List</h6>
            </div>
            <div class="card-body px-0 pt-0 pb-2">
              <div class="table-responsive p-0">
                <table class="table align-items-center mb-0">
                  <thead>
                    <tr>
                     <th class="text-uppercase text-secondary text-xs font-weight-bolder opacity-7">product</th>
                      <th class="text-uppercase text-secondary text-xs font-weight-bolder opacity-7">product price</th>
                       <th class="text-uppercase text-secondary text-xs font-weight-bolder opacity-7">category</th>
                       <th class="text-uppercase text-secondary text-xs font-weight-bolder opacity-7">barnd</th>
                       <th class="text-uppercase text-secondary text-xs font-weight-bolder opacity-7">quantity</th>
                       <th class="text-center text-uppercase text-secondary text-xs font-weight-bolder opacity-7">product status</th>
                      <th class="text-secondary opacity-7"></th>
                      
                    </tr>
                  </thead>
                  <tbody>
                   
                  <tag:forEach var="product" items="${viewProductList}">
                    <tr>
                    
                     <td>
                        <div class="d-flex px-2 py-1">
                          <div class="d-flex flex-column justify-content-center">
                            <h6 class="mb-0 text-sm">${product.name}</h6>
                          </div>
                        </div> 
                      </td>
                    
                      <td>
                        <div class="d-flex px-2 py-1">
                          <div class="d-flex flex-column justify-content-center">
                            <h6 class="mb-0 text-sm">${product.price}</h6>
                          </div>
                        </div> 
                      </td>
                      
                      <td>
                        <div class="d-flex px-2 py-1">
                          <div class="d-flex flex-column justify-content-center">
                            <h6 class="mb-0 text-sm">${product.categoryName}</h6>
                          </div>
                        </div> 
                      </td>
                      
                      <td>
                        <div class="d-flex px-2 py-1">
                          <div class="d-flex flex-column justify-content-center">
                            <h6 class="mb-0 text-sm">${product.brandName}</h6>
                          </div>
                        </div> 
                      </td>
                      
                      <tag:if test="${product.quantity eq '0'}">
                      <td>
                        <div class="d-flex px-2 py-1">
                          <div class="d-flex flex-column justify-content-center">
                            <h6 class="mb-0 text-sm text-danger">out of stock</h6>
                          </div>
                        </div> 
                      </td>
					</tag:if>
					
					<tag:if test="${product.quantity > '0'}">
                      <td>
                        <div class="d-flex px-2 py-1">
                          <div class="d-flex flex-column justify-content-center">
                            <h6 class="mb-0 text-sm">${product.quantity}</h6>
                          </div>
                        </div> 
                      </td>
					</tag:if>	


						<tag:if test="${product.status eq '0'}">
						<td class="align-middle text-center">
                         	<p class="text-xs text-success font-weight-bold mb-0">Active</p>  
                      	</td>
                      	</tag:if>
                      
                      	<tag:if test="${product.status eq '1'}">
                      		<td class="align-middle text-center">
                         		<p class="text-xs text-danger font-weight-bold mb-0">Deactive</p>  
                      		</td>
                      	</tag:if>
          <%-- 
                      <td class="align-middle">
                        <a href="#" data-target="#exampleModal1" onclick="updateDiv('${product.id}','${product.name}')" data-toggle="modal" id="${product.id}" class="text-info font-weight-bold text-xs myLink">
                       Edit</a>
                      </td> --%>
                     
                    
                     
                      <td class="align-middle">
                        <a href="<%=request.getContextPath()%>/delete-product?type=del&id=${product.id}" class="text-danger font-weight-bold text-xs" data-toggle="tooltip"  data-original-title="delete user">
                        Delete 
                        </a> 
                      </td>
                     
                    </tr>
                  </tag:forEach>
                    
                  </tbody>
                </table>
              </div>
            </div>
          </div>
        </div>
      </div>
      
     
  
    				<div id="exampleModal1" class="modal" tabindex="-1" role="dialog">
						  <div class="modal-dialog" role="document">
						    <div class="modal-content">
						      <div class="modal-header">
						        <h5 class="modal-title">Edit</h5>
						        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
						          <span aria-hidden="true">&times;</span>
						        </button>
						      </div>
						      
						       <form role="form" action="edit-brand?type=edit" method="POST">
						      <div class="modal-body">
						  
  								<input id="myInput1" type="text" class="form-control"  placeholder="edit" name="name">
  								<input id="myInput" type="hidden" class="form-control"  name="Id" >
						      </div>
						      <div class="modal-footer">
						        <button type="button" onclick="toggleModal()"class="btn btn-secondary" data-dismiss="modal">Close</button>
						        <button type="submit" class="btn btn-primary">Save changes</button>
						      </div>
						      </form>
						      
						    </div>
						  </div>
						</div>
						
      <footer class="footer pt-6">
        <div class="container-fluid">
          <div class="row align-items-center justify-content-lg-between">
            <div class="col-lg-6 mb-lg-0 mb-4">
              <div class="copyright text-center text-sm text-muted text-lg-start">
                 <script>
                  document.write(new Date().getFullYear())
                </script>,
                made with <i class="fa fa-heart"></i> by
                <a href="https://www.creative-tim.com" class="font-weight-bold" target="_blank">BUMBLE BEE</a>
                
              </div>
            </div>
            
          </div>
        </div>
      </footer>
    </div>
  </main>
  <div class="fixed-plugin">
    <a class="fixed-plugin-button text-dark position-fixed px-3 py-2">
      <i class="fa fa-cog py-2"> </i>
    </a>
    <div class="card shadow-lg">
      <div class="card-header pb-0 pt-3 ">
        <div class="float-start">
          <h5 class="mt-3 mb-0">Argon Configurator</h5>
          <p>See our dashboard options.</p>
        </div>
        <div class="float-end mt-4">
          <button class="btn btn-link text-dark p-0 fixed-plugin-close-button">
            <i class="fa fa-close"></i>
          </button>
        </div>
        <!-- End Toggle Button -->
      </div>
      <hr class="horizontal dark my-1">
      <div class="card-body pt-sm-3 pt-0 overflow-auto">
        <!-- Sidebar Backgrounds -->
        <div>
          <h6 class="mb-0">Sidebar Colors</h6>
        </div>
        <a href="javascript:void(0)" class="switch-trigger background-color">
          <div class="badge-colors my-2 text-start">
            <span class="badge filter bg-gradient-primary active" data-color="primary" onclick="sidebarColor(this)"></span>
            <span class="badge filter bg-gradient-dark" data-color="dark" onclick="sidebarColor(this)"></span>
            <span class="badge filter bg-gradient-info" data-color="info" onclick="sidebarColor(this)"></span>
            <span class="badge filter bg-gradient-success" data-color="success" onclick="sidebarColor(this)"></span>
            <span class="badge filter bg-gradient-warning" data-color="warning" onclick="sidebarColor(this)"></span>
            <span class="badge filter bg-gradient-danger" data-color="danger" onclick="sidebarColor(this)"></span>
          </div>
        </a>
        <!-- Sidenav Type -->
        <div class="mt-3">
          <h6 class="mb-0">Sidenav Type</h6>
          <p class="text-sm">Choose between 2 different sidenav types.</p>
        </div>
        <div class="d-flex">
          <button class="btn bg-gradient-primary w-100 px-3 mb-2 active me-2" data-class="bg-white" onclick="sidebarType(this)">White</button>
          <button class="btn bg-gradient-primary w-100 px-3 mb-2" data-class="bg-default" onclick="sidebarType(this)">Dark</button>
        </div>
        <p class="text-sm d-xl-none d-block mt-2">You can change the sidenav type just on desktop view.</p>
        <!-- Navbar Fixed -->
        <div class="d-flex my-3">
          <h6 class="mb-0">Navbar Fixed</h6>
          <div class="form-check form-switch ps-0 ms-auto my-auto">
            <input class="form-check-input mt-1 ms-auto" type="checkbox" id="navbarFixed" onclick="navbarFixed(this)">
          </div>
        </div>
        <hr class="horizontal dark my-sm-4">
        <div class="mt-2 mb-5 d-flex">
          <h6 class="mb-0">Light / Dark</h6>
          <div class="form-check form-switch ps-0 ms-auto my-auto">
            <input class="form-check-input mt-1 ms-auto" type="checkbox" id="dark-version" onclick="darkMode(this)">
          </div>
        </div>
        <a class="btn bg-gradient-dark w-100" href="https://www.creative-tim.com/product/argon-dashboard">Free Download</a>
        <a class="btn btn-outline-dark w-100" href="https://www.creative-tim.com/learning-lab/bootstrap/license/argon-dashboard">View documentation</a>
        <div class="w-100 text-center">
          <a class="github-button" href="https://github.com/creativetimofficial/argon-dashboard" data-icon="octicon-star" data-size="large" data-show-count="true" aria-label="Star creativetimofficial/argon-dashboard on GitHub">Star</a>
          <h6 class="mt-3">Thank you for sharing!</h6>
          <a href="https://twitter.com/intent/tweet?text=Check%20Argon%20Dashboard%20made%20by%20%40CreativeTim%20%23webdesign%20%23dashboard%20%23bootstrap5&amp;url=https%3A%2F%2Fwww.creative-tim.com%2Fproduct%2Fargon-dashboard" class="btn btn-dark mb-0 me-2" target="_blank">
            <i class="fab fa-twitter me-1" aria-hidden="true"></i> Tweet
          </a>
          <a href="https://www.facebook.com/sharer/sharer.php?u=https://www.creative-tim.com/product/argon-dashboard" class="btn btn-dark mb-0 me-2" target="_blank">
            <i class="fab fa-facebook-square me-1" aria-hidden="true"></i> Share
          </a>
        </div>
      </div>
    </div>
  </div>
  <!--   Core JS Files   -->
  <script src="js/core/popper.min.js"></script>
  <script src="js/core/bootstrap.min.js"></script>
  <script src="js/plugins/perfect-scrollbar.min.js"></script>
  <script src="js/plugins/smooth-scrollbar.min.js"></script>
  <script>
    var win = navigator.platform.indexOf('Win') > -1;
    if (win && document.querySelector('#sidenav-scrollbar')) {
      var options = {
        damping: '0.5'
      }
      Scrollbar.init(document.querySelector('#sidenav-scrollbar'), options);
    }
  </script>
  <!-- Github buttons -->
  <script async defer src="https://buttons.github.io/buttons.js"></script>
  <!-- Control Center for Soft Dashboard: parallax effects, scripts for the example pages etc -->
  <script src="js/argon-dashboard.min.js?v=2.0.4"></script>
  
   <script>
  const inputField = document.getElementById('SInput');

  inputField.addEventListener('keyup', function(event) {
    if (event.keyCode === 13) {
      event.preventDefault();  
      document.getElementById('formS').submit(); 
    }
  });
</script>

	<script >
      function updateDiv(value,value1) {
    	  var myInput = document.getElementById("myInput");
    	  var myInput1 = document.getElementById("myInput1");
    	  myInput.value = value;
    	  myInput1.value = value1;
    	}
     </script>
  
</body>

</html>