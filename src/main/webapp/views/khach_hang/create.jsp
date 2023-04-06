
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
                    <input type="password" name="matKhau" class="form-control" required/>
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-6">
                    <label>Quốc gia</label>
                    <select name="quocGia" class="form-select">
                        <option value="vietnam">Việt Nam</option>
                        <option value="unitedkingdom">Vương quốc Anh</option>
                        <option value="unitedstates">Hoa Kỳ</option>
                        <option value="japan">Nhật Bản</option>
                        <option value="france">Pháp</option>
                        <option value="australia">Úc</option>
                        <option value="china">Trung Quốc</option>
                        <option value="india">Ấn Độ</option>
                        <option value="brazil">Brasil</option>
                        <option value="russia">Nga</option>
                        <option value="germany">Đức</option>
                        <option value="egypt">Ai Cập</option>
                        <option value="thailand">Thái Lan</option>
                        <option value="uae">Các Tiểu Vương quốc Ả Rập Thống nhất</option>
                        <option value="turkey">Thổ Nhĩ Kỳ</option>
                        <option value="singapore">Singapore</option>
                        <option value="canada">Canada</option>
                        <option value="southkorea">Hàn Quốc</option>
                        <option value="spain">Tây Ban Nha</option>
                        <option value="italy">Ý</option>
                        <option value="usa">Mỹ</option>
                    </select>
                </div>
                <div class="col-6">
                    <label>Thành phố</label>
                    <select name="thanhPho" class="form-select">
                        <option value="hanoi">Hà Nội</option>
                        <option value="london">London</option>
                        <option value="newyork">New York</option>
                        <option value="tokyo">Tokyo</option>
                        <option value="paris">Paris</option>
                        <option value="losangeles">Los Angeles</option>
                        <option value="sydney">Sydney</option>
                        <option value="shanghai">Shanghai</option>
                        <option value="mumbai">Mumbai</option>
                        <option value="riodejaneiro">Rio de Janeiro</option>
                        <option value="moscow">Moscow</option>
                        <option value="berlin">Berlin</option>
                        <option value="cairo">Cairo</option>
                        <option value="bangkok">Bangkok</option>
                        <option value="dubai">Dubai</option>
                        <option value="istanbul">Istanbul</option>
                        <option value="singapore">Singapore</option>
                        <option value="toronto">Toronto</option>
                        <option value="seoul">Seoul</option>
                        <option value="barcelona">Barcelona</option>
                        <option value="rome">Rome</option>
                        <option value="sanfrancisco">San Francisco</option>
                    </select>
                </div>
            </div>
            <div class="row mt-3">
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
