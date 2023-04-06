<%--
  Created by IntelliJ IDEA.
  User: thuct
  Date: 4/5/2023
  Time: 12:29 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>
<body style="background: rgb(201, 200, 200);">
<div class="container ">
    <div class="card mb-4 " style="margin: 50px 100px">
        <div class="col-10 offset-1">
            <h1 class="text text-center">SUA THONG TIN NHAN VIÊN</h1>
            <form method="POST" action="/CURD_war_exploded/nhan_vien/update?id=${nv.id}" validate>
                <div class="row mt-3">
                    <div class="col-3">
                        <label>Họ</label>
                        <input type="text" name="ho" class="form-control" value="${nv.ho}" required/>
                    </div>
                    <div class="col-3">
                        <label>Tên Đệm</label>
                        <input type="text" name="tenDem" class="form-control" value="${nv.tenDem}" required/>
                    </div>
                    <div class="col-3">
                        <label>Tên</label>
                        <input type="text" name="ten" class="form-control" value="${nv.ten}" required/>
                    </div>
                    <div class="col-3">
                        <label>Mã Nhân Viên</label>
                        <input type="text" name="ma" class="form-control" value="${nv.ma}" required/>
                    </div>
                </div>

                <div class="row mt-3">
                    <div class="col-6">
                        <label>Chức Vụ</label>
                        <div class="row">
                            <div class="col-10">
                                <select name="idCv" class="form-select">
                                    <c:forEach items="${listCv}" var="x">
                                        <option ${ nv.chucVu == x.id  ? "selected" : "" }
                                                value="${x.id}">${x.ten}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="col-2">
                                <button type="button" class="btn btn-primary" data-bs-toggle="modal"
                                        data-bs-target="#myModal3">
                                    add
                                </button>
                            </div>
                        </div>
                    </div>
                    <div class="col-6">
                        <label>Cửa Hàng</label>
                        <div class="row">
                            <div class="col-10">
                                <select name="idCh" class="form-select">
                                    <c:forEach items="${listCh}" var="sp">
                                        <option  ${ nv.cuaHang == sp.id ? "selected" : "" }
                                                value="${sp.id}">${sp.ten}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="col-2">
                                <button type="button" class="btn btn-primary" data-bs-toggle="modal"
                                        data-bs-target="#myModal2">
                                    add
                                </button>
                            </div>
                        </div>
                    </div>

                </div>

                <div class="row mt-3">
                    <div class="col-3">
                        <label>Giới Tính</label><br>
                        <div class="form-check form-check-inline">
                            <input class="form-check-input" type="radio"
                                   name="gioiTinh"  ${ nv.gioiTinh == "Nam" ? "checked" : "" } value="Nam">
                            <label class="form-check-label">Nam</label>
                        </div>
                        <div class="form-check form-check-inline">
                            <input class="form-check-input" type="radio"
                                   name="gioiTinh" ${ nv.gioiTinh == "Nữ" ? "checked" : "" } value="Nữ">
                            <label class="form-check-label">Nữ</label>
                        </div>
                    </div>
                    <div class="col-2">
                        <label>Ngày Sinh</label>
                        <input type="date" name="ngaySinh" value="${nv.ngaySinh}" class="form-control" required/>
                    </div>
                    <div class="col-3">
                        <label>Sdt</label>
                        <input type="Text" name="sdt" value="${nv.sdt}" class="form-control" required/>
                    </div>
                    <div class="col-4">
                        <label>Mat Khau</label>
                        <input class="form-control" value="${nv.matKhau}" name="matKhau" type="password">

                    </div>
                </div>

                <div class="row mt-3">

                    <div class="col-12">
                        <label>Dia Chi</label>
                        <input class="form-control" value="${nv.diaChi}" name="diaChi" type="text">

                    </div>

                </div>
                <div class="row mt-3">

                    <div class="col">
                        <button type="submit" style="width: 100%;" class="btn btn-primary">Save</button>

                    </div>

                </div>
                <br>

            </form>
        </div>
    </div>
</div>


<div class="modal fade" id="myModal2">
    <div class="modal-dialog">
        <div class="modal-content">

            <!-- Modal Header -->
            <div class="modal-header">
                <h4 class="modal-title">THÊM CỬA HÀNG</h4>
                <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
            </div>

            <!-- Modal body -->
            <div class="modal-body">
                <form method="POST" action="/Demo2_war_exploded/nsx/store">
                    <div class="row">

                        <div class="form-floating mb-3 col-12">
                            <input type="text" class="form-control" name="ma" placeholder="x">
                            <label>Mã</label>
                        </div>
                        <div class="form-floating mb-3 col-12">
                            <input type="text" class="form-control" name="ten" placeholder="x">
                            <label>Tên</label>
                        </div>
                    </div>
                    <div class="row mt-3">
                        <div class="col-6">
                            <button class="btn btn-primary">LƯU</button>
                        </div>
                        <div class="col-6"></div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="myModal3">
    <div class="modal-dialog">
        <div class="modal-content">

            <!-- Modal Header -->
            <div class="modal-header">
                <h4 class="modal-title">THÊM CHỨC VỤ</h4>
                <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
            </div>

            <!-- Modal body -->
            <div class="modal-body">
                <form method="POST" action="/Demo2_war_exploded/san_pham/store">
                    <div class="row">

                        <div class="form-floating mb-3 col-12">
                            <input type="text" class="form-control" name="ma" placeholder="x">
                            <label>Mã</label>
                        </div>
                        <div class="form-floating mb-3 col-12">
                            <input type="text" class="form-control" name="ten" placeholder="x">
                            <label>Tên</label>
                        </div>
                    </div>
                    <div class="row mt-3">
                        <div class="col-6">
                            <button class="btn btn-primary">LƯU</button>
                        </div>
                        <div class="col-6"></div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>