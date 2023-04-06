<%--
  Created by IntelliJ IDEA.
  User: thuct
  Date: 3/31/2023
  Time: 12:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="true" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>
<a href="/CURD_war_exploded/nhan_vien/create" class="btn btn-outline-primary float-end">Them Moi</a>
<div class="table-responsive container">
    <table class="table table-responsive">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Tên & Liên hệ</th>
            <th scope="col">Ngày sinh</th>
            <th scope="col">Địa chỉ</th>
            <th scope="col">Chức Vụ</th>
            <th scope="col">Cửa Hàng</th>
            <th scope="col">Giới Tính</th>
            <th scope="col">chỉnh sửa</th>
        </tr>
        </thead>

        <c:if test="${ f:length(list) == 0 }">
            <h2 class="text-center">KHONG CO DU LIEU</h2>
        </c:if>
        <c:if test="${ f:length(list) != 0 }">
            <tbody>
            <c:forEach items="${ list }" var="nv" varStatus="loop">
                <tr class="table align-middle">
                    <td scope="row"><Strong>${loop.index}</Strong></td>
                    <td>
                        <div class="d-flex align-items-center">
                            <img src="https://mdbootstrap.com/img/new/avatars/${loop.index + 1}.jpg" alt="avatar"
                                 style="width: 55px; height: 55px" class="rounded-circle"/>
                            <div class="ms-4">
                                <p class="fw-bold mb-1">${nv.ho} ${nv.tenDem} ${nv.ten} (${nv.ma})</p>
                                <p class="text-muted mb-0">${nv.sdt}</p>
                            </div>
                        </div>
                    </td>
                    <td>${nv.ngaySinh}</td>
                    <td>${nv.diaChi}</td>
                    <td>${nv.chucVu}</td>
                    <td>${nv.cuaHang}</td>
                    <td>${nv.gioiTinh}</td>
                    <td><a href="/CURD_war_exploded/nhan_vien/edit?id=${nv.id}" class="btn btn-outline-primary">Sửa</a>
                        <a style="margin-left: 5px;" href="/CURD_war_exploded/nhan_vien/delete?id=${nv.id}" class="btn btn-outline-danger">Xóa</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </c:if>

    </table>
</div>

