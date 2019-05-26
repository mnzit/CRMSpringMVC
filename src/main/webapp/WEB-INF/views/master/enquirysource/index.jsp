<%@include file="../../../shared/header.jsp" %>
<div class="jumbotron">
    <h1 class="display-4 text-center">ENQUIRY SOURCES</h1>
</div>
<a class="btn btn-info btn-sm float-right mb-3" href="${SITE_URL}/admin/master/enquiries/source/add"><i class="fa fa-plus"></i></a>
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
        <c:forEach var="source" items="${sources}"> 
            <tr>
                <td>${source.id}</td>
                <td>${source.name}</td>
                <td style="background:${source.color};color:white;">${source.color}</td>
                <td>
                    <a class="btn btn-primary btn-sm" href="${SITE_URL}/admin/master/enquiries/source/edit/${source.id}"><i class="fa fa-edit"></i></a>
                    <a class="btn btn-danger btn-sm" href="${SITE_URL}/admin/master/enquiries/source/delete/${source.id}"><i class="fa fa-trash"></i></a>
                </td>
            </tr>
        </c:forEach>          
    </tbody>
</table>

<%@include file="../../../shared/footer.jsp" %>