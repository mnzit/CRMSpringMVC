<%@include file="../../../shared/header.jsp" %>
<div class="jumbotron">
    <h1 class="display-4 text-center">ADD FOLLOW UPS</h1>
</div>
<form action="${SITE_URL}/admin/enquiries/${enquiryId}/followups" method="POST">
    <div class="row">
        <div class="col-md-6">
            <div class="form-group">
                <label>Message</label>
                <input type="text" class="form-control" name="message" required="required">
            </div><!--form-group-->
        </div><!--col-md-4-->
        <div class="col-md-6">
            <div class="form-group">
                <label>Status</label>
                <select name="followUpStatusId" class="form-control">
                    <c:forEach var="status" items="${statuses}">
                        <option style="background:${status.color};color:white;" value="${status.id}">${status.name}</option>
                    </c:forEach>
                </select>
            </div><!--form-group-->
        </div>
        <input type="hidden" value="${enquiryId}" name="enquiryId">
    </div><!--row-->
    <button type="submit" class="btn btn-primary float-right btn-sm"><i class="fa fa-save"></i> Add</button>
    <a class="btn btn-danger float-left mb-3 btn-sm" href="${SITE_URL}/admin/enquiries/${enquiryId}/followups"><i class="fa fa-angle-left"></i> Back</a>
</form>
<%@include file="../../../shared/footer.jsp" %>