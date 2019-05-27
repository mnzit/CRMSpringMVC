<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="SITE_URL" value="${pageContext.request.contextPath}"/>                    
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
                    <button class="btn btn-danger btn-sm followup-delete-btn" data-id="${followup.id}"><i class="fa fa-trash"></i></button>
                </td>
            </tr><!--tr-->
        </c:forEach>
    </tbody><!--tbody-->
</table<!--table-->
</div>
<script>
    $('.followup-delete-btn').on('click', function () {
        var $id = $(this).attr('data-id');
        var $enquiryid = $('#enquiryid').val();
        $.get('${SITE_URL}/admin/enquiries/' + $enquiryid + '/followups/delete/' + $id, () => {
            let $dialog = $('#followup-modal');
            $dialog.find('#followup-content').html("<div class='text-center'><div class='spinner-border'><span class='sr-only'>Loading...</span></div></div>");
            $.get('${SITE_URL}/admin/enquiries/' + $enquiryid + '/followups/table', (data) => {
                $dialog.find('#followup-content').html(data);
            });
            loader();
            toastr.info('Deleted Successfully');
        });
    });
</script>