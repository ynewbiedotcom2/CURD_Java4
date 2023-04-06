<%--
  Created by IntelliJ IDEA.
  User: thuct
  Date: 3/31/2023
  Time: 12:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>
<body style="background: rgb(201, 200, 200);">
<div class="container ">
    <div class="card mb-4 " style="margin: 100px 100px">
        <div class="col-10 offset-1">
            <h1 class="text text-center">THÊM SẢN PHẨM MỚI</h1>
            <form method="POST" action="/CURD_war_exploded/SanPhamChiTiet/store" validate>
                <div class="row mt-3">


                    <div class="col-6">
                        <label>Năm Bảo Hành</label>
                        <input type="number" name="namBh" class="form-control" required/>
                    </div>
                    <div class="col-6">
                        <label>Số Lượng Tồn</label>
                        <input type="number" name="soLuongTon" class="form-control" required/>
                    </div>
                </div>

                <div class="row mt-3">
                    <div class="col-6">
                        <label>Sản Phẩm</label>
                        <div class="row">
                            <div class="col-10">
                                <select name="idSp" class="form-select">
                                    <c:forEach items="${listSp}" var="sp">
                                        <option value="${sp.ma}">${sp.ten}</option>
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
                        <label>Nhà Sản Xuất</label>
                        <div class="row">
                            <div class="col-10"><select name="idNsx" class="form-select">
                                <c:forEach items="${listNsx}" var="sp">
                                    <option value="${sp.ma}">${sp.ten}</option>
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
                    <div class="col-6">
                        <label>Dòng Sản Phẩm</label>
                        <div class="row">
                            <div class="col-10"><select name="idDongSp" class="form-select">
                                <c:forEach items="${listDong}" var="sp">
                                    <option value="${sp.ma}">${sp.ten}</option>
                                </c:forEach>
                            </select>
                            </div>
                            <div class="col-2">
                                <button type="button" class="btn btn-primary" data-bs-toggle="modal"
                                        data-bs-target="#myModal1">
                                    add
                                </button>
                            </div>
                        </div>

                    </div>
                    <div class="col-6">
                        <label>Màu Sắc</label>
                        <div class="row">
                            <div class="col-10"><select name="idMauSac" class="form-select">
                                <c:forEach items="${listMs}" var="sp">
                                    <option value="${sp.ma}">${sp.ten}</option>
                                </c:forEach>
                            </select>
                            </div>
                            <div class="col-2">
                                <button type="button" class="btn btn-primary" data-bs-toggle="modal"
                                        data-bs-target="#myModal">
                                    add
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row mt-3">
                    <div class="col-6">
                        <label>Giá Nhập</label>
                        <input type="number" name="giaNhap" class="form-control" required/>
                    </div>
                    <div class="col-6">
                        <label>Giá Bán</label>
                        <input type="number" name="giaBan" class="form-control" required/>
                    </div>
                </div>
                <div class="row mt-3">
                    <div class="col-12">
                        <label>Mô Tả</label>
                        <textarea class="form-control" name="" id="" rows="3"></textarea>

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
<div class="modal fade" id="myModal">
    <div class="modal-dialog">
        <div class="modal-content">

            <!-- Modal Header -->
            <div class="modal-header">
                <h4 class="modal-title">THÊM MÀU SẮC</h4>
                <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
            </div>

            <!-- Modal body -->
            <div class="modal-body">
                <form method="POST" action="/Demo2_war_exploded/mau_sac/store">
                    <div class="row">
                        <div class="col-2">
                            <input style="height: 50px" type="color" class="form-control form-control-color"
                                   name="ma" id="exampleColorInput" value="#563d7c" autocompleted>
                        </div>
                        <div class="form-floating mb-3 col-10">
                            <input type="text" class="form-control" name="ten" id="formId1" placeholder="x">
                            <label for="formId1">Tên</label>
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

<div class="modal fade" id="myModal1">
    <div class="modal-dialog">
        <div class="modal-content">

            <!-- Modal Header -->
            <div class="modal-header">
                <h4 class="modal-title">THÊM DÒNG</h4>
                <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
            </div>

            <!-- Modal body -->
            <div class="modal-body">
                <form method="POST" action="/Demo2_war_exploded/dong_sp/store">
                    <div class="row">

                        <div class="form-floating mb-3 col-12">
                            <input type="text" class="form-control" name="ma" placeholder="x">
                            <label for="formId1">Mã</label>
                        </div>
                        <div class="form-floating mb-3 col-12">
                            <input type="text" class="form-control" name="ten" placeholder="x">
                            <label for="formId1">Tên</label>
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
<div class="modal fade" id="myModal2">
    <div class="modal-dialog">
        <div class="modal-content">

            <!-- Modal Header -->
            <div class="modal-header">
                <h4 class="modal-title">THÊM NSX</h4>
                <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
            </div>

            <!-- Modal body -->
            <div class="modal-body">
                <form method="POST" action="/Demo2_war_exploded/nsx/store">
                    <div class="row">

                        <div class="form-floating mb-3 col-12">
                            <input type="text" class="form-control" name="ma" placeholder="x">
                            <label for="formId1">Mã</label>
                        </div>
                        <div class="form-floating mb-3 col-12">
                            <input type="text" class="form-control" name="ten" placeholder="x">
                            <label for="formId1">Tên</label>
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
                <h4 class="modal-title">THÊM SẢN PHẨM</h4>
                <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
            </div>

            <!-- Modal body -->
            <div class="modal-body">
                <form method="POST" action="/Demo2_war_exploded/san_pham/store">
                    <div class="row">

                        <div class="form-floating mb-3 col-12">
                            <input type="text" class="form-control" name="ma" placeholder="x">
                            <label for="formId1">Mã</label>
                        </div>
                        <div class="form-floating mb-3 col-12">
                            <input type="text" class="form-control" name="ten" placeholder="x">
                            <label for="formId1">Tên</label>
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
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
        integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous">
</script>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.min.js"
        integrity="sha384-7VPbUDkoPSGFnVtYi0QogXtr74QeVeeIs99Qfg5YCF+TidwNdjvaKZX19NZ/e6oz" crossorigin="anonymous">
</script>
</body>
