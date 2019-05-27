<%@include file="../../../shared/header.jsp" %>
<div class="jumbotron">
    <h1 class="display-4 text-center">FOLLOW UPS</h1>
</div>
<a class="btn btn-info float-right mb-3 btn-sm" href="${SITE_URL}/admin/enquiries/${enquiryId}/followups/add"><i class="fa fa-plus"></i></a>
<a class="btn btn-secondary float-left mb-3 btn-sm" href="${SITE_URL}/admin/enquiries"><i class="fa fa-angle-left"></i> Back</a>
<table class="table table-hover">
    <thead>
        <tr>
            <th>Id</th>
            <th>Message</th>
            <th>Status</th>
            <th>Date created</th>
            <th>Action</th>
        </tr><!--tr-->
    </thead><!--thead-->
    <tbody>
        <c:forEach var="followup" items="${followups}"> 
            <tr>
                <td>${followup.id}</td>
                <td>${followup.message}</td>
                <td style="background:${followup.followUpStatus.color};color:white;">${followup.followUpStatus.name}</td>        
                <td>${followup.createdDate}</td>
                <td>
                    <a class="btn btn-danger btn-sm" href="${SITE_URL}/admin/enquiries/${enquiryId}/followups/delete/${followup.id}"><i class="fa fa-trash"></i></a>
                </td>
            </tr><!--tr-->
        </c:forEach>
    </tbody><!--tbody-->
</table<!--table-->

<%@include file="../../../shared/footer.jsp" %>