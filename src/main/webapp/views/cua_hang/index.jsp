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
<a href="/CURD_war_exploded/cua_hang/create" class="btn btn-outline-primary float-end">Them Moi</a>
<div class="table-responsive container">
    <table class="table table-responsive">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Tên & Địa Chỉ</th>
            <th scope="col">Thành Phố</th>
            <th scope="col">Quốc Gia</th>
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
                            <c:if test="${nv.ten == null}"><i class="bi bi-house-exclamation-fill" style="font-size:xx-large "></i></c:if>
                            <c:if test="${nv.ten != null}"><i class="bi bi-house-fill" style="font-size:xx-large "></i></c:if>


                            <div class="ms-4">
                                <p class="fw-bold mb-1">${nv.ten}  (${nv.ma})</p>
                                <p class="text-muted mb-0">${nv.diaChi}</p>
                            </div>
                        </div>
                    </td>
                    <td>${nv.thanhPho}</td>
                    <td>${nv.quocGia}</td>
                    <td><a href="/CURD_war_exploded/cua_hang/edit?id=${nv.id}" class="btn btn-outline-primary">Sửa</a>
                        <a style="margin-left: 5px;" href="/CURD_war_exploded/cua_hang/delete?id=${nv.id}" class="btn btn-outline-danger">Xóa</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </c:if>

    </table>
</div>

