<%@include file="../../../shared/header.jsp" %>
<div class="jumbotron">
    <h1 class="display-4 text-center">EDIT ENQUIRY STATUS</h1>
</div>
<form action="${SITE_URL}/admin/master/enquiries/status/" method="POST">
    <div class="row">
        <div class="col-md-6">
            <div class="form-group">
                <label>Status name</label>
                <input type="text" class="form-control" name="name" required="required" value="${status.name}"/>
            </div>
        </div>
        <div class="col-md-6">
            <div class="form-group">
                <label>Status color</label>
                <input type="text" class="form-control" name="color" required="required" value="${status.color}"/>
            </div>
        </div>
    </div>
    <input type="hidden" name="id" value="${status.id}"/>
    <button type="submit" class="btn btn-primary float-right btn-sm"><i class="fa fa-save"></i> Update</button>
    <a class="btn btn-danger float-left mb-3 btn-sm" href="${SITE_URL}/admin/master/enquiries/status"><i class="fa fa-angle-left"></i> Back</a>
</form>
<%@include file="../../../shared/footer.jsp" %>