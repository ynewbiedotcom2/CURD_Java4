
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thêm mới khách hàng</title>
    <link rel="stylesheet" href="/CURD_war_exploded/css/bootstrap.min.css" />
</head>
<body>
    <div class="col-8 offset-2 bg-light">
        <form method="POST" validate
          action="/CURD_war_exploded/khach_hang/update?idx=${ kh.id }">
            <div class="row mt-3">
                <div class="col-6">
                    <label>Mã</label>
                    <input type="text" name="ma" class="form-control" value="${ kh.ma }"  readonly required/>
                </div>
                <div class="col-6">
                    <label>Họ</label>
                    <input type="text" name="ho" class="form-control" value="${ kh.ho }" required/>
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-6">
                    <label>Tên đệm</label>
                    <input type="text" name="tenDem" class="form-control" value="${ kh.tenDem }" required/>
                </div>
                <div class="col-6">
                    <label>Tên</label>
                    <input type="text" name="ten" class="form-control" value="${ kh.ten }" required/>
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-6">
                    <label>Ngày sinh</label>
                    <input type="date" name="ngaySinh" class="form-control" value="${ kh.ngaySinh }" required/>
                </div>
                <div class="col-6">
                    <label>Số điện thoại</label>
                    <input type="tel" name="sdt" class="form-control" value="${ kh.sdt }"required />
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-6">
                    <label>Địa chỉ</label>
                    <input type="text" name="diaChi" class="form-control" value="${ kh.diaChi }" required/>
                </div>
                <div class="col-6">
                    <label>Mật khẩu</label>
                    <input type="password" value="${ kh.matKhau }" name="matKhau" class="form-control" required/>
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-6">
                    <label>Quốc gia</label>
                    <select name="quocGia" class="form-select">
                        <option ${ kh.quocGia == "vietnam" ? "selected" : "" } value="vietnam">Việt Nam</option>
                        <option ${ kh.quocGia == "unitedkingdom" ? "selected" : "" }value="unitedkingdom">Vương quốc Anh</option>
                        <option ${ kh.quocGia == "unitedstates" ? "selected" : "" }value="unitedstates">Hoa Kỳ</option>
                        <option ${ kh.quocGia == "japan" ? "selected" : "" }value="japan">Nhật Bản</option>
                        <option ${ kh.quocGia == "france" ? "selected" : "" }value="france">Pháp</option>
                        <option ${ kh.quocGia == "australia" ? "selected" : "" }value="australia">Úc</option>
                        <option ${ kh.quocGia == "china" ? "selected" : "" }value="china">Trung Quốc</option>
                        <option ${ kh.quocGia == "india" ? "selected" : "" }value="india">Ấn Độ</option>
                        <option ${ kh.quocGia == "brazil" ? "selected" : "" }value="brazil">Brasil</option>
                        <option ${ kh.quocGia == "russia" ? "selected" : "" }value="russia">Nga</option>
                        <option ${ kh.quocGia == "germany" ? "selected" : "" }value="germany">Đức</option>
                        <option ${ kh.quocGia == "egypt" ? "selected" : "" }value="egypt">Ai Cập</option>
                        <option ${ kh.quocGia == "thailand" ? "selected" : "" }value="thailand">Thái Lan</option>
                        <option ${ kh.quocGia == "uae" ? "selected" : "" }value="uae">Các Tiểu Vương quốc Ả Rập Thống
                            nhất
                        </option>
                        <option ${ kh.quocGia == "turkey" ? "selected" : "" }value="turkey">Thổ Nhĩ Kỳ</option>
                        <option ${ kh.quocGia == "singapore" ? "selected" : "" }value="singapore">Singapore</option>
                        <option ${ kh.quocGia == "canada" ? "selected" : "" }value="canada">Canada</option>
                        <option ${ kh.quocGia == "southkorea" ? "selected" : "" }value="southkorea">Hàn Quốc</option>
                        <option ${ kh.quocGia == "spain" ? "selected" : "" }value="spain">Tây Ban Nha</option>
                        <option ${ kh.quocGia == "italy" ? "selected" : "" }value="italy">Ý</option>

                    </select>
                </div>
                <div class="col-6">
                    <label>Thành phố</label>
                    <select name="thanhPho" class="form-select">
                        <option ${ kh.thanhPho == "hanoi" ? "selected" : "" } value="hanoi">Hà Nội</option>
                        <option ${ kh.thanhPho == "london" ? "selected" : "" } value="london">London</option>
                        <option ${ kh.thanhPho == "newyork" ? "selected" : "" }value="newyork">New York</option>
                        <option ${ kh.thanhPho == "tokyo" ? "selected" : "" }value="tokyo">Tokyo</option>
                        <option ${ kh.thanhPho == "paris" ? "selected" : "" }value="paris">Paris</option>
                        <option ${ kh.thanhPho == "losangeles" ? "selected" : "" }value="losangeles">Los Angeles</option>
                        <option ${ kh.thanhPho == "sydney" ? "selected" : "" }value="sydney">Sydney</option>
                        <option ${ kh.thanhPho == "shanghai" ? "selected" : "" } value="shanghai">Shanghai</option>
                        <option ${ kh.thanhPho == "mumbai" ? "selected" : "" }value="mumbai">Mumbai</option>
                        <option ${ kh.thanhPho == "riodejaneiro" ? "selected" : "" }value="riodejaneiro">Rio de Janeiro</option>
                        <option ${ kh.thanhPho == "moscow" ? "selected" : "" } value="moscow">Moscow</option>
                        <option ${ kh.thanhPho == "berlin" ? "selected" : "" }value="berlin">Berlin</option>
                        <option ${ kh.thanhPho == "cairo" ? "selected" : "" }value="cairo">Cairo</option>
                        <option ${ kh.thanhPho == "bangkok" ? "selected" : "" }value="bangkok">Bangkok</option>
                        <option ${ kh.thanhPho == "dubai" ? "selected" : "" }value="dubai">Dubai</option>
                        <option ${ kh.thanhPho == "istanbul" ? "selected" : "" }value="istanbul">Istanbul</option>
                        <option ${ kh.thanhPho == "singapore" ? "selected" : "" }value="singapore">Singapore</option>
                        <option ${ kh.thanhPho == "toronto" ? "selected" : "" } value="toronto">Toronto</option>
                        <option ${ kh.thanhPho == "seoul" ? "selected" : "" }value="seoul">Seoul</option>
                        <option ${ kh.thanhPho == "barcelona" ? "selected" : "" }value="barcelona">Barcelona</option>
                        <option ${ kh.thanhPho == "rome" ? "selected" : "" }value="rome">Rome</option>
                        <option ${ kh.thanhPho == "sanfrancisco" ? "selected" : "" }value="sanfrancisco">San Francisco
                        </option>
                    </select>
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-6 float-end">
                    <button class="btn btn-primary">LƯU</button>
                </div>
                <div class="col-6"></div>
            </div>
        </form>
    </div>

    <script src="/CURD_war_exploded/js/bootstrap.min.js"></script>
</body>
</html>
