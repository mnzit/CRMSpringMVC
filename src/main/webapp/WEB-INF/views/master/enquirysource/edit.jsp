<%@include file="../../../shared/header.jsp" %>
<div class="jumbotron">
    <h1 class="display-4 text-center">EDIT ENQUIRY SOURCE</h1>
</div>
<form action="${SITE_URL}/admin/master/enquiries/source/" method="POST">
    <div class="row">
        <div class="col-md-6">
            <div class="form-group">
                <label>Source name</label>
                <input type="text" class="form-control" name="name" required="required" value="${source.name}"/>
            </div>
        </div>
        <div class="col-md-6">
            <div class="form-group">
                <label>Source color</label>
                <input type="text" class="form-control" name="color" required="required" value="${source.color}"/>
            </div></div>
    </div>
    <input type="hidden" name="id" value="${source.id}"/>
    <button type="submit" class="btn btn-primary float-right btn-sm"><i class="fa fa-save"></i> Update</button>
    <a class="btn btn-danger float-left mb-3 btn-sm" href="${SITE_URL}/admin/master/enquiries/source"><i class="fa fa-angle-left"></i> Back</a>
</form>
<%@include file="../../../shared/footer.jsp" %>