<%@include file="../../../shared/header.jsp" %>
<div class="jumbotron">
    <h1 class="display-4 text-center">ADD ENQUIRY</h1>
</div>
<form action="${SITE_URL}/admin/enquiries" method="POST">
    <div class="row">
        <div class="col-md-4">
            <div class="form-group">
                <label>Firstname</label>
                <input type="text" class="form-control" name="firstName" required="required">
            </div><!--form-group-->
        </div><!--col-md-4-->
        <div class="col-md-4">
            <div class="form-group">
                <label>Lastname</label>
                <input type="text" class="form-control" name="lastName" required="required">
            </div><!--form-group-->
        </div><!--col-md-4-->
        <div class="col-md-4">
            <div class="form-group">
                <label>Email</label>
                <input type="email" class="form-control" name="email" required="required">
            </div><!--form-group-->
        </div><!--col-md-4-->
    </div><!--row-->
    <div class="row">
        <div class="col-md-4">
            <div class="form-group">
                <label>Contact no</label>
                <input type="text" class="form-control" name="contactNo" required="required">
            </div><!--form-group-->
        </div><!--col-md-4-->
        <div class="col-md-2">
            <div class="form-group">
                <label>Source</label>
                <select name="enquirySourceId" class="form-control">
                    <c:forEach var="source" items="${sources}">
                        <option value="${source.id}">${source.name}</option>
                    </c:forEach>
                </select>
            </div><!--form-group-->
        </div><!--col-md-2-->
        <div class="col-md-2">
            <div class="form-group">
                <label>Status</label>
                <select name="enquiryStatusId" class="form-control">
                    <c:forEach var="status" items="${statuses}">
                        <option value="${status.id}">${status.name}</option>
                    </c:forEach>
                </select>
            </div><!--form-group-->
        </div><!--col-md-2-->
        <div class="col-md-4">
            <div class="form-group">
                <label>Referred by</label>
                <input type="text" class="form-control" name="referredBy" required="required">
            </div><!--form-group-->
        </div><!--col-md-4-->
    </div><!--row-->
    <button type="submit" class="btn btn-primary float-right"><i class="fa fa-save"></i> Add</button>
</form>
<%@include file="../../../shared/footer.jsp" %>