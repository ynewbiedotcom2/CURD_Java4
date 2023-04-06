
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>

<div class="col-10 offset-1 mt-5 table-responsive">
    <div class="row">
        <div class="col-6">
            <a href="#" class="btn btn-outline-success float-end">Thêm mới</a>
        </div>
    </div>

    <c:if test="${ f:length(danhSach) == 0 }">
        <h3>Không có dữ liệu</h3>
    </c:if>

    <c:if test="${ f:length(danhSach) != 0 }">
        <table class="table table-striped mt-3">
            <thead class="table-primary">
            <tr>
                <th>Mã</th>
                <th>Họ</th>
                <th>Đệm</th>
                <th>Tên</th>
                <th>Ngày sinh</th>
                <th>SDT</th>
                <th>Địa chỉ</th>
                <th>Thành phố</th>
                <th>Quốc gia</th>
                <th colspan="2">Thao tác</th>
            </tr>
            </thead>
            <tbody>
                <c:forEach items="${ danhSach }" var="kh">
                    <tr>
                        <td>${ kh.ma }</td>
                        <td>${ kh.ho }</td>
                        <td>${ kh.tenDem }</td>
                        <td>${ kh.ten }</td>
                        <td>${ kh.ngaySinh }</td>
                        <td>${ kh.sdt }</td>
                        <td>${ kh.diaChi }</td>
                        <td>${ kh.thanhPho }</td>
                        <td>${ kh.quocGia }</td>
                        <td>
                            <a class="btn btn-outline-primary"
                               href="/CURD_war_exploded/khach_hang/edit?Ma=${ kh.ma }">
                                Cập nhật
                            </a>
                        </td>
                        <td>
                            <a class="btn btn-outline-danger"
                               href="/CURD_war_exploded/khach_hang/delete?Ma=${ kh.ma }">
                                Xóa
                            </a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:if>
</div>