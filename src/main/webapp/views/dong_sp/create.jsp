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

            <form method="POST" action="/CURD_war_exploded/dong_sp/store" validate>
                <div class="row mt-3">

                    <div class="col-6">
                        <label>Tên</label>
                        <input type="text" name="ten" class="form-control"  required/>
                    </div>
                    <div class="col-6">
                        <label>Mã </label>
                        <input type="text" name="ma" class="form-control"  required/>
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
</div>

</body>