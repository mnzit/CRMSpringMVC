<%@include file="../../../shared/header.jsp" %>
<div class="jumbotron">
  <h1 class="display-4 text-center">FOLLOW UP STATUSES</h1>
</div>
 <a class="btn btn-info float-right mb-3 btn-sm" href="${SITE_URL}/admin/master/enquiries/followup/status/add"><i class="fa fa-plus"></i></a>
<table class="table table-hover">
    <thead>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Color</th>
            <th>Action</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="status" items="${statuses}"> 
            <tr>
                <td>${status.id}</td>
                <td>${status.name}</td>
                <td style="background:${status.color};color:white;">${status.color}</td>
                <td>
                    <a class="btn btn-primary btn-sm" href="${SITE_URL}/admin/master/enquiries/followup/status/edit/${status.id}"><i class="fa fa-edit"></i></a>
                    <a class="btn btn-danger btn-sm" href="${SITE_URL}/admin/master/enquiries/followup/status/delete/${status.id}"><i class="fa fa-trash"></i></a>
                </td>
            </tr>
        </c:forEach>        
    </tbody>
</table>
<%@include file="../../../shared/footer.jsp" %>