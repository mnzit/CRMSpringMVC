<%@include file="../../../shared/header.jsp" %>
<div class="jumbotron">
    <h1 class="display-4 text-center">EDIT ENQUIRY</h1>
</div>
<form action="${SITE_URL}/admin/enquiries" method="POST">
    <div class="row">
        <div class="col-md-4">
            <div class="form-group">
                <label>Firstname</label>
                <input type="text" class="form-control" name="firstName" required="required" value="${enquiry.firstName}">
            </div><!--form-group-->
        </div><!--col-md-4-->
        <div class="col-md-4">
            <div class="form-group">
                <label>Lastname</label>
                <input type="text" class="form-control" name="lastName" required="required" value="${enquiry.lastName}">
            </div><!--form-group-->
        </div><!--col-md-4-->
        <div class="col-md-4">
            <div class="form-group">
                <label>email</label>
                <input type="email" class="form-control" name="email" required="required" value="${enquiry.email}">
            </div><!--form-group-->
        </div><!--col-md-4-->
    </div><!--row-->
    <div class="row">
        <div class="col-md-4">
            <div class="form-group">
                <label>Contact no</label>
                <input type="text" class="form-control" name="contactNo" required="required" value="${enquiry.contactNo}">
            </div><!--form-group-->
        </div><!--col-md-4-->
        <div class="col-md-2">
            <div class="form-group">
                <label>Source</label>
                <select name="enquirySourceId" class="form-control">
                    <c:forEach var="source" items="${sources}">
                        <option style="background:${source.color};color:white;" <c:if test="${enquiry.enquirySource.id eq source.id}">selected</c:if> value="${source.id}">${source.name} </option>
                    </c:forEach>
                </select>
            </div><!--form-group-->
        </div><!--col-md-2-->
        <div class="col-md-2">
            <div class="form-group">
                <label>Status</label>
                <select name="enquiryStatusId" class="form-control">
                    <c:forEach var="status" items="${statuses}">
                        <option style="background:${status.color};color:white;" <c:if test="${enquiry.enquiryStatus.id eq status.id}">selected</c:if>  value="${status.id}">${status.name} </option>
                    </c:forEach>
                </select>
            </div><!--form-group-->
        </div><!--col-md-2-->
        <div class="col-md-4">
            <div class="form-group">
                <label>Referred by</label>
                <input type="text" class="form-control" name="referredBy" required="required" value="${enquiry.referredBy}">
            </div><!--form-group-->
        </div><!--col-md-4-->
    </div><!--row-->
    <input type="hidden" name="id" value="${enquiry.id}"/>
    <button type="submit" class="btn btn-primary float-right btn-sm"><i class="fa fa-save"></i> Update</button>
    <a class="btn btn-danger float-left mb-3 btn-sm" href="${SITE_URL}/admin/enquiries"><i class="fa fa-angle-left"></i> Back</a>
</form><!--form-->
<%@include file="../../../shared/footer.jsp" %>