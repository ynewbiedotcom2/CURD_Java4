<%--
  Created by IntelliJ IDEA.
  User: thuct
  Date: 4/4/2023
  Time: 8:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>
<div style="min-height: 1000px; padding-top: 57px;">

    <div class="col-md-3 fixed-top bg-light" style="height: 700px; left: 0px;top: 57px;">
        <div class="row justify-content-center align-items-center g-2">
            <div class="col">
                <ul class="nav ">

                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="dropdownId" data-bs-toggle="dropdown"
                           aria-haspopup="true" aria-expanded="false">DANH SÁCH HÓA ĐƠN</a>
                        <div class="dropdown-menu" aria-labelledby="dropdownId">
                            <a class="dropdown-item" href="#">Hoa don 1</a>
                        </div>
                    </li>
                </ul>
            </div>
            <div class="col"><a href="#" class="btn btn-outline-primary float-end">Tao Hóa đơn</a></div>

        </div>
        <div class="row">
            <div class="col-12"><a href="#" class="btn btn-outline-primary" style="width: 100%;">Thanh Toán</a></div>
        </div>

        <div class="row justify-content-center align-items-center g-2">
            <table class="table table-hover align-middle">
                <thead>
                <tr>
                    <th>#</th>
                    <th>Sản Phẩm</th>
                    <th>Số Lượng</th>
                    <th>Chi Tiết</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <th scope="row">1</th>
                    <td>
                        <div class="mt-1 mb-0 text-muted small">
                            <span>100% cotton</span>
                            <span class="text-primary"> • </span>
                            <span>Light weight</span>

                        </div>
                        <div class="mt-1 mb-0 text-muted small">
                            <span>100% cotton</span>
                            <span class="text-primary"> • </span>
                            <span>Light weight</span>

                        </div>
                    </td>
                    <td>100</td>
                    <td><a href="" class="btn btn-outline-primary">xem</a></td>
                </tr>

                </tbody>
            </table>
        </div>


    </div>
    <div class="row g-2">
        <div class="col-md-3 "></div>
        <div class="col-md-9 bg-light" style="min-height: 1000px; margin-top: -50px">
            <div class="row justify-content-center align-items-center g-2">
                <section style="background-color: #eee;">
                    <div class="input-group" style="margin-top: 10px;">
                        <input type="search" class="form-control " placeholder="Search" aria-label="Search"
                               aria-describedby="search-addon"/>
                        <button type="button" class="btn btn-outline-primary">search</button>
                    </div>
                    <div class="container py-5">
                        <div class="row justify-content-center mb-3">
                            <c:if test="${f:length(lssp) == 0}"><h3 class="text-center">Khong co san pham
                                nao</h3></c:if>
                            <c:if test="${f:length(lssp) != 0}">
                                <c:forEach items="${ lssp }" var="nv" varStatus="loop">
                                    <div class="col-md-12 col-xl-10">
                                        <div class="card shadow-0 border rounded-3">
                                            <div class="card-body">
                                                <div class="row">
                                                    <div class="col-md-12 col-lg-3 col-xl-3 mb-4 mb-lg-0">
                                                        <div class="bg-image hover-zoom ripple rounded ripple-surface">
                                                            <img src="https://mdbcdn.b-cdn.net/img/Photos/Horizontal/E-commerce/Products/img%20(${loop.index+1}).webp"
                                                                 class="w-100"/>
                                                            <a href="#!">
                                                                <div class="hover-overlay">
                                                                    <div class="mask"
                                                                         style="background-color: rgba(253, 253, 253, 0.15);">
                                                                    </div>
                                                                </div>
                                                            </a>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-6 col-lg-6 col-xl-6">
                                                        <h5>${nv.sanPhamByIdSp.ten}</h5>
                                                        <div class="d-flex flex-row">
                                                            <div class="text-danger mb-1 me-2">
                                                                <i class="fa fa-star"></i>
                                                                <i class="fa fa-star"></i>
                                                                <i class="fa fa-star"></i>
                                                                <i class="fa fa-star"></i>
                                                            </div>
                                                            <span>${nv.soLuongTon}</span>
                                                        </div>
                                                        <div class="mt-1 mb-0 text-muted small">
                                                            <span>NSX</span>
                                                            <span class="text-primary"> • </span>
                                                            <span>Mau Sac</span>
                                                            <span class="text-primary"> • </span>
                                                            <span>Dong SP<br/></span>
                                                        </div>
                                                        <div class="mb-2 text-muted small">
                                                            <span> ${nv.nsxByIdNsx.ten}</span>
                                                            <span class="text-primary"> • </span>
                                                            <span>${nv.mauSacByIdMauSac.ten}</span>
                                                            <span class="text-primary"> • </span>
                                                            <span>${nv.dongSpByIdDongSp.ten}<br/></span>

                                                        </div>
                                                        <p class="text-truncate mb-4 mb-md-0">
                                                            ${nv.moTa}
                                                        </p>
                                                    </div>
                                                    <div
                                                            class="col-md-6 col-lg-3 col-xl-3 border-sm-start-none border-start">
                                                        <div class="d-flex flex-row align-items-center mb-1">
                                                            <h4 class="mb-1 me-1">$${nv.giaBan}</h4>
                                                            <span class="text-danger"><s>$${nv.giaBan + 10}</s></span>
                                                        </div>
                                                        <h6 class="text-success">Free shipping</h6>
                                                        <div class="d-flex flex-column mt-4">
                                                            <button class="btn btn-primary btn-sm"
                                                                    type="button">Chi Tiet
                                                            </button>
                                                            <button class="btn btn-outline-primary btn-sm mt-2"
                                                                    type="button">
                                                                Them vao hoa don
                                                            </button>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>

                            </c:if>
                            <br>
                        </div>


                    </div>
                </section>


            </div>

        </div>


    </div>


</div>
