<%--
  Created by IntelliJ IDEA.
  User: thuct
  Date: 3/30/2023
  Time: 10:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="true" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>
<html>
<head>
    <title>Cửa Hàng SECREST</title>
    <link rel="stylesheet" href="/CURD_war_exploded/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.4/font/bootstrap-icons.css">
</head>
<body>


<header>
    <nav class="navbar navbar-light bg-light fixed-top">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">LOGO</a>

            <c:if test="${ errorMessage != null}">
            <div class="alert alert-danger alert-dismissible fade show fixed-top" style="width: 300px;left: 1100px"
                 role="alert">
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                <strong>LỖI:</strong> ${errorMessage} <a href="/CURD_war_exploded/trang_chu/error">xem thêm</a>  </div></c:if>


            <h3 class="text text-center">${curentPage}</h3>


            <button class="navbar-toggler" type="button" data-bs-toggle="offcanvas"
                    data-bs-target="#offcanvasNavbar" aria-controls="offcanvasNavbar">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="offcanvas offcanvas-end" tabindex="-1" id="offcanvasNavbar"
                 aria-labelledby="offcanvasNavbarLabel">
                <div class="offcanvas-header">
                    <h5 class="offcanvas-title" id="offcanvasNavbarLabel">OPTION</h5>
                    <button type="button" class="btn-close text-reset" data-bs-dismiss="offcanvas"
                            aria-label="Close"></button>
                </div>
                <div class="offcanvas-body">
                    <ul class="navbar-nav justify-content-end flex-grow-1 pe-3">
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="/CURD_war_exploded/trang_chu/home">BÁN
                                HÀNG</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/CURD_war_exploded/khach_hang/index">KHÁCH HÀNG</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/CURD_war_exploded/nhan_vien/index">HÓA ĐƠN</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/CURD_war_exploded/nhan_vien/index">NHÂN VIÊN</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/CURD_war_exploded/chuc_vu/index">CHỨC VỤ</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/CURD_war_exploded/cua_hang/index">CỬA HÀNG</a>
                        </li>

                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" id="dropdownId" data-bs-toggle="dropdown"
                               aria-haspopup="true" aria-expanded="false">KHO</a>
                            <div class="dropdown-menu" aria-labelledby="dropdownId">
                                <a class="dropdown-item" href="/CURD_war_exploded/kho_hang/index">DANH SÁCH SẢN
                                    PHẨM</a>
                                <a class="dropdown-item" href="/CURD_war_exploded/san_pham/index">QL SẢN PHẨM</a>
                                <a class="dropdown-item" href="/CURD_war_exploded/nha_san_xuat/index">QL NSX</a>
                                <a class="dropdown-item" href="/CURD_war_exploded/dong_sp/index">QL DÒNG</a>
                                <a class="dropdown-item" href="/CURD_war_exploded/mau_sac/index">QL MÀU SẮC</a>
                                <a class="dropdown-item" href="/CURD_war_exploded/nhan_vien/index">THỐNG KÊ</a>
                            </div>
                        </li>
                    </ul>
                    <br>
                    <form class="d-flex">
                        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                        <button class="btn btn-outline-success" type="submit">Search</button>
                    </form>


                </div>
            </div>
        </div>

    </nav>
</header>


<main style="min-height: 1000px; padding-top: 100px;">

    <div class="container">
        <jsp:include page="${view}"/>
    </div>


</main>


<footer class="text-center text-white" style="background-color: #caced1;">

    <div class="container p-4">

        <section class="">
            <div class="row">
                <div class="col-lg-2 col-md-12 mb-4 mb-md-0">
                    <div class="bg-image hover-overlay ripple shadow-1-strong rounded" data-ripple-color="light">
                        <img src="https://mdbcdn.b-cdn.net/img/new/fluid/city/113.webp" class="w-100"/>
                        <a href="#!">
                            <div class="mask" style="background-color: rgba(251, 251, 251, 0.2);"></div>
                        </a>
                    </div>
                </div>
                <div class="col-lg-2 col-md-12 mb-4 mb-md-0">
                    <div class="bg-image hover-overlay ripple shadow-1-strong rounded" data-ripple-color="light">
                        <img src="https://mdbcdn.b-cdn.net/img/new/fluid/city/111.webp" class="w-100"/>
                        <a href="#!">
                            <div class="mask" style="background-color: rgba(251, 251, 251, 0.2);"></div>
                        </a>
                    </div>
                </div>
                <div class="col-lg-2 col-md-12 mb-4 mb-md-0">
                    <div class="bg-image hover-overlay ripple shadow-1-strong rounded" data-ripple-color="light">
                        <img src="https://mdbcdn.b-cdn.net/img/new/fluid/city/112.webp" class="w-100"/>
                        <a href="#!">
                            <div class="mask" style="background-color: rgba(251, 251, 251, 0.2);"></div>
                        </a>
                    </div>
                </div>
                <div class="col-lg-2 col-md-12 mb-4 mb-md-0">
                    <div class="bg-image hover-overlay ripple shadow-1-strong rounded" data-ripple-color="light">
                        <img src="https://mdbcdn.b-cdn.net/img/new/fluid/city/114.webp" class="w-100"/>
                        <a href="#!">
                            <div class="mask" style="background-color: rgba(251, 251, 251, 0.2);"></div>
                        </a>
                    </div>
                </div>
                <div class="col-lg-2 col-md-12 mb-4 mb-md-0">
                    <div class="bg-image hover-overlay ripple shadow-1-strong rounded" data-ripple-color="light">
                        <img src="https://mdbcdn.b-cdn.net/img/new/fluid/city/115.webp" class="w-100"/>
                        <a href="#!">
                            <div class="mask" style="background-color: rgba(251, 251, 251, 0.2);"></div>
                        </a>
                    </div>
                </div>
                <div class="col-lg-2 col-md-12 mb-4 mb-md-0">
                    <div class="bg-image hover-overlay ripple shadow-1-strong rounded" data-ripple-color="light">
                        <img src="https://mdbcdn.b-cdn.net/img/new/fluid/city/116.webp" class="w-100"/>
                        <a href="#!">
                            <div class="mask" style="background-color: rgba(251, 251, 251, 0.2);"></div>
                        </a>
                    </div>
                </div>
            </div>
        </section>

    </div>

    <div class="text-center p-3" style="background-color: rgba(0, 0, 0, 0.2);">
        © 2023 Copyright:
        <a class="text-white" href="https://mdbootstrap.com/">PH20936.fpt.edu.vn</a>
    </div>

</footer>
<script>
    var alertList = document.querySelectorAll('.alert');
    alertList.forEach(function (alert) {
        new bootstrap.Alert(alert)
    })
</script>

<script src="/CURD_war_exploded/js/bootstrap.bundle.js"></script>
</body>
</html>
