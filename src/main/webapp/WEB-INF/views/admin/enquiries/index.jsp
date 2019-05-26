<%@include file="../../../shared/header.jsp" %>
<div class="jumbotron">
    <h1 class="display-4 text-center">ENQUIRIES</h1>
</div>
<a class="btn btn-info float-right mb-3 btn-sm" href="${SITE_URL}/admin/enquiries/add"><i class="fa fa-plus"></i></a>
<table class="table table-hover">
    <thead>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Email</th>
            <th>Contact no</th>
            <th>Source</th>
            <th>Status</th>
            <th>Referred By</th>
            <th>Visited</th>
            <th>Followups</th>
            <th>Actions</th>
        </tr><!--tr-->
    </thead><!--thead-->
    <tbody>
        <c:forEach var="enquiry" items="${enquiries}"> 
            <tr>
                <td>${enquiry.id}</td>
                <td>${enquiry.firstName} ${enquiry.lastName}</td>
                <td>${enquiry.email}</td>
                <td>${enquiry.contactNo}</td>
                <td>${enquiry.enquirySource.name}</td>
                <td>${enquiry.enquiryStatus.name}</td>
                <td>${enquiry.referredBy}</td>
                <td>
                    <a class="btn-link" href="${SITE_URL}/admin/enquiries/hasvisited/${enquiry.id}">
                        <c:choose>
                            <c:when test="${enquiry.visited}">
                                Yes
                            </c:when>
                            <c:otherwise>
                                Visited?
                            </c:otherwise>
                        </c:choose>
                    </a>
                </td>
                <td>
                    <a class="btn btn-primary btn-sm" href="${SITE_URL}/admin/enquiries/${enquiry.id}/followups">
                        <i class="fa fa-plus"></i>
                        <span class="ml-2 badge badge-light">${enquiry.followUp}</span>
                    </a>
                </td>
                <td>
                    <a class="btn btn-primary btn-sm" href="${SITE_URL}/admin/enquiries/edit/${enquiry.id}"><i class="fa fa-edit"></i></a>
                    <a class="btn btn-danger btn-sm" href="${SITE_URL}/admin/enquiries/delete/${enquiry.id}"><i class="fa fa-trash"></i></a>
                </td>
            </tr><!--tr-->
        </c:forEach>
    </tbody><!--tbody-->
</table<!--table-->
<%@include file="../../../shared/footer.jsp" %>