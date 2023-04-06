<%--
  Created by IntelliJ IDEA.
  User: thuct
  Date: 4/5/2023
  Time: 12:29 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>
<body style="background: rgb(201, 200, 200);">
<div class="container ">
    <div class="card mb-4 " style="margin: 50px 100px">
        <div class="col-10 offset-1">
            <form method="POST" action="/CURD_war_exploded/cua_hang/store" validate>
                  <div class="row mt-3">

            <div class="col-6">
                <label>Tên</label>
                <input type="text" name="ten" class="form-control" required/>
            </div>
            <div class="col-6">
                <label>Mã</label>
                <input type="text" name="ma" class="form-control" required/>
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

                    <div class="col-12">
                        <label>Dia Chi</label>
                        <input class="form-control" value="${nv.diaChi}" name="diaChi" type="text">

                    </div>
                </div>
                <div class="row mt-3">
                    <div class="col">
                        <button type="submit" style="width: 100%;" class="btn btn-primary">Save</button>
                    </div>
                </div>
                <br>
            </form>
        </div>
    </div>


</body>