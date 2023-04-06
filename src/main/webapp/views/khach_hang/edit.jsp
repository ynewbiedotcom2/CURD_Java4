
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thêm mới khách hàng</title>
    <link rel="stylesheet" href="/CURD_war_exploded/css/bootstrap.min.css" />
</head>
<body>
    <div class="col-8 offset-2 bg-light">
        <form method="POST"
          action="/CURD_war_exploded/khach-hang/update?Ma=${ kh.ma }">
            <div class="row mt-3">
                <div class="col-6">
                    <label>Mã</label>
                    <input type="text" class="form-control" value="${ kh.ma }" disabled />
                </div>
                <div class="col-6">
                    <label>Họ</label>
                    <input type="text" name="Ho" class="form-control" value="${ kh.ho }" />
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-6">
                    <label>Tên đệm</label>
                    <input type="text" name="TenDem" class="form-control" value="${ kh.tenDem }" />
                </div>
                <div class="col-6">
                    <label>Tên</label>
                    <input type="text" name="Ten" class="form-control" value="${ kh.ten }" />
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-6">
                    <label>Ngày sinh</label>
                    <input type="date" name="NgaySinh" class="form-control" value="${ kh.ngaySinh }" />
                </div>
                <div class="col-6">
                    <label>Số điện thoại</label>
                    <input type="tel" name="Sdt" class="form-control" value="${ kh.sdt }" />
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-6">
                    <label>Địa chỉ</label>
                    <input type="text" name="DiaChi" class="form-control" value="${ kh.diaChi }" />
                </div>
                <div class="col-6">
                    <label>Mật khẩu</label>
                    <input type="password" name="MatKhau" class="form-control" />
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-6">
                    <label>Quốc gia</label>
                    <select name="QuocGia" class="form-select">
                        <option value="vn" ${ kh.quocGia == "vn" ? "selected" : "" }>Việt Nam</option>
                        <option value="en" ${ kh.quocGia == "en" ? "selected" : "" }>Anh</option>
                    </select>
                </div>
                <div class="col-6">
                    <label>Thành phố</label>
                    <select name="ThanhPho" class="form-select">
                        <option value="hanoi">Hà Nội</option>
                        <option value="london">London</option>
                    </select>
                </div>
            </div><div class="row mt-3">
            <div class="col-6">
                <button class="btn btn-primary">Thêm mới</button>
            </div>
            <div class="col-6"></div>
        </div>
        </form>
    </div>

    <script src="/CURD_war_exploded/js/bootstrap.min.js"></script>
</body>
</html>
