<%--
  Created by IntelliJ IDEA.
  User: thuct
  Date: 4/4/2023
  Time: 8:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="true" %>
<html>
<head>
    <title>LOGIN </title>
    <link rel="stylesheet" href="/CURD_war_exploded/css/bootstrap.min.css">
</head>
<body>
<c:if test="${ not empty errorMessage }">
<div class="alert alert-primary alert-dismissible fade show" role="alert">
    <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
    <strong>Thông báo</strong>
    ${ errorMessage }
</div></c:if>
<div class="position-absolute top-50 start-50 translate-middle">

    <!-- Button trigger modal -->
    <button type="button" class="btn btn-primary btn-lg" data-bs-toggle="modal" data-bs-target="#modalId">
        Nhân Viên
    </button>
    <button type="button" class="btn btn-primary btn-lg" data-bs-toggle="modal" data-bs-target="#modalId1">
        Khách
    </button>
</div>

<!-- Modal 1-->
<div class="modal fade" id="modalId" tabindex="-1" role="dialog" aria-labelledby="modalTitleId" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="modalTitleId">ĐĂNG NHẬP TÀI KHOẢN NHÂN VIÊN</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <div class="container-fluid">
                    <form action="/CURD_war_exploded/nhan_vien/login" method="post">
                        <div class="form-floating mb-3">
                            <input
                                    type="text"
                                    class="form-control" name="ma" id="formId1" placeholder="x">
                            <label for="formId1">MÃ NHÂN VIÊN</label>
                        </div>
                        <div class="form-floating mb-3">
                            <input
                                    type="password"
                                    class="form-control" name="matKhau" id="formId2" placeholder="x">
                            <label for="formId2">MẬT KHẨU</label>
                        </div>
                        <button type="submit" class="btn btn-primary form-control">LOGIN</button>
                    </form>
                </div>
            </div>

        </div>
    </div>
</div>
<!-- Modal 2-->
<div class="modal fade" id="modalId1" tabindex="-1" role="dialog" aria-labelledby="modalTitleId" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="modalTitleId">ĐĂNG NHẬP KHÁCH HÀNG</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <div class="container-fluid">
                    <div class="d-flex justify-content-center align-items-center">
                        <div class="spinner-border text-primary spinner-border-sm"
                             role="status">
                            <span class="visually-hidden">Loading...</span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">CANCER</button>
                <button type="button" class="btn btn-danger">EXIT</button>
            </div>
        </div>
    </div>
</div>

<script>

    var alertList = document.querySelectorAll('.alert');
    alertList.forEach(function (alert) {
        new bootstrap.Alert(alert)
    })

    var modalId = document.getElementById('modalId');

    modalId.addEventListener('show.bs.modal', function (event) {
        // Button that triggered the modal
        let button = event.relatedTarget;
        // Extract info from data-bs-* attributes
        let recipient = button.getAttribute('data-bs-whatever');

        // Use above variables to manipulate the DOM
    });
</script>
<script src="/CURD_war_exploded/js/bootstrap.min.js"></script>
</body>
</html>
