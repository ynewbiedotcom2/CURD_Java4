
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thêm mới khách hàng</title>
    <link rel="stylesheet" href="/CURD_war_exploded/css/bootstrap.min.css" />
</head>
<body>
    <div class="col-8 offset-2 bg-light">
        <form method="POST"
          action="/CURD_war_exploded/khach_hang/store">
            <div class="row mt-3">
                <div class="col-6">
                    <label>Mã</label>
                    <input type="text" name="ma" class="form-control" required/>
                </div>
                <div class="col-6">
                    <label>Họ</label>
                    <input type="text" name="ho" class="form-control" required/>
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-6">
                    <label>Tên đệm</label>
                    <input type="text" name="tenDem" class="form-control" required/>
                </div>
                <div class="col-6">
                    <label>Tên</label>
                    <input type="text" name="ten" class="form-control" required/>
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-6">
                    <label>Ngày sinh</label>
                    <input type="date" name="ngaySinh" class="form-control" required/>
                </div>
                <div class="col-6">
                    <label>Số điện thoại</label>
                    <input type="tel" name="sdt" class="form-control"required />
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-6">
                    <label>Địa chỉ</label>
                    <input type="text" name="diaChi" class="form-control" required/>
                </div>
                <div class="col-6">
                    <label>Mật khẩu</label>
                    <input type="password" name="matKhau" class="form-control"required />
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-6">
                    <label>Quốc gia</label>
                    <select name="quocGia" class="form-select">
                        <option value="vn">Việt Nam</option>
                        <option value="en">Anh</option>

                    </select>
                </div>
                <div class="col-6">
                    <label>Thành phố</label>
                    <select name="thanhPho" class="form-select">
                        <option value="hanoi">Hà Nội</option>
                        <option value="london">London</option>
                    </select>
                </div>
            </div><div class="row mt-3">
            <div class="col-6 float-end">
                <button class="btn btn-primary">Thêm mới</button>
            </div>
            <div class="col-6"></div>
        </div>
        </form>
    </div>

    <script src="/CURD_war_exploded/js/bootstrap.min.js"></script>
</body>
</html>
