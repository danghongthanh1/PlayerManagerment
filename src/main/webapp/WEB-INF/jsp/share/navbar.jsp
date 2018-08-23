<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <!-- Brand -->
  <a class="navbar-brand" href="${pageContext.request.contextPath}/homepage">Home</a>

  <!-- Links -->
  <ul class="navbar-nav">
    <li class="nav-item dropdown">
      <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
        Finance
      </a>
      <div class="dropdown-menu">
        <a class="dropdown-item" href="${pageContext.request.contextPath}/finance/list-finance">View financal table </a>
        <a class="dropdown-item" href="${pageContext.request.contextPath}/finance/add-finance">Add finance </a>
      </div>
    </li>
    <!-- Dropdown -->
    <li class="nav-item dropdown">
      <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
        Person
      </a>
      <div class="dropdown-menu">
        <a class="dropdown-item" href="${pageContext.request.contextPath}/person/view-list">View list person </a>
        <a class="dropdown-item" href="${pageContext.request.contextPath}/person/search-person">Search person </a>
        <a class="dropdown-item" href="${pageContext.request.contextPath}/person/add-person">Add person </a>
        <a class="dropdown-item" href="${pageContext.request.contextPath}/person/add-person-by-excel">Add person by Excel </a>
      </div>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="https://facebook.com/danghongthanh.hust">About US </a>
    </li>
    
  </ul>
</nav>