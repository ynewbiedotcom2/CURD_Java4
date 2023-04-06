<%--
  Created by IntelliJ IDEA.
  User: thuct
  Date: 4/5/2023
  Time: 1:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>
<a class="btn btn-outline-success float-end" href="/CURD_war_exploded/kho_hang/create">Thêm mới</a>
<c:if test="${f:length(list)==0}"><h3 class="text text-center">Không có dữ liêu</h3></c:if>
<c:if test="${f:length(list)!=0}">
    <table class="table table-responsive">
        <thead>
        <tr>
            <th>Tên</th>
            <th>Màu</th>
            <th>Nhà Sản Xuất</th>
            <th>Dòng Sản Phẩm</th>
            <th>Năm Bảo Hành</th>
            <th>Số Lượng Tồn</th>
            <th>Giá Nhập</th>
            <th>Giá Bán</th>
            <th>Hành động</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="kh">
            <tr class="table align-middle">
                <th>${kh.sanPhamByIdSp.ten}</th>
                <th style="color:${kh.mauSacByIdMauSac.ma};text-shadow:0px 0px 1px black  ">${kh.mauSacByIdMauSac.ten}
                </th>
                <th>${kh.nsxByIdNsx.ten}</th>
                <th>${kh.dongSpByIdDongSp.ten}</th>
                <th>${kh.namBh}</th>
                <th>${kh.soLuongTon}</th>
                <th>${kh.giaNhap}</th>
                <th>${kh.giaBan}</th>
                <th><a class="btn btn-primary"
                       href="/CURD_war_exploded/kho_hang/edit?id=${kh.id}"
                       role="button">Sửa</a>
                    <a class="btn btn-danger" href="/CURD_war_exploded/kho_hang/delete?id=${kh.id}"
                       role="button">Xóa</a>
                </th>
            </tr>
        </c:forEach>

        </tbody>

    </table>
</c:if>
