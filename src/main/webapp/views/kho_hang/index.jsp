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
<c:if test="${f:length(list)==0}"><h3 class="text text-center">Không có dữ liêu</h3></c:if>
<c:if test="${f:length(list)!=0}">
    <table class="table table-striped">
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
            <tr>

                <th>${kh.sp}</th>
                <th><input class="form-control form-control-color " type="color" value="${kh.mauSac}" disabled>
                </th>
                <th>${kh.nsx}</th>
                <th>${kh.dongSp}</th>
                <th>${kh.namBaoHanh}</th>
                <th>${kh.soLuongTon}</th>
                <th>${kh.giaNhap}</th>
                <th>${kh.giaBan}</th>
                <th><a class="btn btn-primary"
                       href="/Demo2_war_exploded/products/edit?id=${kh.id}"
                       role="button"><i
                        class="bi bi-pencil-square"></i></a>
                    <a class="btn btn-danger" href="/Demo2_war_exploded/products/delete?id=${kh.id}"
                       role="button"><i
                            class="bi bi-trash"></i></a>
                </th>
            </tr>
        </c:forEach>

        </tbody>

    </table>
</c:if>
